/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

 'use strict';

const Conversation = require('watson-developer-cloud/conversation/v1'); // watson sdk
const config = require('../util/config');
const request = require('request');
const moment = require('moment');
// Create a Service Wrapper
let conversation = new Conversation(config.conversation);

const util = require('util');
const messagePromise = util.promisify(conversation.message);

let getConversationResponse = (message, context) => {
  let payload = {
    workspace_id: process.env.WORKSPACE_ID,
    context: context || {},
    input: message || {}
  };

  payload = preProcess(payload);

  return new Promise((resolved, rejected) => {
    // Send the input to the conversation service
    conversation.message(payload, async function(err, data) {
      if (err) {
        rejected(err);
      }
      else{
          /*
          if(data.context.name == 'Francis Bacon'){
              data.context.name  = 'Francis Bacon';
              data.context.nationality = 'Irish';
              data.context.birth = 'present';
              data.context.url = 'https://media.mutualart.com/Images/2009_07/05/0175/551336/513c9e6b-e007-45b5-91a6-5b350dafcab6_g_570.Jpeg';
              data.output.text = data.context.name+' is a '+data.context.nationality+' artist  from '+data.context.birth+'. Check out a painting at '+data.context.url;
          }
          else if(data.context.name == 'John Constable'){
              data.context.name  = 'John Constable';
              data.context.nationality = 'British';
              data.context.birth = '1776 - 1837';
              data.context.url = 'https://media.mutualart.com/Images/2016_03/11/05/053215387/eb1dc49c-b78f-4586-831d-e6dff3b29df6_570.Jpeg';
              data.output.text = data.context.name+' is a '+data.context.nationality+' artist  from '+data.context.birth+'. Check out a painting at '+data.context.url;
          }
          else if(data.context.type == 'random_artist') {
              var result = 'Francis Bacon / John Constable / ';
              data.output.text = 'Let\'s find some random artists for you! '+result;

          }

          else{
              data.context.name  = '';
              data.context.nationality = '';
              data.context.birth = '';
              data.context.url = '';
              data.output.text ='';
          }*/


          if(data.context.type == 'ask'){
              let artist = data.context.name;
              let result = await artpromise(artist);
              console.log(result);
              data.context.name  = result[0].name;
              data.context.nationality = result[0].nationality;
              data.context.birth = result[0].years;
              data.context.url = result[0].art_link;
              data.output.text = data.context.name+' is a '+data.context.nationality+' artist  from '+data.context.birth+'. Check out a painting at '+data.context.url;
          }
          else if(data.context.type == 'random_artist'){
              let result = await randomArtist();
              console.log(result);
              data.output.text = 'Let\'s find some random artists for you! \n'+result;
          }
        let processed = postProcess(data);
        if(processed){
          // return 값이 Promise 일 경우
          if(typeof processed.then === 'function'){
            processed.then(data => {
              resolved(data);
            }).catch(err => {
              rejected(err);
            })
          }
          // return 값이 변경된 data일 경우
          else{
            resolved(processed);
          }
        }
        else{
          // return 값이 없을 경우
          resolved(data);
        }
      }
    });
  })
}

let postMessage = (req, res) => {
  let message = req.body.input || {};
  let context = req.body.context || {};
  getConversationResponse(message, context).then(data => {
    return res.json(data);
  }).catch(err => {
    return res.status(err.code || 500).json(err);
  });
}

/** 
* 사용자의 메세지를 Watson Conversation 서비스에 전달하기 전에 처리할 코드
* @param  {Object} user input
*/ 
let preProcess = payload => {
  var inputText = payload.input.text; 
  console.log("User Input : " + inputText);
  console.log("Processed Input : " + inputText); 
  console.log("--------------------------------------------------");

  return payload;
}

/** 
 * Watson Conversation 서비스의 응답을 사용자에게 전달하기 전에 처리할 코드 
 * @param  {Object} watson response 
 */ 

let postProcess = response => { 
  console.log("Conversation Output : " + response.output.text);
  console.log("--------------------------------------------------");
  return response;
}

/** 
 * 대화 도중 Action을 수행할 필요가 있을 때 처리되는 함수
 * @param  {Object} data : response object
 * @param  {Object} action 
 */

/**
 * Make reservation
 * @param  {Object} data : response object
 * @param  {Object} action
 */

/** 
 * 사용자의 회의실 예약 리스트를 가져오는 함수
 * @param  {Object} data : response object
 * @param  {Object} action 
 */

function artpromise (artist) {
    return new Promise(function(resolve, reject) {
        const MongoClient = require("mongodb").MongoClient;
        const url = 'mongodb://majac.co.kr:27017/artbot';
        MongoClient.connect(url, function(err, db) {
            if (err) throw err;
            var dbo = db.db("artbot");
            var query = {name: artist};
            var artistinfo = dbo.collection("artistdb").find(query)
                .toArray(function(err, result) {
                    if (err) throw reject(err);
                    resolve(result);
                });
            db.close();
        })
    });
};

function randomArtist() {
    return new Promise(function(resolve, reject) {
        const MongoClient = require("mongodb").MongoClient;
        const url = 'mongodb://majac.co.kr:27017/artbot';
        MongoClient.connect(url, function(err, db) {
            if (err) throw err;
            var dbo = db.db("artbot");
            var randoms = dbo.collection("artistdb").aggregate([
                { $sample: { size: 3} }
            ]);
            var stringRes = "";
            var chk = 0;
            randoms.each(function(err, artist) {
                if (artist !== null) {
                    console.log(artist.name);
                    stringRes = stringRes +artist.name+'/ \n';
                    console.log(stringRes);
                    chk = chk+1;
                }
                else resolve(stringRes);
            });
            db.close();
        })
    });
};
module.exports = {
    'initialize': (app, options) => {
        app.post('/api/message', postMessage);
    },
    'getConversationResponse' : getConversationResponse
};