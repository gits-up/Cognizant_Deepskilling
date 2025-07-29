import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0,
    };
  }

  increment = () => {
    this.setState((prev) => ({ counter: prev.counter + 1 }));
  };

  sayHello = () => {
    alert("Hello! Counter was incremented.");
  };

  decrement = () => {
    this.setState((prev) => ({ counter: prev.counter - 1 }));
  };

  handleWelcome = (message) => {
    alert(`Welcome: ${message}`);
  };

  handleSyntheticEvent = (e) => {
    e.preventDefault();
    alert("I was clicked");
  };

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h2>React Event Handling Examples</h2>

        <h3>Counter: {this.state.counter}</h3>
        <button
          onClick={() => {
            this.increment();
            this.sayHello();
          }}
        >
          Increment
        </button>
        <button onClick={this.decrement}>Decrement</button>

        <hr />

        <button onClick={() => this.handleWelcome("welcome")}>
          Say Welcome
        </button>

        <hr />

        <button onClick={this.handleSyntheticEvent}>OnPress</button>

        <hr />

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
