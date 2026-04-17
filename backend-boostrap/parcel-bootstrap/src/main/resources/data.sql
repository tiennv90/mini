INSERT INTO parcels
(id, tracking_code,carrier ,shipment_id, created_at, updated_at)
VALUES
(1, 'TRACK-100001','DHL', 1, NOW(), NOW()),
(2, 'TRACK-100004','UPS' ,2, NOW(), NOW()),
(3, 'TRACK-100006','FedEx', 3, NOW(), NOW()),
(4, 'TRACK-100008','DHL', 4, NOW(), NOW()),
(5, 'TRACK-100010','UPS', 5, NOW(), NOW());

SELECT setval('parcels_id_seq', COALESCE((SELECT MAX(id) FROM parcels), 1));
