function getPoke() {
    let id = document.getElementById("pokeId").value;
    
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
            let pokeman = JSON.parse(xhr.responseText);
            document.getElementById("pokeName").innerHTML = pokeman.name;
        }
    }

    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/"+id, true);
    xhr.send();
}

window.onload = function() {
    this.document.getElementById("submitId").addEventListener("click", getPoke);
}