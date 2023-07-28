SELECT s.name, s.age
FROM students s
         LEFT JOIN faculties f ON s.faculty_id = f.id;

SELECT s.name, s.age, a.id
FROM students s
         INNER JOIN avatar a ON s.id = a.student_id;

