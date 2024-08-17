INSERT INTO applications (id, user_id, application_name, date, mod_date, token)
VALUES (1, 1, 'Application 1', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day', 'token1');

INSERT INTO applications (id, user_id, application_name, date, mod_date, token)
VALUES (2, 2, 'Application 2', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day', 'token2');

INSERT INTO applications (id, user_id, application_name, date, mod_date, token)
VALUES (3, 3, 'Application 3', NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day', 'token3');


INSERT INTO endpoint (application_id,date_created,date_modified,id,end_point_name,end_point_url, monitor_type)
VALUES (1, NOW() - INTERVAL '1 day', NOW() - INTERVAL '1 day', 1, 'Endpoint 1', 'http://localhost:8080/health', 'HTTPS');


INSERT INTO endpoint_status (id, endpoint_id, status, response_time, date_recorded)
VALUES (1, 1, 'UP', 100, NOW() - INTERVAL '1 day');


INSERT INTO endpoint_daily_uptime (id, endpoint_id, date_recorded, percentage)
VALUES (1, 1, NOW() - INTERVAL '1 day', 100);


INSERT INTO update_event (id, endpoint_id, action, description, date_recorded)
VALUES (1, 1, 'UP', 'Endpoint 1 updated', NOW() - INTERVAL '1 day');

INSERT INTO overall_uptime (id, application_id, last24hours_uptime, last7days_uptime, last30days_uptime, last90days_uptime, last_calculated)
VALUES (1, 1, 100, 100, 100, 100, NOW() - INTERVAL '1 day');


