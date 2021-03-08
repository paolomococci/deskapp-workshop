import React from "react";

const Box = (props) => {
  return (
      <button className="App-box" onClick={props.onClick}>
          {props.value}
      </button>
  );
}

export default Box;
