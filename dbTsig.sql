CREATE TABLE FLETEROS (
  nombre varchar(30) NOT NULL,
  email varchar(30) NOT NULL,
  password varchar(30) NOT NULL,
  telefono varchar(20) NOT NULL,
  PRIMARY KEY (email, password)
);

CREATE TABLE CLIENTES (
  nombre varchar(30) NOT NULL,
  email varchar(30) NOT NULL,
  password varchar(30) NOT NULL,
  telefono varchar(20) NOT NULL,
  PRIMARY KEY (email, password)
);

CREATE SEQUENCE SOLICITUDES_ID_SEC;
CREATE TABLE SOLICITUDES (
    id integer NOT NULL DEFAULT nextval('SOLICITUDES_ID_SEC'),
    origen point NOT NULL,
    destino point NOT NULL,
    peso int NOT NULL,
    titulo text NOT NULL,
    precio real NOT NULL,
    descripcion text NULL,
    PRIMARY KEY (id),
    CHECK (peso > 0)
);
ALTER SEQUENCE SOLICITUDES_ID_SEC OWNED BY SOLICITUDES.id;

CREATE TABLE SOLICITUDES_CLIENTES (
  cliente_email varchar(30) REFERENCES CLIENTES (email),
  cliente_password varchar(30) REFERENCES CLIENTES (password),
  solicitud_id int REFERENCES SOLICITUDES (id),
  fecha timestamp NOT NULL,
  PRIMARY KEY (solicitud_id)
);

CREATE TABLE FLETEROS_SOLICITUDES_CLIENTES (
  solicitud_id int REFERENCES SOLICITUDES_CLIENTES (solicitud_id),
  fletero_email varchar(30) REFERENCES FLETEROS (email),
  fletero_password varchar(30) REFERENCES FLETEROS (password),
  valoracion int DEFAULT 0,
  comentario varchar(300) NULL,
  PRIMARY KEY (solicitud_id)
);

CREATE SEQUENCE ZONAS_ID_SEQ;
CREATE TABLE ZONAS (
  id integer NOT NULL DEFAULT nextval('SOLICITUDES_ID_SEC'),
  precio double NOT NULL,
  PRIMARY KEY (id)
);
ALTER SEQUENCE ZONAS_ID_SEQ OWNED BY ZONAS.id;

CREATE TABLE ZONAS_FLETEROS (
  fletero_email varchar(30) REFERENCES FLETEROS (email),
  fletero_password varchar(30) REFERENCES FLETEROS (password),
  zona_id int REFERENCES ZONAS (id),
  PRIMARY KEY (zona_id)
);

CREATE TABLE VEHICULOS (
  nombre varchar(40) NOT NULL,
  carga int NOT NULL,
  CHECK (carga > 0),
  PRIMARY KEY (nombre)
);

CREATE TABLE VEHICULOS_FLETEROS (
  fletero_email varchar(30) REFERENCES FLETEROS (email),
  fletero_password varchar(30) REFERENCES FLETEROS (password),
  nombre varchar(40) REFERENCES VEHICULOS(nombre),
  PRIMARY KEY (nombre)
);
