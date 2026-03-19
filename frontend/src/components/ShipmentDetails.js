import React, { useState } from 'react';
import { getShipmentDetails } from '../api';
import ApiResponseBlock from './ApiResponseBlock';
import useApi from '../hooks/useApi';

export default function ShipmentDetails() {
 const [shipmentId, setShipmentId] = useState('');
 const {data, error, execute} = useApi(getShipmentDetails);

 const handleView = async () => {
    await execute(shipmentId);
 };

 return (
  <div>
   <h2>Shipment Details</h2>
   <input placeholder="Shipment ID" value={shipmentId} onChange={e => setShipmentId(e.target.value)} />
   <button onClick={handleView}>View</button>
   <ApiResponseBlock data={data} error={error} />
  </div>
 );
}