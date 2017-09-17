select * from categoria;
select * from con_jogo;
select * from console;
select * from item_venda;
select * from venda;
select * from cliente;
select * from funcionario;

Select joNome , sum(ivQtd)as'Quantidade vendida' from jogo join item_venda
join venda  where venDataEHora
BETWEEN $P{dataInicio} and $P{dataFinal} 
and 
joCodigo=iv_joCodigo and 
iv_venCodigo=venCodigo 
group by joNome 
order by sum(ivQtd)  desc limit 10;

Select joNome , sum(ivQtd)as 'Quantidade vendida' from jogo join item_venda
join venda  where venDataEHora
BETWEEN '2017-02-02 23:59:59' and '2017-10-10 23:59:59'
and 
joCodigo=iv_joCodigo and 
iv_venCodigo=venCodigo 
group by joNome 
order by sum(ivQtd)  desc limit 10;
