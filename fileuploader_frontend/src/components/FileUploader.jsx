import React, { useState, useEffect } from 'react';
import styled from "styled-components";
import DragAndDrop from './DragAndDrop'

const UploaderBackground = styled.div`
display:flex;
flex-direction:column;
justify-content:space-around;
align-items:center;
height: 100%;
width: 100%;
background-color:white;
border-radius: 12px;
box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
`

const Text = styled.p`
font-size: ${props => props.textSize};
font-family: Poppins;
color: ${props => props.color};
font-weight: 500;
white-space: nowrap;
overflow: hidden;
text-overflow: ellipsis;
margin:0px;
`

const ResponsePicImg = styled.img`
max-height: 50%;
max-width: 90%;
border-radius: 12px;
`

const Button = styled.button`
background: #2F80ED;
border-radius: 8px;
color:white;
white-space: nowrap;
height:100%;
`
const Linkdiv = styled.div`
display:flex;
justify-content:space-between;
align-items:center;
width:80%;
height:6%;
background: #F6F8FB;
border: 1px solid #E0E0E0;
box-sizing: border-box;
border-radius: 8px;
`
const FileUploader = () => {
    const [responseData, setResponseData] = useState(false)
    useEffect(() => {
        console.log('responseDataUploader :>> ', responseData);
    }, [responseData])
    return (
        <>
            {
                responseData.uploaded ? (
                    <UploaderBackground>
                        <svg xmlns="http://www.w3.org/2000/svg" width="10%" height="10%" fill="#219653" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
                            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
                        </svg>
                        <Text textSize="25px" color="#4F4F4F">Uploaded Successfully!</Text>
                        <ResponsePicImg src={responseData.downloadUrl} alt="" />
                        <Linkdiv>
                            <Text textSize="10px">{responseData.downloadUrl}</Text>
                            <Button onClick={() => navigator.clipboard.writeText(responseData.downloadUrl)}>Copy link</Button>
                        </Linkdiv>
                    </UploaderBackground>
                ) :
                    (
                        <UploaderBackground>
                            <Text textSize="25px" color="#4F4F4F">Upload your image</Text>
                            <Text textSize="15px" color="#828282">File should be Jpeg, Png,...</Text>
                            <DragAndDrop setResponseData={setResponseData} buttonStyle={Button}></DragAndDrop>
                        </UploaderBackground>
                    )
            }
        </>
    );
}

export default FileUploader;