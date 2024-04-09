package list_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class ExemploList {
    public static void main(String[] args) {
        // Inicialização de uma lista de notas:
        // 1. Legado (não recomendado):
        // List notas = new ArrayList();
        // - Essa abordagem não é recomendada, pois não especifica o tipo de elementos
        // na lista.
        // - É preferível usar tipos genéricos para maior segurança de tipos.
        //
        // 2. ArrayList (recomendado):
        // ArrayList<Double> notas = new ArrayList<>();
        // - Cria um ArrayList tipado para armazenar valores do tipo Double.
        // - É flexível e permite adicionar, remover e acessar elementos por índice.
        //
        // 3. List com ArrayList (recomendado):
        // List<Double> notas = new ArrayList<>();
        // - Usa a interface List para declarar a variável.
        // - A implementação real é um ArrayList.
        // - Boa prática para programar voltado para interfaces.
        //
        // 4. Inicialização com valores específicos:
        // List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 5d, 3.6));
        // - Cria uma lista com os valores 7.0, 8.5, 5.0 e 3.6.
        // - Permite adicionar mais elementos posteriormente.
        //
        // 5. Lista imutável com Arrays.asList (não recomendado):
        // List<Double> notas = Arrays.asList(7d, 8.5, 5d, 3.6);
        // - Cria uma lista imutável (não é possível adicionar ou remover elementos).
        // - Não suporta operações de modificação.
        //
        // 6. Lista imutável com List.of (recomendado a partir do Java 9):
        // List<Double> notas = List.of(7d, 8.5, 3.6);
        // - Cria uma lista imutável com os valores especificados.
        // - Mais segura e eficiente em termos de memória.

        List<Double> notas = new ArrayList<Double>();
        notas.add(1.1);
        notas.add(3.2);
        notas.add(5.3);
        notas.add(5.0);
        notas.add(9.5);
        notas.add(0d);
        notas.add(8.4);
        System.out.println(notas);

        System.out.println("Posição da nota 5.0:" + notas.indexOf(5d));
        notas.add(4, 8d);
        System.out.println("Inserção da nota 8.0 na posição 4: " + notas);

        notas.set(notas.indexOf(5d), 6.0);
        System.out.println("Substituição da nota 5.0: " + notas);

        System.out.println("Conferir se nota 5.0 está na lista: " + notas.contains(5d));
        //for (Double nota: notas) System.out.println(nota);
        System.out.println("Terceira nota: " + notas.get(2));
        System.out.println("Menor nota: " + Collections.min(notas));
        System.out.println("Maior nota: " + Collections.max(notas));
        
        Iterator<Double> iterator0 = notas.iterator();
        Double soma = 0d;
        while (iterator0.hasNext()) {
            soma += iterator0.next();            
        }
        System.out.println("Soma de notas: " + soma);
        System.out.println("Média: " + soma/notas.size());

        notas.remove(0d);
        System.out.println("Remover 0: " + notas);
        notas.remove(0);
        System.out.println("Remover posição 0: " + notas);

        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();            
        }
        System.out.println("Remover menores do que 7: " + notas);

        notas.clear();
        System.out.println("Lista apagada? " + notas.isEmpty() + " comprove: " + notas);
    }
}

class ExemploOrdenacao {
    public static void main(String[] args) {
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("John", 10, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("John", 12, "amarelo"));
        }};

        // Ordem de Inserção
        System.out.println(meusGatos);
        
        // Ordem Aleatória
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);
        
        // Ordem Natural (nome)
        Collections.sort(meusGatos);
        System.out.println(meusGatos);
        
        // Ordem por Idade
        Collections.sort(meusGatos, new ComparatorIdade());
        //meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);
        
        // Ordem por Cor
        Collections.sort(meusGatos, new ComparatorCor());
        System.out.println(meusGatos);

        // Comparador Composto Nome/Cor/Idade
        Collections.sort(meusGatos, new ComparatorCompost());
        System.out.println(meusGatos);
    }

}
