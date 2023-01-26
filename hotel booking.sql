DROP database hotel_booking;

CREATE DATABASE hotel_booking;
USE hotel_booking;
-- -----------------------
DROP TABLE IF EXISTS token_expired;
CREATE TABLE token_expired (
id int NOT NULL AUTO_INCREMENT,
name varchar(1000),
PRIMARY KEY (id));
-- ------------------------
DROP TABLE IF EXISTS contact;
CREATE TABLE contact (
id int NOT NULL AUTO_INCREMENT,
address varchar(100),
email varchar(100),
name varchar(100),
phone varchar(100),
PRIMARY KEY (id));
-- ---------------------------------
DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
id int NOT NULL AUTO_INCREMENT,
role_name varchar(100),
PRIMARY KEY (id));

/*Data for the table roles */
INSERT INTO roles (role_name) VALUES 
('admin'),
('regular');
SELECT * FROM roles;
-- ----------------------------
DROP TABLE IF EXISTS users;
CREATE TABLE users (
id int NOT NULL AUTO_INCREMENT,
full_name varchar(100) DEFAULT NULL,
DOB date DEFAULT NULL,
email varchar(100) DEFAULT NULL,
email_verify boolean DEFAULT true,
password varchar(100) DEFAULT NULL,
phone varchar(100) DEFAULT NULL,
gender varchar(100) DEFAULT NULL,
role_id int,
PRIMARY KEY (id),
FOREIGN KEY (role_id) REFERENCES roles (id)-- ON DELETE CASCADE,
);
SELECT * FROM users;

/*Data for the table users */
INSERT INTO users (full_name, DOB, email, password, phone, gender, role_id) VALUES 
('Nguyen Van A' , '1990-12-12', 'nguyenvana@gmail.com'	,'$2a$12$Dhj428GYAkOLcrl6tdi6QOjTiSQ0X/7UJGF.tRZto0w0Bp57nM4VO', '090123456' ,'Male',	 	1),
('Nguyen Thi B' , '1995-12-03', 'nguyenthib95@gmail.com' ,'$2a$12$ULigTHQsN/wwpFAHxs9EwederX1.kZMX1CmLD0RjA9L0XwPO/HZrG', '090123444' ,'Female', 	1),
('Nguyen Van C' , '1991-01-10', 'nguyenvanc91@gmail.com' ,'$2a$12$nUpq89uS.Dgl1TklB8S5xeq5Nt9T13gW0WRuZ49WsxI5NCTjY6XfO', '090333456' ,'Male',	2),
('Nguyen Van D' , '1992-01-15', 'nguyenvand92@gmail.com' ,'$2a$12$jnl3TFxtMNsCKN96nYIkmeBPj6a3HnCa58TFqbYfQBtHhTJmPvHPO', '090333888' ,'Male',	2),
('Nguyen Van E' , '1995-01-15', 'nguyenvane95@gmail.com' ,'$2a$12$oX/7edZfNGcv/GP7qJrYY.8AhyU5UIsoe.yxyLO3TvLFYfxEv4KsC', '090333881' ,'Male',	2),
('Nguyen Van F' , '1998-01-15', 'nguyenvane98@gmail.com' ,'$2a$12$MQkVUyucQuPNw9gNGNfKEu1fM071zxxMv0ucIRBHFrMWWkmcM8POm', '090333889' ,'Male',	2);
SELECT * FROM users;
-- ----------------------------
DROP TABLE IF EXISTS province;
CREATE TABLE province (
id int NOT NULL AUTO_INCREMENT,
province varchar(255) DEFAULT NULL,
PRIMARY KEY (id));
SELECT * FROM province;

INSERT INTO province (province) VALUES 
('Đà Nẵng'),
('Quảng Nam'),
('Huế'),
('Bình Định');
SELECT * FROM province;
-- --------------------
DROP TABLE IF EXISTS city;
CREATE TABLE city (
id int NOT NULL AUTO_INCREMENT,
city varchar(255) DEFAULT NULL,
province_id int DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (province_id) REFERENCES province (id)-- ON DELETE CASCADE,
);
SELECT * FROM city;

