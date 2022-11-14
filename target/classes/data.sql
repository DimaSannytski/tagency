insert into user_role(id, role) values
                                    (1, 'ROLE_USER'),
                                    (2, 'ROLE_ADMIN');
-- password 123456
insert into person (id, first_name, is_enabled, last_name, email, password, userrole_id) VALUES
    (2, 'test', true, 'test', 'test@test.com', '$2a$10$NZ0s/78owi0SSVkNdDcEQ.EPW4u5r.HDSqjXZbOOzYUBc1JrzGbHC', 1),
    (0, 'admin', true, 'adminov', 'admin@admin.com', '$2a$10$NZ0s/78owi0SSVkNdDcEQ.EPW4u5r.HDSqjXZbOOzYUBc1JrzGbHC', 2),
    (1, 'ivan', true, 'ivanov', 'ivan@ivan.com', '$2a$10$NZ0s/78owi0SSVkNdDcEQ.EPW4u5r.HDSqjXZbOOzYUBc1JrzGbHC', 1);


insert into country (id, name) VALUES
                                   (0, 'Ukraine'),
                                   (1, 'Poland'),
                                   (2, 'German'),
                                   (3, 'USA');

insert into hotel (id, address, name, country_id) VALUES
    (0, 'address 1, Lviv', 'Grand Hotel 1', 0),
    (1, 'address 2, Gdansk', 'Grand Hotel 2', 1),
    (2, 'address 3, Berlin', 'Keine Hotel', 2),
    (3, 'address 4, New York', 'Big Great Hotel', 3);

insert into room (id, hotel_id, name) VALUES
    (0, 2, 'room 1'),
    (1, 2, 'room 2'),
    (2, 2, 'room 3');

insert into room_order (end_date, start_date, creator_id, manager_id, room_id) VALUES
    ('2022-12-06', '2022-11-06', 1, 0, 0),
    ('2022-12-08', '2022-12-06', 1, 0, 0),
    ('2022-12-09', '2022-12-08', 1, 0, 0),
    ('2022-12-11', '2022-12-09', 1, 0, 0);