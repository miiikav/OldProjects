
    //var classList = document.getElementById("ordered");
    var naviList = document.getElementsByClassName("navi")[0];
    naviList.classList.add("list");
    //naviList.parentNode.insertBefore(classList,naviList.nextSibling);
    //naviList.appendChild(classList);
    var newList = document.createElement("li");
    var newLink = document.createElement("a");
    var alink = document.createAttribute("href");       // Create a "class" attribute
    alink.value = "http://localhost:3000/";                       // Set the value of the class attribute
    newLink.textContent = "Localhost";
    newLink.setAttributeNode(alink);
    newList.appendChild(newLink);
    naviList.appendChild(newList);
    var newList2 = document.createElement("li");
    var text = document.createTextNode("Item 0");
    newList2.appendChild(text);
    naviList.appendChild(newList2);
    var firstItem = naviList.firstElementChild;
    console.log(firstItem);
    firstItem.insertBefore(newList2, firstItem.firstChild);
    
    var edit = document.getElementById("todo");
    //edit.removeAttribute("class");
    edit.classList.remove("navi");
    var remove = edit.getElementsByTagName("li")[1];
    edit.removeChild(remove);
