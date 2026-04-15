INSERT INTO address (id, street, house_number, postal_code, city, country, created_at, updated_at) VALUES
(1, 'Hauptstraße', '12A', '60311', 'Frankfurt am Main', 'Germany', NOW(), NOW()),
(2, 'Berliner Straße', '45', '10115', 'Berlin', 'Germany', NOW(), NOW()),
(3, 'Marienplatz', '8', '80331', 'Munich', 'Germany', NOW(), NOW()),
(4, 'Königsallee', '21', '40212', 'Düsseldorf', 'Germany', NOW(), NOW()),
(5, 'Reeperbahn', '99', '20359', 'Hamburg', 'Germany', NOW(), NOW());

---

INSERT INTO orders 
(id, external_order_number, delivery_address_id, order_status, created_at, updated_at)
VALUES
(1, 'ORD-2024-0001', 1, 'CREATED', NOW(), NOW()),
(2, 'ORD-2024-0002', 2, 'CREATED', NOW(), NOW()),
(3, 'ORD-2024-0003', 3, 'CREATED', NOW(), NOW()),
(4, 'ORD-2024-0004', 4, 'CREATED', NOW(), NOW()),
(5, 'ORD-2024-0005', 5, 'CREATED', NOW(), NOW());
---

INSERT INTO item_line 
(id, product_name, quantity, order_id, created_at, updated_at)
VALUES
(1, 'Laptop Dell XPS 13', 1, 1, NOW(), NOW()),
(2, 'Wireless Mouse Logitech', 2, 1, NOW(), NOW()),
(3, 'Mechanical Keyboard Keychron', 1, 1, NOW(), NOW()),
(4, 'USB-C Hub Anker', 1, 2, NOW(), NOW()),
(5, '27 inch Monitor LG', 2, 2, NOW(), NOW()),
(6, 'Laptop Stand Aluminum', 1, 2, NOW(), NOW()),
(7, 'External SSD Samsung 1TB', 1, 3, NOW(), NOW()),
(8, 'USB-C Cable 2m', 3, 3, NOW(), NOW()),
(9, 'Webcam Logitech HD', 1, 3, NOW(), NOW()),
(10, 'Noise Cancelling Headphones Sony', 1, 4, NOW(), NOW()),
(11, 'Desk Lamp LED', 2, 4, NOW(), NOW()),
(12, 'Office Chair Ergonomic', 1, 4, NOW(), NOW()),
(13, 'Notebook A5', 5, 5, NOW(), NOW()),
(14, 'Ballpoint Pen Set', 3, 5, NOW(), NOW()),
(15, 'Wireless Charger', 2, 5, NOW(), NOW()),
(16, 'Tablet iPad Air', 1, 1, NOW(), NOW()),
(17, 'Stylus Pen', 2, 2, NOW(), NOW()),
(18, 'Portable Speaker JBL', 1, 3, NOW(), NOW()),
(19, 'Smartphone Stand', 2, 4, NOW(), NOW()),
(20, 'Bluetooth Tracker Tile', 3, 5, NOW(), NOW());

---

INSERT INTO shipments
(id, order_id, shipment_status, shipped_at, created_at, updated_at)
VALUES
(1, 1, 'CREATED', NOW(), NOW(), NOW()),
(2, 2, 'CREATED', NOW() + INTERVAL '1 hour', NOW(), NOW()),
(3, 3, 'CREATED',NOW() + INTERVAL '2 hour', NOW(), NOW()),
(4, 4, 'CREATED',NOW() + INTERVAL '3 hour', NOW(), NOW()),
(5, 5, 'CREATED', NOW() + INTERVAL '4 hour', NOW(), NOW());

---

INSERT INTO parcels
(id, tracking_code,carrier ,shipment_id, created_at, updated_at)
VALUES
(1, 'TRACK-100001','DHL', 1, NOW(), NOW()),
(2, 'TRACK-100004','UPS' ,2, NOW(), NOW()),
(3, 'TRACK-100006','FedEx', 3, NOW(), NOW()),
(4, 'TRACK-100008','DHL', 4, NOW(), NOW()),
(5, 'TRACK-100010','UPS', 5, NOW(), NOW());

SELECT setval('orders_id_seq', COALESCE((SELECT MAX(id) FROM orders), 1));
SELECT setval('address_id_seq', COALESCE((SELECT MAX(id) FROM address), 1));
SELECT setval('parcels_id_seq', COALESCE((SELECT MAX(id) FROM parcels), 1));
SELECT setval('shipments_id_seq', COALESCE((SELECT MAX(id) FROM shipments), 1));
SELECT setval('item_line_id_seq', COALESCE((SELECT MAX(id) FROM item_line), 1));