INSERT INTO city (city, province_id) VALUES 
('Đà Nẵng',1),
('Tam Kỳ', 2),
('Hội An', 2),
('Huế', 3),
('Quy Nhơn',4);
SELECT * FROM city;
-- -------------------------
DROP TABLE IF EXISTS service;
CREATE TABLE service(
id int NOT NULL AUTO_INCREMENT,
service varchar(100) DEFAULT NULL,
PRIMARY KEY (id));
SELECT * FROM service;

INSERT INTO service (service) VALUES 
('pool'),
('breakfast'),
('spa'),
('gym'),
('airport transfer');
SELECT * FROM service;
-- ---------------------
DROP TABLE IF EXISTS hotel;
CREATE TABLE hotel (
id int NOT NULL AUTO_INCREMENT,
hotel_name varchar(100) DEFAULT NULL,
address varchar(100) DEFAULT NULL,
email varchar(100) DEFAULT NULL,
phone varchar(100) DEFAULT NULL,
hotel_rank int DEFAULT NULL CHECK (hotel_rank >=1 OR hotel_rank <=5),
description varchar(255) DEFAULT NULL,
image text DEFAULT NULL,
city_id int DEFAULT NULL,
-- serviceId int DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (city_id) REFERENCES city (id)-- ON DELETE CASCADE,
);
SELECT * FROM hotel;

INSERT INTO hotel (hotel_name, address, email, phone, hotel_rank, description, city_id) VALUES
('HAIAN Beach Hotel & Spa', '278 Vo Nguyen Giap Street, My An Ward, Ngu Hanh Son District, Da Nang', 'haianhotel@gmail.com', '083212234', 5, 'The car parking and the Wi-Fi are always free, so you can stay in touch and come and go as you please. Conveniently situated in the Phước Mỹ part of Đà Nẵng, this property puts you close to attractions and interesting dining options.', 1),
('Stella Maris Beach Danang', '03 Vo Van Kiet Street, Phuoc My Ward, Son Tra District, Da Nang' , 'stellahotel@gmail.com', '083123456', 4, 'Conveniently situated in the Phước Mỹ part of Đà Nẵng, this property puts you close to attractions and interesting dining options. Be sure to set some time aside to visit The Marble Mountains as well as My Khe Beach nearby', 1),
('Sun River Hotel', '132-134-136 Bach Dang Street, Hai Chau District', 'sunriverhotel@gmail.com', '083123456', 4, 'Get your trip off to a great start with a stay at this property, which offers free Wi-Fi in all rooms. Strategically situated in Hải Châu, allowing you access and proximity to local attractions and sights', 1),
('Ban Thach Riverside Hotel & Resort', '10 Bach Dang Street, Tam Ky', 'banthach@yahoo.com', '080111111', 3, 'The car parking and the Wi-Fi are always free, so you can stay in touch and come and go as you please. Conveniently situated in the Tam Ky part of Tam Ky (Quang Nam), this property puts you close to attractions and interesting dining options', 2),
('Phu Ninh Lake Resort', 'Trung Dan, Tam Dai, Phu Ninh, Tam Ky', 'phuninhlake@gmail.com', '080222222', 3, 'The car parking and the Wi-Fi are always free, so you can stay in touch and come and go as you please. Conveniently situated in the Tam Ky part of Tam Ky ', 2),
('Thanh Binh Central Hotel', '98 Ba Trieu Street - Hoi An City', 'thanhbinh@gmail.com', '085555666', 3, 'The car parking and the Wi-Fi are always free, so you can stay in touch and come and go as you please. Strategically situated in Cẩm Phô, allowing you access and proximity to local attractions and sights', 3),
('Senna Hue Hotel', '7 Nguyen Tri Phuong, Hue City, Hue', 'senna@gmail.com', '081123123', 5, 'The car parking and the Wi-Fi are always free, so you can stay in touch and come and go as you please. Strategically situated in Hue City, allowing you access and proximity to local attractions and sights.' , 4),
('White Lotus Hue Hotel', '05-07 Hoang Hoa Tham str., Hue city, Hue City', 'whilelotus@yahoo.com', '081111222', 3, 'The car parking and the Wi-Fi are always free, so you can stay in touch and come and go as you please. Strategically situated in Hue City, allowing you access and proximity to local attractions and sights.' , 4);
SELECT * FROM hotel;
-- --------------------------------
DROP TABLE IF EXISTS hotel_service;
CREATE TABLE hotel_service(
id int NOT NULL AUTO_INCREMENT,
hotel_id int DEFAULT NULL,
service_id int DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (hotel_id) REFERENCES hotel (id),-- ON DELETE CASCADE,
FOREIGN KEY (service_id) REFERENCES service (id)-- ON DELETE CASCADE,
);

