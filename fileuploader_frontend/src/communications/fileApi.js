import axios from "axios";


export const uploadFile = async (file) => {
    const formData = new FormData()
    formData.append(`File`, file)
    return await axios.post("http://localhost:8081/upload", formData, {
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    })
        .then(response => {
            console.log(`responseData`, response.data)
            return response.data
        })
        .catch(error => console.log(`error`, error))
}