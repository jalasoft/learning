var Playground = function(canvas) {
    this.canvas = canvas;
    this.context = canvas.getContext("2d");
    this.delta = canvas.delta || 20;

    this.coordinates = function (event) {
        var rect = this.canvas.getBoundingClientRect();
        return {
            x: event.clientX - rect.left,
            y: event.clientY - rect.top
        };
    };

    this.mouseMoveHandlers = [];
    this.addMouseMoveHandler = function (handler) {
        this.mouseMoveHandlers.push(handler);
    };


    this.init = function () {
      //  this.canvas.addEventListener("mousemove", function (event) {
        //    var coord = Playground.this.coordinates(event);
          //  this.mouseMoveHandlers.forEach(function (handler) {
       //         handler(coord.x, coord.y);
       //     });
      //  });
        this.drawHorizontalLines();
        this.drawVerticalLines();
    };

    this.drawHorizontalLines = function() {
        for(var i = 0; i <= this.canvas.height; i+=this.delta) {
            this.drawHorizontalLine(i);
        }
    };

    this.drawHorizontalLine = function(y) {
        this.context.beginPath();
        this.context.moveTo(0, y);
        this.context.lineTo(this.canvas.width, y);
        this.context.stroke();
    };

    this.drawVerticalLines = function() {
        for (var i = 0; i <= this.canvas.width; i += this.delta) {
            this.drawVerticalLine(i);
        }
    }

    this.drawVerticalLine = function(x) {
        this.context.beginPath();
        this.context.moveTo(x, 0);
        this.context.lineTo(x, this.canvas.height);
        this.context.stroke();
    }
}
