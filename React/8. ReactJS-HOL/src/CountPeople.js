import React from 'react';

class CountPeople extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    const buttonStyle = {
      backgroundColor: 'lightgreen',
      padding: '10px 20px',
      margin: '10px',
      border: '1px solid #ccc',
      borderRadius: '5px',
      fontWeight: 'bold',
      cursor: 'pointer'
    };

    return (
      <div style={{ textAlign: 'center' }}>
        <h2 style={{ color: 'blue' }}>Counter App</h2>
        <p>People Entered: {this.state.entrycount}</p>
        <p>People Exited: {this.state.exitcount}</p>
        <button onClick={this.updateEntry} style={buttonStyle}>Login</button>
        <button onClick={this.updateExit} style={buttonStyle}>Exit</button>
      </div>
    );
  }
}

export default CountPeople;
