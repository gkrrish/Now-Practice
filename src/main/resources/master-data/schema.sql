
CREATE TABLE MASTER_COUNTRIES (
    country_id INT PRIMARY KEY,
    country_name VARCHAR(100),
    telephone_code VARCHAR(20) -- Adjust the size according to your needs
);


CREATE TABLE MASTER_INDIAN_NEWSPAPER_LANGUAGES (
    language_id INT PRIMARY KEY,
    language_name VARCHAR(100)
);


CREATE TABLE MASTER_STATES (
    state_id INT PRIMARY KEY,
    state_name VARCHAR(100),
    country_id INT,
    FOREIGN KEY (country_id) REFERENCES MASTER_COUNTRIES(country_id)
);

CREATE TABLE MASTER_TELANGANA_DISTRICTS (
    district_id INT PRIMARY KEY,
    district_name VARCHAR(100),
    state_id INT,
    FOREIGN KEY (state_id) REFERENCES MASTER_STATES(state_id)
);


CREATE TABLE MASTER_TELANGANA_MANDALS (
    mandal_id INT PRIMARY KEY,
    mandal_name VARCHAR(100),
    district_id INT,
    FOREIGN KEY (district_id) REFERENCES MASTER_TELANGANA_DISTRICTS(district_id)
);

CREATE TABLE MASTER_STATEWISE_TELANGANA_LOCATIONS (
    location_id INT PRIMARY KEY,
    location_name VARCHAR(100),
    country_id INT,
    state_id INT,
    district_id INT,
    mandal_id INT,
    FOREIGN KEY (country_id) REFERENCES MASTER_COUNTRIES(country_id),
    FOREIGN KEY (state_id) REFERENCES MASTER_STATES(state_id),
    FOREIGN KEY (district_id) REFERENCES MASTER_TELANGANA_DISTRICTS(district_id),
    FOREIGN KEY (mandal_id) REFERENCES MASTER_TELANGANA_MANDALS(mandal_id)
);

CREATE TABLE USER_DETAILS(
    UserID NUMBER(10) PRIMARY KEY,
    mobileNumber VARCHAR2(13) UNIQUE,
    Username VARCHAR2(50),
    Age NUMBER(3),
    Gender VARCHAR2(10) CHECK (Gender IN ('Male', 'Female', 'Other')),
    Location VARCHAR2(100),
    RegistrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Active CHAR(1) DEFAULT 'Y' CHECK (Active IN ('Y', 'N'))
);

CREATE TABLE MASTER_BATCH_JOBS (
    BATCH_ID NUMBER PRIMARY KEY,
    DELIVERY_TIME VARCHAR2(20)		,
    INTERVAL_MINUTES NUMBER(2) DEFAULT 30
);

CREATE TABLE SUBSCRIPTION_TYPE (
  subscriptiontypeid INT PRIMARY KEY,
  subscriptiontype VARCHAR2(10) CHECK (subscriptiontype IN ('FREE', 'PAID')),
  subscriptionduration VARCHAR2(10),
  subscriptionfee DECIMAL(10, 2) CHECK (subscriptionfee >= 0),
  CONSTRAINT chk_subscription_type_fee CHECK (
    (UPPER(subscriptiontype) = 'FREE' AND subscriptionfee = 0) OR
    (UPPER(subscriptiontype) = 'PAID' AND subscriptionfee > 0)
  )
);

CREATE TABLE VENDOR_TELANGANA_EENADU (
  newspaper_id INT PRIMARY KEY,
  location_id INT,
  newspaper_name VARCHAR(100),
  newspaper_language INT,
  subscription_type_id INT,
  FOREIGN KEY (location_id) REFERENCES MASTER_STATEWISE_TELANGANA_LOCATIONS(location_id),
  FOREIGN KEY (newspaper_language) REFERENCES MASTER_INDIAN_NEWSPAPER_LANGUAGES(language_id),
  FOREIGN KEY (subscription_type_id) REFERENCES SUBSCRIPTION_TYPE(subscriptiontypeid)
);


CREATE TABLE VENDOR_TELANGANA_VAARTHA (
  newspaper_id INT PRIMARY KEY,
  location_id INT,
  newspaper_name VARCHAR(100),
  newspaper_language INT,
  subscription_type_id INT,
  FOREIGN KEY (location_id) REFERENCES MASTER_STATEWISE_TELANGANA_LOCATIONS(location_id),
  FOREIGN KEY (newspaper_language) REFERENCES MASTER_INDIAN_NEWSPAPER_LANGUAGES(language_id),
  FOREIGN KEY (subscription_type_id) REFERENCES SUBSCRIPTION_TYPE(subscriptiontypeid)
);