INSERT INTO hotel_service (hotel_id, service_id) VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(2,1),
(2,2),
(2,4),
(2,5),
(3,1),
(3,2),
(3,3),
(3,4),
(3,5),
(4,1),
(4,2),
(4,3),
(4,4),
(4,5),
(5,1),
(5,2),
(5,3),
(5,4),
(5,5),
(6,1),
(6,2),
(6,3),
(6,4),
(6,5),
(7,1),
(7,2),
(7,3),
(7,4),
(8,1),
(8,2),
(8,3),
(8,5);

SELECT * FROM hotel_service;
-- -----------------------------
DROP TABLE IF EXISTS attraction;
CREATE TABLE attraction (
id int NOT NULL AUTO_INCREMENT,
name varchar(100) DEFAULT NULL,
-- description varchar(255) DEFAULT NULL,
distance decimal(4,2) DEFAULT NULL CHECK (distance > 0 ),
image text DEFAULT NULL,
hotel_id int DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (hotel_id) REFERENCES hotel (id)-- ON DELETE CASCADE
);
SELECT * FROM attraction;

INSERT INTO attraction (name, distance, hotel_id) VALUES
('Nhà thờ Đức Bà',10.22,1),
('Chợ đêm Hạnh Thông Tây',5.11,1),
('Bưu điện trung tâm thành phố',7.62,1),
('Bảo tàng chứng tích chiến tranh',11.25,1),
('Công viên văn hóa Suối Tiên',1.33,1),
('Chợ Bến Thành',2.82,2),
('Cầu Phú Mỹ',3.14,2),
('Nhà hát thành phố',6.55,2),
('Bảo tàng y học cổ truyền',10.16,2),
('Công viên Tao Đàn',9.15,2),
('Thảo Cầm Viên',7.63,3),
('Bảo tàng tranh 3D',11.48,3),
('Địa đạo Củ Chi',2.25,3),
('Công viên nước Đầm Sen',4.72,3),
('Landmark 81',1.32,3),
('Chùa Bửu Long',12.82,4),
('Chùa Bà Thiên Hậu',6.58,4),
('Cầu Ánh Sao',4.75,4),
('Khu đô thị Phú Mỹ Hưng',5.52,4),
('Bảo tàng lịch sử Việt Nam',3.11,4),
('Hẻm Bia',4.78,5),
('Khu du lịch Suối Mơ',9.55,5),
('Đường sách Nguyên Văn Bình',11.56,5),
('Bến Bạch Đằng',5.88,5),
('Khu du lịch Cần Giờ',2.12,5),
('Chợ Bà Chiểu',5.82,6),
('Hầm Thủ Thiêm',3.12,6),
('Bảo tàng Phụ Nữ Nam Bộ',10.86,6),
('Phố đi bộ Nguyễn Huệ',4.11,6),
('Khu du lịch Bình Quới',1.52,6),
('Tu viện Khánh An',3.65,7),
('Phố người Hoa',7.75,7),
('Phố Tây Bùi Viện',9.98,7),
('Hồ Đá',1.55,7),
('Dinh Độc Lập',2.85,7),
('Tòa tháp Bitexco',3.11,8),
('Hồ con rùa',8.52,8),
('Công viên nước Đại Thế Giới',7.66,8),
('Bến Nhà Rồng',10.26,8),
('Nhà thờ Tân Định',4.42,8);
SELECT * FROM attraction;

