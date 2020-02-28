//ES6 Features
class User {
    constructor(username, password) {
        this.username = username;
        this.password = password;
    }
}

function login(user) {
    if (user.username === "nick" && user.password === "1234") {
        return true;
    } else if (user.username === "kennith" && user.password === "9876") {
        return true;
    }
    return false;
}

function submitLogin(event) {
    event.preventDefault();
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var user = new User(username, password);
    if (login(user)) {
        document.getElementById("message").innerHTML =
         `Login succesful: Hello ${user.username}`;
    } else {
        document.getElementById("message").innerHTML =
         `Username & password did not match`;
    }
}
    
window.onload = function (){//                                            vvvv----------callback
    this.document.getElementById("submitLogin").addEventListener('click', submitLogin);
}