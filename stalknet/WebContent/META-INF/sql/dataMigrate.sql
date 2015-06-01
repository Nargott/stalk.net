CREATE TEMPORARY TABLE tmp SELECT name, pass, mail FROM users_;

INSERT INTO users (login, pass, email) SELECT name, pass, mail FROM tmp