import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';
import '@testing-library/jest-dom';

test('renders Repositories heading', () => {
  render(<App />);
  const heading = screen.getByText(/Repositories/i);
  expect(heading).toBeInTheDocument();
});
