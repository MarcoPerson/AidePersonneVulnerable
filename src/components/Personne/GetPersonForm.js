// components/GetPersonForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetPersonForm = () => {
  const [personId, setPersonId] = useState('');
  const [result, setResult] = useState(null);

  const handleChange = (e) => {
    setPersonId(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.get(`http://localhost:5000/getPersonne/${personId}`);
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while fetching the person.' });
    }
  };

  return (
    <div>
      <h2>Get Person Form</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Person ID:
          <input type="number" value={personId} onChange={handleChange} required />
        </label>
        <br />
        <button type="submit">Get Person</button>
      </form>

      {result && <Result data={result} />}
    </div>
  );
};

export default GetPersonForm;
