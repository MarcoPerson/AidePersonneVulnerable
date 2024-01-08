// components/GetAllMissionsWithoutBenevole.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetInfosMissionsSansBenevole = () => {
  const [missionsWithoutBenevole, setMissionsWithoutBenevole] = useState([]);
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchMissionsWithoutBenevole = async () => {
      try {
        const response = await axios.get('http://localhost:5002/infosToutesLesMissionsSansBenevole');
        setMissionsWithoutBenevole(response.data);
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
      {missionsWithoutBenevole.length > 0 ? (
        <span></span>
      ) : (
        <p>No missions without a benevole available.</p>
      )}

      {result && <Result data={result} />}
    </div>
  );
};

export default GetInfosMissionsSansBenevole;
