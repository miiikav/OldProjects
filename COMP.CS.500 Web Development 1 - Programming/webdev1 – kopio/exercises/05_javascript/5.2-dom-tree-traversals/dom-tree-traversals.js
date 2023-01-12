const start = document.getElementsByTagName('ul')[0];
var i;
for (i = 0; i <= start.childElementCount-1; i++) {
var animals_fish = start.children[i];
    if(animals_fish.hasChildNodes){
        let firstChildren = animals_fish.getElementsByTagName('li');
        //console.log(firstChildren[i].textContent);
        var your_text = document.createTextNode(" ("+firstChildren.length+")");
        console.log(your_text);
        if(your_text!=" (0)"){
            animals_fish.insertBefore(your_text, animals_fish.children[0]);
            animals_fish.normalize();
        }
        var j;
        console.log(animals_fish.childElementCount);
        for (j = 0; j <= animals_fish.childElementCount-1; j++) {
            if(firstChildren[j].hasChildNodes){
                let secondChildren = firstChildren[j].getElementsByTagName('li');
                var your_text = document.createTextNode(" ("+secondChildren.length+")");
                console.log(your_text);
                if(your_text!=" (0)"){
                    firstChildren[j].insertBefore(your_text, firstChildren[j].children[0]);
                    firstChildren[j].normalize();
                }
                var k;
                console.log(firstChildren[j].childElementCount);
                for (k = 0; k <= firstChildren[j].childElementCount-1; k++) {
                    if(secondChildren[k].hasChildNodes){
                        let thirdChildren = secondChildren[k].getElementsByTagName('li');
                        var your_text = document.createTextNode(" ("+thirdChildren.length+")");
                        console.log(your_text);
                        if(your_text!=" (0)"){
                            secondChildren[k].insertBefore(your_text, secondChildren[k].children[0]);
                            secondChildren[k].normalize();
                        }
                    }
                    else{
                        //do nothing
                    }
                }k=0;
            }
            else{
                //do nothing
            }
        }j=0;
    }
    else{
        //do nothing
    }
}
//console.log(test);