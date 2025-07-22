import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails(props) {
  const { id, name, technology, status } = props;

  const headingStyle = {
    color: status.toLowerCase() === 'ongoing' ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
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
