// components/Mission/AddReviewForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const AddReviewForm = () => {
  const [missionId, setMissionId] = useState('');
  const [avis, setAvis] = useState('');
  const [result, setResult] = useState(null);

  const handleMissionIdChange = (e) => {
    setMissionId(e.target.value);
  };

  const handleAvisChange = (e) => {
    setAvis(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const endpoint = `http://localhost:5001/ajoutAvisMission/${missionId}`;
    const avisData = { avis };

    try {
      const response = await axios.post(endpoint, avisData);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while adding a review to the mission.' });
    }
  };

  return (
    <div>
      <h2>Add Review to Mission</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Mission ID:
          <input type="number" value={missionId} onChange={handleMissionIdChange} required />
        </label>
        <br />
        <label>
          Avis:
          <textarea value={avis} onChange={handleAvisChange} required />
        </label>
        <br />
        <button type="submit">Add Review</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default AddReviewForm;
