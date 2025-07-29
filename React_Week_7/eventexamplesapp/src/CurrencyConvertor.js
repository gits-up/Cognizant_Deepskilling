import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      inr: "",
      euro: "",
    };
  }

  handleChange = (e) => {
    this.setState({ inr: e.target.value });
  };

  handleSubmit = () => {
    const euroValue = (parseFloat(this.state.inr) / 90).toFixed(2);
    this.setState({ euro: euroValue });
  };

  render() {
    return (
      <div>
        <h3 style={{ color: "green" }}>Currency Convertor (INR ➝ EUR)</h3>
        <input
          type="number"
          value={this.state.inr}
          onChange={this.handleChange}
          placeholder="Enter amount in INR"
        />
        <button onClick={this.handleSubmit}>Convert</button>
        {this.state.euro && <p>Converted Value in Euro: €{this.state.euro}</p>}
      </div>
    );
  }
}

export default CurrencyConvertor;
