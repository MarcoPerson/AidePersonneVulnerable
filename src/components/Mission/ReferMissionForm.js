// components/Mission/ReferMissionForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const ReferMissionForm = () => {
  const [missionId, setMissionId] = useState('');
  const [result, setResult] = useState(null);

  const handleMissionIdChange = (e) => {
    setMissionId(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const endpoint = `http://localhost:5001/referrerMission/${missionId}`;

    try {
      const response = await axios.put(endpoint);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while referring the mission.' });
    }
  };

  return (
    <div>
      <h2>Refer Mission</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Mission ID:
          <input type="number" value={missionId} onChange={handleMissionIdChange} required />
        </label>
        <br />
        <button type="submit">Refer Mission</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default ReferMissionForm;
