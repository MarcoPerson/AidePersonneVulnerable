// components/Mission/AddMissionForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const AddMissionForm = () => {
  const [demandeurId, setDemandeurId] = useState('');
  const [sujet, setSujet] = useState('');
  const [isReferentNeeded, setIsReferentNeeded] = useState(false);
  const [result, setResult] = useState(null);

  const handleDemandeurIdChange = (e) => {
    setDemandeurId(e.target.value);
  };

  const handleSujetChange = (e) => {
    setSujet(e.target.value);
  };

  const handleIsReferentNeededChange = (e) => {
    setIsReferentNeeded(e.target.checked);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const missionData = {
      demandeurId: parseInt(demandeurId),
      sujet,
      isReferentNeeded,
    };

    try {
      const response = await axios.post('http://localhost:5001/ajoutMission', missionData);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while adding the mission.' });
    }
  };

  return (
    <div>
      <h2>Add Mission</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Demandeur ID:
          <input type="number" value={demandeurId} onChange={handleDemandeurIdChange} required />
        </label>
        <br />
        <label>
          Sujet:
          <input type="text" value={sujet} onChange={handleSujetChange} required />
        </label>
        <br />
        <label>
          Is Referent Needed:
          <input type="checkbox" checked={isReferentNeeded} onChange={handleIsReferentNeededChange} />
        </label>
        <br />
        <button type="submit">Add Mission</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default AddMissionForm;
