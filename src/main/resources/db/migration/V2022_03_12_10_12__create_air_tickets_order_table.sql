Create Table air_tickets_order
(
    id                           INT          NOT NULL AUTO_INCREMENT,
    user_id                      INT          NOT NULL,
    flight_no                  VARCHAR(200)   ,
    flight_date                TIMESTAMP(3)   ,
    order_status                 VARCHAR(200) NOT NULL,
    pay_type                 VARCHAR(200) ,
    amount                       FLOAT       ,
    ticket_id                   INT          ,
    invoice_id                   INT         ,
    luggage_id                   INT         ,
    original_order_id            INT,
    created_at                  TIMESTAMP(3) DEFAULT '1970-01-01 10:00:00',
    updated_at                  TIMESTAMP(3) DEFAULT '1970-01-01 10:00:00',
    PRIMARY KEY (id)
)
