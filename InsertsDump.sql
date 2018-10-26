/*Fornecedor*/
INSERT INTO `hiber`.`fornecedor` (`forCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `forAnotacoes`, `forCNPJ`, `forEmail`, `forNomeEmpresa`, `forTelefoneContato`) VALUES ('1', 'Eldorado', 'Formiga', 'Minas Gerais', '104', 'Brasil', 'Isolina C. Souza', 'Forncene jogos de FPS', '1', 'alf@gmail.com', 'FormigaGames', '(37)99999-9999');
INSERT INTO `hiber`.`fornecedor` (`forCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `forAnotacoes`, `forCNPJ`, `forEmail`, `forNomeEmpresa`, `forTelefoneContato`) VALUES ('2', 'Centro', 'São Paulo', 'São Paulo', '235', 'Brasil', 'Av. Brasil', 'Forncene jogos de Hack and Slash', '2', 'sp@gmail.com', 'SPGames', '(37)99999-9991');
INSERT INTO `hiber`.`fornecedor` (`forCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `forAnotacoes`, `forCNPJ`, `forEmail`, `forNomeEmpresa`, `forTelefoneContato`) VALUES ('3', 'Centro', 'Belo Horizonte', 'Minas Gerais', '653', 'Brasil', 'Av. BH', 'Forncene jogos de Terror', '3', 'bh@gmail.com', 'BhGames', '(37)99999-9992');
INSERT INTO `hiber`.`fornecedor` (`forCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `forAnotacoes`, `forCNPJ`, `forEmail`, `forNomeEmpresa`, `forTelefoneContato`) VALUES ('4', 'Centro', 'Florianópolis', 'Santa Catarina', '148', 'Brasil', 'Av. Flor', 'Forncene jogos de corrida', '4', 'sc@gmail.com', 'SCGames', '(37)99999-9993');
INSERT INTO `hiber`.`fornecedor` (`forCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `forAnotacoes`, `forCNPJ`, `forEmail`, `forNomeEmpresa`, `forTelefoneContato`) VALUES ('5', 'Centro', 'Curitiba', 'Paraná', '987', 'Brasil', 'Av. Paraná', 'Forncene jogos de Moba', '5', 'pn@gmail.com', 'PNGames', '(37)99999-9994');
INSERT INTO `hiber`.`fornecedor` (`forCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `forAnotacoes`, `forCNPJ`, `forEmail`, `forNomeEmpresa`, `forTelefoneContato`) VALUES ('6', 'Centro', 'Recife', 'Pernanbuco', '23', 'Brasil', 'Av. Recife', 'Forncene jogos de Aventura', '6', 'pb@gmail.com', 'PBGames', '(37)99999-9995');
INSERT INTO `hiber`.`fornecedor` (`forCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `forAnotacoes`, `forCNPJ`, `forEmail`, `forNomeEmpresa`, `forTelefoneContato`) VALUES ('7', 'Centro', 'Vitória', 'Espírito Santo', '1342', 'Brasil', 'Av. Santa', 'Forncene jogos de Plataforma', '7', 'es@gmail.com', 'ESGames', '(37)99999-9996');
INSERT INTO `hiber`.`fornecedor` (`forCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `forAnotacoes`, `forCNPJ`, `forEmail`, `forNomeEmpresa`, `forTelefoneContato`) VALUES ('8', 'Centro', 'Rio de Janeiro', 'Rio de Janeiro', '626', 'Brasil', 'Av. Rj', 'Forncene jogos de RPG', '8', 'rj@gmail.com', 'RJGames', '(37)99999-9997');
/*Categoria*/
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('1', 'FPS');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('2', 'Hack and Slash');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('3', 'Terror');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('4', 'Corrida');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('5', 'Moba');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('6', 'Aventura');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('7', 'Plataforma');
INSERT INTO `hiber`.`categoria` (`catCodigo`, `catNome`) VALUES ('8', 'RPG');
/*Console*/
INSERT INTO `hiber`.`console` (`conCodigo`, `conMarca`, `conNome`) VALUES ('1', 'Nintendo', 'Switch');
INSERT INTO `hiber`.`console` (`conCodigo`, `conMarca`, `conNome`) VALUES ('2', 'Sony', 'Playstation 4');
INSERT INTO `hiber`.`console` (`conCodigo`, `conMarca`, `conNome`) VALUES ('3', 'Microsoft', 'Xbox One');
INSERT INTO `hiber`.`console` (`conCodigo`, `conMarca`, `conNome`) VALUES ('4', 'Pc Gamer', 'PC');
/*Jogo*/
select * from jogo;
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('1', '+(18)', '4444', 'Crysis 4', '444', '4', 'Aluguel', '1', '4', '1', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('2', '+(18)', '3333', 'Half Life 3', '333', '3', 'Aluguel', '1', '4', '1', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('3', '+(18)', '3756', 'God Of War 3', '350', '20', 'Venda', '2', '3', '2', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('4', '+(18)', '5678', 'Devil My Cry 5', '200', '30', 'Venda', '2', '3', '2', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('5', '+(18)', '3544', 'OutLast 1', '130', '10', 'Aluguel', '3', '1', '3', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('6', '+(18)', '5213', 'OutLast 2', '170', '5', 'Venda', '3', '1', '3', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('7', '+(18)', '7846', 'Blur', '210', '15', 'Aluguel', '4', '2', '4', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('8', '+(18)', '9821', 'Flat Out 2', '100', '20', 'Venda', '4', '2', '4', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('9', '+(18)', '3648', 'Dota 3', '160', '25', 'Aluguel', '5', '3', '5', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('10', '+(18)', '1023', 'Smite 2', '155', '15', 'Venda', '5', '3', '5', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('11', '+(18)', '3068', 'The last of Us 3', '190', '35', 'Aluguel', '6', '4', '6', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('12', '+(18)', '8016', 'Zelda Z', '220', '30', 'Venda', '6', '1', '6', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('13', '+(18)', '9041', 'Celeste', '205', '20', 'Aluguel', '7', '2', '7', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('14', '+(18)', '7605', 'Dead Cells 2', '175', '25', 'Venda', '7', '3', '7', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('15', '+(18)', '2903', 'Warcraft 4', '125', '20', 'Aluguel', '8', '1', '8', '1');
INSERT INTO `hiber`.`jogo` (`joCodigo`, `joFaixaEtaria`, `joLote`, `joNome`, `joPrecoPadrao`, `joQtd`, `joTipo`, `jo_catCodigo`, `jo_conCodigo`, `jo_forCodigo`, `jo_lucCodigo`) VALUES ('16', '+(18)', '4068', 'Dark souls The Remake', '135', '35', 'Venda', '8', '2', '8', '1');
/*Cliente*/
select * from cliente;
INSERT INTO `hiber`.`cliente` (`cliCodigo`, `cliCpf`, `cliEmail`, `cliIdade`, `cliNome`, `cliTelefone`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`) VALUES ('1', '140.999.333-00', 'cli1@gmail.com', '20', 'Joao das neves', '(37)98888-9999', 'Cristo', 'Formiga', 'Minas Gerais', '101', 'Brasil', 'Rua um');
INSERT INTO `hiber`.`cliente` (`cliCodigo`, `cliCpf`, `cliEmail`, `cliIdade`, `cliNome`, `cliTelefone`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`) VALUES ('2', '150.999.333-11', 'cli2@gmail.com', '30', 'Chico Cruz', '(37)98888-9991', 'Centro', 'Formiga', 'Minas Gerais', '202', 'Brasil', 'Rua dois');
INSERT INTO `hiber`.`cliente` (`cliCodigo`, `cliCpf`, `cliEmail`, `cliIdade`, `cliNome`, `cliTelefone`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`) VALUES ('3', '100.333.777.-22', 'cli3@gmail.com', '25', 'Maria do Carmo', '(37)98888-9992', 'Centenário', 'Formiga', 'Minas Gerais', '303', 'Brasil', 'Rua três');
INSERT INTO `hiber`.`cliente` (`cliCodigo`, `cliCpf`, `cliEmail`, `cliIdade`, `cliNome`, `cliTelefone`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`) VALUES ('4', '333.125.468-66', 'cli4@gmail.com', '22', 'José Fino', '(37)98888-9993', 'Centro', 'Arcos', 'Minas Gerais', '404', 'Brasil', 'Rua quatro');
INSERT INTO `hiber`.`cliente` (`cliCodigo`, `cliCpf`, `cliEmail`, `cliIdade`, `cliNome`, `cliTelefone`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`) VALUES ('5', '152.468.665-44', 'cli5@gmail.com', '23', 'Marcos Quintus', '(37)98888-9994', 'Centro', 'Córrego fundo', 'Minas Gerais', '505', 'Brasil', 'Rua cinco');
/*lista desejo*/
INSERT INTO `hiber`.`listadesejo` (`lisCodigo`, `lisNomeJogo`, `lisPlataforma`, `cliente_cliCodigo`) VALUES ('1', 'Dark sousl 4', 'PC', '1');
INSERT INTO `hiber`.`listadesejo` (`lisCodigo`, `lisNomeJogo`, `lisPlataforma`, `cliente_cliCodigo`) VALUES ('2', 'Super Mario Universe', 'Nintendo Switch', '2');
INSERT INTO `hiber`.`listadesejo` (`lisCodigo`, `lisNomeJogo`, `lisPlataforma`, `cliente_cliCodigo`) VALUES ('3', 'Shadow of the Colossus 2', 'Playstation 5', '3');
INSERT INTO `hiber`.`listadesejo` (`lisCodigo`, `lisNomeJogo`, `lisPlataforma`, `cliente_cliCodigo`) VALUES ('4', 'Halo 8', 'XboxTwo', '4');
/*Emprego*/
INSERT INTO `hiber`.`emprego` (`empCodigo`, `empDescricao`, `empNome`, `empSalarioPadrao`) VALUES ('1', 'Tem a função de administrador no sistema', 'Administrador', '5000');
INSERT INTO `hiber`.`emprego` (`empCodigo`, `empDescricao`, `empNome`, `empSalarioPadrao`) VALUES ('2', 'Tem a função de vendedor no sistema', '2000');
INSERT INTO `hiber`.`emprego` (`empCodigo`, `empDescricao`, `empNome`, `empSalarioPadrao`) VALUES ('3', 'Realiza faxinas na empresa', 'Faxineiro', '1000');
INSERT INTO `hiber`.`emprego` (`empCodigo`, `empDescricao`, `empNome`, `empSalarioPadrao`) VALUES ('4', 'Realiza entregas na empresa', 'Motoboy', '1200');
INSERT INTO `hiber`.`emprego` (`empCodigo`, `empDescricao`, `empNome`, `empSalarioPadrao`) VALUES ('5', 'Realiza o marketing da empresa', 'Market Man or Woman or other genre', '1800');
/*Funcionario*/
INSERT INTO `hiber`.`funcionario` (`funCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `funCpf`, `funEmail`, `funIdade`, `funNisPis`, `funNome`, `funSalario`, `funTelefone`, `fun_caixaCodigo`, `fun_empCodigo`) VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `hiber`.`funcionario` (`funCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `funCpf`, `funEmail`, `funIdade`, `funNisPis`, `funNome`, `funSalario`, `funTelefone`, `fun_caixaCodigo`, `fun_empCodigo`) VALUES ('2', 'Bairro da Empresa', 'Formiga', 'Minas Gerais', '1002', 'Brasil', 'Rua Empresarial', '110.999.333-22', 'fun2@gmail.com', '20', '333.55555.22-2', 'Rubens Roxo', '3500', '(37)97777-9991', '1', '2');
INSERT INTO `hiber`.`funcionario` (`funCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `funCpf`, `funEmail`, `funIdade`, `funNisPis`, `funNome`, `funSalario`, `funTelefone`, `fun_caixaCodigo`, `fun_empCodigo`) VALUES ('3', 'Bairro da Empresa', 'Formiga', 'Minas Gerais', '1003', 'Brasil', 'Rua Empresarial', '110.999.333-33', 'fun3@gmail.com', '40', '333.55555.22-3', 'Mario Luis', '2000', '(37)97777-9992', '1', '3');
INSERT INTO `hiber`.`funcionario` (`funCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `funCpf`, `funEmail`, `funIdade`, `funNisPis`, `funNome`, `funSalario`, `funTelefone`, `fun_caixaCodigo`, `fun_empCodigo`) VALUES ('4', 'Bairro da Empresa', 'Formiga', 'Minas Gerais', '1004', 'Brasil', 'Rua Empresarial', '110.999.333-44', 'fun4@gmail.com', '18', '333.55555.22-4', 'Akira', '1000', '(37)97777-9993', '1', '4');
INSERT INTO `hiber`.`funcionario` (`funCodigo`, `endBairro`, `endCidade`, `endEstado`, `endNumero`, `endPais`, `endRua`, `funCpf`, `funEmail`, `funIdade`, `funNisPis`, `funNome`, `funSalario`, `funTelefone`, `fun_caixaCodigo`, `fun_empCodigo`) VALUES ('5', 'Bairro da Empresa', 'Formiga', 'Minas Gerais', '1005', 'Brasil', 'Rua Empresarial', '110.999.333-55', 'fun5@gmail.com', '35', '333.55555.22-5', 'Steve Joab', '2300', '(37)97777-9994', '1', '5');
UPDATE `hiber`.`funcionario` SET `endBairro` = 'Bairro da Empresa', `endCidade` = 'Formiga', `endEstado` = 'Minas Gerais', `endNumero` = '1001', `endPais` = 'Brasil', `endRua` = 'Rua Empresarial', `funCpf` = '110.999.333-00', `funEmail` = 'fun1@gmail.com', `funIdade` = '30', `funNisPis` = '333.55555.22-1', `funNome` = 'Armelindo Rico', `funSalario` = '9999', `funTelefone` = '(37)97777-9999' WHERE (`funCodigo` = '1');


/*Vendedor*/
INSERT INTO `hiber`.`vendedor` (`vendedorCodigo`, `vendedorNomeUsuario`, `vendedorSenha`, `vendedor_funCodigo`) VALUES ('1', '1', '1', '1');
/*Venda*/
INSERT INTO `hiber`.`venda` (`vendaCodigo`, `vendaData`, `vendaEntrada`, `vendaNparcelas`, `vendaValorTotal`, `venda_caixaCodigo`, `venda_clienteCodigo`, `venda_vendedorCodigo`) VALUES ('1', '1000-10-10', '20', '3', '100', '1', '1', '1');
/*itemVenda*/
INSERT INTO `hiber`.`jogo_venda` (`jvPreco`, `jvQdt`, `joCod`, `venCod`) VALUES ('10', '5', '1', '1');
/*vendaAParazo*/
INSERT INTO `hiber`.`vendaaprazo` (`vapCodigo`, `vapData`, `vapNumParcela`, `vapSituacao`, `vapValorParcela`, `vap_vendaCodigo`) VALUES ('1', '1000-10-10', '1', 'Paga', '50', '1');
INSERT INTO `hiber`.`vendaaprazo` (`vapCodigo`, `vapData`, `vapNumParcela`, `vapSituacao`, `vapValorParcela`, `vap_vendaCodigo`) VALUES ('2', '1000-10-10', '2', 'Pendente', '50', '1');
INSERT INTO `hiber`.`vendaaprazo` (`vapCodigo`, `vapData`, `vapNumParcela`, `vapSituacao`, `vapValorParcela`, `vap_vendaCodigo`) VALUES ('3', '1000-10-10', '3', 'Pendente', '50', '1');

