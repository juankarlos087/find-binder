-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 21-10-2022 a las 04:04:21
-- Versión del servidor: 5.7.11
-- Versión de PHP: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `seguimiento`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacion`
--

CREATE TABLE `asignacion` (
  `codigo_asi` int(11) NOT NULL,
  `fecha_asi` date NOT NULL,
  `codigo_car` int(11) NOT NULL,
  `codigo_res` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `asignacion`
--

INSERT INTO `asignacion` (`codigo_asi`, `fecha_asi`, `codigo_car`, `codigo_res`) VALUES
(1, '2022-09-21', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carpeta`
--

CREATE TABLE `carpeta` (
  `codigo_car` int(11) NOT NULL,
  `nombre_emp` varchar(45) NOT NULL,
  `identificacion_emp` varchar(25) NOT NULL,
  `codigo_tip` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `carpeta`
--

INSERT INTO `carpeta` (`codigo_car`, `nombre_emp`, `identificacion_emp`, `codigo_tip`) VALUES
(1, 'juan', '1010013908', 1),
(2, 'andres', '27878345', 1),
(3, 'antonio', '10908734567', 1),
(4, 'leonardo', '88654334', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `codigo_dep` int(11) NOT NULL,
  `nombre_dep` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`codigo_dep`, `nombre_dep`) VALUES
(1, 'compras');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responsable`
--

CREATE TABLE `responsable` (
  `codigo_res` int(11) NOT NULL,
  `nombre_res` varchar(45) DEFAULT NULL,
  `dependencia_res` varchar(45) NOT NULL,
  `codigo_dep` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `responsable`
--

INSERT INTO `responsable` (`codigo_res`, `nombre_res`, `dependencia_res`, `codigo_dep`) VALUES
(1, 'juan', 'sistemas', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `codigo_tip` int(11) NOT NULL,
  `estado_tip` varchar(10) NOT NULL,
  `observacion_tip` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`codigo_tip`, `estado_tip`, `observacion_tip`) VALUES
(1, 'ACTIVA', ''),
(2, 'INACTIVA', ''),
(3, 'MUERTO', ''),
(4, 'RECHAZADA', 'Falta documentacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(2) NOT NULL,
  `nombre_usuario` varchar(30) NOT NULL,
  `clave_usuario` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD PRIMARY KEY (`codigo_asi`),
  ADD KEY `fk_asignacion_carpeta1_idx` (`codigo_car`),
  ADD KEY `fk_asignacion_responsable1_idx` (`codigo_res`);

--
-- Indices de la tabla `carpeta`
--
ALTER TABLE `carpeta`
  ADD PRIMARY KEY (`codigo_car`),
  ADD KEY `fk_carpeta_tipo_idx` (`codigo_tip`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`codigo_dep`);

--
-- Indices de la tabla `responsable`
--
ALTER TABLE `responsable`
  ADD PRIMARY KEY (`codigo_res`),
  ADD KEY `fk_responsable_departamento1_idx` (`codigo_dep`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`codigo_tip`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignacion`
--
ALTER TABLE `asignacion`
  MODIFY `codigo_asi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `carpeta`
--
ALTER TABLE `carpeta`
  MODIFY `codigo_car` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `codigo_dep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `responsable`
--
ALTER TABLE `responsable`
  MODIFY `codigo_res` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `codigo_tip` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(2) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD CONSTRAINT `fk_asignacion_carpeta1` FOREIGN KEY (`codigo_car`) REFERENCES `carpeta` (`codigo_car`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_asignacion_responsable1` FOREIGN KEY (`codigo_res`) REFERENCES `responsable` (`codigo_res`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `carpeta`
--
ALTER TABLE `carpeta`
  ADD CONSTRAINT `fk_carpeta_tipo` FOREIGN KEY (`codigo_tip`) REFERENCES `tipo` (`codigo_tip`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `responsable`
--
ALTER TABLE `responsable`
  ADD CONSTRAINT `fk_responsable_departamento1` FOREIGN KEY (`codigo_dep`) REFERENCES `departamento` (`codigo_dep`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
