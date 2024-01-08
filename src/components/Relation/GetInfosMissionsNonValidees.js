// components/GetAllNonValidatedMissions.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetInfosMissionsNonValidees = () => {
  const [nonValidatedMissions, setNonValidatedMissions] = useState([]);
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchNonValidatedMissions = async () => {
      try {
        const response = await axios.get('http://localhost:5002/infosToutesLesMissionsNonValidees');
        setNonValidatedMissions(response.data);
        setResult(response.data);
      } catch (error) {
        setResult({ error: 'An error occurred while fetching non-validated missions.' });
      }
    };

    fetchNonValidatedMissions();
  }, []);

  return (
    <div>
      <h2>Get All Non-Validated Missions</h2>
      {nonValidatedMissions.length > 0 ? (
        <span></span>
      ) : (
        <p>No non-validated missions available.</p>
      )}

      {result && <Result data={result} />}
    </div>
  );
};

export default GetInfosMissionsNonValidees;