-- ---------------------------------
DROP TABLE IF EXISTS review;
CREATE TABLE review (
id int NOT NULL AUTO_INCREMENT,
content varchar(255) DEFAULT NULL,
rate_score decimal(4,2) DEFAULT NULL,
created_date date DEFAULT (current_date),
hotel_id int DEFAULT NULL,
users_id int DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (hotel_id) REFERENCES hotel (id),-- ON DELETE CASCADE,
FOREIGN KEY (users_id) REFERENCES users (id)-- ON DELETE CASCADE,
);
SELECT * FROM review;

INSERT INTO review (content, rate_score, hotel_id, users_id) VALUES 
( 'good', 5, 1, 3 ),
( 'good', 5, 2, 3 ),
( 'good', 5, 3, 3 ),
( 'good', 5, 4, 3 ),
( 'good', 5, 5, 3 ),
( 'good', 5, 6, 3 ),
( 'good', 5, 7, 3 ),
( 'good', 5, 8, 3 ),
( 'quite good', 4, 1, 4 ),
( 'quite good', 4, 2, 4 ),
( 'quite good', 4, 3, 4 ),
( 'quite good', 4, 4, 4 ),
( 'quite good', 4, 5, 4 ),
( 'quite good', 4, 6, 4 ),
( 'quite good', 4, 7, 4 ),
( 'quite good', 4, 8, 4 ),
( 'normal', 3, 1, 5 ),
( 'normal', 3, 2, 5 ),
( 'normal', 3, 3, 5 ),
( 'normal', 3, 4, 5 ),
( 'quite good', 3, 5, 5 ),
( 'quite good', 3, 6, 5 ),
( 'quite good', 3, 7, 5 ),
( 'quite good', 3, 8, 5 ),
( 'bad', 2, 1, 6 ),
( 'bad', 2, 2, 6 ),
( 'bad', 2, 3, 6 ),
( 'bad', 2, 4, 6 );
SELECT * FROM review where users_id = 4;

-- ------------------------------
DROP TABLE IF EXISTS room_category;
CREATE TABLE room_category (
id int NOT NULL AUTO_INCREMENT,
room_category varchar(100) DEFAULT NULL,
PRIMARY KEY (id));
INSERT INTO room_category (room_category) VALUES 
('standard'),
('deluxe'),
('family'),
('president');
SELECT * FROM room_category;
-- --------------------------------
DROP TABLE IF EXISTS bed_category;
CREATE TABLE bed_category (
id int NOT NULL AUTO_INCREMENT,
bed_category varchar(100) DEFAULT NULL,
PRIMARY KEY (id));

INSERT INTO  bed_category (bed_category) VALUES 
('single Twin'),
('double Twin'),
('single Queen'),
('double Queen'),
('single King');
SELECT * FROM bed_category;
-- -----------------------
DROP TABLE IF EXISTS room;
CREATE TABLE room (
id int NOT NULL AUTO_INCREMENT,
room_name varchar (100) DEFAULT NULL,
max_occupy_adult int DEFAULT NULL,
max_occupy_child int DEFAULT NULL,
price decimal (10,2) DEFAULT NULL,
hotel_id int DEFAULT NULL,
bed_category_id int DEFAULT NULL,
room_category_id int DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (hotel_id) REFERENCES hotel (id),-- ON DELETE CASCADE,
FOREIGN KEY (bed_category_id) REFERENCES bed_category (id),-- ON DELETE CASCADE,
FOREIGN KEY (room_category_id) REFERENCES room_category (id)-- ON DELETE CASCADE,
);
SELECT * FROM room;

