// components/GetAllNonReferencedMissions.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetInfosMissionsNonReferrees = () => {
  const [nonReferencedMissions, setNonReferencedMissions] = useState([]);
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchNonReferencedMissions = async () => {
      try {
        const response = await axios.get('http://localhost:5002/infosToutesLesMissionsNonReferrees');
        setNonReferencedMissions(response.data);
        setResult(response.data);
      } catch (error) {
        setResult({ error: 'An error occurred while fetching non-referenced missions.' });
      }
    };

    fetchNonReferencedMissions();
  }, []);

  return (
    <div>
      <h2>Get All Non-Referenced Missions</h2>
      {nonReferencedMissions.length > 0 ? (
        <span></span>
      ) : (
        <p>No non-referenced missions available.</p>
      )}

      {result && <Result data={result} />}
    </div>
  );
};

export default GetInfosMissionsNonReferrees;
