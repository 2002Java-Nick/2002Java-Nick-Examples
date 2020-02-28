/*
* Let's do some JavaScript
*/

var a, b, c, d, e, f, g, h, i;

console.log(`2 + 2 = ${2 + 2}`);

console.log(`a: ${a}`);

b = 10;

c = '10';

d = true;

e = { myValue: 'stuff' };

h = [];

i = function() {console.log("calling function i")};

function myFunc() {console.log("calling function myFunc")};

var j = ()=>{console.log("calling function j")};

var myArr = [];


/* function add(x, y, z) {
    return x + y + z;
} */
var add = function (x, y, z) {
    return x + y + z;
}
/* function add(x, y) {
    return x + y;
} */

add = function (x, y) {
    return x + y;
}

add = function () {
    var ret = 0;

    for (var x of arguments) {
        ret += x;
    }

    return ret;

}

//maker function
function makeCar(make, model, year, vin, color) {
    var car = {};
    car.make = make;
    car.model = model;
    car.vin = vin;
    car.year = year;
    car.color = color;
    car.drive = function() {console.log("yeah I'm driving")};
    return car;
}

var Car = function(make, model, year, vin, color) {
    this.make = make;
    this.model = model;
    this.vin = vin;
    this.year = year;
    this.color = color;
    this.drive = function (){console.log("Still driving")};
    this.break = function(){console.log("Not still driving")};
}

var f120 = new Car('ford', 'f120', 1999, '4', 'cherry white');

var Bus = function(){};
Bus.prototype = new Car();
Bus.prototype.drive = function() {console.log("The wheels on the bus go round and round")};