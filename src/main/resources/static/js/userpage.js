document.addEventListener('DOMContentLoaded', () => {

    const createButton = document.getElementById('btn-create')
    const viewButton = document.getElementById('btn-view')
    const feedButton = document.getElementById('btn-event')
    const settingsButton = document.getElementById('btn-settings')

    createButton.onclick = (e) => {

        document.querySelector('.active').classList.remove('active')
        createButton.classList.add('active')
    }

    viewButton.onclick = (e) => {

        document.querySelector('.active').classList.remove('active')
        viewButton.classList.add('active')
    }

    feedButton.onclick = (e) => {

        document.querySelector('.active').classList.remove('active')
        feedButton.classList.add('active')
    }

    settingsButton.onclick = (e) => {

        document.querySelector('.active').classList.remove('active')
        settingsButton.classList.add('active')
    }


})
