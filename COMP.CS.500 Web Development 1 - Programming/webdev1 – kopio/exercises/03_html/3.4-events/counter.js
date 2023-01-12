var decrement = document.getElementById("decrement");
var increment = document.getElementById("increment");
var reset = document.getElementById("reset");
var counter = document.getElementById("counter").textContent;
var realCounter = document.getElementById("counter")
var maxNum= "5";
var minNum= "-5";
//console.log(counter);
var realNumber = Number.parseInt(counter,10);
decrement.addEventListener("click", decrementFunction);
increment.addEventListener("click", incrementFunction);
reset.addEventListener("click", resetFunction);

function decrementFunction(){
    realNumber--;
    if (realNumber<minNum){
        var numtext = maxNum.toString();
        realCounter.textContent = numtext;
        realNumber = maxNum
    }
    else{
            var numtext = realNumber.toString();
            realCounter.textContent = numtext;
    }


}
function incrementFunction(){
    realNumber++;
    if (realNumber>maxNum){
        var numtext = minNum.toString();
        realCounter.textContent = numtext;
        realNumber = minNum;
    }
    else{
        var numtext = realNumber.toString();
        realCounter.textContent = numtext;
    }
}
function resetFunction(){
    realCounter.textContent = "0";
    realNumber = Number.parseInt(counter,10);
}