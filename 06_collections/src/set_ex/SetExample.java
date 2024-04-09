package set_ex;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class SetExample {
    public static void main(String[] args) {
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString());

        System.out.println("Elemento 5.0 está no conjunto? " + notas.contains(5.0));
        System.out.println("Exibir a menor nota: " + Collections.min(notas));
        System.out.println("Exibir a maior nota: " + Collections.max(notas));

        Double soma = 0.0;
        Iterator<Double> iterator0 = notas.iterator();
        while (iterator0.hasNext()) {
            soma += iterator0.next();
        }
        System.out.println("Exibir soma: " + soma);

        notas.remove(0d);
        System.out.println("Remover a nota 0: " + notas);

        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println("Remover notas menores do que 7: " + notas);

        System.out.println("Utilizar LinkedHashSet<> para exibir notas na ordem informada: ");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(8d);
        notas2.add(3.6);
        System.out.println(notas2);

        Set<Double> notas3 = new TreeSet<>(notas2); //notas2 já possui Comparable
        System.out.println("Ordem Crescente: " + notas3); //TreeSet organiza seus elementos
        notas.clear();
        System.out.println(notas + "/" + notas.isEmpty());        
    }

}

class ExemploOrdem {
    public static void main(String[] args) {
        Set<Serie> minhaSeries1 = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s", "comédia", 25));
        }};
        System.out.println("Ordem de Inserção: " + minhaSeries1);

        System.out.println("Ordem Natual (tempo episodio): ");
        Set<Serie> minhaSeries2 = new TreeSet<>(minhaSeries1);
        for (Serie serie: minhaSeries2) System.out.println(serie.getNome()+"/"+serie.getGenero()+"/"+serie.getTempoEpisodio());
        
        System.out.println("Ordem Nome/Genero/TempoEpisodio: ");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempo());
        minhasSeries3.addAll(minhaSeries1);
        for (Serie serie: minhasSeries3) System.out.println(serie.getNome()+"/"+serie.getGenero()+"/"+serie.getTempoEpisodio());
    }
}

class ComparatorNomeGeneroTempo implements Comparator<Serie> {
    @Override
    public int compare(Serie o1, Serie o2) {
        int nome = o1.getNome().compareTo(o2.getNome());
        if (nome != 0) return nome;

        int genero = o1.getGenero().compareTo(o2.getGenero());
        if (genero != 0) return genero;
        
        return Integer.compare(o1.getTempoEpisodio(), o2.getTempoEpisodio());        
    }    
}
