CREATE TABLE manufacturer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255)
);

CREATE TABLE dealership (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255)
);

CREATE TABLE customer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE vehicle (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vin VARCHAR(255) NOT NULL UNIQUE,
    license_plate VARCHAR(255) NOT NULL UNIQUE,
    make VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    fuel_type VARCHAR(255),
    status VARCHAR(255),
    manufacturer_id BIGINT,
    CONSTRAINT fk_vehicle_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id)
);

CREATE TABLE employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    dealership_id BIGINT,
    CONSTRAINT fk_employee_dealership FOREIGN KEY (dealership_id) REFERENCES dealership(id)
);

CREATE TABLE part (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    part_number VARCHAR(255),
    description VARCHAR(255),
    price DECIMAL(19,2),
    quantity INT
);

CREATE TABLE service_record (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255),
    date DATE NOT NULL,
    vehicle_id BIGINT,
    mechanic_id BIGINT,
    CONSTRAINT fk_service_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle(id),
    CONSTRAINT fk_service_mechanic FOREIGN KEY (mechanic_id) REFERENCES employee(id)
);

CREATE TABLE service_record_parts (
    service_record_id BIGINT NOT NULL,
    part_id BIGINT NOT NULL,
    PRIMARY KEY (service_record_id, part_id),
    CONSTRAINT fk_srp_record FOREIGN KEY (service_record_id) REFERENCES service_record(id),
    CONSTRAINT fk_srp_part FOREIGN KEY (part_id) REFERENCES part(id)
);

CREATE TABLE invoice (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE,
    service_record_id BIGINT UNIQUE,
    CONSTRAINT fk_invoice_service FOREIGN KEY (service_record_id) REFERENCES service_record(id)
);

CREATE TABLE appointment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    vehicle_id BIGINT,
    CONSTRAINT fk_appointment_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
);

CREATE TABLE warranty (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    vehicle_id BIGINT UNIQUE,
    CONSTRAINT fk_warranty_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
);

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);
