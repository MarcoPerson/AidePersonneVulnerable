// components/Mission/GetMissionForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetMissionForm = () => {
  const [missionId, setMissionId] = useState('');
  const [result, setResult] = useState(null);

  const handleMissionIdChange = (e) => {
    setMissionId(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const endpoint = `http://localhost:5001/getMission/${missionId}`;

    try {
      const response = await axios.get(endpoint);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while fetching the mission details.' });
    }
  };

  return (
    <div>
      <h2>Get Mission Details</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Mission ID:
          <input type="number" value={missionId} onChange={handleMissionIdChange} required />
        </label>
        <br />
        <button type="submit">Get Mission Details</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default GetMissionForm;
