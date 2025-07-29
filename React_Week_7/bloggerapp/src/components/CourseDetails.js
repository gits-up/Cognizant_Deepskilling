import React from "react";

function CourseDetails({ show }) {
  let content;

  if (show) {
    const courses = ["React", "Redux", "Next.js"];

    content = (
      <ul>
        {courses.map((course, index) => (
          <li key={index}>{course}</li>
        ))}
      </ul>
    );
  } else {
    content = <p>No Course Details</p>;
  }

  return (
    <div>
      <h3>Course Details</h3>
      {content}
    </div>
  );
}

export default CourseDetails;
