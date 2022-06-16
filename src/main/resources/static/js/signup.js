document.addEventListener('DOMContentLoaded', () => {

    //add onchange event listeners to validate the 2 passwords are equal
    document.getElementsByClassName('password')[0].onchange = (e) => {
        e.preventDefault()
        if (document.getElementById('password').value !== document.getElementById('confirmPassword').value) {
            document.getElementById('password').setCustomValidity('Passwords must match.');
        } else {
            document.getElementById('password').setCustomValidity('');
        }

    }

    document.getElementsByClassName('password')[1].onchange = (e) => {
        e.preventDefault()
        if (document.getElementById('password').value !== document.getElementById('confirmPassword').value) {
            document.getElementById('password').setCustomValidity('Passwords must match.');
        } else {
            document.getElementById('password').setCustomValidity('');
        }

    }

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
        if (signUpForm.checkValidity() === true){
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
                if (response.status >= 200 && response.status <= 299){
                    alert("Account created successfully!")
                    return
                }

                alert("Account could not be created.")
            })
                .catch(e => console.log(e))
        }


    }
}, false)
