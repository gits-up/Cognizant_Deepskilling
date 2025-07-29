import React from 'react';
import EmployeeCard from './EmployeeCard';

function EmployeesList() {
  const employees = [
    { id: 1, name: 'Syed', designation: 'Developer' },
    { id: 2, name: 'Jojo', designation: 'Tester' },
    { id: 3, name: 'Elisa', designation: 'Designer' }
  ];

  return (
    <div style={{ display: 'flex', gap: '20px' }}>
      {employees.map(emp => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;