===============================================================================================================================================

-- Create the VENDOR_DYNAMIC_GENERIC table
CREATE TABLE VENDOR_DYNAMIC_GENERIC (
    dynamic_id INT PRIMARY KEY,
    telangana_eenadu_id INT NOT NULL,
    CONSTRAINT FK_EenaduId FOREIGN KEY (telangana_eenadu_id) REFERENCES VENDOR_TELANGANA_EENADU(newspaper_id)
);

CREATE TABLE UX_USER_SUBSCRIPTION (
    user_id INT,
    newspaper_id INT,
    batch_id NUMBER,
    user_eligible NUMBER(1,0) DEFAULT 1,
    location_id INT,
    
    CONSTRAINT PK_UX_USER_SUBSCRIPTION PRIMARY KEY (user_id, newspaper_id,location_id),
    FOREIGN KEY (user_id) REFERENCES USER_DETAILS(UserID),
    FOREIGN KEY (newspaper_id) REFERENCES VENDOR_DYNAMIC_GENERIC(DYNAMIC_ID),
    FOREIGN KEY (location_id) REFERENCES MASTER_STATEWISE_TELANGANA_LOCATIONS(LOCATION_ID),
    FOREIGN KEY (batch_id) REFERENCES MASTER_BATCH_JOBS(batch_id)
);



=====================================================================================================================================================

-- Create the function generate_location_name in PL/SQL
CREATE OR REPLACE FUNCTION generate_location_name(country_id INT, state_id INT, district_id INT, mandal_id INT)
RETURN VARCHAR2 AS
    country_name VARCHAR2(100);
    state_name VARCHAR2(100);
    district_name VARCHAR2(100);
    mandal_name VARCHAR2(100);
    result VARCHAR2(500);
BEGIN
    SELECT country_name INTO country_name FROM MASTER_COUNTRIES WHERE country_id = generate_location_name.country_id;
    SELECT state_name INTO state_name FROM MASTER_STATES WHERE state_id = generate_location_name.state_id;
    SELECT district_name INTO district_name FROM MASTER_TELANGANA_DISTRICTS WHERE district_id = generate_location_name.district_id;
    SELECT mandal_name INTO mandal_name FROM MASTER_TELANGANA_MANDALS WHERE mandal_id = generate_location_name.mandal_id;
    
    result := country_name || '_' || state_name || '_' || district_name || '_' || mandal_name;
    
    RETURN result;
END;
/

DECLARE
    loc_name VARCHAR2(100);
BEGIN
    loc_name := generate_location_name(9, 24, 3, 1); 
    DBMS_OUTPUT.PUT_LINE('Location Name: ' || loc_name);
END;
===================================================================================================================================

    CREATE TABLE MASTER_ANDHRAPRADESH_DISTRICTS (
    district_id INT PRIMARY KEY,
    district_name VARCHAR(100),
    state_id INT,
    FOREIGN KEY (state_id) REFERENCES MASTER_STATES(state_id)
    );

    
    CREATE TABLE MASTER_ANDHRAPRADESH_MANDALS (
    mandal_id INT PRIMARY KEY,
    mandal_name VARCHAR(100),
    district_id INT,
    FOREIGN KEY (district_id) REFERENCES MASTER_ANDHRAPRADESH_DISTRICTS(district_id)
    );
    
    CREATE TABLE MASTER_STATEWISE_ANDHRAPRADESH_LOCATIONS (
    location_id INT PRIMARY KEY,
    location_name VARCHAR(100),
    country_id INT,
    state_id INT,
    district_id INT,
    mandal_id INT,
    FOREIGN KEY (country_id) REFERENCES MASTER_COUNTRIES(country_id),
    FOREIGN KEY (state_id) REFERENCES MASTER_STATES(state_id),
    FOREIGN KEY (district_id) REFERENCES MASTER_ANDHRAPRADESH_DISTRICTS(district_id),
    FOREIGN KEY (mandal_id) REFERENCES MASTER_ANDHRAPRADESH_MANDALS(mandal_id)
    );

========================================================================================================================================
