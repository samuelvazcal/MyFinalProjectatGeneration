/*Creación de la base de datos*/
CREATE DATABASE IF NOT EXISTS finalproject;

USE finalproject;

/*Creación de las tablas.*/
CREATE TABLE productos (
id_Producto VARCHAR(7) NOT NULL UNIQUE,
nombre VARCHAR(100) NOT NULL,
mts_Caja DOUBLE NOT NULL,
pzs_Caja INT NOT NULL,
peso_Caja DOUBLE NOT NULL,
cajas_Pallet INT NOT NULL,
precio_metro DOUBLE NOT NULL,
CONSTRAINT prod01 PRIMARY KEY (id_Producto)
);

CREATE TABLE clientes(
id_cliente INT AUTO_INCREMENT NOT NULL UNIQUE,
nombre VARCHAR(50) NOT NULL,
domicilio VARCHAR(150) NOT NULL,
telefono VARCHAR(20) NOT NULL,
constraint client01 PRIMARY KEY (id_cliente)
);

CREATE TABLE cotizacion(
id_cotizacion INT AUTO_INCREMENT NOT NULL UNIQUE,
id_clienteC INT NOT NULL,
fecha DATE NOT NULL,
tonelaje INT NOT NULL,
CONSTRAINT cot01 PRIMARY KEY (id_cotizacion),
CONSTRAINT cot02 FOREIGN KEY (id_clienteC) REFERENCES clientes (id_cliente)
);

CREATE TABLE cotizacion_productos(
id_detalle INT AUTO_INCREMENT NOT NULL UNIQUE,
id_cotizacionC INT NOT NULL,
id_productoC VARCHAR(7) NOT NULL,
cajas INT NOT NULL,
CONSTRAINT cot03 PRIMARY KEY (id_detalle),
CONSTRAINT cot04 FOREIGN KEY (id_cotizacionC) REFERENCES cotizacion (id_cotizacion),
CONSTRAINT cot05 FOREIGN KEY (id_productoC) REFERENCES productos (id_producto)
);

/*Inserción de los valores iniciales en las tablas*/

