/**
 * TODO: 8.3 Register new user
 *       - Handle registration form submission
 *       - Prevent registration when password and passwordConfirmation do not match
 *       - Use createNotification() function from utils.js to show user messages of
 *       - error conditions and successful registration
 *       - Reset the form back to empty after successful registration
 *       - Use postOrPutJSON() function from utils.js to send your data back to server
 */

const register = document.getElementById('btnRegister').addEventListener('click', registerUser);

/**
 * Function for registering a new user
 *
 * @param {object} event Event object
 * @returns {void}
 */
function registerUser(event) {
    // Prevent default form submit event
    event.preventDefault();
    // Store filled form values into variables
    const name = document.querySelector('#name').value;
    const email = document.querySelector('#email').value;
    const password = document.querySelector('#password').value;
    const passwordConfirmation = document.querySelector('#passwordConfirmation').value;

    // Show user notification if password does not match with the password confirmation
    if (password !== passwordConfirmation) {
        createNotification('Password and password confirmation do not match', 'notifications-container', false);
    }
    // Show user notification if password's length is less than 10 characters 
    else if (password.length < 10){
        createNotification('Password must contain atleast 10 characters', 'notifications-container', false);
    } 
    // Successful registration of a new user
    else {
        const userData = {
            "name" : name,
            "email" : email,
            "password" : password
        };

        postOrPutJSON('/api/register', 'POST', userData).then(response => {
            // Reset the form back to empty
            document.querySelector('#name').value = "";
            document.querySelector('#email').value = "";
            document.querySelector('#password').value = "";
            document.querySelector('#passwordConfirmation').value = "";
            // Show user notification of successful registration
            createNotification('Registration successful', 'notifications-container');
        });
    }
}