INSERT INTO room( hotel_id,room_name,room_category_id, bed_category_id,  max_occupy_adult, max_occupy_child, price) VALUES 
(1,'HA01',1,1,1,1,50),
(1,'HA02',2,2,2,2,75),
(1,'HA03',3,3,2,2,100),
(1,'HA04',3,4,4,4,150),
(1,'HA05',4,5,4,4,400),
(2,'SM01',1,2,2,1,60),
(2,'SM02',2,2,2,2,70),
(2,'SM03',3,3,2,2,120),
(2,'SM04',3,4,4,6,120),
(3,'SR01',1,1,2,2,40),
(3,'SR02',2,1,2,2,30),
(3,'SR03',2,2,4,3,60),
(3,'SR04',3,4,4,6,120),
(3,'SR05',3,3,4,4,80),
(4,'BT01',1,2,2,1,55),
(4,'BT02',2,3,4,2,75),
(4,'BT03',3,4,6,4,125),
(4,'BT04',3,3,4,2,95),
(4,'BT05',4,5,6,6,350),
(5,'PN01',1,1,1,1,35),
(5,'PN02',2,2,4,2,55),
(5,'PN03',3,3,4,2,85),
(5,'PN04',3,4,6,4,105),
(5,'PN05',4,5,8,4,255),
(6,'TB01',2,3,4,2,50),
(6,'TB02',3,4,6,4,100),
(6,'TB03',3,3,4,2,85),
(6,'TB04',2,2,4,2,70),
(7,'SH01',1,2,2,1,40),
(7,'SH02',2,2,4,2,60),
(7,'SH03',3,3,4,2,80),
(7,'SH04',3,4,6,3,100),
(8,'WL01',1,2,2,1,40),
(8,'WL02',2,2,2,1,60),
(8,'WL03',2,3,2,1,80),
(8,'WL04',3,4,4,2,100),
(8,'WL04',4,5,6,3,350);
SELECT * FROM room;

-- SELECT count(*) FROM room;
-- --------------------------
DROP TABLE IF EXISTS voucher;
CREATE TABLE voucher (
id int NOT NULL AUTO_INCREMENT,
voucher_code varchar(100) DEFAULT NULL,
discount_percent int DEFAULT NULL,
expired_date date DEFAULT NULL,
-- appliedDate date DEFAULT NULL,
PRIMARY KEY (id));

INSERT INTO voucher (voucher_code ,
discount_percent ,
expired_date ) VALUES
('SALESOFF', 5, '2023-06-30'),
('ACCOUNT', 10, '2023-12-30'),
('HOLIDAY', 15, '2023-05-30'),
('PROMO20', 20, '2023-09-30'),
('PROMO25', 25, '2023-09-30');
SELECT * FROM voucher;
-- -----------------------------------------------------
-- Tạo bảng calendar_table để có series ngày trong 1 năm
DROP TABLE IF EXISTS calendar_table;
CREATE TABLE calendar_table (
	dt DATE NOT NULL PRIMARY KEY,
	y SMALLINT NULL,
	q tinyint NULL,
	m tinyint NULL,
	d tinyint NULL,
	dw tinyint NULL,
	month_name VARCHAR(9) NULL,
	day_name VARCHAR(9) NULL,
	w tinyint NULL,
	is_weekday BINARY(1) NULL,
	is_holiday BINARY(1) NULL,
	holiday_descr VARCHAR(32) NULL,
	is_payday BINARY(1) NULL
);
DROP TABLE IF EXISTS ints;
CREATE TABLE ints ( i tinyint ); -- ko tạo Entity trong JPA mapping
-- truncate ints;
INSERT INTO ints VALUES (0),(1),(2),(3),(4),(5),(6),(7),(8),(9);
-- truncate calendar_table ;
INSERT INTO calendar_table (dt)
SELECT DATE('2023-01-01') + INTERVAL a.i*10000 + b.i*1000 + c.i*100 + d.i*10 + e.i DAY
FROM ints a JOIN ints b JOIN ints c JOIN ints d JOIN ints e
WHERE (a.i*10000 + b.i*1000 + c.i*100 + d.i*10 + e.i) <= 364 -- 1 NĂM
ORDER BY 1;
SELECT count(*) FROM calendar_table; 
-- ------------------------------------------------------
DROP TABLE IF EXISTS room_dates;
CREATE TABLE room_dates (
id int NOT NULL AUTO_INCREMENT,
dt date DEFAULT NULL, 
room_status int DEFAULT 1, -- 1 or 0
room_id int DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (room_id) REFERENCES room (id),-- ON DELETE CASCADE,
FOREIGN KEY (dt) REFERENCES calendar_table (dt)-- ON DELETE CASCADE,
);
SELECT * FROM room_dates;

