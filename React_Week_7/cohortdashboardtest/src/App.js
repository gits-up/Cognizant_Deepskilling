import React from 'react';
import CohortDetails from './components/CohortDetails';
import CohortData from './Cohort';

function App() {
  return (
    <div className="App">
      <h2>Cohort Dashboard</h2>
      <CohortDetails cohort={CohortData[0]} />
    </div>
  );
}

export default App;
