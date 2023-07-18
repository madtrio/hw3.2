-- 1. Получить всех студентов, возраст которых находится между 10 и 20 (можно подставить любые числа, главное, чтобы нижняя граница была меньше верхней).
-- 2. Получить всех студентов, но отобразить только список их имен.
-- 3. Получить всех студентов, у которых в имени присутствует буква «О» (или любая другая).
-- 4. Получить всех студентов, у которых возраст меньше идентификатора.
-- 5. Получить всех студентов упорядоченных по возрасту.

select * from students where age between 10 and 20;
select name from students;
select * from students where name like '%O%';
select * from students where age < id;
select * from students order by age;