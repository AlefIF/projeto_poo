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
SELECT *from notadecompra where ndcCodigo=0;
/*Nota de conta*/
SELECT *from contas where conCodigo=0;
/*Venda por vendedor*/
SELECT 
	funCodigo,funNome,count(vendaCodigo) as 'NVendasRealizadas'
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
	NVendasRealizadas 
		desc;  
/*Venda por periodo*/
Select  sum(vendaCodigo) as 'Quantidade de vendas' from venda where vendaData 
BETWEEN 'dataInicio' and 'dataFinal';
/*Aluguel por periodo*/
Select  sum(locCodigo) as 'Quantidade de alugueis' from locacao where locDataAluguel 
BETWEEN 'dataInicio' and 'dataFinal';
/*Lucro por ano*/

