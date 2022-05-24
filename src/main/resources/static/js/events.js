document.addEventListener('DOMContentLoaded', () => {

    let row = Array.from(document.getElementsByClassName('weRow'))
    row.map(element => {
        element.onclick = () => {
            console.log('pressed')
        }
    })

})
