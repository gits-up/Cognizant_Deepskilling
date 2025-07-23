import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './components/Home';
import TrainerList from './components/TrainerList';
import TrainerDetails from './components/TrainerDetails';
import trainerData from './TrainersMock';

function App() {
  return (
    <BrowserRouter>
      <div>
        <nav>
          <Link to="/">Home</Link> | <Link to="/trainers">Trainer List</Link>
        </nav>
        <hr />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainerList data={trainerData} />} />
          <Route path="/trainer/:id" element={<TrainerDetails data={trainerData} />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
