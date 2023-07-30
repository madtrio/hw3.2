--liquibase formatted sql

-- changeset madtrio:1
--precondition-sql-check expectedResult:0 select count(*) from pg_catalog.pg_tables t inner join pg_indexes i on i.tablename = t.tablename = where t.tablename = 'students' and i.indexname = 'IDX_students_name';
--rollback DROP INDEX IDX_students_name
CREATE INDEX IDX_students_name ON students (name);

-- changeset madtrio:2
--precondition-sql-check expectedResult:0 select count(*) from pg_catalog.pg_tables t inner join pg_indexes i on i.tablename = t.tablename = where t.tablename = 'faculties' and i.indexname = 'IDX_faculties_name_color';
--rollback DROP INDEX IDX_faculties_name_color
CREATE INDEX IDX_faculties_name_color ON faculties (name, color);

