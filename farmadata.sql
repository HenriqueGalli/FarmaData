-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07-Maio-2022 às 21:08
-- Versão do servidor: 10.4.21-MariaDB
-- versão do PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `farmadata`
--

DELIMITER $$
--
-- Procedimentos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAlteraQuantidadeEstoque` (INOUT `Quantidade` INT, INOUT `Id` INT)  BEGIN
 update estoque set 
 Quantidade = Quantidade
 where Id   = Id  ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spEditaMedicamento` (IN `uId` INT, INOUT `NomeComercial` VARCHAR(255), INOUT `Fabricante` VARCHAR(255), INOUT `NomeGenerico` VARCHAR(255), INOUT `BulaRemedio` VARCHAR(255), INOUT `Valor` DOUBLE)  BEGIN
update medicamento set 
NomeComercial = NomeComercial,
Fabricante = Fabricante,
NomeGenerico = NomeGenerico ,
BulaRemedio = BulaRemedio ,
Valor = Valor 
WHERE Id = uId;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spIncluiMedicamento` (INOUT `NomeComercial` VARCHAR(255) CHARSET utf8, INOUT `Fabricante` VARCHAR(255) CHARSET utf8, INOUT `NomeGenerico` VARCHAR(255) CHARSET utf8, INOUT `BulaRemedio` VARCHAR(255) CHARSET utf8, INOUT `Valor` DOUBLE ZEROFILL)  BEGIN
insert into Medicamento
 (NomeComercial, Fabricante, NomeGenerico, BulaRemedio, Valor)
 values
 (NomeComercial, Fabricante, NomeGenerico, BulaRemedio, Valor);
 END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spListaEstoque` ()  SELECT * from estoque 
    INNER JOIN medicamento on estoque.IdMedicamento = medicamento.Id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spListaMedicamentos` ()  BEGIN
 select * from medicamento;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `Id` int(11) NOT NULL,
  `IdMedicamento` int(11) NOT NULL,
  `Quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`Id`, `IdMedicamento`, `Quantidade`) VALUES
(7, 7, 0),
(8, 8, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `farmacia`
--

CREATE TABLE `farmacia` (
  `Id` int(11) NOT NULL,
  `Login` varchar(20) NOT NULL,
  `Senha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `medicamento`
--

CREATE TABLE `medicamento` (
  `Id` int(11) NOT NULL,
  `NomeComercial` varchar(255) NOT NULL,
  `Fabricante` varchar(255) NOT NULL,
  `NomeGenerico` varchar(255) NOT NULL,
  `BulaRemedio` varchar(255) DEFAULT NULL,
  `Valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `medicamento`
--

INSERT INTO `medicamento` (`Id`, `NomeComercial`, `Fabricante`, `NomeGenerico`, `BulaRemedio`, `Valor`) VALUES
(7, 'SeraQueMuda', 'Teste3', 'Teste3', 'Teste3', 23),
(8, 'Teste4', 'Teste5', 'Teste3', 'Teste3', 23);

--
-- Acionadores `medicamento`
--
DELIMITER $$
CREATE TRIGGER `trg_Estoque` AFTER INSERT ON `medicamento` FOR EACH ROW INSERT INTO `estoque`(`IdMedicamento`, `Quantidade`) VALUES ((SELECT MAX(ID) FROM medicamento), 0)
$$
DELIMITER ;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Estoque_Remedio` (`IdMedicamento`);

--
-- Índices para tabela `farmacia`
--
ALTER TABLE `farmacia`
  ADD PRIMARY KEY (`Id`);

--
-- Índices para tabela `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `farmacia`
--
ALTER TABLE `farmacia`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `medicamento`
--
ALTER TABLE `medicamento`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `estoque`
--
ALTER TABLE `estoque`
  ADD CONSTRAINT `FK_Estoque_Remedio` FOREIGN KEY (`IdMedicamento`) REFERENCES `medicamento` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
