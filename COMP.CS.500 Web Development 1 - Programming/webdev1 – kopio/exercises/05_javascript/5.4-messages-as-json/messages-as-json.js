var contacts = document.getElementById("contacts");
document.addEventListener('userDataReady', function (event) {
    //console.log(event.detail.jsonText);
    var obj = JSON.parse(event.detail.jsonText); //parse json
    //console.log(obj);
    var i;
    for (i = 0; i < obj.length; i++) {//loop contacts
        var newUser = document.getElementById("user-card-template"); //get template
        var clone = newUser.content.cloneNode(true); //clone template
        var card = clone.childNodes[1]; //get card div
        //console.log(card);
        card.childNodes[1].alt=obj[i].firstName+" "+obj[i].lastName;//imgAltName
        card.childNodes[1].src=obj[i].avatar;//Avatar
        card.childNodes[3].textContent=obj[i].firstName+" "+obj[i].lastName;//Name
        card.childNodes[5].textContent=obj[i].email;//Email
        card.childNodes[7].childNodes[1].textContent=obj[i].phoneNumber;//Number
        card.childNodes[9].childNodes[1].textContent=obj[i].address.streetAddress;//streetAddress
        card.childNodes[9].childNodes[3].textContent=obj[i].address.zipCode+" "+obj[i].address.city;//zip and city
        card.childNodes[9].childNodes[5].textContent=obj[i].address.country;//country
        card.childNodes[11].childNodes[0].textContent=obj[i].homepage;//homepage
        card.childNodes[11].childNodes[0].href=obj[i].homepage;//homepage
        contacts.appendChild(clone);//add to contacts
    }

});
fetchUserData();