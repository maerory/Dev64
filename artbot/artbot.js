let spawn = require('child_process').spawn,
    py = spawn('python',['artist_crawl.py']),
    data = "/Artist/Gustave-Courbet/D67F26682B95774D",
    dataString = '';

py.stdout.on('data', function(data){
  dataString += data.toString();
});

py.stdout.on('end', function(){
  console.log(dataString);
});

py.stdin.write(JSON.stringify(data));
py.stdin.end();
