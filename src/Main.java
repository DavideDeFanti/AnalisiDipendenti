import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Dipendente dip1 = new Dipendente("Marco", 37, 35000.00, Dipartimento.SALES);
        Dipendente dip2 = new Dipendente("Luigi", 46, 60000.00, Dipartimento.FINANCE);
        Dipendente dip3 = new Dipendente("Andrea", 27, 30000.00, Dipartimento.HR);
        Dipendente dip4 = new Dipendente("Vittorio", 60, 65000.00, Dipartimento.IT);
        Dipendente dip5 = new Dipendente("Francesca", 57, 45000.00, Dipartimento.SALES);
        Dipendente dip6 = new Dipendente("Erica", 24, 25000.00, Dipartimento.HR);
        Dipendente dip7 = new Dipendente("Enrico", 29, 35000.00, Dipartimento.FINANCE);
        Dipendente dip8 = new Dipendente("Davide", 34, 28000.00, Dipartimento.IT);

        List<Dipendente> listaDipendenti = Arrays.asList(dip1, dip2, dip3, dip4, dip5, dip6, dip7, dip8);

        // Interfaccia funzionale con lambda
        List<Dipendente> listaFiltroEta = new ArrayList<>();
        FiltroDipendente filtroEta = dip -> dip.getEta() > 30;
        for (Dipendente dip : listaDipendenti) {
            if (filtroEta.test(dip)) {
                listaFiltroEta.add(dip);
            }
        }
        System.out.println(listaFiltroEta);
        System.out.println();

        List<Dipendente> listaFiltroStipendio = new ArrayList<>();
        FiltroDipendente filtroStip = dip -> dip.getStipendio() >= 45000.0;
        for (Dipendente dip : listaDipendenti) {
            if (filtroStip.test(dip)) {
                listaFiltroStipendio.add(dip);
            }
        }
        System.out.println(listaFiltroStipendio);
        System.out.println();

        // Method reference e Constructor reference
        Function<String, Dipendente> creaDipendente = Dipendente::new;
        String[] nomiDipendenti = {"Mario", "Giulia", "Stefano", "Carlo", "Matteo"};
        List<Dipendente> listaNomiDipendenti = new ArrayList<>();
        for (String nomi : nomiDipendenti) {
            listaNomiDipendenti.add(creaDipendente.apply(nomi));
        }
        System.out.println(listaNomiDipendenti);
        Comparator<Dipendente> ordineAlfabetico = Comparator.comparing(Dipendente::getNome);
        listaNomiDipendenti.sort(ordineAlfabetico);
        System.out.println("Lista nomi ordinati:");
        System.out.println(listaNomiDipendenti);
        System.out.println();

        // Analisi con Stream
        // Filtro
        Stream<Dipendente> streamFiltro = listaDipendenti.stream()
                .filter(dip -> dip.getStipendio() > 30000.0);
        System.out.println("Filtro stipendio maggiore di 30.000:");
        streamFiltro.forEach(System.out::println);
        System.out.println();

        //Ordinamento
        Stream<Dipendente> streamOrdine = listaDipendenti.stream()
                .sorted(Comparator.comparing(Dipendente::getEta));
        System.out.println("Ordinamento crescente per età:");
        streamOrdine.forEach(System.out::println);
        System.out.println();

        //Map
        OptionalDouble mediaStipendi = listaDipendenti
                .stream()
                .mapToDouble(Dipendente::getStipendio)
                .average();
        mediaStipendi.ifPresent(media -> System.out.println("Stipendio medio: " + media));
        mediaStipendi.orElse(- 1.0);
        System.out.println();

        // Raggruppare
        Map<Dipartimento, List<Dipendente>> dipendentiPerDipartimento =
                listaDipendenti.stream()
                        .collect(Collectors.groupingBy(Dipendente::getDipartimento));

        dipendentiPerDipartimento
                .forEach((chiave, valore) -> {
                            System.out.println(chiave + ": " + valore);
                        }
                );
    }
}