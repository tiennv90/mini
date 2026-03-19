import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/v1',
  headers: {
    'Content-Type': 'application/json',
  },
});

// Order
export const createOrder = (data) => api.post('/orders', data);
export const getOrderDetails = (orderId) => api.get(`/orders/${orderId}`);
export const createShipment = (orderId, data) => api.post(`/orders/${orderId}/shipment`, data);

// Shipment
export const packShipment = (shipmentId, data) => api.patch(`/shipments/${shipmentId}`, data);
export const shipShipment = (shipmentId, data) => api.patch(`/shipments/${shipmentId}`, data);
export const getShipmentDetails = (shipmentId) => api.get(`/shipments/${shipmentId}`);
export const searchShipments = (criteria, page = 0, size = 5) =>
  api.get('/shipments', {
    params: {
      carrier: criteria.carrier || '',
      status: criteria.status || '',
      page,
      size
    }
  });

// Parcel
export const assignParcelTracking = (parcelId, data) => api.patch(`/parcels/${parcelId}/tracking`, data);