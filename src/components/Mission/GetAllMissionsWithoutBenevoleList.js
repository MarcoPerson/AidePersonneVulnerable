// components/Mission/GetAllMissionsWithoutBenevoleList.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetAllMissionsWithoutBenevoleList = () => {
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchMissionsWithoutBenevole = async () => {
      const endpoint = 'http://localhost:5001/toutesLesMissionsSansBenevole';

      try {
        const response = await axios.get(endpoint);
        setResult(response.data);
      } catch (error) {
        setResult({ error: 'An error occurred while fetching missions without a benevole.' });
      }
    };

    fetchMissionsWithoutBenevole();
  }, []);

  return (
    <div>
      <h2>Get All Missions Without Benevole</h2>
      {result && <Result data={result} />}
    </div>
  );
};

export default GetAllMissionsWithoutBenevoleList;
