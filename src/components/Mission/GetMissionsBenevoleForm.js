// components/Mission/GetMissionsBenevoleForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetMissionsBenevoleForm = () => {
  const [benevoleId, setBenevoleId] = useState('');
  const [result, setResult] = useState(null);

  const handleBenevoleIdChange = (e) => {
    setBenevoleId(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const endpoint = `http://localhost:5001/getMissionsBenevole/${benevoleId}`;

    try {
      const response = await axios.get(endpoint);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while fetching missions for the benevole.' });
    }
  };

  return (
    <div>
      <h2>Get Missions for Benevole</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Benevole ID:
          <input type="number" value={benevoleId} onChange={handleBenevoleIdChange} required />
        </label>
        <br />
        <button type="submit">Get Missions</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default GetMissionsBenevoleForm;
