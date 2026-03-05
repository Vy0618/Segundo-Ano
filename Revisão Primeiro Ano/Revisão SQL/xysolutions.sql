-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 29/01/2026 às 14:01
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `xysolutions`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `candidatos`
--

CREATE TABLE `candidatos` (
  `id_candidatos` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `nivel_Escolaridade` text DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `contratacao`
--

CREATE TABLE `contratacao` (
  `id_contrataco` int(11) NOT NULL,
  `data_contratacao` date DEFAULT NULL,
  `id_candidatos` int(11) DEFAULT NULL,
  `id_vaga` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `empresas_clientes`
--

CREATE TABLE `empresas_clientes` (
  `id_empresa` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `CNPJ` varchar(14) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `entrevista`
--

CREATE TABLE `entrevista` (
  `id_entrevista` int(11) NOT NULL,
  `diadata` datetime DEFAULT NULL,
  `resultado` text DEFAULT NULL,
  `id_processo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario_hr`
--

CREATE TABLE `funcionario_hr` (
  `id_funcionariohr` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `cargo` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `processo_seletivo`
--

CREATE TABLE `processo_seletivo` (
  `id_processo` int(11) NOT NULL,
  `situacao` varchar(20) DEFAULT NULL,
  `id_candidatos` int(11) DEFAULT NULL,
  `id_vaga` int(11) DEFAULT NULL,
  `id_funcionariohr` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `vaga`
--

CREATE TABLE `vaga` (
  `id_vaga` int(11) NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `descricao` text DEFAULT NULL,
  `salario` double(11) DEFAULT NULL,
  `id_empresa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `candidatos`
--
ALTER TABLE `candidatos`
  ADD PRIMARY KEY (`id_candidatos`);

--
-- Índices de tabela `contratacao`
--
ALTER TABLE `contratacao`
  ADD PRIMARY KEY (`id_contrataco`),
  ADD KEY `id_candidatos` (`id_candidatos`),
  ADD KEY `id_vaga` (`id_vaga`);

--
-- Índices de tabela `empresas_clientes`
--
ALTER TABLE `empresas_clientes`
  ADD PRIMARY KEY (`id_empresa`);

--
-- Índices de tabela `entrevista`
--
ALTER TABLE `entrevista`
  ADD PRIMARY KEY (`id_entrevista`),
  ADD KEY `id_processo` (`id_processo`);

--
-- Índices de tabela `funcionario_hr`
--
ALTER TABLE `funcionario_hr`
  ADD PRIMARY KEY (`id_funcionariohr`);

--
-- Índices de tabela `processo_seletivo`
--
ALTER TABLE `processo_seletivo`
  ADD PRIMARY KEY (`id_processo`),
  ADD KEY `id_funcionariohr` (`id_funcionariohr`),
  ADD KEY `id_vaga` (`id_vaga`),
  ADD KEY `id_candidatos` (`id_candidatos`);

--
-- Índices de tabela `vaga`
--
ALTER TABLE `vaga`
  ADD PRIMARY KEY (`id_vaga`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `candidatos`
--
ALTER TABLE `candidatos`
  MODIFY `id_candidatos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `contratacao`
--
ALTER TABLE `contratacao`
  MODIFY `id_contrataco` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `empresas_clientes`
--
ALTER TABLE `empresas_clientes`
  MODIFY `id_empresa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `entrevista`
--
ALTER TABLE `entrevista`
  MODIFY `id_entrevista` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `funcionario_hr`
--
ALTER TABLE `funcionario_hr`
  MODIFY `id_funcionariohr` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `processo_seletivo`
--
ALTER TABLE `processo_seletivo`
  MODIFY `id_processo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `vaga`
--
ALTER TABLE `vaga`
  MODIFY `id_vaga` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `contratacao`
--
ALTER TABLE `contratacao`
  ADD CONSTRAINT `contratacao_ibfk_1` FOREIGN KEY (`id_candidatos`) REFERENCES `candidatos` (`id_candidatos`),
  ADD CONSTRAINT `contratacao_ibfk_2` FOREIGN KEY (`id_vaga`) REFERENCES `vaga` (`id_vaga`);

--
-- Restrições para tabelas `entrevista`
--
ALTER TABLE `entrevista`
  ADD CONSTRAINT `entrevista_ibfk_1` FOREIGN KEY (`id_processo`) REFERENCES `processo_seletivo` (`id_processo`);

--
-- Restrições para tabelas `processo_seletivo`
--
ALTER TABLE `processo_seletivo`
  ADD CONSTRAINT `processo_seletivo_ibfk_1` FOREIGN KEY (`id_funcionariohr`) REFERENCES `funcionario_hr` (`id_funcionariohr`),
  ADD CONSTRAINT `processo_seletivo_ibfk_2` FOREIGN KEY (`id_vaga`) REFERENCES `vaga` (`id_vaga`),
  ADD CONSTRAINT `processo_seletivo_ibfk_3` FOREIGN KEY (`id_candidatos`) REFERENCES `candidatos` (`id_candidatos`);

--
-- Restrições para tabelas `vaga`
--
ALTER TABLE `vaga`
  ADD CONSTRAINT `vaga_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresas_clientes` (`id_empresa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
