import logo from './logo.svg';
import './App.css';
import FileUploader from './components/FileUploader'
import styled from 'styled-components';

const Page = styled.div`
display:flex;
justify-content:center;
align-items:center;
height:100vh;
width:100vw;
`

const UploaderDiv = styled.div`
width:25%;
height: 50%;

`

function App() {
  return (
    <div className="App">
      <Page>
        <UploaderDiv>
          <FileUploader />
        </UploaderDiv>
      </Page>
    </div>
  );
}

export default App;
