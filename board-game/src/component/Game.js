import React from "react";
import Board from './Board';

export default class Game extends React.Component {
  render() {
    return (
      <div className="App-game">
        <div className="App-game-board">
          <Board/>
        </div>
        <div className="App-game-info">
          <div>{
              // TODO status
          }</div>
          <ol>{
              // TODO
          }</ol>
        </div>
      </div>
    );
  }
}
