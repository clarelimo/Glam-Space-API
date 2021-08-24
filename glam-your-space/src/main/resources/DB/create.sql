SET MODE PostgreSQL;

CREATETABLE IF NOT EXISTS feedback (
id int PRIMARY KEY auto_increament,
name VARCHAR,
email VARCHAR,
message VARCHAR
);