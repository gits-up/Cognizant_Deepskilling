import React, { useEffect, useState } from "react";
import GitClient from "./GitClient";

function App() {
  const [repos, setRepos] = useState([]);
  const client = new GitClient();

  useEffect(() => {
    client.getRepositories("techiesyed").then(setRepos);
  }, []);

  return (
    <div className="App">
      <h2>Repositories</h2>
      <ul>
        {repos.map((repo, idx) => (
          <li key={idx}>{repo}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
