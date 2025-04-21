--Q1
Create Table students(
id serial Primary Key,
name varchar(50) not null,
email varchar(50) unique;
age int,
marks decimal(5,2)
);


Insert into students (name, email, age, marks)Values ('Yash', 'yash@email.com', 22, 91.5),
('Reddy', 'reddy@gmail.com', 23, 94.2),
('Manoj', 'manoj@gmail.com', 24, 82.4),
('Jafar', 'jafar@gmail.com', 24, 88.4);
Insert into students (name, email, age, marks)Values ('Rahul', 'rahul@email.com', 24, 89.4);
Insert into students (name, email, age, marks)Values ('Varun', 'varun@gmail.com', 20, .4);


select * from students;

--Q2
select * from students where age >21;

--Q3
Update students set email='rahul@gmail.com' where id=5;

--Q4
Delete from students where age <18;

--q5
select * from students order by marks desc limit 1 offset 1;


create table courses (
course_id int;
student_id int;
course_name varchar(50)
);
insert into courses values 
(101, 1, 'Java'),
(102, 2, 'Python'),
(103, 1, 'SQL');

--Q6
select s.name, c.course_name from students s inner join courses c on s.id = c.student_id;

