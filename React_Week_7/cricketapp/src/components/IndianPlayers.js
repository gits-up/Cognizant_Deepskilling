import React from "react";

const IndianPlayers = () => {
  const OddTeam = ["Kohli", "Gill", "Rahul", "Jadeja", "Ashwin"];
  const EvenTeam = ["Rohit", "Surya", "Hardik", "Bumrah", "Kuldeep"];

  const [odd1, odd2, odd3, ...oddRest] = OddTeam;
  const [even1, even2, even3, ...evenRest] = EvenTeam;

  const T20players = ["Dhoni", "Raina", "Ishant"];
  const RanjiPlayers = ["Wasim", "Prithvi", "Manoj"];

  const mergedPlayers = [...T20players, ...RanjiPlayers];

  return (
    <div>
      <h3>Odd Team Players</h3>
      <ul>
        <li>{odd1}</li>
        <li>{odd2}</li>
        <li>{odd3}</li>
        {oddRest.map((p, index) => (
          <li key={index}>{p}</li>
        ))}
      </ul>

      <h3>Even Team Players</h3>
      <ul>
        <li>{even1}</li>
        <li>{even2}</li>
        <li>{even3}</li>
        {evenRest.map((p, index) => (
          <li key={index}>{p}</li>
        ))}
      </ul>

      <h3>All Merged Players (T20 + Ranji)</h3>
      <ul>
        {mergedPlayers.map((p, index) => (
          <li key={index}>{p}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
