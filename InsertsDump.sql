/*Fornecedor*/
INSERT INTO `hiber`.`fornecedor` (`forCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `forAnotacoes`, `forCNPJ`, `forEmail`, `forNomeEmpresa`, `forTelefoneContato`) VALUES ('1', 'Eldorado', 'Formiga', 'Minas Gerais', '104', 'Brasil', 'Isolina C. Souza', 'Forncene jogos de ação', '1', 'alf@gmail.com', 'ForGames', '3799999999');
INSERT INTO `hiber`.`fornecedor` (`forCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `forAnotacoes`, `forCNPJ`, `forEmail`, `forNomeEmpresa`, `forTelefoneContato`) VALUES ('2', 'Sr. de Lourdes', 'São Paulo', 'São Paulo', '235', 'Brasil', 'Av. Brasil', 'Forncene jogos de FPS', '2', 'st@gmail.com', 'SãoGames', '3799999998');
INSERT INTO `hiber`.`fornecedor` (`forCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `forAnotacoes`, `forCNPJ`, `forEmail`, `forNomeEmpresa`, `forTelefoneContato`) VALUES ('3', 'Cristo', 'Belo Horizonte', 'Minas Gerais', '653', 'Brasil', 'Cruzada', 'Forncene jogos de RPG', '3', 'bh@gmail.com', 'BhGames', '3799999997');
/*Jogo*/
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('1', '+(18)', '123', 'Crysis 4', '444', '4', 'Aluguel', '1', '1', '1', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('2', '+(18)', '321', 'God of War 3', '250', '10', 'Venda', '2', '2', '2', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('3', '+(18)', '213', 'Dark souls', '150', '20', 'Venda', '3', '3', '3', '1');
/*Categoria*/
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('1', 'FPS');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('2', 'Hack and Slash');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('3', 'Terror');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('4', 'Corrida');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('5', 'Moba');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('6', 'Aventura');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('7', 'Plataforma');
/*Console*/
INSERT INTO `hiber`.`console` (`conCodigo`, `conMarca`, `conNome`) VALUES ('1', 'Nintendo', 'Switch');
INSERT INTO `hiber`.`console` (`conCodigo`, `conMarca`, `conNome`) VALUES ('2', 'Sony', 'Playstation 4');
INSERT INTO `hiber`.`console` (`conCodigo`, `conMarca`, `conNome`) VALUES ('3', 'Microsoft', 'Xbox One');
INSERT INTO `hiber`.`console` (`conCodigo`, `conMarca`, `conNome`) VALUES ('4', 'Pc Gamer', 'PC');
/*lista desejo*/
INSERT INTO `hiber`.`listadesejo` (`lisCodigo`, `lisNomeJogo`, `lisPlataforma`, `cliente_cliCodigo`) VALUES ('1', 'ds 2', 'PC', '1');
/*Cliente*/
INSERT INTO `hiber`.`cliente` (`cliCodigo`, `cliCpf`, `cliEmail`, `cliIdade`, `cliNome`, `cliTelefone`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`) VALUES ('1', '2', '2', '2', 'b', 's', 's', 's', 's', '2', 's', '2');


/*Funcionario*/
INSERT INTO `hiber`.`funcionario` (`funCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `funCpf`, `funEmail`, `funIdade`, `funNisPis`, `funNome`, `funSalario`, `funTelefone`, `fun_caixaCodigo`, `fun_empCodigo`) VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
/*Vendedor*/
INSERT INTO `hiber`.`vendedor` (`vendedorCodigo`, `vendedorNomeUsuario`, `vendedorSenha`, `vendedor_funCodigo`) VALUES ('1', '1', '1', '1');
/*cliente*/
INSERT INTO `hiber`.`cliente` (`cliCodigo`, `cliCpf`, `cliEmail`, `cliIdade`, `cliNome`, `cliTelefone`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`) VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
/*Venmda*/
INSERT INTO `hiber`.`venda` (`vendaCodigo`, `vendaData`, `vendaEntrada`, `vendaNparcelas`, `vendaValorTotal`, `venda_caixaCodigo`, `venda_clienteCodigo`, `venda_vendedorCodigo`) VALUES ('1', '1000-10-10', '20', '3', '100', '1', '1', '1');
/*itemVenda*/
INSERT INTO `hiber`.`jogo_venda` (`jvPreco`, `jvQdt`, `joCod`, `venCod`) VALUES ('10', '5', '1', '1');
/*vendaAParazo*/
INSERT INTO `hiber`.`vendaaprazo` (`vapCodigo`, `vapData`, `vapNumParcela`, `vapSituacao`, `vapValorParcela`, `vap_vendaCodigo`) VALUES ('1', '1000-10-10', '1', 'Paga', '50', '1');
INSERT INTO `hiber`.`vendaaprazo` (`vapCodigo`, `vapData`, `vapNumParcela`, `vapSituacao`, `vapValorParcela`, `vap_vendaCodigo`) VALUES ('2', '1000-10-10', '2', 'Pendente', '50', '1');
INSERT INTO `hiber`.`vendaaprazo` (`vapCodigo`, `vapData`, `vapNumParcela`, `vapSituacao`, `vapValorParcela`, `vap_vendaCodigo`) VALUES ('3', '1000-10-10', '3', 'Pendente', '50', '1');

