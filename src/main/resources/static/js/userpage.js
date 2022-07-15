document.addEventListener('DOMContentLoaded', () => {

    const createButton = document.getElementById('btn-create')
    const viewButton = document.getElementById('btn-view')
    const feedButton = document.getElementById('btn-event')
    const settingsButton = document.getElementById('btn-settings')

    createButton.onclick = (e) => {

        document.querySelector('.active').classList.remove('active')
        createButton.classList.add('active')

        document.querySelector('.main-area').innerHTML = ''

        fetch('http://localhost:8080/createfrag')
            .then(response => response.text())
            .then(response => document.querySelector('.main-area').innerHTML = response)

    }

    viewButton.onclick = (e) => {

        document.querySelector('.active').classList.remove('active')
        viewButton.classList.add('active')
    }

    feedButton.onclick = (e) => {

        document.querySelector('.active').classList.remove('active')
        feedButton.classList.add('active')

        document.querySelector('.main-area').innerHTML = ''


        fetch('http://localhost:8080/feedfrag')
            .then(response => response.text())
            .then(response => document.querySelector('.main-area').innerHTML = response)
    }

    settingsButton.onclick = (e) => {

        document.querySelector('.active').classList.remove('active')
        settingsButton.classList.add('active')
    }


})
