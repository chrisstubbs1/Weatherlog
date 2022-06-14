document.addEventListener('DOMContentLoaded', () => {

    let signUpForm = document.getElementById('signUpForm')
    signUpForm.onsubmit = (e) => {
        e.preventDefault()

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
        }).catch(e => console.log(e))
    }


}, false)