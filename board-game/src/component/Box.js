import React from "react";

export default class Box extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      text: null
    };
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState((prevState, props) => {
      return {text: "clicked"};
    });
  }

  render() {
    return (
      <button 
        className="App-box" 
        onClick={() => this.setState({value: '🔴'})}>
        {
          this.state.value
        }
      </button>
    );
  }
}
