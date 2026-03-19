import React, { useState } from 'react';
import { createShipment } from '../api';
import ApiResponseBlock from './ApiResponseBlock';
import useApi from '../hooks/useApi';

export default function CreateShipment() {
 const [orderId, setOrderId] = useState('');
 const [carrier, setCarrier] = useState('');
 const { data, error, execute } = useApi(createShipment);

 const handleSubmit = async (e) => {
    e.preventDefault();
    await execute(orderId, { carrier });
 };

 return (
  <div>
   <h2>Create Shipment</h2>
   <form onSubmit={handleSubmit}>
    <input placeholder="Order ID" value={orderId} onChange={e => setOrderId(e.target.value)} required />
    <input placeholder="Carrier" value={carrier} onChange={e => setCarrier(e.target.value)} required />
    <button type="submit">Create Shipment</button>
   </form>
   <ApiResponseBlock data={data} error={error} />
  </div>
 );
}