-- Dữ liệu được tạo ra từ ban đầu 
INSERT INTO room_dates (room_id, dt)
SELECT room.id, calendar_table.dt 
FROM room 
CROSS JOIN calendar_table;
SELECT * FROM room_dates;
-- SELECT count(*) FROM room_dates; -- tested ok
-- --------------------------------------
DROP TABLE IF EXISTS booking;
CREATE TABLE booking ( -- thông tin bảng này cập nhật từ người dùng/ FORM
id int NOT NULL AUTO_INCREMENT,
users_id int DEFAULT NULL,
check_in date DEFAULT NULL,
check_out date DEFAULT NULL, 
adult_number int DEFAULT NULL,
child_number int DEFAULT NULL,
voucher_id int DEFAULT NULL, 
-- issued_date date DEFAULT (CURRENT_DATE), -- VU cooment
paid_date date DEFAULT (CURRENT_DATE),
cancel_date date DEFAULT NULL, 
booking_status varchar (100) DEFAULT ('open'), -- open, complete, cancel
total_price decimal (10,2) DEFAULT (0),
payment_method varchar(100) DEFAULT NULL,
-- payment_date date DEFAULT NULL,  --comment by Vu 15/01/23
PRIMARY KEY (id),
FOREIGN KEY (voucher_id) REFERENCES voucher (id),-- ON DELETE CASCADE,
FOREIGN KEY (users_id) REFERENCES users (id)-- ON DELETE CASCADE,
);

INSERT INTO booking (users_id, check_in,  check_out , adult_number, child_number , booking_status, total_price, payment_method) VALUES
(3, '2023-01-01', '2023-01-05', 2 , 1,  'open', 10000, 'Paypal' ),
(4, '2023-01-18', '2023-01-19', 1 , 0,  'complete', 12000, 'Visa Credit' );
INSERT INTO booking (users_id, check_in,  check_out , adult_number, child_number , booking_status, total_price, payment_method) VALUES
(3, '2023-01-18', '2023-01-19', 1 , 0,  'complete', 12000, 'Visa Credit' );

SELECT * FROM booking;
-- -----------------------------------------------

DROP TABLE IF EXISTS booking_room;
CREATE TABLE booking_room (
id int NOT NULL AUTO_INCREMENT,
booking_id int DEFAULT NULL ,
room_id int DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (booking_id) REFERENCES booking (id),-- ON DELETE CASCADE,
FOREIGN KEY (room_id) REFERENCES room (id)-- ON DELETE CASCADE,
-- check_in date DEFAULT NULL, -- lấy từ Booking --comment by Vu 15/01/23
-- check_out date DEFAULT NULL, -- lấy từ Booking --comment by Vu 15/01/23
-- room_name varchar (100) DEFAULT NULL, -- lấy từ room --comment by Vu 15/01/23
-- price decimal (10,2) DEFAULT NULL, -- lấy từ room --comment by Vu 15/01/23
-- offer_status int DEFAULT 0, -- 1 (available) or 0 (unavailable) --comment by Vu 15/01/23
-- chosen_status int DEFAULT 0, -- 1 (KH chọn) or 0 (ko chọn) --comment by Vu
-- hotel_id int DEFAULT NULL, --comment by Vu 15/01/23
);

INSERT INTO booking_room (booking_id, room_id) VALUES
(1,1);  

select * from booking_room;

-- chủ yếu replicate dữ liệu từ bảng Booking và 1 số thông tin từ Input 
-- DROP TABLE IF EXISTS bill; --comment by Vu 15/01/23
-- CREATE TABLE bill (
-- id int NOT NULL AUTO_INCREMENT,
-- booking_id int DEFAULT NULL,
-- users_id int DEFAULT NULL,
-- full_name varchar (255) DEFAULT NULL,
-- payment_date date DEFAULT NULL,
-- payment_total decimal (10,2) DEFAULT NULL,
-- payment_method varchar(100) DEFAULT NULL,
-- PRIMARY KEY (id),
-- FOREIGN KEY (booking_id) REFERENCES booking (id),-- ON DELETE CASCADE,
-- FOREIGN KEY (users_id) REFERENCES users (id)-- ON DELETE CASCADE,
-- );
-- SELECT * FROM bill;

