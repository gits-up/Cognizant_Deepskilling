import React from 'react';

function CohortDetails({ cohort }) {
  const { id, name, technology, status } = cohort;

  const headingStyle = {
    color: status.toLowerCase() === 'ongoing' ? 'green' : 'blue'
  };

  return (
    <div>
      <h3 style={headingStyle}>Cohort ID: {id}</h3>
      <dl>
        <dt>Name</dt>
        <dd>{name}</dd>
        <dt>Technology</dt>
        <dd>{technology}</dd>
        <dt>Status</dt>
        <dd>{status}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
