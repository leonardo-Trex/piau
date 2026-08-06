
    set client_min_messages = WARNING;

    alter table if exists topics 
       drop constraint if exists FK5ev6xmksptiooaygsp0bjio5j;

    drop table if exists exams cascade;

    drop table if exists group_projects cascade;

    drop table if exists topics cascade;
