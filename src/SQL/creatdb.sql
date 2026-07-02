/*create table transactions (
transactions_id int primary Key,
amount decimal(10,2),
status varchar(20),
currency varchar(10),
created_at date,
sender_bank varchar(20)
)
DESCRIBE transactions;
select * from transactions
delete from transactions where transactions_id=3;
*/
insert into transactions values
(1, 4500, 'SUCCESS', 'USD', '2026-06-01', 'HDFC Bank'),
(2, 12000, 'FAILED', 'USD', '2026-06-02', 'ICICI Bank'),
(3, 3200, 'SUCCESS', 'EUR', '2026-06-03', 'SBI'),
(4, 8700, 'PENDING', 'USD', '2026-06-04', 'HDFC Bank'),
(5, 15600, 'FAILED', 'INR', '2026-06-05', 'Axis Bank'),
(6, 2100, 'SUCCESS', 'USD', '2026-06-06', 'ICICI Bank'),
(7, 9900, 'FAILED', 'EUR', '2026-06-07', 'HSBC'),
(8, 4300, 'SUCCESS', 'USD', '2026-06-08', 'Kotak Mahindra'),
(9, 1800, 'PENDING', 'INR', '2026-06-09', 'ICICI Bank'),
(10, 22000, 'SUCCESS', 'USD', '2026-06-10', 'HDFC Bank');