// components/DeletePersonForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const DeletePersonForm = () => {
  const [personId, setPersonId] = useState('');
  const [result, setResult] = useState(null);

  const handleChange = (e) => {
    setPersonId(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.get(`http://localhost:5000/supprimerPersonne/${personId}`);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while deleting the person.' });
    }
  };

  return (
    <div>
      <h2>Delete Person Form</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Person ID:
          <input type="number" value={personId} onChange={handleChange} required />
        </label>
        <br />
        <button type="submit">Delete Person</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default DeletePersonForm;
