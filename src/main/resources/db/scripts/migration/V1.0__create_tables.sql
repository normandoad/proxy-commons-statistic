CREATE TABLE client (
  id UUID NOT NULL,
  ip VARCHAR(255) NOT NULL,
  idproxy UUID NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE query (
  id UUID NOT NULL,
  idClient UUID NOT NULL,
  QueryPath VARCHAR(255) NOT NULL,
  initDate TIMESTAMP NOT NULL,
  endDate TIMESTAMP DEFAULT NULL,
  initDateMeliRequest TIMESTAMP NOT NULL,
  endDateMeliRequest TIMESTAMP NOT NULL,
  exception VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE proxy (
  id UUID NOT NULL,
  port INTEGER,
  initDate TIMESTAMP NOT NULL,
  endDate TIMESTAMP DEFAULT NULL,
  exception VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY(id)
);
 
 ALTER TABLE query
    ADD FOREIGN KEY (idClient) REFERENCES client(id);
 ALTER TABLE client  
    ADD FOREIGN KEY (idproxy) REFERENCES proxy(id);

   