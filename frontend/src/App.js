import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Navbar from './components/Navbar';
import CreateOrder from './components/CreateOrder';
import CreateShipment from './components/CreateShipment';
import { PackShipment, ShipShipment } from './components/PackShipment';
import ShipmentDetails from './components/ShipmentDetails';
import AssignTracking from './components/AssignTracking';
import SearchShipments from './components/SearchShipments';

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Navigate to="/orders/create" />} />
        <Route path="/orders/create" element={<CreateOrder />} />
        <Route path="/orders/shipment" element={<CreateShipment />} />
        <Route path="/shipments/pack" element={<PackShipment />} />
        <Route path="/shipments/ship" element={<ShipShipment />} />
        <Route path="/shipments/details" element={<ShipmentDetails />} />
        <Route path="/parcels/tracking" element={<AssignTracking />} />
        <Route path="/shipments/search" element={<SearchShipments />} />
      </Routes>
    </Router>
  );
}

export default App;