var canvas = document.getElementById("canvas");
var playground = new Playground(canvas);

playground.init();

var xDiv = document.getElementById("x");
var yDiv = document.getElementById("y");

playground.addMouseMoveHandler(function(x, y) {
    xDiv.innerHTML = "X = " + x;
    yDiv.innerHTML = "Y = " + y;
});
