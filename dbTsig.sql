CREATE TABLE USUARIOS (
  nombre varchar(30) NOT NULL,
  username varchar(30) NOT NULL,
  password varchar(30) NULL,
  enabled smallint NOT NULL DEFAULT 1,
  telefono varchar(20) NOT NULL,
  vehiculo_nombre varchar(40) NULL,
  vehiculo_carga int NULL,
  dtype varchar(10) NOT NULL,
  PRIMARY KEY (username)
);

CREATE SEQUENCE ROLES_ID_SEC;
CREATE TABLE ROLES (
  id integer NOT NULL DEFAULT nextval('ROLES_ID_SEC'),
  username varchar(30) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (username) REFERENCES USUARIOS (username)
);
ALTER SEQUENCE ROLES_ID_SEC OWNED BY ROLES.id;

CREATE SEQUENCE SOLICITUDES_ID_SEC;
CREATE TABLE SOLICITUDES (
    id integer NOT NULL DEFAULT nextval('SOLICITUDES_ID_SEC'),
    peso int NULL,
    volumen int NULL,
    precio_max float NOT NULL,
    titulo text NOT NULL,
    descripcion text NULL,
    PRIMARY KEY (id),
    CHECK (peso > 0)
);
ALTER SEQUENCE SOLICITUDES_ID_SEC OWNED BY SOLICITUDES.id;

CREATE TABLE SOLICITUDES_CLIENTES (
  cliente_email varchar(30) NOT NULL,
  solicitud_id int NOT NULL,
  fecha date NOT NULL,
  PRIMARY KEY (solicitud_id),
  FOREIGN KEY (cliente_email) REFERENCES USUARIOS (username),
  FOREIGN KEY (solicitud_id) REFERENCES SOLICITUDES (id)
);

CREATE TABLE FLETEROS_SOLICITUDES_CLIENTES (
  solicitud_id int NOT NULL,
  fletero_email varchar(30) NOT NULL,
  valoracion int DEFAULT 0,
  estado varchar(30) NULL,
  precio float NULL,
  PRIMARY KEY (solicitud_id),
  FOREIGN KEY (fletero_email) REFERENCES USUARIOS (username),
  FOREIGN KEY (solicitud_id) REFERENCES SOLICITUDES (id)
);

CREATE SEQUENCE ZONAS_ID_SEQ;
CREATE TABLE ZONAS (
  id integer NOT NULL DEFAULT nextval('ZONAS_ID_SEQ'),
  precio float NOT NULL,
  PRIMARY KEY (id)
);
ALTER SEQUENCE ZONAS_ID_SEQ OWNED BY ZONAS.id;

CREATE TABLE ZONAS_FLETEROS (
  fletero_email varchar(30) NOT NULL,
  zona_id int NOT NULL,
  PRIMARY KEY (zona_id),
  FOREIGN KEY (fletero_email) REFERENCES USUARIOS(username),
  FOREIGN KEY (zona_id) REFERENCES ZONAS(id)
);
