// components/GetAllValidateursList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetAllValidateursList = () => {
  const [validateurs, setValidateurs] = useState([]);
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchValidateurs = async () => {
      try {
        const response = await axios.get('http://localhost:5000/tousLesValidateurs');
        setValidateurs(response.data);
        setResult(response.data);
      } catch (error) {
        setResult({ error: 'An error occurred while fetching all validateurs.' });
      }
    };

    fetchValidateurs();
  }, []);

  return (
    <div>
      <h2>Get All Validateurs</h2>
      {validateurs.length > 0 ? (
        <ul>
          {validateurs.map((validateur) => (
            <li key={validateur.id}>
              {validateur.nom} {validateur.prenom} - Age: {validateur.age}
            </li>
          ))}
        </ul>
      ) : (
        <p>No validateurs available.</p>
      )}

      {result && <Result data={result} />}
    </div>
  );
};

export default GetAllValidateursList;
