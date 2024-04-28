INSERT INTO MASTER_COUNTRIES (country_id, country_name, telephone_code)VALUES(1, 'United States', '+1');
INSERT INTO MASTER_COUNTRIES (country_id, country_name, telephone_code)VALUES(2, 'India', '+91');

INSERT INTO MASTER_INDIAN_NEWSPAPER_LANGUAGES (language_id, language_name) VALUES (1, 'English');
INSERT INTO MASTER_INDIAN_NEWSPAPER_LANGUAGES (language_id, language_name) VALUES (2, 'Hindi');
INSERT INTO MASTER_INDIAN_NEWSPAPER_LANGUAGES (language_id, language_name) VALUES (3, 'Telugu');
INSERT INTO MASTER_INDIAN_NEWSPAPER_LANGUAGES (language_id, language_name) VALUES (4, 'Tamil');

INSERT INTO MASTER_STATES (state_id, state_name, country_id)VALUES(1, 'Telangana', 2);
    


INSERT INTO MASTER_TELANGANA_DISTRICTS (district_id, district_name, state_id)VALUES(1, 'Hyderabad', 1);    
INSERT INTO MASTER_TELANGANA_DISTRICTS (district_id, district_name, state_id)VALUES(2, 'Wanaparthy', 1);



INSERT INTO MASTER_TELANGANA_MANDALS (mandal_id, mandal_name, district_id)VALUES(1, 'Hyderabad', 1);
INSERT INTO MASTER_TELANGANA_MANDALS (mandal_id, mandal_name, district_id)VALUES(2, 'Ghatkesar', 1);
INSERT INTO MASTER_TELANGANA_MANDALS (mandal_id, mandal_name, district_id)VALUES(3, 'Gopalpet', 2);
INSERT INTO MASTER_TELANGANA_MANDALS (mandal_id, mandal_name, district_id)VALUES(4, 'Wanaparthy', 2);



INSERT INTO MASTER_STATEWISE_TELANGANA_LOCATIONS (
    location_id,
    location_name,
    country_id,
    state_id,
    district_id,
    mandal_id
) VALUES (
    1,
    generate_location_name(2, 1, 1, 1), 
    2,  -- Country ID for India
    1, -- State ID for Telangana
    1,  -- District ID for the district
    1   -- Mandal ID for the mandal
);

INSERT INTO USER_DETAILS(UserID, Username, Age, Gender, Location, RegistrationDate, Active,mobilenumber)
VALUES (1, 'Krishna', 30, 'Male', 'Hyderabad', TIMESTAMP '2024-04-27 10:00:00', 'Y','+919876543210');


-----------------------------------------------
TRUNCATE TABLE MASTER_BATCH_JOBS;

INSERT INTO MASTER_BATCH_JOBS (BATCH_ID, DELIVERY_TIME)
SELECT ROWNUM AS BATCH_ID,
       TO_CHAR(TIMESTAMP '2024-04-28 04:00:00' + INTERVAL '30' MINUTE * (ROWNUM - 1), 'HH:MI AM') AS DELIVERY_TIME
FROM dual
CONNECT BY LEVEL <= 48;

COMMIT;
----------------------------------------------

INSERT INTO VENDOR_TELANGANA_EENADU (newspaper_id, location_id, newspaper_name, newspaper_language, SubscriptionType, SubscriptionFee)
VALUES (1, 1, 'Telangana Eenadu-Hyderabad', 3, 'FREE', 0.00);


INSERT INTO VENDOR_DYNAMIC_GENERIC (dynamic_id, telangana_eenadu_id)
VALUES (1, 1);


INSERT INTO UX_USER_SUBSCRIPTION (user_id, newspaper_id, mandal_id, batch_id, user_eligible)
VALUES (1, 1, 1, 1, 1);




