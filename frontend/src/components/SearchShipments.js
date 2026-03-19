import React, { useState, useEffect } from 'react';
import { searchShipments } from '../api';

export default function SearchShipments() {
  const [criteria, setCriteria] = useState({ carrier:'', status:'' });
  const [page, setPage] = useState(0);
  const [size] = useState(5);
  const [result, setResult] = useState(null);

  const fetchData = async () => {
    const res = await searchShipments(criteria,page,size);
    setResult(res.data);
  };

  useEffect(() => { if(result) fetchData(); }, [page]);

  return (
    <div>
      <h2>Search Shipments</h2>
      <input placeholder="Carrier" value={criteria.carrier} onChange={e=>setCriteria({...criteria, carrier:e.target.value})} />
      <select value={criteria.status} onChange={e=>setCriteria({...criteria, status:e.target.value})}>
        <option value="">All</option>
        <option value="CREATED">CREATED</option>
        <option value="PACKED">PACKED</option>
        <option value="SHIPPED">SHIPPED</option>
      </select>
      <button onClick={()=>{ setPage(0); fetchData(); }}>Search</button>

      {result && (
        <div>
          <h3>Page {result.page.number+1} / {result.page.totalPages}</h3>
          <ul>
            {result.content.map(sh=> <li key={sh.id}>ID: {sh.id}, Status: {sh.status}, Carrier: {sh.carrier}</li>)}
          </ul>
          <button disabled={page<=0} onClick={()=>setPage(page-1)}>Prev</button>
          <button disabled={page>=result.page.totalPages-1} onClick={()=>setPage(page+1)}>Next</button>
        </div>
      )}
    </div>
  );
}