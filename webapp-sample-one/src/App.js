import React, {useState} from "react";
import Button from "./component/Button";
import './App.css';

const App = () => {

  const [text, setText] = useState("clickable");

  function handleClick() {
    setText("clicked");
  }

  return (
    <div className="app">
      <header className="app-header">
        <h1 class="app-title">sample one</h1>
        <Button text={text} handleClick={handleClick}/>
      </header>
    </div>
  );
}

export default App;
