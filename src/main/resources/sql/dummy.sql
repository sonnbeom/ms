DELIMITER //

CREATE PROCEDURE Insert11Posts()
BEGIN
    DECLARE counter INT DEFAULT 1;
    
    WHILE counter <= 63 DO
        INSERT INTO POSTS (USERID, TITLE, NICKNAME, TEXTCONTENT, CATEGORY, CREATED_AT, UPDATED_AT)
        VALUES 
        (CONCAT('userID', counter), 
         CONCAT('Title', counter), 
         CONCAT('Nickname', counter), 
         CONCAT('TextContent', counter), 
         'SampleCategory', 
         CURRENT_TIMESTAMP, 
         CURRENT_TIMESTAMP);
         
        SET counter = counter + 1;
    END WHILE;
END //

DELIMITER ;

-- 프로시저 호출
CALL Insert11Posts();