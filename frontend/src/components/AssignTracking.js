import React, { useState } from 'react';
import { assignParcelTracking } from '../api';
import ApiResponseBlock from './ApiResponseBlock';
import useApi from '../hooks/useApi';

export default function AssignTracking() {
  const [parcelId, setParcelId] = useState('');
  const [trackingCode, setTrackingCode] = useState('');
  const { data, error, execute } = useApi(assignParcelTracking);

  const handleAssign = async () => {
    await execute(parcelId, {trackingCode});
  };

  return (
    <div>
      <h2>Assign Tracking</h2>
      <input placeholder="Parcel ID" value={parcelId} onChange={e=>setParcelId(e.target.value)} />
      <input placeholder="Tracking Code" value={trackingCode} onChange={e=>setTrackingCode(e.target.value)} />
      <button onClick={handleAssign}>Assign</button>
      <ApiResponseBlock data={data} error={error} />
    </div>
  );
}