
document.getElementById("storageInput").addEventListener("keyup", function(){
    var input = document.getElementById("storageInput");
    window.localStorage.setItem("label",input.value);
    console.log(localStorage);
    document.getElementById("storageLabel").innerHTML = window.localStorage.getItem("label");
});
