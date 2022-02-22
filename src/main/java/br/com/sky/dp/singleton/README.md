Singleton é um dos design patterns mais simples. Garante que apenas um único objeto de uma determinada classe exista
durante o runtime da aplicação.
Teoricamente possui os mesmos prós e contras do uso de uma variável global na aplicação.

Para alguns, o singleton é um anti-pattern.

Há alguns modos de aplicar o singleton
1) Eager initiation -> Criar o objeto antes de necessitar.
2) Lazy initiation -> Criar o objeto sob demanda na primeira solicitação
3) Static Block initiation -> Criar o objeto no loading da classe
4) Enum -> Definir a classe usando um enum