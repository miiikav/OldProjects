 var MyApp = {}; // Globally scoped object
 const countriesList = document.getElementById("countries"); //<div id=countries>
 const alpha_container = document.getElementById("alpha_container");
 //var countryElement = document.getElementsByClassName("country");
 MyApp.countries; //kaikkien maiden tiedot
 MyApp.level=1; // 1=aloitusmaat 2=aloitusmaan naapurimaat 3=naapurimaiden naapurimaat
//let validCountries;// Maat joilla on naapurimaita
//var startList;//Aloitusmaiden lista
MyApp.selectedCountriesList = []; //Valituiden maiden lista
MyApp.countrynumber = 0; //Maiden jÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤rjestysnumerot
//var validBorderingCountries;
MyApp.divlevel = false;
//fetch('https://restcountries.eu/rest/v2/all/') //Haetaan tiedot 
fetch('https://restcountries.com/v2/all/') //Haetaan tiedot //päivitetty 3.2.2023
.then(res => res.json()
	.then(data => initialize(data)))
.catch(err => console.log("Error:",err));
function initialize(countriesData) {
    MyApp.countries = countriesData;
    //console.log("function initialize");
    //console.log(countries);
    //for(let i=0; i<countries.lenght; i++){
	//console.log(_.size(MyApp.countries[6].borders));
    MyApp.validCountries = _.filter(MyApp.countries, function(country){return _.size(country.borders)>1;}); //rajataan maita
	console.log(MyApp.validCountries[1].name);
	MyApp.startList=_.sample(MyApp.validCountries,3);
	console.log("startList test: "+MyApp.startList[0].alpha3Code+MyApp.startList[1].alpha3Code+MyApp.startList[2].alpha3Code);
	
	let temp = "";
	MyApp.startList.forEach(country => generateCountryCards(country));
	MyApp.level++;
	//var countryElement = document.querySelectorAll("#countries div");
	//

	//var countryElement = document.getElementById(startList[0].alpha3Code);
	//console.log(startList[2].value);
	//.innerHTML = temp;
	//for(var i = 0; i <2; i++){
		//displayCountryInfo(startList[i].value);
	//}    
        //console.log(countries[i].all);
        //var output = JSON.stringify(json);
    //}
    //countries.forEach(country => temp+=`<p value="${country.alpha3Code}"><em>${country.name}: </em>${country.capital}</p>`);
    //countriesList.innerHTML = temp;
}      

    //"name:" + ${countries[i].name} +  ${countries[i].topLevelDomain}
        
