CREATE SCHEMA `negozio_sportivo_online` ;

CREATE TABLE `negozio_sportivo_online`.`utente` (
  `nome` VARCHAR(45) NOT NULL,
  `cognome` VARCHAR(45) NOT NULL,
  `indirizzo` VARCHAR(45) NOT NULL,
  `cap` INT(5) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`));

CREATE TABLE `negozio_sportivo_online`.`ordine` (
  `idordine` INT NOT NULL AUTO_INCREMENT,
  `totale` FLOAT NOT NULL,
  `data` DATE NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idordine`),
  INDEX `ordine_username_idx` (`username` ASC) VISIBLE,
  CONSTRAINT `ordine_username`
    FOREIGN KEY (`username`)
    REFERENCES `negozio_sportivo_online`.`utente` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `negozio_sportivo_online`.`articolo` (
  `id_articolo` INT NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modello` VARCHAR(45) NOT NULL,
  `prezzo` DOUBLE NOT NULL,
  PRIMARY KEY (`id_articolo`));
  
CREATE TABLE `negozio_sportivo_online`.`ordinearticolo` (
  `id_oa` INT NOT NULL,
  `id_ordine` INT NOT NULL,
  `id_articolo` INT NOT NULL,
  `qta` INT NOT NULL,
  PRIMARY KEY (`id_oa`),
  INDEX `id_oa_articolo_idx` (`id_articolo` ASC) VISIBLE,
  INDEX `id_oa_ordine_idx` (`id_ordine` ASC) VISIBLE,
  CONSTRAINT `id_oa_articolo`
    FOREIGN KEY (`id_articolo`)
    REFERENCES `negozio_sportivo_online`.`articolo` (`id_articolo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_oa_ordine`
    FOREIGN KEY (`id_ordine`)
    REFERENCES `negozio_sportivo_online`.`ordine` (`idordine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    
CREATE TABLE `negozio_sportivo_online`.`amministratore` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`));
  
CREATE TABLE `negozio_sportivo_online`.`carrello` (
  `id_car` VARCHAR(45) NOT NULL,
 `username` VARCHAR(45) NOT NULL,
  `id_articolo` INT NOT NULL,
  `qta` INT NOT NULL,
  PRIMARY KEY (`id_car`),
  INDEX `carrello_art_idx` (`id_articolo` ASC) VISIBLE,
  CONSTRAINT `carrello_user`
    FOREIGN KEY (`username`)
    REFERENCES `negozio_sportivo_online`.`utente` (`username`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `carrello_art`
    FOREIGN KEY (`id_articolo`)
    REFERENCES `negozio_sportivo_online`.`articolo` (`id_articolo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
