import React, { useState, useEffect } from 'react';
import styled from "styled-components";
import DragAndDrop from './DragAndDrop'

const UploaderBackground = styled.div`
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
`

const FileUploader = () => {
    const [responseData, setResponseData] = useState()
    useEffect(() => {
        console.log('responseDataUploader :>> ', responseData);
    }, [responseData])
    return (
        <UploaderBackground>
            <Text textSize="18px" color="#4F4F4F">Upload your file</Text>
            <Text textSize="10px" color="#828282">File should be Jpeg, Png,...</Text>
            <DragAndDrop setResponseData={setResponseData}></DragAndDrop>
        </UploaderBackground>
    );
}

export default FileUploader;