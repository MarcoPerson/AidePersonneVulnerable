// components/GetAllDemandeursList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetAllDemandeursList = () => {
  const [demandeurs, setDemandeurs] = useState([]);
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchDemandeurs = async () => {
      try {
        const response = await axios.get('http://localhost:5000/tousLesDemandeurs');
        setDemandeurs(response.data);
        setResult(response.data);
      } catch (error) {
        setResult({ error: 'An error occurred while fetching all demandeurs.' });
      }
    };

    fetchDemandeurs();
  }, []);

  return (
    <div>
      <h2>Get All Demandeurs</h2>
      {demandeurs.length > 0 ? (
        <ul>
          {demandeurs.map((demandeur) => (
            <li key={demandeur.id}>
              {demandeur.nom} {demandeur.prenom} - Age: {demandeur.age}
            </li>
          ))}
        </ul>
      ) : (
        <p>No demandeurs available.</p>
      )}

      {result && <Result data={result} />}
    </div>
  );
};

export default GetAllDemandeursList;
