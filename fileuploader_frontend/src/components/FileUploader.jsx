import React from 'react';
import styled from "styled-components";

const UploaderBackground = styled.div`
height: 100%;
width: 100%;
background-color:white;
border-radius: 12px;
box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
`

const Text = styled.p`
font-size: ${props => props.textSize};
color: #4F4F4F;
`

const FileUploader = () => {
    return (
        <UploaderBackground>
            <Text textSize="18px">Upload your file</Text>
        </UploaderBackground>
    );
}

export default FileUploader;