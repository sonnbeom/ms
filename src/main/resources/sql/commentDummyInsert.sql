DELIMITER //
CREATE PROCEDURE InsertMultipleComments()
BEGIN
    DECLARE i INT DEFAULT 0;

    WHILE i < 100 DO
        INSERT INTO COMMENTS (POST_ID, TEXT, STATUS, CREATED_AT, UPDATED_AT, USER_ID)
        VALUES (1, CONCAT('This is a sample comment number ', i), 'active',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'test1');

        SET i = i + 1;
    END WHILE;

END //

DELIMITER ;

CALL InsertMultipleComments();


DROP PROCEDURE InsertMultipleComments;
