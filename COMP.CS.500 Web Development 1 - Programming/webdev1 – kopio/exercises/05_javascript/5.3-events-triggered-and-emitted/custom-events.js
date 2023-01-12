var roll = document.getElementById('roll-button');
var totalsDiv = document.getElementById('totals');
var totals = totalsDiv.getElementsByTagName("span")[0];
var ones = document.getElementById('ones');
var twos = document.getElementById('twos');
var threes = document.getElementById('threes');
var fours = document.getElementById('fours');
var fives = document.getElementById('fives');
var sixes = document.getElementById('sixes');
let rollCounter=0;
let rollOnes=0;
let rollTwos=0;
let rollThrees=0;
let rollFours=0;
let rollFives=0;
let rollSixes=0;
document.addEventListener('rollDice', function (evt) {
    //console.log(evt.detail.value);
    //console.log(totals);
    //console.log(rollCounter);
    switch(evt.detail.value) {
        case 1:
            var newRoll = document.getElementById("template1");
            var clone = newRoll.content.cloneNode(true);
            roll.replaceChild(clone,roll.childNodes[0]);
            rollCounter++;
            rollOnes++;
            totals.textContent=rollCounter;
            ones.childNodes[3].textContent=rollOnes;
            // code block
            break;
        case 2:
            var newRoll = document.getElementById("template2");
            var clone = newRoll.content.cloneNode(true);
            roll.replaceChild(clone,roll.childNodes[0]);
            rollCounter++;
            rollTwos++;
            totals.textContent=rollCounter;
            twos.childNodes[3].textContent=rollTwos;
            // code block
            break;
        case 3:
            var newRoll = document.getElementById("template3");
            var clone = newRoll.content.cloneNode(true);
            roll.replaceChild(clone,roll.childNodes[0]);
            rollCounter++;
            rollThrees++;
            totals.textContent=rollCounter;
            threes.childNodes[3].textContent=rollThrees;
            // code block
            break;
        case 4:
            var newRoll = document.getElementById("template4");
            var clone = newRoll.content.cloneNode(true);
            roll.replaceChild(clone,roll.childNodes[0]);
            rollCounter++;
            rollFours++;
            totals.textContent=rollCounter;
            fours.childNodes[3].textContent=rollFours;
            // code block
            break;
        case 5:
            var newRoll = document.getElementById("template5");
            var clone = newRoll.content.cloneNode(true);
            roll.replaceChild(clone,roll.childNodes[0]);
            rollCounter++;
            rollFives++;
            totals.textContent=rollCounter;
            fives.childNodes[3].textContent=rollFives;
             // code block
             break;
        case 6:
            var newRoll = document.getElementById("template6");
            var clone = newRoll.content.cloneNode(true);
            roll.replaceChild(clone,roll.childNodes[0]);
            rollCounter++;
            rollSixes++;
            totals.textContent=rollCounter;
            sixes.childNodes[3].textContent=rollSixes;
            // code block
            break;
        default:
          // code block
          break;
      }
  });
  
  

roll.addEventListener('click', rollDice);

