// components/GetAllReferentsList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetAllReferentsList = () => {
  const [referents, setReferents] = useState([]);
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchReferents = async () => {
      try {
        const response = await axios.get('http://localhost:5000/tousLesReferents');
        setReferents(response.data);
        setResult(response.data);
      } catch (error) {
        setResult({ error: 'An error occurred while fetching all référents.' });
      }
    };

    fetchReferents();
  }, []);

  return (
    <div>
      <h2>Get All Référents</h2>
      {referents.length > 0 ? (
        <ul>
          {referents.map((referent) => (
            <li key={referent.id}>
              {referent.nom} {referent.prenom} - Age: {referent.age}
            </li>
          ))}
        </ul>
      ) : (
        <p>No référents available.</p>
      )}

      {result && <Result data={result} />}
    </div>
  );
};

export default GetAllReferentsList;
