DELETE FROM table_b;
DELETE FROM table_a;

INSERT INTO table_a(id)
VALUES
    (0),
    (1),
    (2);
INSERT INTO table_b(id, status, a_id)
VALUES
    (0, -1, 0),
    (1, 0, 1),
    (2, -1, 1),
    (3, 0, 2);