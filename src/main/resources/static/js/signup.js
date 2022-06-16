document.addEventListener('DOMContentLoaded', () => {

    //logic to determine if two passwords are equal
    const customPasswordEqualityChecker = (e) => {
        e.preventDefault()

        if (document.getElementById('password').value !== document.getElementById('confirmPassword').value) {
            document.getElementById('password').setCustomValidity('Passwords must match.');
        } else {
            document.getElementById('password').setCustomValidity('');
        }
    }

    //Logic to determine if firstName is long enough
    const customFirstNameValidator = (e) => {
        e.preventDefault()

        const firstNameInput = document.getElementById('fName')
        if (firstNameInput.value.length < 2) {
            firstNameInput.setCustomValidity('First Name must be greater than 2 characters.')
        } else {
            firstNameInput.setCustomValidity('')
        }

    }

    const customLastNameValidator = (e) => {
        e.preventDefault()

        const lastNameInput = document.getElementById('lName')
        if (lastNameInput.value.length < 2) {
            lastNameInput.setCustomValidity('Last Name must be greater than 2 characters.')
        } else {
            lastNameInput.setCustomValidity('')
        }
    }

    const customUsernameValidator = (e) => {
        e.preventDefault()

        const usernameInput = document.getElementById('uName')
        if (usernameInput.value.length < 4) {
            usernameInput.setCustomValidity('Username must be at least 4 characters.')
        } else {
            usernameInput.setCustomValidity('')
        }

    }

    const customBirthDateValidator = (e) => {
        e.preventDefault()

        const birthdayInput = document.getElementById('bDay')
        const userBirthDate = new Date(birthdayInput.value)
        const currentDate = new Date()

        let yearsInBetween = (userBirthDate.getTime() - currentDate.getTime()) / 1000
        yearsInBetween /= (60 * 60 * 24)
        yearsInBetween = Math.abs(Math.round(yearsInBetween / 365.25))

        yearsInBetween < 2 ? birthdayInput.setCustomValidity('You must be at least 2 years old to sign up') :
            birthdayInput.setCustomValidity('')

    }


    //attach the custom validations
    document.getElementsByClassName('password')[0].onchange = customPasswordEqualityChecker
    document.getElementsByClassName('password')[1].onchange = customPasswordEqualityChecker
    document.getElementById('fName').onchange = customFirstNameValidator
    document.getElementById('lName').onchange = customLastNameValidator
    document.getElementById('uName').onchange = customUsernameValidator
    document.getElementById('bDay').onchange = customBirthDateValidator

    //Logic to launch the modal
    const launchModal = (title, message) => {
        document.getElementById()
    }

    //add the submission event listener on the form here
    let signUpForm = document.getElementById('signUpForm')
    signUpForm.onsubmit = (e) => {
        //Validate the form inputs here
        e.preventDefault()

        if (signUpForm.checkValidity() === false) {

            e.preventDefault();
            e.stopPropagation();
        }

        signUpForm.classList.add('was-validated');


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////


        //if the form is valid submit the request
        if (signUpForm.checkValidity() === true) {
            let formData = new FormData(document.getElementById('signUpForm'))
            const data = {}

            formData.forEach(((value, key) => data[key] = value))

            const jsonData = JSON.stringify(data)

            fetch('http://localhost:8080/api/users/', {
                method: 'POST',
                body: jsonData,
                headers: {
                    "Content-type": "application/json; charset=UTF-8"
                }
            }).then(response => {
                if (response.status >= 200 && response.status <= 299) {
                    alert("Account created successfully!")
                    // document.getElementById('exampleModal').click()
                    return
                }

                alert("Account could not be created.")
            })
                .catch(e => console.log(e))
        }
    }

}, false)
