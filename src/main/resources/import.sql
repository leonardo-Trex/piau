INSERT INTO group_projects(description, deadline, my_role, status)
VALUES
    ('Trabalho A1 - Semana Acadêmica', '2026-02-01', 'Pesquisar',0),
    ('Trabalho A2 - Apresentação', '2026-03-01', 'Canvas',0);

INSERT INTO exams(description, deadline, status)
VALUES
    ('Prova de Cálculo I', '2026-02-01', 0),
    ('Prova de Cálculo I A2', '2026-03-01', 0);

INSERT INTO topics(description, proficiency, exam_id)
VALUES
    ('Derivadas', 0, 1),
    ('Integrais', 0, 1);