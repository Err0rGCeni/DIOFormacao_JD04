# Estruturas de Dados em Java: Introdução

Bit, organização dos dados em memória, mecanismos de organização de dados que atendem diferentes requisitos de processamento.

Tipos de Dados:

- _boolean_: 1 bit;
- _byte_: 1 byte;
- _char_: 2 byte;
- _short_: 2 byte;
- _int_: 4 byte;
- _long_: 8 bytes;
- _float_: 4 bytes;
- _double_: 8 bytes;

## Atribuição e Referência

- As atribuições em Java são sempre por cópia de valor;
- Com tipo primitivo, copia-se o valor em memória;
  - `a = b`: O valor em **b** é copiado para o espaço em memória da variável **a**.
- Com objetos, copia-se o valor da referência em memória, sem duplicar o objeto;
  - `a = b`: Copia a referência de memória do objeto **b**  para o objeto **a** . Se modificar **b**, **a** também é modificado.

## Nó e Encadeamento

- **Nó**: Espaço em memória que armazena tanto o dado quanto uma referência para o próximo nó.
- O Encademante de Nós se dá ao atribuir a referência de um nó ao seu próximo nó. O último nó tem referência _null_.

## Generics

    Lista<String> minhaLista = new Lista<>();

    public class Lista<T>{
        private T t;
        ...
    }

- Introduzido desde o Java SE 5.0;
- Evitar casting excessivo;
- Evitar códigos redudantes;
- Encontrar erros em tempo de compilação;

Wildcards:

### Unknown Wildcards (Unbounded)

    public void imprimeLista(List<?> lista) {
        for (Object obj: lista) {
            System.out.println(obj);
        }
    }

    List<Aluno> minhaLista = newList<Aluno>();
    imprimeLista(minhaLista);

Função genérica que imprime listas de qualquer coisa, desde que tenha `toString()` implementado.

### Bounded Wildcard (Upper Bounded / Lower Bounded)

    public void imprimeLista(List<? extends Pessoa> listaPessoas) {
        for (Pessoa p: listaPessoas) {
            System.out.println(p);
        }
    }

    List<Aluno> minhaLista = new List<Aluno>();
    imprimeLista(minhaLista);

Só se pode passar lista de Pessoas e seus herdeiros (classes filhas).

    public void imprimeLista(List<? super Pessoa> listaPessoas) {
        for (Pessoa p: listaPessoas) {
            System.out.println(p);
        }
    }

    List<Aluno> minhaLista = new List<Aluno>();
    imprimeLista(minhaLista);

Não aceita classes herdeiras, só aceita da classe Pessoas e superiores.

### Convenção

- K ("Key") : Map<K, V>;
- V ("Value"): Map<K, V>;
- E ("Element"): List< E >;
- T ("Type"): Collections#addAll;
- ?: Genérico;
