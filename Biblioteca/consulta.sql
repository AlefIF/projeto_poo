select *from livro
select * from genero;
select gen_Nome , count(liv_Titulo) from genero join livro
where gen_Id=liv_Genero
group by gen_Id;