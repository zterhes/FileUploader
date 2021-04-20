import axios from "axios";


export const uploadFile = async (file) => {
    const fileName = file.name
    console.log(`fileName`, fileName)
    const formData = new FormData()
    formData.append(`File`, file)
    console.log(`formData`, formData)
    await axios.post("http://localhost:8081/upload", formData, {
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    })
        .then(response => console.log(`response`, response))
        .catch(error => console.log(`error`, error))
}