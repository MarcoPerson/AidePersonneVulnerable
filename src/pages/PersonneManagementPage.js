import React, { useState } from 'react';
import Link from 'next/link';
import AddPersonForm from '../components/Personne/AddPersonForm';
import GetPersonForm from '../components/Personne/GetPersonForm';
import DeletePersonForm from '../components/Personne/DeletePersonForm';
import GetAllPersonsList from '../components/Personne/GetAllPersonsList';
import GetAllDemandeursList from '../components/Personne/GetAllDemandeursList';
import GetAllValidateursList from '../components/Personne/GetAllValidateursList';
import GetAllBenevolesList from '../components/Personne/GetAllBenevolesList';
import GetAllReferentsList from '../components/Personne/GetAllReferentsList';

const PersonManagementPage = () => {
  const [currentEndpoint, setCurrentEndpoint] = useState(null);

  const renderForm = () => {
    switch (currentEndpoint) {
      case 'ajoutPersonne':
        return <AddPersonForm />;
      case 'getPersonne':
        return <GetPersonForm />;
      case 'supprimerPersonne':
        return <DeletePersonForm />;
      case 'toutesLesPersonnes':
        return <GetAllPersonsList />;
      case 'tousLesDemandeurs':
        return <GetAllDemandeursList />;
      case 'tousLesValidateurs':
        return <GetAllValidateursList />;
      case 'tousLesBenevoles':
        return <GetAllBenevolesList />;
      case 'tousLesReferents':
        return <GetAllReferentsList />;
      default:
        return null;
    }
  };

  return (
    <div className='render'>
      <Link href="/">
        <button className='home'>Home</button>
      </Link>
      <div className='inrender'>
      <button onClick={() => setCurrentEndpoint('ajoutPersonne')}>Add Person</button>
      <button onClick={() => setCurrentEndpoint('getPersonne')}>Get Person</button>
      <button onClick={() => setCurrentEndpoint('supprimerPersonne')}>Delete Person</button>
      <button onClick={() => setCurrentEndpoint('toutesLesPersonnes')}>Get All Persons</button>
      <button onClick={() => setCurrentEndpoint('tousLesDemandeurs')}>Get All Demandeurs</button>
      <button onClick={() => setCurrentEndpoint('tousLesValidateurs')}>Get All Validateurs</button>
      <button onClick={() => setCurrentEndpoint('tousLesBenevoles')}>Get All Benevoles</button>
      <button onClick={() => setCurrentEndpoint('tousLesReferents')}>Get All Referents</button>
    </div>
    <div className='result'>
        {renderForm()}
      </div>
    </div>
  );
};

export default PersonManagementPage;
