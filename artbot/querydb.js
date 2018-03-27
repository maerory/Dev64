var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";
let artist = "John Constable"
let link;

MongoClient.connect(url, function(err, db) {
  if (err) throw err;
  var dbo = db.db("mydb");
  var query = { name: artist };
  dbo.collection("artists").find(query).toArray(function(err, result) {
    if (err) throw err;
    link = result.map(function (result) {
      return result.link
    });

    db.close();
  })
})