-- CẦN BỔ SUNG THÊM CÂU LỆNH INSERT 1 BOOKING ĐƯỢC THỰC HIỆN THANH TOÁN

-- DROP TABLE IF EXISTS booking_room_dates; --comment by Vu 15/01/23
-- CREATE TABLE booking_room_dates (
-- id int NOT NULL AUTO_INCREMENT,
-- room_dates_id int DEFAULT NULL, 
-- room_id int DEFAULT NULL,
-- dt date DEFAULT NULL,
-- room_status int DEFAULT NULL,
-- booking_id int DEFAULT NULL,
-- check_in date DEFAULT NULL,
-- check_out date DEFAULT NULL,
-- PRIMARY KEY (id),
-- FOREIGN KEY (booking_id) REFERENCES booking (id),-- ON DELETE CASCADE,
-- FOREIGN KEY (room_dates_id) REFERENCES room_dates (id)-- ON DELETE CASCADE,
-- );
-- -------------------------------
-- DROP TABLE IF EXISTS offer_status; --comment by Vu 15/01/23
-- CREATE TABLE offer_status ( -- dữ liệu được tạo từ query
-- id int NOT NULL AUTO_INCREMENT,
-- booking_id int  ,-- lấy từ booking_room_dates
-- room_id int DEFAULT NULL, -- lấy từ booking_room_dates
-- offer_status int DEFAULT NULL, -- tính toán từ booking_room_dates
-- PRIMARY KEY (id));

-- ------------ DATABASE CREATION ENDS HERE -----------------
-- ----------------------------------------------------------
-- ------------------------------- --------------------------
-- Query dùng để update dữ liệu bảng BOOKING_ROOM (OFFER) sau khi insert dữ liệu mới vào bảng BOOKING
-- INSERT INTO booking_room (bookingId, checkIn, checkOut, roomId, hotelId, roomName, price) 
-- SELECT b.Id, b.checkIn, b.checkOut, r.Id, r.hotelId, r.roomName, r.price
-- FROM booking AS b
-- CROSS JOIN room AS r;
-- -- WHERE bookingId = ?; -- lấy thông tin từ người dùng
-- SELECT * FROM booking_room;
-- ---------------------------------------
-- insert thông tin bằng query cho bảng này
-- DROP TABLE IF EXISTS booking_room_dates;
-- CREATE TABLE booking_room_dates (
-- id int NOT NULL AUTO_INCREMENT,
-- roomDatesId int DEFAULT NULL, 
-- roomId int DEFAULT NULL,
-- dt date DEFAULT NULL,
-- roomStatus int DEFAULT NULL,
-- bookingId int DEFAULT NULL,
-- checkIn date DEFAULT NULL,
-- checkOut date DEFAULT NULL,
-- FOREIGN KEY (bookingId) REFERENCES booking (id),
-- FOREIGN KEY (roomDatesId) REFERENCES room_dates (id),
-- PRIMARY KEY (id));

-- Query dùng để update dữ liệu bảng booking_room_dates sau khi insert dữ liệu mới vào bảng BOOKING
-- bảng này có thể xóa dữ liệu đi sau khi tính toán
-- INSERT INTO booking_room_dates (roomDatesId, roomId, dt, roomStatus, bookingId, checkIn, checkOut) 
-- SELECT r.id, r.roomId, r.dt, r.roomStatus, b.id, b.checkIn, b.checkOut
-- FROM booking AS b
-- CROSS JOIN room_dates AS r
-- WHERE r.dt >= b.checkIn AND r.dt <= b.checkOut;
-- -- AND bookingId = ?; -- lấy thông tin từ người dùng
-- SELECT * FROM booking_room_dates;
-- ------------------------------
-- bảng này có thể xóa dữ liệu đi sau khi tính toán
-- DROP TABLE IF EXISTS offer_status;
-- CREATE TABLE offer_status ( -- dữ liệu được tạo từ query
-- id int NOT NULL AUTO_INCREMENT,
-- bookingId int  ,-- lấy từ booking_room_dates
-- roomId int DEFAULT NULL, -- lấy từ booking_room_dates
-- offerStatus int DEFAULT NULL, -- tính toán từ booking_room_dates
-- PRIMARY KEY (id));

