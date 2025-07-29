import React, { useState } from "react";

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState("");
  const [complaint, setComplaint] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!employeeName || !complaint) {
      alert("Please fill all fields");
      return;
    }

    const refNumber = Math.floor(Math.random() * 90000) + 10000;
    alert(
      `Thanks ${employeeName}!\nYour complaint has been registered with Reference Number: ${refNumber}`
    );

    setEmployeeName("");
    setComplaint("");
  };

  return (
    <div>
      <h2>Complaint Registration</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Employee Name:</label>
          <br />
          <input
            type="text"
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            placeholder="Enter your name"
          />
        </div>
        <br />
        <div>
          <label>Complaint:</label>
          <br />
          <textarea
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            placeholder="Describe your complaint"
            rows="4"
            cols="40"
          />
        </div>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
