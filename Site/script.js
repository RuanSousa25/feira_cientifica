$.getJSON("http://dreamlo.com/lb/6289978d8f40bb11c05666db/json", (data) => {
  for (let i in data.dreamlo.leaderboard.entry) {
    let el = document.getElementById("leaderboardcont");
    el.innerHTML +=
      "<div class=posrank id='posrank" +
      (Number(i) + 1) +
      "'><h3>" +
      (Number(i) + 1) +
      "</h3><h4>" +
      data.dreamlo.leaderboard.entry[i].name +
      "-" +
      data.dreamlo.leaderboard.entry[i].score +
      "" +
      "</h4></div>";
  }
  console.log(data.dreamlo.leaderboard.entry);
});
