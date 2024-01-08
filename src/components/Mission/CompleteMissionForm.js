// components/Mission/CompleteMissionForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const CompleteMissionForm = () => {
  const [missionId, setMissionId] = useState('');
  const [result, setResult] = useState(null);

  const handleMissionIdChange = (e) => {
    setMissionId(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const endpoint = `http://localhost:5001/completeMission/${missionId}`;

    try {
      const response = await axios.put(endpoint);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while marking the mission as complete.' });
    }
  };

  return (
    <div>
      <h2>Complete Mission</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Mission ID:
          <input type="number" value={missionId} onChange={handleMissionIdChange} required />
        </label>
        <br />
        <button type="submit">Complete Mission</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default CompleteMissionForm;
