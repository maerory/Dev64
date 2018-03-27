var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";

MongoClient.connect(url, function(err, db) {
  if (err) throw err;
  var dbo = db.db("mydb");
  var names = [
    {"link": "/Artist/John-Constable/C834A9E5B37C3FA3", "name": "John Constable"},
    {"link": "/Artist/Joseph-Mallord-William-Turner/2A123FB50C356620", "name": "Joseph Mallord William Turner"},
    {"link": "/Artist/Gustave-Courbet/D67F26682B95774D", "name": "Gustave Courbet"},
    {"link": "/Artist/Albert-Bierstadt/F18F0F11CC072D1B", "name": "Albert Bierstadt"},
    {"link": "/Artist/Frederic-Remington/1723C19D8BBFD20E", "name": "Frederic Remington"}
  ];
  dbo.collection("artists").insertMany(names, function(err, res) {
    if (err) throw err;
    console.log("Number of documents inserted: " + res.insertedCount);
    db.close();
  })
})
