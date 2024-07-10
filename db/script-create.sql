CREATE TABLE `tbRegistroCnab` (
  id int PRIMARY KEY  AUTO_INCREMENT,
  codigoBanco char(3) NOT NULL,
  numInscricaoFavorecido char(14) NOT NULL,
  valorDocumento decimal(11,2) NOT NULL
);