DELIMITER $$

CREATE PROCEDURE get_users_by_filtering(
IN reg_academico VARCHAR(9),
IN nom_completo VARCHAR(200),
IN cor_electronico VARCHAR(255)
)
BEGIN
SELECT * from users
WHERE
registro_academico REGEXP concat(reg_academico)
AND nombre_completo REGEXP concat(nom_completo)
AND correo_electronico REGEXP concat(cor_electronico);
END;$$

DELIMITER $$

CREATE PROCEDURE get_users_by_search(
IN to_search VARCHAR(255)
)
BEGIN
SELECT * from users
WHERE
registro_academico REGEXP concat(to_search)
OR nombre_completo REGEXP concat(to_search)
OR correo_electronico REGEXP concat(to_search);
END;$$

DELIMITER $$

CREATE PROCEDURE get_communities_by_search(
IN to_search VARCHAR(255)
)
BEGIN
SELECT * from comunity
WHERE
id_comunity REGEXP concat(to_search)
OR nombre_comunidad REGEXP concat(to_search)
OR course_codigo_curso REGEXP concat(to_search);
END;$$




