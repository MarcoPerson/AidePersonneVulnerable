// components/Mission/GetAllMissionsNonValideesList.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetAllMissionsNonValideesList = () => {
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchNonValideesMissions = async () => {
      const endpoint = 'http://localhost:5001/toutesLesMissionsNonValidees';

      try {
        const response = await axios.get(endpoint);
        setResult(response.data);
      } catch (error) {
        setResult({ error: 'An error occurred while fetching non-validated missions.' });
      }
    };

    fetchNonValideesMissions();
  }, []);

  return (
    <div>
      <h2>Get All Non-Validated Missions</h2>
      {result && <Result data={result} />}
    </div>
  );
};

export default GetAllMissionsNonValideesList;
