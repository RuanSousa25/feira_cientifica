$.getJSON("http://dreamlo.com/lb/6289978d8f40bb11c05666db/json", (data)=>{
    for(let i in data.dreamlo.leaderboard.entry){
      let el = document.getElementById("leaderboardcont");
      el.innerHTML += "<div class=posrank><h4>nome: "+ data.dreamlo.leaderboard.entry[i].name+"/ pontuação: "+data.dreamlo.leaderboard.entry[i].score+""+"</h4></div>";
    }
    console.log(data.dreamlo.leaderboard.entry)
 });
