import logo from './logo.svg';
import './App.css';
import FileUploader from './components/FileUploader'
import styled from 'styled-components';

const Page = styled.div`
display:flex;
justify-content:center;
align-items:center;
`

const UploaderDiv = styled.div`
width: 402px;
height: 469px;

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
