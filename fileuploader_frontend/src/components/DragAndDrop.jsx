import React, { createRef, useCallback } from 'react'
import { useDropzone } from 'react-dropzone'
import styled from "styled-components";
import img from "../img/image.svg"
import { uploadFile } from "../communications/fileApi"



const DropZoneStyle = styled.div`
display:flex;
flex-direction:column;
justify-content:space-evenly;
align-items:center;
width: 338px;
height: 218.9px;
background: #F6F8FB;
border: 1px dashed #97BEF4;
box-sizing: border-box;
border-radius: 12px;
`

const Text = styled.p`
width: 166.01px;
height: 17.99px;
left: 643.17px;
top: 589.3px;

font-family: Poppins;
font-style: normal;
font-weight: 500;
font-size: 12px;
line-height: 18px;
letter-spacing: -0.035em;
color: #BDBDBD;
`

const Button = styled.button`
background: #2F80ED;
border-radius: 8px;
color:white;
height:10%;
width:25%;
`


const DragAndDrop = ({setResponseData,buttonStyle}) => {
    const onDrop = async acceptedFile => {
        const responseData = await uploadFile(acceptedFile[0])
        console.log('responseData onDrop :>> ', responseData);
        setResponseData(responseData)
    }

    const { getRootProps, getInputProps,open } = useDropzone({ onDrop, noClick: true, maxFiles: 1})

    return (
        <>
            <DropZoneStyle  {...getRootProps()} >
                <input {...getInputProps()} />
                <img src={img} alt="" />
                <Text>Drag and Drop your image here</Text>
            </DropZoneStyle>
            <Text textSize="10px" color="#828282">Or</Text>
            <Button onClick={open}>Choose file</Button>
        </>
    )
}

export default DragAndDrop

