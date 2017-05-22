select *from jogo;
select *from con_jogo;
select *from categoria;
select *from console;

select joNome, catNome, conNome from jogo join categoria join con_jogo join console
where jo_catCodigo=catCodigo and 
joCodigo=cjg_joCodigo and cjg_conCodigo=conCodigo 