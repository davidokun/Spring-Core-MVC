CREATE TABLE user
(
    id INT,
    username VARCHAR(50),
    password VARCHAR(50),
    enable TINYINT
);

INSERT INTO test.user
(id, username, password, enable)
    VALUES
    (1, 'testuser','testpassword',true),
    (2, 'testuser2','testpassword2',true)