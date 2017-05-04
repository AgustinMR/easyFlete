CREATE TABLE FLETEROS (
  nombre varchar(30) NOT NULL,
  email varchar(30) NOT NULL,
  password varchar(30) NOT NULL,
  telefono varchar(20) NOT NULL,
  vehiculo_nombre varchar(40) NULL,
  vehiculo_carga varchar(40) NULL,
  PRIMARY KEY (email)
);

CREATE TABLE CLIENTES (
  nombre varchar(30) NOT NULL,
  email varchar(30) NOT NULL,
  password varchar(30) NULL,
  telefono varchar(20) NOT NULL,
  PRIMARY KEY (email)
);

CREATE SEQUENCE SOLICITUDES_ID_SEC;
CREATE TABLE SOLICITUDES (
    id integer NOT NULL DEFAULT nextval('SOLICITUDES_ID_SEC'),
    origen text NOT NULL,
    destino text NOT NULL,
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
  fecha timestamp NOT NULL,
  PRIMARY KEY (solicitud_id),
  FOREIGN KEY (cliente_email) REFERENCES CLIENTES (email),
  FOREIGN KEY (solicitud_id) REFERENCES SOLICITUDES (id)
);

CREATE TABLE FLETEROS_SOLICITUDES_CLIENTES (
  solicitud_id int NOT NULL,
  fletero_email varchar(30) NOT NULL,
  valoracion int DEFAULT 0,
  comentario varchar(300) NULL,
  PRIMARY KEY (solicitud_id),
  FOREIGN KEY (fletero_email) REFERENCES FLETEROS (email),
  FOREIGN KEY (solicitud_id) REFERENCES SOLICITUDES (id)
);

CREATE SEQUENCE ZONAS_ID_SEQ;
CREATE TABLE ZONAS (
  id integer NOT NULL DEFAULT nextval('SOLICITUDES_ID_SEC'),
  precio float NOT NULL,
  PRIMARY KEY (id)
);
ALTER SEQUENCE ZONAS_ID_SEQ OWNED BY ZONAS.id;

CREATE TABLE ZONAS_FLETEROS (
  fletero_email varchar(30) NOT NULL,
  zona_id int NOT NULL,
  PRIMARY KEY (zona_id),
  FOREIGN KEY (fletero_email) REFERENCES FLETEROS(email),
  FOREIGN KEY (zona_id) REFERENCES ZONAS(id)
);
