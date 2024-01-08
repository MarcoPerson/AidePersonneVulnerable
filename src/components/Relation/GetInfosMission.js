// components/GetMissionInfo.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetInfosMission = () => {
  const [missionId, setMissionId] = useState('');
  const [result, setResult] = useState(null);

  const handleChange = (e) => {
    setMissionId(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.get(`http://localhost:5002/infosMission/${missionId}`);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while fetching information about the mission.' });
    }
  };

  return (
    <div>
      <h2>Get Mission Information</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Mission ID:
          <input type="number" value={missionId} onChange={handleChange} required />
        </label>
        <br />
        <button type="submit">Get Mission Information</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default GetInfosMission;
