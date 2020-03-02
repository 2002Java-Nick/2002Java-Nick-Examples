//Immediatly Evoked Function Expression
//Pre-ES6
//allows JS developers to create a local scope

var temp = 28;

var displayTemp = "";

(function iefe() {
    var farenheightString = "F";

    var celciusString = "C";

    var offset = 32;

    var rate = 1.8;

    var farenheightTemp = (temp * rate) + offset;

    displayTemp = `${temp}*${celciusString} : ${farenheightTemp}*${farenheightString}`

})()//;

console.log(displayTemp);


function add (x, y) {
    return //<----- Semi-Colon injection
    x + y;
}

//Closure: a way to achieve Encapsulation in JS
//by returning a function from within a function
//that holds a value being encapsulated

var x = function() {
    let variable = 12;
   /*  return function() {
        return variable;
    } */
    return {
        getValue: function() {return variable},
        setValue: function(val) { if(val> 0) variable = val;}
    }
}()
