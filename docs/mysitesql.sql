use webdb;
desc user;
select * from user;
insert into user values(null,"다미","queen@naver.com","1234","male",now());

-- password 가져오면 안됨
select no,name from user where email = 'queen@naver.com' and password = '1234';



delete from user where no = 3;
