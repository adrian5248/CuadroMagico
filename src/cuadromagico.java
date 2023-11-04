import java.util.Scanner;

public class cuadromagico {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el número de filas: ");
        int filas = input.nextInt();

        System.out.print("Ingrese el número de columnas: ");
        int columnas = input.nextInt();

        if (filas != columnas) {
            System.out.println("La matriz no es cuadrada, no se puede hacer el cuadro mágico.");
            return;
        }

        int[][] cuadroMagico = new int[filas][columnas];

        System.out.println("Ingrese los datos de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cuadroMagico[i][j] = input.nextInt();
            }
        }

        if (esCuadroMagico(cuadroMagico)) {
            System.out.println("Es un cuadro mágico.");
        } else {
            System.out.println("el cuadro no es mágico.");
        }
    }


    public static boolean esCuadroMagico(int[][] cuadro) {
        int n = cuadro.length;
        
        // aqui se verifica que la matriz sea cuadrada
        for (int i = 0; i < n; i++) {
            if (cuadro[i].length != n) {
                return false;
            }
        }

        int sumaDiagonal1 = 0;
        int sumaDiagonal2 = 0;

        for (int i = 0; i < n; i++) {
            int sumaFila = 0;
            int sumaColumna = 0;

            for (int j = 0; j < n; j++) {
                sumaFila += cuadro[i][j];
                sumaColumna += cuadro[j][i];
            }

            sumaDiagonal1 += cuadro[i][i];
            sumaDiagonal2 += cuadro[i][n - i - 1];

            if (sumaFila != sumaColumna) {
                return false;
            }
        }

        return sumaDiagonal1 == sumaDiagonal2;
    }
}