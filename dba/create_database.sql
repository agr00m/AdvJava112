CREATE database student;
CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';
GRANT ALL ON student.* TO 'student'@'localhost';