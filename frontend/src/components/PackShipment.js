import React, { useState } from 'react';
import { packShipment, shipShipment } from '../api';
import ApiResponseBlock from './ApiResponseBlock';
import useApi from '../hooks/useApi';

export function PackShipment() {
  const [shipmentId, setShipmentId] = useState('');
  const { data, error, execute } = useApi(packShipment);

  const handlePack = async () => {
    await execute(shipmentId, {newShipmentStatus: 'PACKED'});
  };

  return (
    <div>
      <h2>Pack Shipment</h2>
      <input
        placeholder="Shipment ID"
        value={shipmentId}
        onChange={e => setShipmentId(e.target.value)}
      />
      <button onClick={handlePack}>Pack</button>

      <ApiResponseBlock data={data} error={error} />
    </div>
  );
}

export function ShipShipment() {
  const [shipmentId, setShipmentId] = useState('');
  const { data, error, execute } = useApi(shipShipment);

  const handleShip = async () => {
    await execute(shipmentId, {newShipmentStatus: 'SHIPPED'});
  };

  return (
    <div>
      <h2>Ship Shipment</h2>
      <input
        placeholder="Shipment ID"
        value={shipmentId}
        onChange={e => setShipmentId(e.target.value)}
      />
      <button onClick={handleShip}>Ship</button>

      <ApiResponseBlock data={data} error={error} />
    </div>
  );
}