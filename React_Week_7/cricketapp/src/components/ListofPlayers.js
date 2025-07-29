import React from "react";

const ListofPlayers = () => {
  const players = [
    { name: "Kohli", score: 85 },
    { name: "Rohit", score: 45 },
    { name: "Gill", score: 76 },
    { name: "Surya", score: 34 },
    { name: "Rahul", score: 52 },
    { name: "Jadeja", score: 91 },
    { name: "Hardik", score: 67 },
    { name: "Ashwin", score: 22 },
    { name: "Bumrah", score: 80 },
    { name: "Shami", score: 60 },
    { name: "Kuldeep", score: 71 },
  ];

  const lowScorers = players.filter((player) => player.score < 70);

  return (
    <div>
      <h3>List of Players and Scores</h3>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>

      <h3>Players with score below 70</h3>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
