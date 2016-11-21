DROP TABLE employees;
 
CREATE TABLE employees (
    emp_id          int(11) NOT NULL auto_increment,
    first_name      varchar(25),
    last_name       varchar(30),
    ssn             varchar(20),
    dept            varchar(10),
    room            varchar(10),
    phone           varchar(10),
    PRIMARY KEY  (emp_id)
) ENGINE=InnoDB;
 
INSERT into employees values (101, 'Joe', 'Coyne', '111-22-3333', 'HR', '125', '555-3726');
INSERT into employees values (102, 'Fred', 'Hensen', '222-33-4444', 'Eng', '126', '555-3727');
INSERT into employees values (103, 'Ethyl', 'Roselle', '333-44-5555', 'Admin', '127', '555-3728');
INSERT into employees values (104, 'Barney', 'Curry', '444-55-6666', 'IT', '128', '555-3729');
INSERT into employees values (105, 'Wilma', 'Hilgart', '555-66-7777', 'HR', '129', '555-3730');
INSERT into employees values (106, 'Greg', 'Statz', '666-77-8888', 'Eng', '130', '555-3731');
insert into employees values (107, 'Mark', 'Stanley', '777-88-9999', 'Admin', '131', '555-3732');
insert into employees values (108, 'Sandy', 'Flynn', '888-99-1111', 'IT', '132', '555-3733');
insert into employees values (109, 'Chris', 'Foley', '999-11-2222', 'HR', '133', '555-3734');
insert into employees values (110, 'Dan', 'Bristol', '123-45-6789', 'Eng', '134', '555-3735');
insert into employees values (111, 'Don', 'Buell', '234-56-7891', 'Admin', '225', '555-3736');
insert into employees values (112, 'Glen', 'Doran', '345-67-8912', 'IT', '226', '555-3737');
insert into employees values (113, 'Bill', 'Gardiner', '456-78-9123', 'HR', '227', '555-3738');
insert into employees values (114, 'Karen', 'Mack', '567-89-1234', 'Eng', '228', '555-3739');
insert into employees values (115, 'Dianne', 'Klein', '678-91-2345', 'Admin', '229', '555-3740');
insert into employees values (116, 'Dawn', 'Tillman', '789-12-3456', 'IT', '230', '555-3741');
insert into employees values (117, 'Ed', 'O''Connor', '891-23-4567', 'HR', '231', '555-3742');
insert into employees values (118, 'Hugo', 'Matson', '912-34-5678', 'Eng', '232', '555-3743');
insert into employees values (119, 'Dave', 'Koch', '987-65-4321', 'Admin', '233', '555-3744');
insert into employees values (120, 'Mike', 'Smith', '876-54-3219', 'IT', '234', '555-3745');
insert into employees values (121, 'Alan', 'Smith', '765-43-2198', 'HR', '235', '555-3746');
insert into employees values (122, 'Brian', 'Smith', '654-32-1987', 'Eng', '236', '555-3747');
insert into employees values (123, 'Nancy', 'Hagman', '543-21-9876', 'Admin', '237', '555-3748');
insert into employees values (124, 'Andre', 'Dillard', '432-19-8765', 'IT', '238', '555-3749');
insert into employees values (125, 'Jack', 'Darrow', '321-98-7654', 'HR', '239', '555-3750');
insert into employees values (126, 'Vicki', 'Berg', '219-87-6543', 'Eng', '311', '555-3751');
insert into employees values (127, 'Grank', 'Marco', '198-76-5432', 'Admin', '312', '555-3752');
insert into employees values (128, 'Brenda', 'Smithson', '999-88-7777', 'IT', '313', '555-3753');
insert into employees values (129, 'Barry', 'Thorpe', '888-77-6666', 'HR', '314', '555-3754');
insert into employees values (130, 'Sheri', 'Lytle', '777-66-5555', 'Eng', '315', '555-3755');
insert into employees values (131, 'Connie', 'Hunter', '666-55-4444', 'Admin', '316', '555-3756');
insert into employees values (132, 'Jim', 'Cramer', '555-44-3333', 'IT', '317', '555-3757');
insert into employees values (133, 'Craig', 'Kim', '444-33-2222', 'HR', '318', '555-3758');
insert into employees values (134, 'Jay', 'Meyer', '333-22-1111', 'Eng', '319', '555-3759');
insert into employees values (135, 'John', 'Reyes', '222-11-9999', 'Admin', '320', '555-3760');
insert into employees values (136, 'Curtis', 'Strand', '111-99-8888', 'IT', '321', '555-3761');
insert into employees values (137, 'Fred', 'Balmer', '546-87-9349', 'HR', '322', '555-3762');
insert into employees values (138, 'Donna', 'Gorman', '159-34-3187', 'Eng', '323', '555-3763');
insert into employees values (139, 'Janice', 'Hall', '375-45-9833', 'Admin', '324', '555-3764');
insert into employees values (140, 'Jennifer', 'Houseman', '479-58-4879', 'IT', '401', '555-3765');
insert into employees values (141, 'Jane', 'Linderman', '157-98-6125', 'HR', '402', '555-3766');
insert into employees values (142, 'Sheila', 'Moore', '459-35-7913', 'Eng', '403', '555-3767');
insert into employees values (143, 'Seth', 'Olson', '587-59-3214', 'Admin', '404', '555-3768');
insert into employees values (144, 'Kathy', 'Roberts', '719-12-9854', 'IT', '405', '555-3769');
insert into employees values (145, 'Laura', 'Johnson', '579-15-3187', 'HR', '406', '555-3770');
insert into employees values (146, 'Sharon', 'Lee', '447-84-1115', 'Eng', '407', '555-3771');
insert into employees values (147, 'Jeff', 'Sager', '487-54-5149', 'Admin', '408', '555-3772');
insert into employees values (148, 'Steve', 'Stone', '156-16-1321', 'IT', '409', '555-3773');
insert into employees values (149, 'Nick', 'Mathis', '487-32-4981', 'HR', '410', '555-3774');
insert into employees values (150, 'Carrie', 'Ramirez', '657-54-9813', 'Eng', '411', '555-3775');