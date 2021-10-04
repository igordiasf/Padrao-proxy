package padroesestruturais.proxy;


import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Montadora> Montadoras = new HashMap<>();

    public static Montadora getMontadora(Integer matricula) {
        return Montadoras.get(matricula);
    }

    public static void addMontadora(Montadora Montadora) {
        Montadoras.put(Montadora.getMatricula(), Montadora);
    }
}
