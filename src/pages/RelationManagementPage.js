import React, { useState } from 'react';
import Link from 'next/link';
import GetInfosPersonne from '../components/Relation/GetInfosPersonne';
import GetInfosMission from '../components/Relation/GetInfosMission';
import GetInfosMissionsSansBenevole from '../components/Relation/GetInfosMissionsSansBenevole';
import GetInfosMissionsNonValidees from '../components/Relation/GetInfosMissionsNonValidees';
import GetInfosMissionsNonReferrees from '../components/Relation/GetInfosMissionsNonReferrees';
import GetInfosToutesLesMissions from '../components/Relation/GetInfosToutesLesMissions';

const RelationManagementPage = () => {
  const [currentEndpoint, setCurrentEndpoint] = useState(null);

  const renderForm = () => {
    switch (currentEndpoint) {
      case 'infosPersonne':
        return <GetInfosPersonne />;
      case 'infosMission':
        return <GetInfosMission />;
      case 'infosToutesLesMissionsSansBenevole':
        return <GetInfosMissionsSansBenevole />;
      case 'infosToutesLesMissionsNonValidees':
        return <GetInfosMissionsNonValidees />;
      case 'infosToutesLesMissionsNonReferrees':
        return <GetInfosMissionsNonReferrees />;
      case 'infosToutesLesMissions':
        return <GetInfosToutesLesMissions />;
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
      <button onClick={() => setCurrentEndpoint('infosPersonne')}>Get Person Information</button>
      <button onClick={() => setCurrentEndpoint('infosMission')}>Get Mission Information</button>
      <button onClick={() => setCurrentEndpoint('infosToutesLesMissionsSansBenevole')}>
        Get All Missions Without Benevole
      </button>
      <button onClick={() => setCurrentEndpoint('infosToutesLesMissionsNonValidees')}>
        Get All Non-Validated Missions
      </button>
      <button onClick={() => setCurrentEndpoint('infosToutesLesMissionsNonReferrees')}>
        Get All Non-Referreed Missions
      </button>
      <button onClick={() => setCurrentEndpoint('infosToutesLesMissions')}>Get All Missions</button>
    </div>
    <div className='result'>
        {renderForm()}
      </div>
    </div>
  );
};

export default RelationManagementPage;
