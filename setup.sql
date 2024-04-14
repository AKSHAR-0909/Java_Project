CREATE TABLE person (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    phone_number VARCHAR(20),
    address VARCHAR(255)
);

INSERT INTO person (name, email, password, phone_number, address) VALUES
('John Doe', 'johndoe@example.com', 'password123', '1234567890', '123 Main St'),
('Jane Smith', 'janesmith@example.com', 'password456', '0987654321', '456 Elm St');

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES person(user_id)
);


INSERT INTO users (user_id, password) VALUES
(1, 'password123'),
(2, 'password456');


CREATE TABLE bookings (
    booking_id SERIAL PRIMARY KEY,
    user_id INT,
    flight_id INT,
    booking_date DATE,
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO bookings (user_id, flight_id, booking_date, status) VALUES
(1, 1, '2024-04-05', 'Confirmed'),
(1, 3, '2024-04-06', 'Pending'),
(2, 2, '2024-04-07', 'Confirmed');


CREATE TABLE flight (
    flight_id SERIAL PRIMARY KEY,
    source VARCHAR(255),
    destination VARCHAR(255),
    departure_date DATE,
    return_date DATE,
    price FLOAT,
    available_seats INT,
    flight_type VARCHAR(50)
);

INSERT INTO flight (source, destination, departure_date, return_date, price, available_seats, flight_type) VALUES
('New York', 'Los Angeles', '2024-05-01', '2024-05-05', 500.00, 200, 'OneWay'),
('Chicago', 'Miami', '2024-06-10', '2024-06-15', 600.00, 150, 'TwoWay'),
('San Francisco', 'Seattle', '2024-07-20', '2024-07-25', 400.00, 180, 'OneWay');

CREATE TABLE admin (
    user_id SERIAL PRIMARY KEY,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);