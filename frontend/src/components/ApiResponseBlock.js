import React from 'react';

export default function ApiResponseBlock({ data, error }) {
  if (!data && !error) return null;

  if (error) {
    return (
      <div style={{ border: '1px solid red', padding: '5px', marginTop: '10px' }}>
        <h3 style={{ color: 'red' }}>Error</h3>
        <pre>{JSON.stringify(error, null, 2)}</pre>
      </div>
    );
  }

  return (
    <div style={{ border: '1px solid green', padding: '5px', marginTop: '10px' }}>
      <h3>Success</h3>
      <pre>{JSON.stringify(data, null, 2)}</pre>
    </div>
  );
}