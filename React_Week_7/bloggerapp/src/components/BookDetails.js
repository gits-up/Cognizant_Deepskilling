import React from "react";

function BookDetails({ show }) {
  if (!show) {
    return <p>No Book Info Available</p>;
  }

  const title = "The React Way";
  const author = "Dan Abramov";
  const pages = 350;

  return (
    <div>
      <h3>Book Details</h3>
      <p>Title: {title}</p>
      <p>Author: {author}</p>
      <p>Pages: {pages > 300 ? "Lengthy Book" : "Quick Read"}</p>
    </div>
  );
}

export default BookDetails;
