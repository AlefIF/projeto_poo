SELECT * FROM bdtechsalesatual.venda;
SELECT * FROM bdtechsalesatual.item_venda;

select month(venData),sum(ivQtd) from venda  join item_venda
on venCodigo=iv_venCodigo and year(venData)=2017
group by month(venData);