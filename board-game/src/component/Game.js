import React from "react";
import Board from './Board';
import Winner from './Winner';

export default class Game extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      gameLedger: [
        {boxes: Array(9).fill(null)}
      ],
      moveNumber: 0,
      isCrossMarkNext: true
    };
  }

  handleClick(index) {
    const gameLedger = this.state.gameLedger.slice(0, this.state.moveNumber+1);
    const current = gameLedger[gameLedger.length-1];
    const boxes = current.boxes.slice();
    if (Winner(boxes) || boxes[index]) {
      return;
    }
    boxes[index] = this.state.isCrossMarkNext ? "❌" : "⭕";
    this.setState({
      gameLedger: gameLedger.concat([
        {boxes: boxes}
      ]),
      moveNumber: gameLedger.length,
      isCrossMarkNext: !this.state.isCrossMarkNext
    });
  }

  switchTo(play) {
    this.setState({
      moveNumber: play,
      isCrossMarkNext: (play % 2) === 0
    });
  }

  render() {
    const gameLedger = this.state.gameLedger;
    const current = gameLedger[this.state.moveNumber];
    const winner = Winner(current.boxes);
    const moves = gameLedger.map((play, move) => {
      const desc = move ? 'session : ' + move : 'game start';
      return (
        <li key={move}>
          <button onClick={() => this.switchTo(move)}>{desc}</button>
        </li>
      );
    });
    let status;
    if (winner) {
      status = "winner: " + winner;
    } else {
      status = "player: " + (this.state.isCrossMarkNext ? "❌" : "⭕");
    }
    return (
      <section className="App-game">
        <section className="App-game-board">
          <Board 
            boxes={current.boxes} 
            onClick={index => this.handleClick(index)}
          />
        </section>
        <section className="App-game-info">
          <div>{status}</div>
          <ol>{moves}</ol>
        </section>
      </section>
    );
  }
}
