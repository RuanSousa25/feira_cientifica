var currentImg = 1;
function mostrarImg() {
  let img = document.getElementById("currentimg");
  switch (currentImg) {
    case 1:
      document.getElementById("currentimg").style.backgroundImage =
        "url(imagens/inicio.png)";
      break;
    case 2:
      document.getElementById("currentimg").style.backgroundImage =
        "url(imagens/gameplay.png)";
      break;
    case 3:
      document.getElementById("currentimg").style.backgroundImage =
        "url(imagens/desafios.png)";

      break;
    case 4:
      document.getElementById("currentimg").style.backgroundImage =
        "url(imagens/final.png)";

      break;
  }
}
function nextImg() {
  if (currentImg == 4) {
    currentImg = 1;
  } else {
    currentImg++;
  }
  mostrarImg();
  clearInterval(loop);
  passarImg();
}
function prevImg() {
  if (currentImg == 1) {
    currentImg = 4;
  } else {
    currentImg--;
  }
  mostrarImg();
  clearInterval(loop);
  passarImg();
}

function passarImg() {
  loop = setInterval(() => {
    if (currentImg == 4) {
      currentImg = 1;
    } else {
      currentImg++;
    }
    mostrarImg();
  }, 5000);
}
