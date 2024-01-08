// components/GetAllMissions.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetInfosToutesLesMissions = () => {
  const [allMissions, setAllMissions] = useState([]);
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchAllMissions = async () => {
      try {
        const response = await axios.get('http://localhost:5002/infosToutesLesMissions');
        setAllMissions(response.data);
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
      {allMissions.length > 0 ? (
        <span></span>
      ) : (
        <p>No missions available.</p>
      )}

      {result && <Result data={result} />}
    </div>
  );
};

export default GetInfosToutesLesMissions;
