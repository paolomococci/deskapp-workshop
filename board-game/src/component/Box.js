import React from "react";

export default class Box extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      text: "clickable"
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
      <button className="App-box" onClick={() => alert('You clicked on a box.')}>
        {
          this.props.value
        }
      </button>
    );
  }
}
