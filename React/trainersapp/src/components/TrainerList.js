import React from 'react';
import { Link } from 'react-router-dom';

const TrainerList = ({ data }) => {
  return (
    <div>
      <h2>Trainer List</h2>
      <ul>
        {data.map((trainer) => (
          <li key={trainer.TrainerId}>
            <Link to={`/trainer/${trainer.TrainerId}`}>{trainer.Name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TrainerList;
