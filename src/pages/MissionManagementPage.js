import React, { useState } from 'react';
import Link from 'next/link';
import AddMissionForm from '../components/Mission/AddMissionForm';
import AssignMissionForm from '../components/Mission/AssignMissionForm';
import ReferMissionForm from '../components/Mission/ReferMissionForm';
import ValidateMissionForm from '../components/Mission/ValidateMissionForm';
import RejectMissionForm from '../components/Mission/RejectMissionForm';
import CompleteMissionForm from '../components/Mission/CompleteMissionForm';
import AddReviewForm from '../components/Mission/AddReviewForm';
import GetMissionForm from '../components/Mission/GetMissionForm';
import GetMissionsDemandeurForm from '../components/Mission/GetMissionsDemandeurForm';
import GetMissionsBenevoleForm from '../components/Mission/GetMissionsBenevoleForm';
import GetAllMissionsWithoutBenevoleList from '../components/Mission/GetAllMissionsWithoutBenevoleList';
import GetAllMissionsNonValideesList from '../components/Mission/GetAllMissionsNonValideesList';
import GetAllMissionsNonReferreesList from '../components/Mission/GetAllMissionsNonReferreesList';
import GetAllMissionsList from '../components/Mission/GetAllMissionsList';

const MissionManagementPage = () => {
  const [currentEndpoint, setCurrentEndpoint] = useState(null);

  const renderForm = () => {
    switch (currentEndpoint) {
      case 'ajoutMission':
        return <AddMissionForm />;
      case 'assignerMission':
        return <AssignMissionForm />;
      case 'referrerMission':
        return <ReferMissionForm />;
      case 'validerMission':
        return <ValidateMissionForm />;
      case 'refuserMission':
        return <RejectMissionForm />;
      case 'completeMission':
        return <CompleteMissionForm />;
      case 'ajoutAvisMission':
        return <AddReviewForm />;
      case 'getMission':
        return <GetMissionForm />;
      case 'getMissionsDemandeur':
        return <GetMissionsDemandeurForm />;
      case 'getMissionsBenevole':
        return <GetMissionsBenevoleForm />;
      case 'toutesLesMissionsSansBenevole':
        return <GetAllMissionsWithoutBenevoleList />;
      case 'toutesLesMissionsNonValidees':
        return <GetAllMissionsNonValideesList />;
      case 'toutesLesMissionsNonReferrees':
        return <GetAllMissionsNonReferreesList />;
      case 'toutesLesMissions':
        return <GetAllMissionsList />;
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
        <button onClick={() => setCurrentEndpoint('ajoutMission')}>Add Mission</button>
        <button onClick={() => setCurrentEndpoint('assignerMission')}>Assign Mission</button>
        <button onClick={() => setCurrentEndpoint('referrerMission')}>Refer Mission</button>
        <button onClick={() => setCurrentEndpoint('validerMission')}>Validate Mission</button>
        <button onClick={() => setCurrentEndpoint('refuserMission')}>Reject Mission</button>
        <button onClick={() => setCurrentEndpoint('completeMission')}>Complete Mission</button>
        <button onClick={() => setCurrentEndpoint('ajoutAvisMission')}>Add Review to Mission</button>
        <button onClick={() => setCurrentEndpoint('getMission')}>Get Mission</button>
        <button onClick={() => setCurrentEndpoint('getMissionsDemandeur')}>Get Missions for Demandeur</button>
        <button onClick={() => setCurrentEndpoint('getMissionsBenevole')}>Get Missions for Benevole</button>
        <button onClick={() => setCurrentEndpoint('toutesLesMissionsSansBenevole')}>Get All Missions Without Benevole</button>
        <button onClick={() => setCurrentEndpoint('toutesLesMissionsNonValidees')}>Get All Non-Validated Missions</button>
        <button onClick={() => setCurrentEndpoint('toutesLesMissionsNonReferrees')}>Get All Non-Referreed Missions</button>
        <button onClick={() => setCurrentEndpoint('toutesLesMissions')}>Get All Missions</button>
      </div>
      <div className='result'>
        {renderForm()}
      </div>
    </div>
  );
};

export default MissionManagementPage;
