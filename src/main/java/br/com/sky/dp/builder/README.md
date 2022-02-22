O padrão Builder possui 2 interpretações:

1) No livro GangOfFour diz que permite a criação de um objeto complexo passo a passo usando a sequencia correta das ações. 
E que a construção é controlada por um objeto "diretor" que precisa saber apenas o tipe do objeto para criá-lo.
2) Um padrão muito parecido com o Abstract Factory, porém dá mais controle no processo de criação do objeto. Ex: Builder no Lombok

O Builder ajuda na construção de objetos imutáveis que tenham vários atributos opcionais.
Com o builder não é necessário criar vários construtores (matriz de posibilidades entre os campos opcionais), visto
que a classe não poderá conter métodos setters para garantir imutabilidade.