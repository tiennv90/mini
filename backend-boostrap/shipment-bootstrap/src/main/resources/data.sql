INSERT INTO shipments
(id, order_id, shipment_status, shipped_at, created_at, updated_at)
VALUES
(1, 1, 'CREATED', NOW(), NOW(), NOW()),
(2, 2, 'CREATED', NOW() + INTERVAL '1 hour', NOW(), NOW()),
(3, 3, 'CREATED',NOW() + INTERVAL '2 hour', NOW(), NOW()),
(4, 4, 'CREATED',NOW() + INTERVAL '3 hour', NOW(), NOW()),
(5, 5, 'CREATED', NOW() + INTERVAL '4 hour', NOW(), NOW());

SELECT setval('shipments_id_seq', COALESCE((SELECT MAX(id) FROM shipments), 1));