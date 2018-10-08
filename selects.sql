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
select * from contas;
select * from contasaprazo;
select * from listadesejo;

/* Jogos menos vendidos*/
SELECT 
    joCodigo, joNome, SUM(jvQdt) AS 'NVendas'
FROM
    jogo
        JOIN
    jogo_venda
WHERE
    joCodigo = joCod
GROUP BY joCodigo
ORDER BY NVendas asc
LIMIT 10;
/*jogos mais vendidos*/
SELECT 
    joCodigo, joNome, SUM(jvQdt) AS 'NVendas'
FROM
    jogo
        JOIN
    jogo_venda
WHERE
    joCodigo = joCod
GROUP BY joCodigo
ORDER BY NVendas desc
LIMIT 10;
/*jogos mais alugados*/
SELECT 
    joCodigo, joNome, SUM(jlQtd) AS 'NAlocações'
FROM
    jogo
        JOIN
    jogo_locacao
WHERE
    joCodigo = joCod
GROUP BY joCodigo
ORDER BY NAlocações desc
LIMIT 10;
/*jogos menos alugados*/
SELECT 
    joCodigo, joNome, SUM(jlQtd) AS 'NAlocações'
FROM
    jogo
        JOIN
    jogo_locacao
WHERE
    joCodigo = joCod
GROUP BY joCodigo
ORDER BY NAlocações asc
LIMIT 10;
/*Nota de Conmpra*/
SELECT *from notadecompra;
/*Nota de conta*/
SELECT *from contas;
/*Venda por vendedor*/
SELECT 
	funCodigo,funNome,count(vendaCodigo)as 'NumeroDeVendas',sum(vendaValorTotal) as 'Valor total de Vendas' 
FROM 
	funcionario 
			JOIN
	vendedor
			JOIN
	venda
WHERE 
	funCodigo=ven_funCodigo 
			AND
    venCodigo=venda_vendedorCodigo
GROUP BY 
	funCodigo
ORDER BY
	NumeroDeVendas 
		desc;  
/*Lucro  de um jogo de aluguel por período*/
SELECT joCodigo, joNome, count(locCodigo) as 'Quantidade de alugueis',sum(devValor) 'ValorRendido'
FROM  jogo JOIN jogo_locacao JOIN locacao JOIN devolucao
WHERE joCodigo=joCod AND locCod=locCodigo AND locCodigo=dev_loCodigo
BETWEEN 'dataInicio' AND 'dataFinal'
GROUP BY  joCodigo
ORDER BY ValorRendido;
/*Lucro  de um jogo de venda por período*/
SELECT joCodigo, joNome, count(vendaCodigo) as 'Quantidade de vendas',sum(vendaValorTotal) 'ValorRendido'
FROM  jogo JOIN jogo_venda JOIN venda 
WHERE joCodigo=joCod AND venCod=vendaCodigo 
BETWEEN 'dataInicio' AND 'dataFinal'
GROUP BY  joCodigo
ORDER BY ValorRendido;
/*Venda por vendedor*/
SELECT 
	funCodigo,funNome,count(vendaCodigo)as 'NumeroDeVendas',
    sum(vendaValorTotal) as 'Valor total de Vendas' ,
    count(locCodigo) 'Quantidade de alugueis',sum(devValor)as 'Valor total de Alugueis'
    ,('Valor total de Vendas'+'Valor total de Alugueis') as 'MontanteTotal'
FROM 
	funcionario JOIN vendedor JOIN venda JOIN locacao JOIN devolucao
WHERE 
	funCodigo=vendedor_funCodigo AND vendedorCodigo=venda_vendedorCodigo
    AND  loc_vendedorCodigo=venCodigo and locCodigo=dev_locCodigo
GROUP BY 
	funCodigo
ORDER BY
	MontanteTotal desc; 








