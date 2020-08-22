-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 21-08-2020 a las 16:33:23
-- Versión del servidor: 10.3.23-MariaDB-0+deb10u1
-- Versión de PHP: 7.0.33-0+deb9u3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbtiendaonline`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarpaquete` (IN `paramIn1` VARCHAR(30), IN `paramIn2` FLOAT(8,2), IN `paramIn3` VARCHAR(10), IN `paramIn4` VARCHAR(30), IN `paramIn5` VARCHAR(20), OUT `paramOut` VARCHAR(20))  BEGIN 

   insert into paquetes(nombre,precio,tipo,cantidad_bolson,vigencia)values(paramIn1,paramIn2,paramIn3,paramIn4,paramIn5);
   
   set paramOut='Registro exitoso';

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `direcion` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `dpi` varchar(25) DEFAULT NULL,
  `no_telefono` varchar(10) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_clientes`
--

CREATE TABLE `compra_clientes` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `no_compra` int(11) DEFAULT NULL,
  `paquete_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes`
--

CREATE TABLE `paquetes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `precio` float(8,2) DEFAULT NULL,
  `tipo` varchar(10) DEFAULT NULL,
  `cantidad_bolson` varchar(30) DEFAULT NULL,
  `vigencia` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paquetes`
--

INSERT INTO `paquetes` (`id`, `nombre`, `precio`, `tipo`, `cantidad_bolson`, `vigencia`) VALUES
(1, 'internet 4G LTE', 15.00, 'DATOS', '3GB', '3 Dias'),
(5, 'llamada ilimitadas', 100.00, 'VOZ', 'llamadas ilimitadas', 'Ilimitada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `fecha_venta` date DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `paquete_id` int(11) DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `compra_clientes`
--
ALTER TABLE `compra_clientes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `compra_cliente_id_fk` (`cliente_id`),
  ADD KEY `compra_paquete_id_fk` (`paquete_id`);

--
-- Indices de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ventas_cliente_id_fk` (`cliente_id`),
  ADD KEY `ventas_paquete_id_fk` (`paquete_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `compra_clientes`
--
ALTER TABLE `compra_clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra_clientes`
--
ALTER TABLE `compra_clientes`
  ADD CONSTRAINT `compra_cliente_id_fk` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`),
  ADD CONSTRAINT `compra_paquete_id_fk` FOREIGN KEY (`paquete_id`) REFERENCES `paquetes` (`id`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_cliente_id_fk` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`),
  ADD CONSTRAINT `ventas_paquete_id_fk` FOREIGN KEY (`paquete_id`) REFERENCES `paquetes` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
