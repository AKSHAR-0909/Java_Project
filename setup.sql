-- Create tables
CREATE TABLE person (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    phone_number VARCHAR(20),
    address VARCHAR(255)
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES person(user_id)
);

CREATE TABLE discount (
    discount_id SERIAL PRIMARY KEY,
    discount_type VARCHAR(50) NOT NULL,
    threshold FLOAT,
    fixed_amount FLOAT,
    percentage FLOAT
);

CREATE TABLE bookings (
    booking_id SERIAL PRIMARY KEY,
    user_id INT,
    flight_id INT,
    booking_date DATE,
    status VARCHAR(50),
    price FLOAT,
    discount_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (discount_id) REFERENCES discount(discount_id)
);

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

-- Insert data
INSERT INTO person (name, email, password, phone_number, address) VALUES
('John Doe', 'johndoe@example.com', 'password123', '1234567890', '123 Main St'),
('Jane Smith', 'janesmith@example.com', 'password456', '0987654321', '456 Elm St');

INSERT INTO users (user_id, password) VALUES
(1, 'password123'),
(2, 'password456');

INSERT INTO discount (discount_type, threshold, fixed_amount, percentage) VALUES
('Threshold', 500.00, 50.00, 10.00);

INSERT INTO bookings (user_id, flight_id, booking_date, status, price, discount_id) VALUES
(1, 1, '2024-04-05', 'Confirmed', 500.00, 1),
(1, 3, '2024-04-06', 'Pending', 600.00, 1),
(2, 2, '2024-04-07', 'Confirmed', 400.00, 1);

INSERT INTO flight (source, destination, departure_date, return_date, price, available_seats, flight_type) VALUES
('New York', 'Los Angeles', '2024-05-01', '2024-05-05', 500.00, 200, 'OneWay'),
('Chicago', 'Miami', '2024-06-10', '2024-06-15', 600.00, 150, 'TwoWay'),
('San Francisco', 'Seattle', '2024-07-20', '2024-07-25', 400.00, 180, 'OneWay');
