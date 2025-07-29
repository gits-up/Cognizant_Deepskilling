import React, { Component } from "react";
import Guest from "./Guest";
import User from "./User";

class LoginControl extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false,
    };
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  };

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  };

  render() {
    const { isLoggedIn } = this.state;

    let button;
    let page;

    if (isLoggedIn) {
      button = <button onClick={this.handleLogout}>Logout</button>;
      page = <User />;
    } else {
      button = <button onClick={this.handleLogin}>Login</button>;
      page = <Guest />;
    }

    return (
      <div>
        {button}
        <hr />
        {page}
      </div>
    );
  }
}

export default LoginControl;
