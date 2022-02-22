Strategy é um design pattern comportamental que cria objetos como um conjunto de comportamentos e consegue alterar
no contexto original o comportamento interno de um outro objeto.

O comportamento fica isolado do objeto original, deixando por exemplo, diferentes algoritmos tomarem a decisão. 
Tais como algoritmos de ordenação, onde cada algoritmo pode representar uma estratégia, 
e a coleção não precisa saber como o algoritmo é executado

Este design pattern é baseado no princípio open/closed do SOLID. Onde não precisamos modificar o contexto original,
mas podemos escolher ou incluir implementações do comportamento.