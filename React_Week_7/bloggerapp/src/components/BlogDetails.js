import React from "react";

function BlogDetails({ show }) {
  const blogs = [
    { id: 1, title: "React Basics" },
    { id: 2, title: "Hooks in Depth" },
    { id: 3, title: "JSX Patterns" },
  ];

  return (
    <div>
      <h3>Blog Details</h3>
      {show && (
        <ul>
          {blogs.map((blog) => (
            <li key={blog.id}>{blog.title}</li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default BlogDetails;
