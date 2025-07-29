import React from "react";
import "./App.css";

function App() {
  const heading = <h2 style={{ color: "blue" }}>Office Space Rental App</h2>;

  const officeImage =
    "https://i.pinimg.com/originals/59/ec/28/59ec2823567a4dff1f3e86bb3aecfc9d.jpg";

  const officeSpaces = [
    {
      name: "Space One",
      rent: 45000,
      address: "Koramangala, Bangalore",
    },
    {
      name: "Space Two",
      rent: 65000,
      address: "Powai, Mumbai",
    },
    {
      name: "Space Three",
      rent: 55000,
      address: "Baner, Pune",
    },
    {
      name: "Space Four",
      rent: 70000,
      address: "Cyber City, Gurgaon",
    },
  ];

  return (
    <div>
      {heading}

      <img
        src={officeImage}
        alt="Office Space"
        style={{
          width: "25%",
          height: "25%",
          display: "block",
          marginBottom: "20px",
        }}
      />

      <ul>
        {officeSpaces.map((office, index) => {
          const rentStyle = {
            color: office.rent < 60000 ? "red" : "green",
            fontWeight: "bold",
          };

          return (
            <li key={index} style={{ marginBottom: "15px" }}>
              <p>
                <strong>Name:</strong> {office.name}
              </p>
              <p>
                <strong style={rentStyle}>Rent:</strong>{" "}
                <span style={rentStyle}>Rs. {office.rent}</span>
              </p>
              <p>
                <strong>Address:</strong> {office.address}
              </p>
              <hr />
            </li>
          );
        })}
      </ul>
    </div>
  );
}

export default App;
