import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';
import '@testing-library/jest-dom';

test('renders cohort dashboard title', () => {
  render(<App />);
  const titleElement = screen.getByText(/Cohort Dashboard/i);
  expect(titleElement).toBeInTheDocument();
});
