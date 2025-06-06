# AP2-POO

1:N (Bidirecional) - 1 cidadão tem reporta N problemas 
	Cidadão - Lista de Problemas que ele reportou
	Problema - Usuário que reportou

1:N (Unidirecional) - 1 Cidadão pode fazer N comentários
	Comentário - Guarda o Cidadão que o fez

1:N (Unidirecional) - 1 Problema tem N comentários
	Problema - Lista de Problemas

1:1 (Unidirecional) - 1 Problema tem 1 Localização e a Localização está associada a somente aquele problema
(Localização exata do problema, mesmo que um poste e um buraco estejam muito próximos, tem coordenadas ligeiramente diferentes)
	Problema - Guardar a Localização


N:N (Unidirecional) - N Cidadãos contribuem com N Problemas
	Cidadão - Lista de Problemas que ele contribuiu