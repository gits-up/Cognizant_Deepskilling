import React from "react";

class Getuser extends React.Component {
  constructor() {
    super();
    this.state = {
      user: null,
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch("https://api.randomuser.me/");
      const data = await response.json();
      this.setState({ user: data.results[0] });
    } catch (error) {
      console.error("Error fetching user:", error);
    }
  }

  render() {
    const { user } = this.state;

    if (!user) {
      return <h3>Loading user...</h3>;
    }

    return (
      <div>
        <h2>User Info</h2>
        <p>
          <strong>Name:</strong> {user.name.title} {user.name.first}
        </p>
        <img src={user.picture.large} alt="User" />
      </div>
    );
  }
}

export default Getuser;
