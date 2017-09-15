CREATE DATABASE futbolpluss;

CREATE TABLE eqipos (
equ_code INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
equ_nombre varchar(60) NOT NULL,
equ_escudo blob
)

CREATE TABLE usuarios (
usu_code INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
usu_nombre varchar(60) NOT NULL,
usu_usuario varchar(10) NOT NULL,
usu_clave varchar(10) NOT NULL
)
CREATE TABLE resultados (
res_code INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
res_usuario INTEGER NOT NULL,
res_fecreacion DATE NOT NULL,
res_feencuentro DATE NOT NULL,
CONSTRAINT resultados_res_usuario_ref FOREIGN KEY (res_usuario) REFERENCES usuarios(usu_code)
)
CREATE TABLE marcadores (
mar_code INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
mar_equipo INTEGER NOT NULL,
mar_anotacion INTEGER NOT NULL,
mar_resultado Integer NOT NULL,
mar_local boolean NOT NULL,
CONSTRAINT marcadores_mal_resultado_ref FOREIGN KEY (mar_resultado) REFERENCES resultados(res_code)
)