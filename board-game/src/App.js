import React from "react";
import './App.css';
import Game from './component/Game';

export default class App extends React.Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <Game/>
        </header>
      </div>
    );
  }
}
