// components/GetAllBenevolesList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetAllBenevolesList = () => {
  const [benevoles, setBenevoles] = useState([]);
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchBenevoles = async () => {
      try {
        const response = await axios.get('http://localhost:5000/tousLesBenevoles');
        setBenevoles(response.data);
        setResult(response.data);
      } catch (error) {
        setResult({ error: 'An error occurred while fetching all benevoles.' });
      }
    };

    fetchBenevoles();
  }, []);

  return (
    <div>
      <h2>Get All Benevoles</h2>
      {benevoles.length > 0 ? (
        <ul>
          {benevoles.map((benevole) => (
            <li key={benevole.id}>
              {benevole.nom} {benevole.prenom} - Age: {benevole.age}
            </li>
          ))}
        </ul>
      ) : (
        <p>No benevoles available.</p>
      )}

      {result && <Result data={result} />}
    </div>
  );
};

export default GetAllBenevolesList;
