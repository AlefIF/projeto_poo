SELECT * FROM item_venda;
SELECT * FROM venda;
SELECT * FROM funcionario;
SELECT * FROM console;
SELECT * FROM categoria;
SELECT * FROM devolucao;
SELECT * FROM funcionario;
SELECT * FROM  cliente;
SELECT * FROM locacao;




SELECT funCodigo, funNome, count(venCodigo) 
from funcionario join venda where funCodigo = ven_funcodigo group by funCodigo;

select month(venData),sum(ivQtd) from venda  left join item_venda 
on venCodigo=iv_venCodigo and year(venData)=2017 group by month(venData);