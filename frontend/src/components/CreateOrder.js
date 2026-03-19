import React, { useState } from 'react';
import { createOrder } from '../api';
import ApiResponseBlock from './ApiResponseBlock';
import useApi from '../hooks/useApi';

export default function CreateOrder() {
 const [externalOrderNumber, setExternalOrderNumber] = useState('');
 const [address, setAddress] = useState({ street: '', houseNumber: '', city: '', postalCode: '', country: '' });
 const [items, setItems] = useState([{ productName: '', quantity: 1 }]);
 const { data, error, execute } = useApi(createOrder);

 const handleAddItem = () => setItems([...items, { productName: '', quantity: 1 }]);
 const handleChangeItem = (idx, field, value) => {
  const newItems = [...items];
  newItems[idx][field] = field === 'quantity' ? Number(value) : value;
  setItems(newItems);
 };

  const handleSubmit = async (e) => {
      e.preventDefault();
      execute({externalOrderNumber, address, items});
  };

 return (
  <div>
   <h2>Create Order</h2>
   <form onSubmit={handleSubmit}>
    <input placeholder="External Order Number" value={externalOrderNumber} onChange={e => setExternalOrderNumber(e.target.value)} required />
    <h3>Address</h3>
    {['street', 'houseNumber', 'city', 'postalCode', 'country'].map(field => (
     <input key={field} placeholder={field} value={address[field]} onChange={e => setAddress({ ...address, [field]: e.target.value })} required />
    ))}
    <h3>Items</h3>
    {items.map((item, idx) => (
     <div key={idx}>
      <input placeholder="Product Name" value={item.productName} onChange={e => handleChangeItem(idx, 'productName', e.target.value)} required />
      <input type="number" min="1" placeholder="Quantity" value={item.quantity} onChange={e => handleChangeItem(idx, 'quantity', e.target.value)} required />
     </div>
    ))}
    <button type="button" onClick={handleAddItem}>Add Item</button><br /><br />
    <button type="submit">Create Order</button>
   </form>
    <ApiResponseBlock data={data} error={error} />
  </div>
 );
}