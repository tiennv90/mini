import React from 'react';
import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <nav style={{ marginBottom: '20px', borderBottom: '1px solid #ccc', paddingBottom: '10px' }}>
      <Link style={{ marginRight: '10px' }} to="/orders/create">Create Order</Link>
      <Link style={{ marginRight: '10px' }} to="/orders/shipment">Create Shipment</Link>
      <Link style={{ marginRight: '10px' }} to="/parcels/tracking">Assign Tracking Code To Parcel</Link>
      <Link style={{ marginRight: '10px' }} to="/shipments/search">Search Shipments</Link>
      <Link style={{ marginRight: '10px' }} to="/shipments/pack">Pack Shipment</Link>
      <Link style={{ marginRight: '10px' }} to="/shipments/ship">Ship Shipment</Link>
      <Link style={{ marginRight: '10px' }} to="/shipments/details">Shipment Details</Link>
    </nav>
  );
}