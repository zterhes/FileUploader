import React, { useCallback } from 'react'
import { useDropzone } from 'react-dropzone'
import styled from "styled-components";
import img from "../img/image.svg"
import { uploadFile } from "../communications/fileApi"



const DropZoneStyle = styled.div`
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
`


const DragAndDrop = () => {
    const onDrop = useCallback(acceptedFiles => {
        uploadFile(acceptedFiles)
    }, [])

    const { getRootProps, getInputProps, isDragActive } = useDropzone({ onDrop, noClick: true })

    return (
        <DropZoneStyle {...getRootProps()}>
            <input {...getInputProps()} />
            <img src={img} alt="" />
            <Text>Drop the files here ...</Text>
        </DropZoneStyle>

    )
}

export default DragAndDrop

