// components/Mission/RejectMissionForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const RejectMissionForm = () => {
  const [missionId, setMissionId] = useState('');
  const [motif, setMotif] = useState('');
  const [result, setResult] = useState(null);

  const handleMissionIdChange = (e) => {
    setMissionId(e.target.value);
  };

  const handleMotifChange = (e) => {
    setMotif(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const endpoint = `http://localhost:5001/refuserMission/${missionId}`;
    const motifData = { motif };

    try {
      const response = await axios.post(endpoint, motifData);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while refusing the mission.' });
    }
  };

  return (
    <div>
      <h2>Reject Mission</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Mission ID:
          <input type="number" value={missionId} onChange={handleMissionIdChange} required />
        </label>
        <br />
        <label>
          Motif:
          <textarea value={motif} onChange={handleMotifChange} required />
        </label>
        <br />
        <button type="submit">Reject Mission</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default RejectMissionForm;
