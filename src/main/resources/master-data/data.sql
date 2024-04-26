INSERT INTO MASTER_COUNTRIES (country_id, country_name, telephone_code)
VALUES
    (1, 'United States', '+1'),
    (2, 'United Kingdom', '+44'),
    (3, 'Canada', '+1'),
    (4, 'Australia', '+61'),
    (5, 'Germany', '+49'),
    (6, 'France', '+33'),
    (7, 'Japan', '+81'),
    (8, 'China', '+86'),
    (9, 'India', '+91'),
    (10, 'Brazil', '+55');

INSERT INTO MASTER_INDIAN_NEWSPAPER_LANGUAGES (language_id, language_name) VALUES (1, 'English');
INSERT INTO MASTER_INDIAN_NEWSPAPER_LANGUAGES (language_id, language_name) VALUES (2, 'Hindi');
INSERT INTO MASTER_INDIAN_NEWSPAPER_LANGUAGES (language_id, language_name) VALUES (3, 'Telugu');
INSERT INTO MASTER_INDIAN_NEWSPAPER_LANGUAGES (language_id, language_name) VALUES (4, 'Tamil');

INSERT INTO MASTER_STATES (state_id, state_name, country_id)
VALUES
    (1, 'Andhra Pradesh', 9),
    (2, 'Arunachal Pradesh', 9),
    (3, 'Assam', 9),
    (4, 'Bihar', 9),
    (5, 'Chhattisgarh', 9),
    (6, 'Goa', 9),
    (7, 'Gujarat', 9),
    (8, 'Haryana', 9),
    (9, 'Himachal Pradesh', 9),
    (10, 'Jharkhand', 9),
    (11, 'Karnataka', 9),
    (12, 'Kerala', 9),
    (13, 'Madhya Pradesh', 9),
    (14, 'Maharashtra', 9),
    (15, 'Manipur', 9),
    (16, 'Meghalaya', 9),
    (17, 'Mizoram', 9),
    (18, 'Nagaland', 9),
    (19, 'Odisha', 9),
    (20, 'Punjab', 9),
    (21, 'Rajasthan', 9),
    (22, 'Sikkim', 9),
    (23, 'Tamil Nadu', 9),
    (24, 'Telangana', 9),
    (25, 'Tripura', 9),
    (26, 'Uttar Pradesh', 9),
    (27, 'Uttarakhand', 9),
    (28, 'West Bengal', 9),
    (29, 'Andaman and Nicobar Islands', 9),
    (30, 'Chandigarh', 9),
    (31, 'Dadra and Nagar Haveli and Daman and Diu', 9),
    (32, 'Lakshadweep', 9),
    (33, 'Delhi', 9),
    (34, 'Puducherry', 9);


INSERT INTO MASTER_TELANGANA_DISTRICTS (district_id, district_name, state_id)
VALUES
    (1, 'Adilabad', 24),
    (2, 'Bhadradri Kothagudem', 24),
    (3, 'Hyderabad', 24),
    (4, 'Jagtial', 24),
    (5, 'Jangaon', 24),
    (6, 'Jayashankar Bhupalapally', 24),
    (7, 'Jogulamba Gadwal', 24),
    (8, 'Kamareddy', 24),
    (9, 'Karimnagar', 24),
    (10, 'Khammam', 24),
    (11, 'Komaram Bheem Asifabad', 24),
    (12, 'Mahabubabad', 24),
    (13, 'Mahbubnagar', 24),
    (14, 'Mancherial', 24),
    (15, 'Medak', 24),
    (16, 'Medchal', 24),
    (17, 'Nagarkurnool', 24),
    (18, 'Nalgonda', 24),
    (19, 'Nirmal', 24),
    (20, 'Nizamabad', 24),
    (21, 'Peddapalli', 24),
    (22, 'Rajanna Sircilla', 24),
    (23, 'Rangareddy', 24),
    (24, 'Sangareddy', 24),
    (25, 'Siddipet', 24),
    (26, 'Suryapet', 24),
    (27, 'Vikarabad', 24),
    (28, 'Wanaparthy', 24),
    (29, 'Warangal Rural', 24),
    (30, 'Warangal Urban', 24),
    (31, 'Yadadri Bhuvanagiri', 24);


INSERT INTO MASTER_ANDHRAPRADESH_DISTRICTS (district_id, district_name, state_id)
VALUES
    (1, 'Anantapur', 1),
    (2, 'Chittoor', 1),
    (3, 'East Godavari', 1),
    (4, 'Guntur', 1),
    (5, 'Kadapa', 1),
    (6, 'Krishna', 1),
    (7, 'Kurnool', 1),
    (8, 'Nellore', 1),
    (9, 'Prakasam', 1),
    (10, 'Srikakulam', 1),
    (11, 'Visakhapatnam', 1),
    (12, 'Vizianagaram', 1),
    (13, 'West Godavari', 1),
    (14, 'YSR Kadapa', 1);


INSERT INTO MASTER_TELANGANA_MANDALS (mandal_id, mandal_name, district_id)
VALUES
    (1, 'Hyderabad', 3),
    (2, 'Ghatkesar', 3),
    (3, 'Kukatpally', 3),
    (4, 'L. B. Nagar', 3);



INSERT INTO MASTER_STATEWISE_TELANGANA_LOCATIONS (
    location_id,
    location_name,
    country_id,
    state_id,
    district_id,
    mandal_id
) VALUES (
    1,
    generate_location_name(9, 24, 3, 1), -- Example values for location name generation
    9,  -- Country ID for India
    24, -- State ID for Telangana
    3,  -- District ID for the district
    1   -- Mandal ID for the mandal
);

INSERT INTO VENDOR_TELANGANA_EENADU (newspaper_id, newspaper_name, upload_date, mandal_id, pdf_location)
VALUES (1, 'Telangana Eenadu-Hyderabad', TO_DATE('2024-04-28', 'YYYY-MM-DD'), 1, 's3://bucket-name/mandal1/newspaper1.pdf');
