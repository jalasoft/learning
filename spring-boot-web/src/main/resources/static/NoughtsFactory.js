/**
 * Created by lastovicka on 11/23/15.
 */
function renderGame() {
    var form = document.forms[0];
    form.style.display = "none";

    var width = document.querySelector("#width").value;
    var height = document.querySelector("#height").value;

    var result = GameFactory.build(width, height);

    var game = document.querySelector("#game");
    game.appendChild(result);
}

var GameFactory = {};
GameFactory.build = function(width, height) {
    console.log("" + width + "  " + height);

    var table = this.table();

    for(var i=0; i<height;i++) {
        var row = this.row(width);
        table.appendChild(row);
    }
    this.registerListener(table);
    return table;
}
GameFactory.row = function(size) {
    var row = this.tr();
    for(var i=0;i<size;i++) {
        var cell = this.td();
        row.appendChild(cell);
    }
    return row;
}

GameFactory.td = function() {
    var result = document.createElement("td");
    result.style.backgroundColor = "white";
    return result;
}
GameFactory.tr = function() {
    return document.createElement("tr");
}
GameFactory.table = function() {
    return document.createElement("table");
}
GameFactory.registerListener = function(table) {
    table.addEventListener("click", this.handleClick, false);
}
GameFactory.handleClick = function(event) {
    var target = event.target;

    if (target.nodeName !== "TD") {
        return;
    }
    if (target.style.backgroundColor === "white") {
        target.style.backgroundColor = "red";
    } else {
        target.style.backgroundColor = "white";
    }
}