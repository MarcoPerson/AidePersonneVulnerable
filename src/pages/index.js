import React from 'react';
import Link from 'next/link';

const HomePage = () => {
  return (
    <div className='renderHome'>
      <h1>Welcome to the Home Page</h1>
      <Link href="/MissionManagementPage">
          <button>Mission Management</button>
      </Link>
      <Link href="/PersonneManagementPage">
          <button>Personne Management</button>
      </Link>
      <Link href="/RelationManagementPage">
          <button>Relation Management</button>
      </Link>
    </div>
  );
};

export default HomePage;
