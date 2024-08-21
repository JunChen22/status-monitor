INSERT INTO applications (id, user_id, application_name, notification_type, token, date_created, date_modified)
VALUES
(1, 1, 'Application 1', 'email,text,discord', 'token1', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day'),
(2, 1, 'Application 2', 'email,text,discord', 'token2', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day');

INSERT INTO endpoint (id, application_id, end_point_name, end_point_url, monitor_type, current_status, date_created, date_modified)
VALUES
(1, 1, 'Endpoint 1', 'http://localhost:8081', 'HTTPS', 'UP', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day'),
(2, 1, 'Endpoint 2', 'http://localhost:8082', 'HTTPS', 'UP', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day'),
(3, 1, 'Endpoint 3', 'http://localhost:8083', 'HTTPS', 'UP', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day'),
(4, 1, 'Endpoint 4', 'google.com', 'HTTPS', 'UP', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day'),
(5, 1, 'Endpoint 5', 'github.com', 'HTTPS', 'UP', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day'),
(6, 2, 'Endpoint 6', 'amazon.com', 'HTTPS', 'UP', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day'),
(7, 2, 'Endpoint 7', 'stackoverflow.com', 'HTTPS', 'UP', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day'),
(8, 2, 'Endpoint 8', 'apple.com', 'HTTPS', 'UP', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day');

INSERT INTO endpoint_status (id, endpoint_id, status, response_time, date_created)
VALUES
(1, 1, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '1 minute'),
(2, 1, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '2 minute'),
(3, 1, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '3 minute'),
(4, 1, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '4 minute'),
(5, 1, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '5 minute'),
(6, 2, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '1 minute'),
(7, 2, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '2 minute'),
(8, 2, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '3 minute'),
(9, 2, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '4 minute'),
(10, 2, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '5 minute'),
(11, 3, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '1 minute'),
(12, 3, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '2 minute'),
(13, 3, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '3 minute'),
(14, 3, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '4 minute'),
(15, 3, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '5 minute'),
(16, 4, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '1 minute'),
(17, 4, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '2 minute'),
(18, 4, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '3 minute'),
(19, 4, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '4 minute'),
(20, 5, 'UP', FLOOR(RANDOM() * 1000), NOW() - INTERVAL '4 minute');

SELECT setval('endpoint_status_id_seq', 21, false);

INSERT INTO endpoint_daily_uptime (id, endpoint_id, date_created, percentage)
VALUES
(1, 1, NOW() - INTERVAL '1 day', 100),
(2, 1, NOW() - INTERVAL '2 day', 100),
(3, 1, NOW() - INTERVAL '3 day', 100),
(4, 1, NOW() - INTERVAL '4 day', 100),
(5, 1, NOW() - INTERVAL '5 day', 100),
(6, 2, NOW() - INTERVAL '1 day', 100),
(7, 2, NOW() - INTERVAL '2 day', 100),
(8, 2, NOW() - INTERVAL '3 day', 100),
(9, 2, NOW() - INTERVAL '4 day', 100),
(10, 2, NOW() - INTERVAL '5 day', 100),
(11, 3, NOW() - INTERVAL '1 day', 100),
(12, 3, NOW() - INTERVAL '2 day', 100),
(13, 3, NOW() - INTERVAL '3 day', 100),
(14, 3, NOW() - INTERVAL '4 day', 100),
(15, 3, NOW() - INTERVAL '5 day', 100),
(16, 4, NOW() - INTERVAL '1 day', 100),
(17, 4, NOW() - INTERVAL '2 day', 100),
(18, 4, NOW() - INTERVAL '3 day', 100),
(19, 4, NOW() - INTERVAL '4 day', 100),
(20, 5, NOW() - INTERVAL '4 day', 100);

INSERT INTO overall_uptime (id, application_id, last24hours_uptime, last7days_uptime, last30days_uptime, last90days_uptime, date_modified)
VALUES
(1, 1, 100, 100, 100, 100, NOW() - INTERVAL '1 day'),
(2, 2, 100, 100, 100, 100, NOW() - INTERVAL '1 day'),
(3, 3, 100, 100, 100, 100, NOW() - INTERVAL '1 day'),
(4, 4, 100, 100, 100, 100, NOW() - INTERVAL '1 day'),
(5, 5, 100, 100, 100, 100, NOW() - INTERVAL '1 day');

INSERT INTO update_event (id, application_id, endpoint_id, action, description, date_created)
VALUES
(1, 1, 1, 'UP', 'Endpoint 1 is down', NOW() - INTERVAL '1 week'),
(2, 1, 2, 'UP', 'Endpoint 2 is down', NOW() - INTERVAL '2 day'),
(3, 1, 3, 'UP', 'Endpoint 3 is down', NOW() - INTERVAL '3 day'),
(4, 1, 4, 'UP', 'Endpoint 4 is down', NOW() - INTERVAL '4 day'),
(5, 1, 5, 'UP', 'Endpoint 5 is down', NOW() - INTERVAL '5 day'),
(6, 2, 1, 'UP', 'Endpoint 1 is down', NOW() - INTERVAL '1 day'),
(7, 2, 2, 'UP', 'Endpoint 2 is down', NOW() - INTERVAL '1 day'),
(8, 2, 3, 'UP', 'Endpoint 3 is down', NOW() - INTERVAL '1 day'),
(9, 3, 4, 'UP', 'Endpoint 4 is down', NOW() - INTERVAL '1 day'),
(10, 3, 5, 'UP', 'Endpoint 5 is down', NOW() - INTERVAL '1 day');