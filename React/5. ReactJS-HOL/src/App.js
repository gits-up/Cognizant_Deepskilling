import React from 'react';
import CohortDetails from './components/CohortDetails';

function App() {
  return (
    <div>
      <CohortDetails
        id={101}
        name="React Bootcamp"
        technology="ReactJS"
        status="Ongoing"
      />
      <CohortDetails
        id={102}
        name="Java Batch"
        technology="Java"
        status="Completed"
      />
    </div>
  );
}

export default App;
