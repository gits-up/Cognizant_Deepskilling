import React, { useContext } from 'react';
import ThemeContext from '../ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  return (
    <div className="card">
      <h4>{employee.name}</h4>
      <p>{employee.designation}</p>
      <button className={theme}>View Profile</button>
    </div>
  );
}

export default EmployeeCard;
