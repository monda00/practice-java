-- meeting room
INSERT INTO meeting_room (room_name) VALUES ('Room A');
INSERT INTO meeting_room (room_name) VALUES ('Room B');
INSERT INTO meeting_room (room_name) VALUES ('Room C');
INSERT INTO meeting_room (room_name) VALUES ('Room D');
INSERT INTO meeting_room (room_name) VALUES ('Room E');
INSERT INTO meeting_room (room_name) VALUES ('Room F');
INSERT INTO meeting_room (room_name) VALUES ('Room G');
INSERT INTO meeting_room (room_name) VALUES ('Room H');

-- reservable room
-- room 1
INSERT INTO reservable_room (reserved_date, room_id) VALUES ('2025-01-21', 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES ('2025-01-22', 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES ('2025-01-23', 1);
-- room 7
INSERT INTO reservable_room (reserved_date, room_id) VALUES ('2025-01-21', 7);
INSERT INTO reservable_room (reserved_date, room_id) VALUES ('2025-01-22', 7);
INSERT INTO reservable_room (reserved_date, room_id) VALUES ('2025-01-23', 7);

-- dummy user
INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES ('user1', 'user', 'one', 'password', 'USER');
INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES ('user2', 'user', 'two', 'password', 'USER');
INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES ('user3', 'user', 'three', 'password', 'USER');
INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES ('admin', 'admin', 'admin', 'password', 'ADMIN');