/*Tabla de PRODUCTOS*/
INSERT INTO productos VALUES ('PP004', 'Nube, pulido microsellado 60 X 60', 1.44, 4, 27.905, 42, 126.08);
INSERT INTO productos VALUES ('PP004S', 'Nube SLIM, piso porcelanico 60 X 60', 1.44, 4, 22.16, 52, 179.44);
INSERT INTO productos VALUES ('PP005', 'Nero, pulido microsellado 60 X 60', 1.44, 4, 26.565, 40, 168.76);
INSERT INTO productos VALUES ('PP006', 'Carbonate, esmaltado mate 60 X 60', 1.44, 4, 29.555, 40, 346.52);
INSERT INTO productos VALUES ('PP007S', 'Cerene, pulido microsellado slim 60 X 60', 1.44, 4, 22.505, 52, 189.84);
INSERT INTO productos VALUES ('PP019', 'Avorio, esmaltado pulido 60 X 60', 1.44, 4, 25.19625, 42, 197.47);
INSERT INTO productos VALUES ('PP022', 'Trento, pulido microsellado 60 X 60', 1.44, 4, 26.125, 42, 280.11);
INSERT INTO productos VALUES ('PP022S', 'Trento SLIM, pulido microsellado 60 X 60', 1.44, 4, 22.87, 50, 163.11);
INSERT INTO productos VALUES ('PP025', 'Doratta, pulido microsellado 60 X 60', 1.44, 4, 27.09, 42, 189.06);
INSERT INTO productos VALUES ('PP025S', 'Doratta, pulido microsellado slim 60 X 60', 1.44, 4, 22.305, 48, 166.28);
INSERT INTO productos VALUES ('PP030', 'Finestre, pulido microsellado 60 X 60', 1.44, 4, 29.525, 40, 149.93);
INSERT INTO productos VALUES ('PP036', 'Ravello Gris 60X60', 1.44, 4, 29.48, 40, 220.09);
INSERT INTO productos VALUES ('PP039', 'Ravello beige 60X60', 1.44, 4, 32.33, 60, 133.9);
INSERT INTO productos VALUES ('PP057', 'Benedetto, pulido microsellado 60 X 60', 1.44, 4, 27.59, 42, 282.83);
INSERT INTO productos VALUES ('PP057S', 'Benedetto, pulido microsellado slim 60 X 60', 1.44, 4, 22.505, 50, 161.18);
INSERT INTO productos VALUES ('PP066', 'Macerata, esmaltado mate 60 X 60', 1.44, 4, 28.94, 40, 263.89);
INSERT INTO productos VALUES ('PP068', 'Bianco, esmaltado pulido 60 X 60', 1.44, 4, 29.005, 40, 183.02);
INSERT INTO productos VALUES ('PP071', 'Slate Ossidatta  60 X 60', 1.08, 3, 32.5, 22, 201.39);
INSERT INTO productos VALUES ('PP072', 'Slate Enego 60 X 60', 1.08, 3, 34.765, 22, 229.58);
INSERT INTO productos VALUES ('PP080', 'Finestre, pulido microsellado 80 X 80', 1.92, 3, 39.675, 32, 220.29);
INSERT INTO productos VALUES ('PP084', 'Sorano, pulido microsellado 60 X 60', 1.44, 4, 29.385, 40, 233.79);
INSERT INTO productos VALUES ('PP085', 'Trento, pulido microsellado 80 X 80', 1.92, 3, 39.97, 32, 224.09);
INSERT INTO productos VALUES ('PP086', 'Biella, pulido microsellado 80 X 80', 1.92, 3, 39.17, 32, 231.79);
INSERT INTO productos VALUES ('PP089', 'Arazzo café, esmaltado mate 60 X 60', 1.44, 4, 29.495, 40, 131.39);
INSERT INTO productos VALUES ('PP097', 'Biella, pulido microsellado 60 X 60', 1.44, 4, 28.44, 40, 187.09);
INSERT INTO productos VALUES ('PP098', 'Arazzo blanco, esmaltado mate 60 X 60', 1.44, 4, 29.615, 40, 229.85);
INSERT INTO productos VALUES ('PP102', 'Arazzo negro, esmaltado mate 60 X 60', 1.44, 4, 29.515, 40, 155.64);
INSERT INTO productos VALUES ('PP127', 'Colombo, esmaltado mate 60 X 60', 1.44, 4, 29.385, 40, 138.77);
INSERT INTO productos VALUES ('PP129', 'Barrea, esmaltado mate 60 X 60', 1.44, 4, 29.58, 40, 200.33);
INSERT INTO productos VALUES ('PP130', 'Padua, pulido microsellado 60 X 60', 1.44, 4, 29.57, 42, 184.39);
INSERT INTO productos VALUES ('PP132', 'Grego, esmaltado pulido 60 X 60', 1.44, 4, 29.86, 40, 120.67);
INSERT INTO productos VALUES ('PP138', 'Murano, piso porcelánico 120 X 60', 1.44, 2, 35.715, 60, 165.76);
INSERT INTO productos VALUES ('PP139', 'Murano Mate 120 X 60', 1.44, 2, 35.57, 60, 278.17);
INSERT INTO productos VALUES ('PP140', 'Finestre, pulido microsellado 1 X 1 ', 2, 2, 54.835, 29, 156.9);
INSERT INTO productos VALUES ('PP141', 'Carrara, piso porcelánico 60X60', 1.44, 4, 31.475, 40, 197.88);
INSERT INTO productos VALUES ('PP142', 'Colossale mate  120X60', 1.44, 2, 30.315, 60, 169.86);
INSERT INTO productos VALUES ('PP143', 'Collosale Brillante 120X60', 1.44, 2, 30.155, 60, 226.9);
INSERT INTO productos VALUES ('PP144', 'Novara Brillante 60X60', 1.44, 4, 27.995, 40, 170.98);
INSERT INTO productos VALUES ('PP145', 'Novara mate 60x60', 1.44, 4, 27.91, 40, 265.64);
INSERT INTO productos VALUES ('PP146', 'Carraragrigio 60X60', 1.44, 4, 30.705, 40, 158.78);
INSERT INTO productos VALUES ('PP150', 'Biella, pulido microsellado 1 X 1 ', 2, 2, 54.73, 29, 209.12);
INSERT INTO productos VALUES ('PW008', 'Montalto GRIS OXFORD, esmaltado 90 X 15', 1.08, 8, 26.83, 40, 277.94);
INSERT INTO productos VALUES ('PW019', 'Alberi Miel, porcelánico 120 X 20', 1.68, 6, 32.75, 42, 195.47);
INSERT INTO productos VALUES ('PW020', 'Alberi Canela, porcelánico 120 X 20', 1.68, 6, 32.525, 42, 164.75);
INSERT INTO productos VALUES ('PW021', 'Alberi Cacao, porcelánico 120 X 20', 1.68, 6, 32.555, 42, 108.8);
INSERT INTO productos VALUES ('PW023', 'Natura grafito 120 X 20', 1.68, 5, 27.575, 36, 194.5);
INSERT INTO productos VALUES ('PW025', 'Natura cuarzo 120 X 20', 1.68, 5, 27.02, 36, 169.49);
INSERT INTO productos VALUES ('CM01', 'Cementi Gazzo, esmaltado 60 X 60', 1.44, 4, 30.18, 40, 246.03);
INSERT INTO productos VALUES ('CM02', 'Cementi Capri, esmaltado 60 X 60', 1.44, 4, 29.99, 40, 222.38);
INSERT INTO productos VALUES ('CM03', 'Cementi Gazzo, esmaltado 80 X 80', 1.92, 3, 48.18, 32, 116.92);
INSERT INTO productos VALUES ('CM04', 'Cementi Capri, esmaltado 80 X 80', 1.92, 3, 48.215, 32, 185.81);
INSERT INTO productos VALUES ('CM05', 'Cementi Alessandria BLANCO, esmaltado 120 X 60', 1.44, 2, 35.28, 32, 206.1);
INSERT INTO productos VALUES ('CM06', 'Cementi Alessandria GRIS, esmaltado 120 X 60', 1.44, 2, 35.265, 32, 204.05);
INSERT INTO productos VALUES ('CM07', 'Decotaro Vechio 120 X 60', 1.44, 2, 32.71, 60, 261.63);
INSERT INTO productos VALUES ('CM08', 'Cementi Vechio 120 X 60', 1.44, 2, 33.75, 60, 155.4);
INSERT INTO productos VALUES ('CM09', 'Molise chiaro 60X60', 1.44, 4, 29.82, 40, 197.92);
INSERT INTO productos VALUES ('CM10', 'Molise Oxford 60X60', 1.44, 4, 29.21, 40, 122.47);

/*Tabla de CLIENTES*/
INSERT INTO clientes VALUES (0, 'CISCO Systems', 'San Frnacisco, California', 7326994916);
INSERT INTO clientes VALUES (0, 'McKinsey & Company', 'Nueva York, EUA', 8174327126);
INSERT INTO clientes VALUES (0, 'Alphabet Inc.', 'Mountain View, California', 6241734358);





