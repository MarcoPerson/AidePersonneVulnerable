// components/AddPersonForm.js
import React, { useState } from 'react';
import axios from 'axios';
import Result from '../Result';

const AddPersonForm = () => {
  const [checked, setChecked] = useState(false)
  const [formData, setFormData] = useState({
    nom: '',
    prenom: '',
    age: 0,
    adresse: '',
    isReferentNeeded: false,
    role: '',
  });

  const [result, setResult] = useState(null);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleCheckBoxChange = (e) => {
    setFormData({ ...formData, [e.target.name]: !checked });
    setChecked(!checked);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://localhost:5000/ajoutPersonne', { ...formData });
      setResult(response.data);
    } catch (error) {
      setResult({ error: 'An error occurred while adding the person.' });
    }
  };

  return (
    <div>
      <h2>Add Person Form</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Nom:
          <input type="text" name="nom" value={formData.nom} onChange={handleChange} required />
        </label>
        <br />
        <label>
          Prénom:
          <input type="text" name="prenom" value={formData.prenom} onChange={handleChange} required />
        </label>
        <br />
        <label>
          Âge:
          <input type="number" name="age" value={formData.age} onChange={handleChange} required />
        </label>
        <br />
        <label>
          Adresse:
          <input type="text" name="adresse" value={formData.adresse} onChange={handleChange} required />
        </label>
        <br />
        <label>
          Référent nécessaire:
          <input type="checkbox" name="isReferentNeeded" checked={checked} onChange={handleCheckBoxChange} />
        </label>
        <br />
        <label>
          Rôle:
          <select name="role" value={formData.role} onChange={handleChange} required>
            <option value="">Select Role</option>
            <option value="Benevole">Benevole</option>
            <option value="Demandeur">Demandeur</option>
            <option value="Validateur">Validateur</option>
            <option value="Referent">Referent</option>
          </select>
        </label>
        <br />
        <button type="submit">Add Person</button>
      </form>

      {result && <Result data={{result}} />}
    </div>
  );
};

export default AddPersonForm;
