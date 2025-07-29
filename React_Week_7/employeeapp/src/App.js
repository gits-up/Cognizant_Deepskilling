import React, { useState } from 'react';
import EmployeesList from './components/EmployeesList';
import ThemeContext from './ThemeContext';
import './App.css';

function App() {
  const [theme, setTheme] = useState('light');

  return (
    <ThemeContext.Provider value={theme}>
      <div className="App">
        <h2>Employee Management</h2>
        <button onClick={() => setTheme('light')}>Light Theme</button>
        <button onClick={() => setTheme('dark')}>Dark Theme</button>

        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
