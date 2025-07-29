import React, { useState } from 'react';
import CourseDetails from './components/CourseDetails';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';

function App() {
  const [showAll, setShowAll] = useState(true);

  const containerStyle = {
    display: 'flex',
    justifyContent: 'space-around',
    alignItems: 'flex-start',
    padding: '20px',
    gap: '20px'
  };

  const columnStyle = {
    borderLeft: '3px solid green',
    paddingLeft: '20px',
    width: '30%'
  };

  return (
    <div>
      <h2 style={{ textAlign: 'center' }}>Blogger App</h2>

      <div style={containerStyle}>
        <div style={columnStyle}><CourseDetails show={showAll} /></div>
        <div style={columnStyle}><BookDetails show={showAll} /></div>
        <div style={columnStyle}><BlogDetails show={showAll} /></div>
      </div>
    </div>
  );
}

export default App;
