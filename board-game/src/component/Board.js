import React from "react";
import Box from './Box';

export default class Board extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      boxes: Array(9).fill(null)
    };
  }

  renderBox(arg) {
    return <Box value={this.state.boxes[arg]}/>;
  }
  
  render() {
    const status = 'Player: 🔴';

    return (
      <div>
        <div className="App-status">{status}</div>
        <div className="App-board-row">
          {this.renderBox(0)}
          {this.renderBox(1)}
          {this.renderBox(2)}
        </div>
        <div className="App-board-row">
          {this.renderBox(3)}
          {this.renderBox(4)}
          {this.renderBox(5)}
        </div>
        <div className="App-board-row">
          {this.renderBox(6)}
          {this.renderBox(7)}
          {this.renderBox(8)}
        </div>
      </div>
    );
  }
}
