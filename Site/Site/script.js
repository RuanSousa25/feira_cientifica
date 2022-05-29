$.getJSON("http://dreamlo.com/lb/6289978d8f40bb11c05666db/json", (data) => {
  let el = document.getElementById("leaderboardcontpc");
  for (let i in data.dreamlo.leaderboard.entry) {
    el.innerHTML +=
      "<div class='posrank' id='posrankpc" +
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
});
$.getJSON("http://dreamlo.com/lb/628e22e18f40bb11c05c5751/json", (data) => {
  let el = document.getElementById("leaderboardcontmob");
  for (let i in data.dreamlo.leaderboard.entry) {
    el.innerHTML +=
      "<div class='posrank' id='posrankmob" +
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
});
