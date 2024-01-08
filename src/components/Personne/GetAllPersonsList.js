// components/GetAllPersonsList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const GetAllPersonsList = () => {
  const [persons, setPersons] = useState([]);
  const [result, setResult] = useState(null);

  useEffect(() => {
    const fetchPersons = async () => {
      try {
        const response = await axios.get('http://localhost:5000/toutesLesPersonnes');
        setPersons(response.data);
        setResult(response.data);
      } catch (error) {
        setResult({ error: 'An error occurred while fetching all persons.' });
      }
    };

    fetchPersons();
  }, []);

  return (
    <div>
      <h2>Get All Persons</h2>
      {persons.length > 0 ? (
        <ul>
          {persons.map((person) => (
            <li key={person.id}>
              {person.nom} {person.prenom} - Age: {person.age} - Role: {person.role}
            </li>
          ))}
        </ul>
      ) : (
        <p>No persons available.</p>
      )}

      {result && <Result data={result} />}
    </div>
  );
};

export default GetAllPersonsList;
