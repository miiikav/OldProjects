/**
 * TODO: 8.3 List all users (use <template id="user-template"> in users.html)
 *       - Each user should be put inside a clone of the template fragment
 *       - Each individual user HTML should look like this
 *         (notice the id attributes and values, replace "{userId}" with the actual user id)
 *
 *         <div class="item-row" id="user-{userId}">
 *           <h3 class="user-name" id="name-{userId}">Admin</h3>
 *           <p class="user-email" id="email-{userId}">admin@email.com</p>
 *           <p class="user-role" id="role-{userId}">admin</p>
 *           <button class="modify-button" id="modify-{userId}">Modify</button>
 *           <button class="delete-button" id="delete-{userId}">Delete</button>
 *         </div>
 *
 *       - Each cloned template fragment should be appended to <div id="users-container">
 *       - Use getJSON() function from utils.js to fetch user data from server
 */
document.addEventListener("DOMContentLoaded", function() {
  getJSON("/api/users").then(data => {
    listUsers(data);
  });

  const listUsers = data => {
    const usersContainer = document.querySelector("#users-container");
    const template = document.querySelector("#user-template").content;
    data.map((iterData) => {  
      // Clone template elements
      const clone = template.cloneNode(true);

      // Set user's data properties into variables
      const user = iterData;
      const id = user._id;
      const name = user.name;
      const email = user.email;
      const role = user.role;
      
      // Set user data into cloned template elements
      clone.querySelector(".item-row").id = "user-" + id;
      clone.querySelector(".user-name").id = "name-" + id;
      clone.querySelector(".user-name").innerHTML = name;
      clone.querySelector(".user-email").id = "email-" + id;
      clone.querySelector(".user-email").innerHTML = email;
      clone.querySelector(".user-role").id = "role-" + id;
      clone.querySelector(".user-role").innerHTML = role;
      // Add modify and delete buttons from cloned template
      clone.querySelector(".modify-button").id = "modify-" + id;
      clone.querySelector(".delete-button").id = "delete-" + id;
    
      //Append cloned elements into users container
      usersContainer.appendChild(clone);
    });

    // Ex8.5 stuff below
    // Add eventlisteners to delete buttons
    let removeBtn = document.querySelectorAll('.delete-button');
    Array.prototype.map.call(removeBtn, function(currentBtn){
      currentBtn.addEventListener("click", deleteUser);
    });

    // Add eventlisteners to modify buttons
    let modifyBtn = document.querySelectorAll('.modify-button');
    Array.prototype.map.call(modifyBtn, function(currentBtn){
      currentBtn.addEventListener("click", modifyUser);
    });
  };
  
    /**
     * Function for deleting an user
     *
     * @param {object} event Event object
     * @returns {void}
     */
    function deleteUser(event) {
      const deleteBtnId = event.target.id;
      const userId = deleteBtnId.split("-")[1];
      deleteResourse(`api/users/${userId}`).then(data => {
        //Show user notification of successful deletion
        const deletedUserName = data.name;
        createNotification(`Deleted user ${deletedUserName}`, 'notifications-container');
        //Update user listing after successful modification
        updateUserListing();
        // Remove an open user edit form if one exists
        const editFormExists = document.querySelector("#edit-user-form");
        if (editFormExists) {
          removeEditForm();
        }
      });
    }

    /**
     * Function for modifying an user
     *
     * @param {object} event Event object
     * @returns {void}
     */
    function modifyUser(event) {
      // Remove an open user edit form if one exists
      const editFormExists = document.querySelector("#edit-user-form");
      if (editFormExists) {
        removeEditForm();
      }

      // Get user's id from modify button's id attribute
      const modifyBtnId = event.target.id;
      const userId = modifyBtnId.split("-")[1];

      // Get user's data from HTML elements
      const userName = document.querySelector(`#name-${userId}`).innerHTML;
      const userEmail = document.querySelector(`#email-${userId}`).innerHTML;
      const userRole = document.querySelector(`#role-${userId}`).innerHTML;

      // Construct user editing form
      const formContainer = document.querySelector("#modify-user");
      const formTemplate = document.querySelector("#form-template").content;

      // Clone template elements
      const clone = formTemplate.cloneNode(true);

      // Set data properties of the user to be modified into cloned template elements
      clone.querySelector("#edit-user-form > h2").innerHTML = `Modify user ${userName}`;
      clone.querySelector('input[name="_id"]').setAttribute("value", userId);
      clone.querySelector('input[name="name"]').setAttribute("value", userName);
      clone.querySelector('input[name="email"]').setAttribute("value", userEmail);
      clone.querySelector('#role-input').value = userRole;
      
      // Append cloned elements into edit form container
      formContainer.appendChild(clone);

      // Add eventlistener to edit form's Update button
      const editUpdateBtn = document.querySelector("#update-button");
      editUpdateBtn.addEventListener("click", updateUser);

    };

    /**
     * Function for updating modified user
     *
     * @param {object} event Event object
     * @returns {void}
     */
    function updateUser(event){
      // Prevent default form submit event
      event.preventDefault();
      // Store filled form values into variables
      const id = document.querySelector('#id-input').value;
      const name = document.querySelector('#name-input').value;
      const email = document.querySelector('#email-input').value;
      const role = document.querySelector('#role-input').value;

      // Successful user modify
      const userData = {
          "_id" : id,
          "name" : name,
          "email" : email,
          "role" : role
      };

      postOrPutJSON(`api/users/${id}`, 'PUT', userData).then(response => {
          // Show user notification of successful modification
          createNotification(`Updated user ${name}`, 'notifications-container');
          //Remove edit form after successful modification
          removeEditForm();
          //Update user listing after successful modification
          updateUserListing();
      });
    };

    /**
     * Function for updating user listing. Retrieves all users from backend so it is up to date.
     *
     * @returns {void}
     */
    function updateUserListing(){
      document.querySelector("#users-container").innerHTML = "";
      getJSON("/api/users").then(data => {
        listUsers(data);
      });
    };

    /**
     * Function for removing user edit form elements
     *
     * @returns {void}
     */
    function removeEditForm(){
      const editForm = document.querySelector("#edit-user-form");
      editForm.remove();
    }
});
/*
 * TODO: 8.5 Updating/modifying and deleting existing users
 *       - Use postOrPutJSON() function from utils.js to send your data back to server
 *       - Use deleteResource() function from utils.js to delete users from server
 *       - Clicking "Delete" button of a user will delete the user and update the listing accordingly
 *       - Clicking "Modify" button of a user will use <template id="form-template"> to
 *         show an editing form populated with the values of the selected user
 *       - The edit form should appear inside <div id="modify-user">
 *       - Afted successful edit of user the form should be removed and the listing updated accordingly
 *       - You can use removeElement() from utils.js to remove the form.
 *       - Remove edit form from the DOM after successful edit or replace it with a new form when another
 *         user's "Modify" button is clicked. There should never be more than one form visible at any time.
 *         (Notice that the edit form has an id "edit-user-form" which should be unique in the DOM at all times.)
 *       - Also remove the edit form when a user is deleted regardless of which user is deleted.
 *       - Modifying a user successfully should show a notification message "Updated user {User Name}"
 *       - Deleting a user successfully should show a notification message "Deleted user {User Name}"
 *       - Use createNotification() function from utils.js to create notifications
 */
