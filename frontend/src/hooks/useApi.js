import { useState } from 'react';

export default function useApi(apiFunc) {
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);

  const execute = async (...args) => {
    setData(null);
    setError(null);

    try {
      const res = await apiFunc(...args);
      setData(res.data);
      return res.data;
    } catch (err) {
      const errData = err.response?.data || err.message;
      setError(errData);
    } 
  };

  return { data, error, execute};
}