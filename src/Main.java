import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> elfos = leerArchivo();
        int res = valorMaximo(elfos);
        System.out.println(res);
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
