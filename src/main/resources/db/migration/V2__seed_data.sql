
INSERT INTO manufacturer(name, country) VALUES ('Toyota', 'Japan'), ('BMW', 'Germany');
INSERT INTO dealership(name, location) VALUES ('City Motors', 'Bucharest'), ('Auto Hub', 'Cluj-Napoca');
INSERT INTO customer(first_name, last_name, email) VALUES ('Ana', 'Popescu', 'ana.popescu@example.com'), ('Mihai', 'Ionescu', 'mihai.ionescu@example.com');

INSERT INTO vehicle(vin, license_plate, make, model, year, fuel_type, status, manufacturer_id)
VALUES
('JTDBR32E720123456', 'B123ABC', 'Toyota', 'Corolla', 2022, 'Hybrid', 'ACTIVE', 1),
('WBA8D9G59JNU12345', 'CJ99XYZ', 'BMW', '320d', 2021, 'Diesel', 'IN_SERVICE', 2);

INSERT INTO employee(name, role, email, phone, dealership_id)
VALUES
('Andrei Marin', 'Mechanic', 'andrei.marin@example.com', '0711000001', 1),
('Elena Dima', 'Sales Consultant', 'elena.dima@example.com', '0711000002', 2);

INSERT INTO part(name, part_number, description, price, quantity)
VALUES
('Oil Filter', 'OF-100', 'Standard oil filter', 49.99, 10),
('Brake Pads', 'BP-250', 'Front brake pads', 199.99, 8);

INSERT INTO service_record(description, date, vehicle_id, mechanic_id)
VALUES ('Annual service', '2026-01-10', 1, 1);

INSERT INTO service_record_parts(service_record_id, part_id) VALUES (1, 1), (1, 2);

INSERT INTO invoice(amount, service_record_id) VALUES (249.98, 1);
INSERT INTO appointment(date, vehicle_id) VALUES ('2026-05-15', 2);
INSERT INTO warranty(start_date, end_date, vehicle_id) VALUES ('2024-01-01', '2027-12-31', 1);
INSERT INTO users(username, password, role) VALUES ('admin', 'admin123', 'ADMIN'), ('service.user', 'service123', 'SERVICE');
