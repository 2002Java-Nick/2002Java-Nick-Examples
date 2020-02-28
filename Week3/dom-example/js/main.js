window.onload = function() {
    var myParagraph = document.getElementById("myParagraph");
    myParagraph.innerHTML = "Hello World";
    
}

function addHeader() {
    var myHeader = document.createElement("h1");
    myHeader.innerHTML = "Manipulating DOM";
    this.document.getElementById("header-container").appendChild(myHeader);
}