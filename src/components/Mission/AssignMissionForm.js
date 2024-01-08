// components/Mission/AssignMissionForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const AssignMissionForm = () => {
  const [missionId, setMissionId] = useState('');
  const [benevoleId, setBenevoleId] = useState('');
  const [result, setResult] = useState(null);

  const handleMissionIdChange = (e) => {
    setMissionId(e.target.value);
  };

  const handleBenevoleIdChange = (e) => {
    setBenevoleId(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const endpoint = `http://localhost:5001/assignerMission/${missionId}/${benevoleId}`;

    try {
      const response = await axios.put(endpoint);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while assigning the mission.' });
    }
  };

  return (
    <div>
      <h2>Assign Mission to Benevole</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Mission ID:
          <input type="number" value={missionId} onChange={handleMissionIdChange} required />
        </label>
        <br />
        <label>
          Benevole ID:
          <input type="number" value={benevoleId} onChange={handleBenevoleIdChange} required />
        </label>
        <br />
        <button type="submit">Assign Mission</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default AssignMissionForm;
