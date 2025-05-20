CREATE TABLE IF NOT EXISTS ration_card_holder (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ration_card_number VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(100),
    city VARCHAR(50),
    last_coupon_date DATE
);
