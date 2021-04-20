import axios from "axios";


export const uploadFile = async (files) => {
    await axios.post("http://localhost:8081/upload", files)
        .then(response => console.log(`response`, response))
        .catch(error => console.log(`error`, error))
}