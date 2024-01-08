// components/Mission/GetAllMissionsNonReferreesList.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetAllMissionsNonReferreesList = () => {
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchNonReferreedMissions = async () => {
      const endpoint = 'http://localhost:5001/toutesLesMissionsNonReferrees';

      try {
        const response = await axios.get(endpoint);
        setResult(response.data);
      } catch (error) {
        setResult({ error: 'An error occurred while fetching non-referreed missions.' });
      }
    };

    fetchNonReferreedMissions();
  }, []);

  return (
    <div>
      <h2>Get All Non-Referreed Missions</h2>
      {result && <Result data={result} />}
    </div>
  );
};

export default GetAllMissionsNonReferreesList;
