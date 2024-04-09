# Estruturas de Dados em Java: Pilhas e Filas

## Pilhas [Last In First Out]

"O último elemento que entra é o primeiro a sair."

O encadeamento se dá em o elemento/nó referenciar ao elemento/nó anterior. Armazena-se uma referência para o topo da pilha.

- **Método Top**: Retorna a referência do primeiro nó da pilha (topo).
- **Método Pop**: Retira o primeiro nó da pilha.
  - Armazena a referência do topo;
  - Atualiza a referência de topo para o próximo nó (remove o nó do topo);
  - Retorna a referência armazenada (retorna o nó);
- **Método Push**: Adiciona um nó ao topo da pilha.
  - Armazena a referência do topo;
  - Atualiza a referência do topo com o novo Nó;
  - Atribui a referência armazenada ao campo de referência do novo Nó;
- **Método isEmpty**: Retorna se a pilha (ou outra estrutura de dados) está vazia (verifica se a referência para entrada da pilha está _null_).

## Filas [First In First Out]

"O primeiro elemento que entra é o primeiro a sair."

Similar à pilha, mas a referência aponta para o próximo elemento/nó.

- **Método Enqueue**: Adiciona o nó ao começo da fila (Entre a referência de entrada e o último nó).
  - Recebe um novo Nó;
  - Adiciona a referência de entrada atual para o campo de referência do novo Nó;
  - Atualiza a referência de entrada para o novo Nó;
- **Método Dequeue**: Remove o primeiro nó da fila.
  - Armazena a referência de entrada;
  - Itera entre os campos de referência dos Nós até encontrar aquele que aponta para null (primeiro Nó);
    - Armazena a referência do próximo nó em um auxiliar;
    - Enquanto a referência no campo de referência não for null;
  - Ao encontrar o Nó que "aponta" para null, alterar o Nó auxiliar (segundo) para apontar para null (agora primeiro)

- **Método isEmpty**: Retorna se a fila está vazia.
