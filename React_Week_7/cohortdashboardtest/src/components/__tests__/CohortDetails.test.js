import React from 'react';
import { render, screen } from '@testing-library/react';
import CohortDetails from '../CohortDetails';
import CohortData from '../../Cohort';
import '@testing-library/jest-dom';

describe('CohortDetails Component', () => {
  const cohort = CohortData[0];

  test('renders the component', () => {
    render(<CohortDetails cohort={cohort} />);
    expect(screen.getByText(/Cohort ID/i)).toBeInTheDocument();
  });

  test('displays cohort details', () => {
    render(<CohortDetails cohort={cohort} />);
    expect(screen.getByText(`Cohort ID: ${cohort.id}`)).toBeInTheDocument();
    expect(screen.getByText(cohort.name)).toBeInTheDocument();
    expect(screen.getByText(cohort.technology)).toBeInTheDocument();
    expect(screen.getByText(cohort.status)).toBeInTheDocument();
  });
});
