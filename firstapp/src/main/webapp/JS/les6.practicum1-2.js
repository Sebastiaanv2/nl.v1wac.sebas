window.addEventListener("storage", function(){
    document.getElementById("storageLabel").innerHTML = window.localStorage.getItem("label");
});