-- tính toán để kiểm tra mỗi offer có available hay không
-- INSERT INTO offer_status (bookingId, roomId, offerStatus)
-- SELECT 
-- 	  b.bookingId
-- 	, b.roomId
--     , CASE WHEN sum(roomStatus) OVER (partition by b.bookingId , b.roomId)  = count(roomStatus) OVER (partition by b.bookingId , b.roomId) THEN 1 ELSE 0 END AS offerStatus
-- FROM booking_room_dates b;
-- SELECT * FROM offer_status;

-- ----------------------------

SELECT hotel_id, hotel_name, address, description, image, hotel_rank, avg_rate_score, rate_count,
booking_id, room_id, max_occupy_adult, max_occupy_child, price, room_category, bed_category
FROM
(SELECT hotel.hotel_id, hotel.hotel_name, hotel.address, hotel.description, hotel.image, hotel.hotel_rank, hotel.avg_rate_score, hotel.rate_count
, booking.id as booking_id
, room.id as room_id, room.max_occupy_adult, room.max_occupy_child, room.price, room_category.room_category,  bed_category.bed_category
, room_dates.room_status
, SUM(room_dates.room_status) OVER (PARTITION BY booking.id, room.id) AS sum_status
, count(room_dates.room_status) OVER (PARTITION BY booking.id, room.id) AS count_status
FROM
(SELECT h.id AS hotel_id
, h.hotel_name
, h.address
, h.description
, h.image
, h.hotel_rank
, avg(rv.rate_score) AS avg_rate_score 
, count(rv.rate_score) AS rate_count 
FROM hotel AS h 
INNER JOIN review AS rv
ON h.id = rv.hotel_id
WHERE h.id = 1 -- INPUT
GROUP BY 1,2,3,4,5,6) AS hotel

INNER JOIN room
ON room.hotel_id = hotel.hotel_id

CROSS JOIN booking

INNER JOIN room_dates
ON room.id = room_dates.room_id

INNER JOIN bed_category
ON bed_category.id = room.bed_category_id

INNER JOIN room_category
ON room_category.id = room.room_category_id

WHERE booking.id = 1 -- INPUT 
AND room.max_occupy_adult >= booking.adult_number
AND room.max_occupy_child  >= booking.child_number

AND room_dates.dt >= booking.check_in
AND   room_dates.dt < booking.check_out
) AS b
WHERE b.sum_status = b.count_status
GROUP BY 1,2,3,4,5,6,7,8,9,10,11,12,13,14
;

-- -----------------------------------------------------
SELECT -- hotel.id AS hotel_id, 
hotel.hotel_name,
room.id as room_id, room.max_occupy_adult, room.max_occupy_child, 
'2023-01-01' AS check_in, -- input
'2023-01-05' AS check_out, -- input
room_category.room_category,  
bed_category.bed_category,
room.price * datediff('2023-01-05','2023-01-01') AS sub_total_price -- input 
FROM hotel
INNER JOIN room
ON room.hotel_id = hotel.id
INNER JOIN room_dates
ON room.id = room_dates.room_id
INNER JOIN bed_category
ON bed_category.id = room.bed_category_id
INNER JOIN room_category
ON room_category.id = room.room_category_id
WHERE hotel_id = 1 -- hotel id input
AND room.max_occupy_adult >= 2 -- adult_number input
AND room.max_occupy_child  >= 1 -- child_number input
AND room_dates.dt >= '2023-01-01' -- check_in input
AND room_dates.dt < '2023-01-05' -- check_out input
group by 1,2,3,4,5,6,7,8
HAVING  SUM(room_dates.room_status) = COUNT(room_dates.room_status);
-- -------------------------------------------
select b.*, r.room_name as room_name, 
            h.hotel_name as hotel_name, h.address as hotel_address, 
            h.email as hotel_email, h.phone as hotel_phone 
            from room r , hotel h, booking b, booking_room br 
            where b.id=br.booking_id and  r.hotel_id=h.id 
            and br.room_id=r.id and b.users_id= 3 and h.id=1 ;           
-- ------------------------------------------------





















































