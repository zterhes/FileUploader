import logo from './logo.svg';
import './App.css';
import FileUploader from './components/FileUploader'
import styled from 'styled-components';

const Page = styled.div`
display:flex;
flex-direction:column;
justify-content:space-between;
align-items:center;
height:100vh;
width:100vw;
`

const UploaderDiv = styled.div`
width:25%;
height: 50%;
margin-top:15%;
`

const ProjectTab= styled.p`
font-family: Montserrat;
font-style: normal;
font-weight: 500;
font-size: 14px;
line-height: 17px;
text-align: center;

color: #A9A9A9;
`

function App() {
  return (
    <div className="App">
      <Page>
        <UploaderDiv>
          <FileUploader />
        </UploaderDiv>
        <ProjectTab>created by zterhes - devChallenges.io</ProjectTab>
      </Page>
    </div>
  );
}

export default App;