//console.log("test");
//countryElement.onclick = countryClicked();
function countryClicked(countryid, countrynumber) {
    console.log("countryClicked id="+countryid);
    console.log("countrynumber ="+countrynumber);
    

    //document.getElementById(countryid).style.backgroundColor = "lightblue";
    //MyApp.trueLevelId=document.getElementById(countryid).parentNode.id;
    var allCountryidCountries=document.querySelectorAll(`#${countryid}`); //sama maa saattaa olla useaan kertaan taulukossa
    var j = 0;
    console.log(j+" vs "+ _.size(allCountryidCountries));
    while( _.size(allCountryidCountries)>j){
        //console.log("allCountryidCountries[j].getAttribute('countrynumber')"+allCountryidCountries[j].getAttribute('countrynumber')+"vs"+countrynumber);
        if(allCountryidCountries[j].getAttribute('countrynumber')===`"${countrynumber}"`){ //Haetaan oikea maa jÃ¤rjestysnumeron perustella
            //console.log("allCountryidCountries[j] test ="+allCountryidCountries[j].getAttribute('countrynumber'));
            
            MyApp.trueLevelId=allCountryidCountries[j].parentNode.id; //Haetaan valitun maan taso
            //console.log("allCountryidCountries[j] test2 ="+allCountryidCountries[j].parentNode.id);
            //console.log("allCountryidCountries[j] test3 ="+allCountryidCountries[j].parentNode);
            var selectedElement = allCountryidCountries[j];
            while (selectedElement.nextElementSibling != null) { //poistaa naapureilta mahdollisen sinisen taustan
                selectedElement.nextElementSibling.style.backgroundColor = "#eee";
                selectedElement=selectedElement.nextElementSibling;
            }
            while (selectedElement.previousElementSibling != null) { //poistaa naapureilta mahdollisen sinisen taustan
                selectedElement.previousElementSibling.style.backgroundColor = "#eee";
                selectedElement=selectedElement.previousElementSibling;
            }
            allCountryidCountries[j].style.backgroundColor = "lightblue"; // v�rj�t��n valitun maan tausta siniseksi
        }
        j++;
    }
    //console.log("allCountryidCountries[0] ="+allCountryidCountries[0].getAttribute('countrynumber'));
    //console.log("allCountryidCountries[1] ="+allCountryidCountries[1].id);
    //console.log("allCountryidCountries[2] ="+allCountryidCountries[2].id);
    //MyApp.trueLevelId=document.getElementById(countryid).getAttribute("countrynumber");
    //MyApp.trueLevelId=MyApp.trueLevelId.parentNode.id;
    //MyApp.trueLevelId=document.querySelector("['countrynumber'=Ã‚Â´${countrynumber}Ã‚Â´]");//.parentNode.id;
    console.log("MyApp.trueLevelId="+MyApp.trueLevelId);
    MyApp.levelId=document.getElementById(`level${MyApp.level-1}`).id;
    console.log("MyApp.levelId="+MyApp.levelId);
    while(MyApp.levelId!=MyApp.trueLevelId){
    console.log(MyApp.trueLevelId+MyApp.levelId);
            var removeElement = document.getElementById(MyApp.levelId);
            removeElement.parentNode.removeChild(removeElement);
            var returncountry = MyApp.selectedCountriesList.pop();
            MyApp.countries.push(returncountry);
            MyApp.level--;
            MyApp.levelId=document.getElementById(`level${MyApp.level-1}`).id;
    }
    //// Highlight this element (=event.target node)     
    //MyApp.alpha3CodeList.push(countryid);// Add alpha3Code to list of selected countries 
    var findcountry = _.find(MyApp.countries, function(country){return country.alpha3Code==countryid;}); //etsitÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤n maata alpha3Code perusteella. console.log("alpha3Code vs countryid = "+country.alpha3Code+" vs "+countryid);
    console.log("findcountry name ="+findcountry.name);
    MyApp.countries = _.filter(MyApp.countries, function(country){return country.alpha3Code!=findcountry.alpha3Code; }); //poistetaan maa luettelosta
    MyApp.selectedCountriesList.push(findcountry);// Add alpha3Code to list of selected countries 
    if(findcountry == null){ // Eli se maa on jo valittu aikaisemmin
        var findcountry = _.find(MyApp.selectedCountriesList, function(country){return country.alpha3Code==countryid;}); // Haetaan maa listalta
        //document.getElementById(findcountry.alpha3Code).style.backgroundColor = "#eee";// vaihdetaan vÃ¤ri valkoiseksi
        MyApp.selectedCountriesList = _.filter(MyApp.selectedCountriesList , function(country){return country.alpha3Code!=findcountry.alpha3Code; }); //Poistetaan maa listalta
        MyApp.countries.push(findcountry); // Palautetaan maa muiden ei valittujen maiden joikkoon
    }
        //if(MyApp.selectedCountriesList[0]==null){
                //MyApp.selectedCountriesList[0] = findcountry;
                //console.log("selectedCountriesList = "+MyApp.selectedCountriesList[0].alpha3Code);
        //}
        //else{
                //MyApp.selectedCountriesList[_.size(MyApp.selectedCountriesList)+1] = findcountry;
        //}
        //console.log("test ="+MyApp.countries[1].alpha3Code);//ALB
    var borderList =[]; //Lista valitun maan naapurimaista
    var i=0;
    while( _.size(findcountry.borders)>i){
        var temp=findcountry.borders[i];
        console.log(temp);
        temp2= _.find(MyApp.countries, function(country){return country.alpha3Code==temp;});
        //console.log("temp2 name ="+temp2.name);
        if(temp2!=null){
                if(_.size(temp2.borders)>1){
                    console.log("temp2 name ="+temp2.name);
                    borderList.push(temp2);
                }
        }
        i++;
    }
    i=0;
    if(_.size(borderList)!==0){
        //console.log("borderList size test"+ _.size(borderList));
        var validBorderingCountries = _.filter(borderList, function(country){return _.size(country.borders)>1}); //rajataan maita	// Get valid bordering countries
        //var findAlpha3CodeListCountry = _.find(MyApp.countries, function(country){console.log("alpha3Code vs alpha3CodeList = "+country.alpha3Code+" vs "+MyApp.alpha3CodeList);return country.alpha3Code==MyApp.alpha3CodeList;});
        //console.log("findAlpha3CodeList name ="+MyApp.alpha3CodeList[0]);

        console.log("borderList name ="+borderList[0].name);
        console.log("validBorderingCountries name ="+validBorderingCountries[0].name);
        if(MyApp.level>=1){
            validBorderingCountries.forEach(country => generateCountryCards(country)); // Generate new DOM nodes
            //removeCountryCards(countryid);
            MyApp.level++;
            updateVisitList(); // Update UI element showing a list of visited countries }
        }
    }
    else{
        updateVisitListEnd();
    }
}
function updateVisitListEnd(){
    var Txtcontent="END OF LIST"
    var alphaName = document.createElement("p");
    alphaName.id = "ENDING";
    var alphaTxt = document.createTextNode(Txtcontent);
    alphaName.appendChild(alphaTxt);
    alphaName.style.color = "red";
    alpha_container.appendChild(alphaName);
}
function updateVisitList(){
    var i =0;
    var removeList=document.querySelectorAll("#alpha_container > p");
    Array.prototype.forEach.call( removeList, function( node ) {
         node.parentNode.removeChild( node );
    });
                //var alpha_container = document.createElement("div");
    //alpha_container.id = "alpha_container";
    while(_.size( MyApp.selectedCountriesList)>i){
                        var Txtcontent=MyApp.selectedCountriesList[i].alpha3Code;
                        var alphaName = document.createElement("p");
        alphaName.id = MyApp.selectedCountriesList[i].alpha3Code;
                        var alphaTxt = document.createTextNode(Txtcontent);
        alphaName.appendChild(alphaTxt);
        alpha_container.appendChild(alphaName);

        i++;
    }

}
function generateCountryCards(countries){    // Check if we have any valid countries left
        if(MyApp.level==1){
                if(document.getElementById(`level${MyApp.level}`)==null){
                        var level_container = document.createElement("div");
                        level_container.id = `level${MyApp.level}`
                        level_container.className = 'level';
                        var level_number = document.createElement("h2");
                        var leveltxt = document.createTextNode(`Level ${MyApp.level}`);
                        level_number.appendChild(leveltxt);
                        level_container.appendChild(level_number);
                }
                else{
                        var level_container = document.getElementById(`level${MyApp.level}`);
                }
                var country_container = document.createElement("div");// Generate DOM nodes for countries
                country_container.id = countries.alpha3Code;
                country_container.className = 'country';
                //country_container.value = MyApp.countrynumber;
                country_container.setAttribute('countrynumber',`"${MyApp.countrynumber}"`);
                //console.log(country_container.getAttribute('countrynumber'));
                country_container.setAttribute('onclick',`countryClicked("${countries.alpha3Code}",${country_container.getAttribute('countrynumber')})`); //onclick lisÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤ys html elementtiin. Toimii, mutta ei ehkÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤ paras ratkaisu
                var flag_container = document.createElement("div");
                flag_container.id = "flag-container";
                country_container.appendChild(flag_container);
                var flag = document.createElement("img");
                flag.setAttribute('src',`${countries.flag}`);
                flag.alt = `Flag of ${countries.name}`;
                flag_container.appendChild(flag);
                var info_container = document.createElement("div");
                info_container.id = "info-container";
                country_container.appendChild(info_container);
                var countryname = document.createElement("p");
                var countrynametxt = document.createTextNode(`${countries.name} :`);
                countryname.appendChild(countrynametxt);
                info_container.appendChild(countryname);
                var capital = document.createElement("p");
                var capitaltxt = document.createTextNode(`${countries.capital}`);
                capital.appendChild(capitaltxt);
                info_container.appendChild(capital);
                var currencies = document.createElement("p");
                var currenciestxt = document.createTextNode(`Currencies: ${countries.currencies[0].name} (${countries.currencies[0].code})`);
                currencies.appendChild(currenciestxt);
                info_container.appendChild(currencies);
                var borders = document.createElement("p");
                var borderstxt = document.createTextNode(`Borders: ${countries.borders}`);
                borders.appendChild(borderstxt);
                info_container.appendChild(borders); // Insert DOM nodes into DOM 
                level_container.appendChild(country_container);
                countriesList.appendChild(level_container);
                //return country_container;
                //console.log(level);
        }
        else if(MyApp.level>1){
                console.log("taso2 tai enemmÃ¤n");
                if(document.getElementById(`level${MyApp.level}`)==null){
                        var level_container = document.createElement("div");
                        level_container.id = `level${MyApp.level}`
                        level_container.className = 'level';
                        var level_number = document.createElement("h2");
                        var leveltxt = document.createTextNode(`Level ${MyApp.level}`);
                        level_number.appendChild(leveltxt);
                        level_container.appendChild(level_number);
                }
                else{
                        var level_container = document.getElementById(`level${MyApp.level}`);
                }
                var country_container = document.createElement("div");// Generate DOM nodes for countries
                country_container.id = countries.alpha3Code;
                country_container.className = 'country';
                country_container.setAttribute('countrynumber',`"${MyApp.countrynumber}"`);
                country_container.setAttribute('onclick',`countryClicked("${countries.alpha3Code}",${country_container.getAttribute('countrynumber')})`);//onclick lisÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤ys html elementtiin. Toimii, mutta ei ehkÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¤ paras ratkaisu
                var flag_container = document.createElement("div");
                flag_container.id = "flag-container";
                country_container.appendChild(flag_container);
                var flag = document.createElement("img");
                flag.setAttribute('src',`${countries.flag}`);
                flag.alt = `Flag of ${countries.name}`;
                flag_container.appendChild(flag);
                var info_container = document.createElement("div");
                info_container.id = "info-container";
                country_container.appendChild(info_container);
                var countryname = document.createElement("p");
                var countrynametxt = document.createTextNode(`${countries.name} :`);
                countryname.appendChild(countrynametxt);
                info_container.appendChild(countryname);
                var capital = document.createElement("p");
                var capitaltxt = document.createTextNode(`${countries.capital}`);
                capital.appendChild(capitaltxt);
                info_container.appendChild(capital);
                var currencies = document.createElement("p");
                var currenciestxt = document.createTextNode(`Currencies: ${countries.currencies[0].name} (${countries.currencies[0].code})`);
                currencies.appendChild(currenciestxt);
                info_container.appendChild(currencies);
                var borders = document.createElement("p");
                var borderstxt = document.createTextNode(`Borders: ${countries.borders}`);
                borders.appendChild(borderstxt);
                info_container.appendChild(borders); // Insert DOM nodes into DOM 
                level_container.appendChild(country_container);
                countriesList.appendChild(level_container);
        }
        //country_container.onclick = countryClicked(country_container.id);
        //countryElement = document.getElementsByClassName("country");
        MyApp.countrynumber++;
}
	//function removeCountryCards(countryid) {
    // Removes an element from the document
		//if(MyApp.level==1){
			//while(_.size(MyApp.startList)>i){
				//if(MyApp.startList[i].alpha3Code!=countryid){
					//var element = document.getElementById(MyApp.startList[i].alpha3Code);
					//element.parentNode.removeChild(element);
				//}
			//}
			//i++;
		//}
	//}

//country_container.onclick = countryClicked(country_container.id);