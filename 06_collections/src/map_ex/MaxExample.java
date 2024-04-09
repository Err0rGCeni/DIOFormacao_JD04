package map_ex;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MaxExample {
    public static void main(String[] args) {
        Map<String, Double> carrosPopulares = new HashMap<>() {
            {
                put("gol", 14.4);
                put("uno", 15.6);
                put("mobi", 16.1);
                put("hb20", 14.5);
                put("kwid", 15.6);
            }
        };
        System.out.println(carrosPopulares);

        carrosPopulares.put("gol", 15.2);
        System.out.println("Substituir o consumo do gol por 15.2: " + carrosPopulares);

        System.out.println("Tucson está no dicionário? " + carrosPopulares.containsKey("tucson"));
        System.out.println("Consumo do uno: " + carrosPopulares.get("uno"));

        System.out.println("Modelos: " + carrosPopulares.keySet());
        System.out.println("Consumos: " + carrosPopulares.values());
        System.out.println("Max Consumos: " + Collections.max(carrosPopulares.values()));

        Double maisEf = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        // System.out.println(entries);
        String modeloMaisEf = "";
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(maisEf)) {
                modeloMaisEf = entry.getKey();
                System.out.println("Modelo mais ef.: " + modeloMaisEf + "/" + maisEf);
            }
        }
        System.out.println("Min Consumos: " + Collections.min(carrosPopulares.values()));

        System.out.println("Modelo menos econômico e consumo: ");
        Double consumoMenosEf = Collections.min(carrosPopulares.values());
        String modeloMenosEf = "";
        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoMenosEf)) {
                modeloMenosEf = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEf + "/" + consumoMenosEf);
            }
        }

        System.out.println("Soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println("Remoção consumo igual a 15,6: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(15.6))
                iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("Exibir na ordem informada: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {
            {
                put("gol1", 14.4);
                put("uno2", 15.6);
                put("mobi3", 16.1);
                put("hb204", 14.5);
                put("kwid5", 15.6);
            }
        };
        System.out.println(carrosPopulares1);

        System.out.println("Exibir ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);
    }

}

class ExemploOrdem {
    public static void main(String[] args) {
        System.out.println("Ordem Aleatória");
        Map<String, Livro> meusLivros1 = new HashMap<>() {
            {
                put("Hawking, Stephen", new Livro("História Tempo", 256));
                put("Duhigg, Charles", new Livro("Poder Hábito", 408));
                put("Harari, Yuval", new Livro("21 Lições", 432));
            }
        };
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet()) {
            System.out.println(livro.getKey() + "/" + livro.getValue());
        }

        System.out.println("Ordem Inserção");
        Map<String, Livro> meusLivros2 = new LinkedHashMap<>() {
            {
                put("Hawking, Stephen", new Livro("História Tempo", 256));
                put("Duhigg, Charles", new Livro("Poder Hábito", 408));
                put("Harari, Yuval", new Livro("21 Lições", 432));
            }
        };
        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet()) {
            System.out.println(livro.getKey() + "/" + livro.getValue());
        }

        System.out.println("Ordem Alfabética (Autores)");
        Map<String, Livro> meusLivros3 = new TreeMap<>() {
            {
                put("Hawking, Stephen", new Livro("História Tempo", 256));
                put("Duhigg, Charles", new Livro("Poder Hábito", 408));
                put("Harari, Yuval", new Livro("21 Lições", 432));
            }
        };
        for (Map.Entry<String, Livro> livro : meusLivros3.entrySet()) {
            System.out.println(livro.getKey() + "/" + livro.getValue());
        }

        System.out.println("Ordem Alfabética (Autores)");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros1.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros4) {
            System.out.println(livro.getKey() + "/" + livro.getValue());
        }
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }

}