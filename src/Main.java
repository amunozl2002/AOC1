import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> elfos = leerArchivo();
        int max = valorMaximo(elfos);
        System.out.println("El valor máximo es: " + max);
        ordenarLista(elfos);
        System.out.println("-----------------------------");
        System.out.println("Valor Máximo: " + elfos.get(0));
        System.out.println("Valor nº 2: " + elfos.get(1));
        System.out.println("Valor nº 3: " + elfos.get(2));
        int suma = elfos.get(0) + elfos.get(1) + elfos.get(2);
        System.out.println("La suma de los tres mayores valores es: " + suma);
    }

    private static List<Integer> leerArchivo() throws IOException {
        FileReader input = new FileReader("C:/Users/aml20/Desktop/input.txt");
        BufferedReader br = new BufferedReader(input);
        String inputLine = br.readLine();
        int suma = 0;
        List<Integer> elfos = new ArrayList<>();
        int indice = 0;

        while (inputLine != null) {
            if (inputLine.isEmpty()) {
                elfos.add(indice, suma);
                indice++;
                suma = 0;
            } else {
                suma += Integer.parseInt(inputLine);
            }
            inputLine = br.readLine();
        }
        return elfos;
    }

    private static List<Integer> ordenarLista(List<Integer> lista) {
        Collections.sort(lista);
        Collections.reverse(lista);
        return lista;
    }

    private static int valorMaximo(List<Integer> elfos) {
        int res = 0;
        for (int elfo : elfos) {
            if (elfo > res) {
                res = elfo;
            }
        }
        return res;
    }
}
