document.addEventListener('DOMContentLoaded', () => {

    let weatherEventForm = document.getElementById('weForm')
    weatherEventForm.onsubmit = (e) => {
        e.preventDefault()

        let formData = new FormData(document.getElementById('weForm'))

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

}, false)

