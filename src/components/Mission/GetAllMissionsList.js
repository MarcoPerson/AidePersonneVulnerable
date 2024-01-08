// components/Mission/GetAllMissionsList.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetAllMissionsList = () => {
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchAllMissions = async () => {
      const endpoint = 'http://localhost:5001/toutesLesMissions';

      try {
        const response = await axios.get(endpoint);
        setResult(response.data);
      } catch (error) {
        setResult({ error: 'An error occurred while fetching all missions.' });
      }
    };

    fetchAllMissions();
  }, []);

  return (
    <div>
      <h2>Get All Missions</h2>
      {result && <Result data={result} />}
    </div>
  );
};

export default GetAllMissionsList;
