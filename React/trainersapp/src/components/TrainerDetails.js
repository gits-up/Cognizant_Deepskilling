import React from 'react';
import { useParams } from 'react-router-dom';

const TrainerDetails = ({ data }) => {
  const { id } = useParams();
  const trainer = data.find((t) => t.TrainerId === parseInt(id));

  if (!trainer) {
    return <h2>Trainer Not Found</h2>;
  }

  return (
    <div>
      <h2>Trainer Details</h2>
      <p><strong>ID:</strong> {trainer.TrainerId}</p>
      <p><strong>Name:</strong> {trainer.Name}</p>
      <p><strong>Email:</strong> {trainer.Email}</p>
      <p><strong>Phone:</strong> {trainer.Phone}</p>
      <p><strong>Stream:</strong> {trainer.Stream}</p>
      <p><strong>Skills:</strong></p>
      <ul>
        {trainer.Skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
};

export default TrainerDetails;
