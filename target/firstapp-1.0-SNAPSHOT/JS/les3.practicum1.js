//    document.querySelector("#testtext").innerHTML = "Hello and welcome to my party!"
var timer = 0;
function timerFunc(){
    timer++;
    document.getElementById("timer").innerHTML = timer + "s";
}
var timerInterval = setInterval(timerFunc, 1000);

var text1;
var text2;
function printToLog(){


    text1 = document.getElementById("testtext").value;

    if (text1 !== text2){
        console.log(text1);
        text2 = document.getElementById("testtext").value;

        clearInterval(timerInterval);
        timerInterval = setInterval(timerFunc, 1000);
        timer = 0;
    }

}
setInterval(printToLog,5000);

