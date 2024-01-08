// components/Mission/GetMissionsDemandeurForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetMissionsDemandeurForm = () => {
  const [demandeurId, setDemandeurId] = useState('');
  const [result, setResult] = useState(null);

  const handleDemandeurIdChange = (e) => {
    setDemandeurId(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const endpoint = `http://localhost:5001/getMissionsDemandeur/${demandeurId}`;

    try {
      const response = await axios.get(endpoint);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while fetching missions for the demandeur.' });
    }
  };

  return (
    <div>
      <h2>Get Missions for Demandeur</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Demandeur ID:
          <input type="number" value={demandeurId} onChange={handleDemandeurIdChange} required />
        </label>
        <br />
        <button type="submit">Get Missions</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default GetMissionsDemandeurForm;
