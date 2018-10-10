select * from emprego; 
select * from fornecedor;
select * from funcionario;
select * from jogo;
select * from categoria;
select * from console;
select * from notadecompra;
select * from compraPrazo;
select * from vendedor;
select * from lucro;
select * from caixa;
select * from cliente;
select * from venda;
select * from vendaaprazo;
select * from jogo_venda;
select * from jogo_locacao;
select * from locacao;
select * from devolucao;
select * from conta;
select * from contaaprazo;
select * from listadesejo;

/* Jogos menos vendidos*/
SELECT 
    joCodigo, joNome, SUM(jvQdt) AS 'NVendas',sum(vendaValorTotal)'Valor total de Venda'
FROM
    jogo
        JOIN
    jogo_venda
		JOIN
    venda    
WHERE
    joCodigo = joCod
			AND
	venCod = vendaCodigo
GROUP BY joCodigo
ORDER BY NVendas asc
LIMIT 10;
/*jogos mais vendidos*/
SELECT 
    joCodigo, joNome, SUM(jvQdt) AS 'NVendas',sum(vendaValorTotal)'Valor total de Venda'
FROM
    jogo
        JOIN
    jogo_venda
    	JOIN
    venda  
WHERE
    joCodigo = joCod
			AND
	venCod = vendaCodigo
GROUP BY joCodigo
ORDER BY NVendas desc
LIMIT 10;
/*jogos mais alugados*/
SELECT 
    joCodigo, joNome, SUM(jlQtd) AS 'NAlocações',sum(devValor) AS 'Valor Total'
FROM
    jogo
        JOIN
    jogo_locacao
		JOIN 
	locacao
		JOIN
	devolucao
WHERE
    joCodigo = joCod
			AND
	locCod=locCodigo
			AND
	locCodigo=dev_locCodigo
GROUP BY joCodigo
ORDER BY NAlocações desc
LIMIT 10;
/*jogos menos alugados*/
SELECT 
    joCodigo, joNome, SUM(jlQtd) AS 'NAlocações',sum(devValor) AS 'Valor Total'
FROM
    jogo
        JOIN
    jogo_locacao
		JOIN 
	locacao
		JOIN
	devolucao
WHERE
    joCodigo = joCod
			AND
	locCod=locCodigo
			AND
	locCodigo=dev_locCodigo
GROUP BY joCodigo
ORDER BY NAlocações asc
LIMIT 10;
/*Nota de Conmpra*/
SELECT *from notadecompra;
/*Nota de conta*/
SELECT *from conta;
/*Lucro  de um jogo de aluguel por período*/
SELECT joCodigo, joNome, count(locCodigo) as 'Quantidade de alugueis',sum(devValor) as'ValorRendido'
FROM  jogo JOIN jogo_locacao JOIN locacao JOIN devolucao
WHERE joCodigo=joCod AND locCod=locCodigo AND locCodigo=dev_loCodigo
AND devData
BETWEEN '1000-01-01' AND '3000-01-01'
GROUP BY  joCodigo
ORDER BY ValorRendido;
/*Lucro  de um jogo de venda por período*/
SELECT joCodigo, joNome, count(vendaCodigo) as 'Quantidade de vendas',sum(vendaValorTotal) as'ValorRendido'
FROM  jogo JOIN jogo_venda JOIN venda 
WHERE joCodigo=joCod AND venCod=vendaCodigo 
AND vendaData
BETWEEN '1000-01-01' AND '3000-01-01'
GROUP BY  joCodigo
ORDER BY ValorRendido desc;
/*Montante total por vendedor*/
SELECT 
	funCodigo,funNome,count(vendaCodigo)as 'Numero de vendas',
    sum(vendaValorTotal) as 'Valor total de vendas' ,
    count(locCodigo) 'Quantidade de alugueis',sum(devValor) as 'Valor total de alugueis'
    ,(sum(vendaValorTotal)+sum(devValor)) as 'MontanteTotal'
FROM 
	funcionario JOIN vendedor JOIN venda JOIN locacao JOIN devolucao
WHERE 
	funCodigo=vendedor_funCodigo AND vendedorCodigo=venda_vendedorCodigo
    AND  loc_vendedorCodigo=vendedorCodigo and locCodigo=dev_locCodigo
GROUP BY 
	funCodigo
ORDER BY
	MontanteTotal desc; 
/* Montante por Cliente*/
SELECT 
	cliCodigo,cliNome,count(vendaCodigo)as 'Numero de vendas',
    sum(vendaValorTotal) as 'Valor total de vendas' ,
    count(locCodigo) 'Quantidade de alugueis',sum(devValor) as 'Valor total de alugueis'
    ,(sum(vendaValorTotal)+sum(devValor)) as 'MontanteTotal'
FROM 
	cliente JOIN venda JOIN locacao JOIN devolucao
WHERE 
	cliCodigo=venda_clienteCodigo and cod=loc_clienteCodigo
    and locCodigo=dev_locCodigo
GROUP BY 
	cliCodigo
ORDER BY
	MontanteTotal desc; 







