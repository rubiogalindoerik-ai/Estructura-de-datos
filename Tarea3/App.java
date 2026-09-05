public class App {
    public static  int secuencuaFibonnacci(int n) {
        // Caso Base
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        // Rescursividad
        return secuencuaFibonnacci(n -1) + secuencuaFibonnacci(n - 2);
    }

    public static boolean subset_sum(int [] conjunto, int n, int objetivo) {
        // Caso Base
        if (objetivo == 0) {
            return true;
        } else if (n == 0) {
            return false;
        }

        // Recursividad
        if (conjunto[n-1] > objetivo) {
            return  subset_sum(conjunto, n-1, objetivo);
        }

        return subset_sum(conjunto, n-1, objetivo) || subset_sum(conjunto, n-1, objetivo - conjunto[n-1]);

    }

    private static int[] encontrarVacia(int[][] tablero) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tablero[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean esValido(int[][] tablero, int num, int fila, int col) {
        for (int j = 0; j < 9; j++) {
            if (tablero[fila][j] == num) {
                return false;
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (tablero[i][col] == num) {
                return false;
            }
        }
        
        int cajaFila = fila - fila % 3;
        int cajaCol = col - col % 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[cajaFila + i][cajaCol + j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static boolean resolverSudoku(int[][] tablero) {
        int[] vacia = encontrarVacia(tablero);
        
        // Caso Base
        if (vacia == null) {
            return true;
        }
        
        // Recursividad
        int fila = vacia[0];
        int col = vacia[1];
        
        for (int num = 1; num <= 9; num++) {
            if (esValido(tablero, num, fila, col)) {
                tablero[fila][col] = num;
                
                if (resolverSudoku(tablero)) {
                    return true;
                }
                
                tablero[fila][col] = 0;
            }
        }
        
        return false;
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int r = 0; r < 9; r++) {
            for (int d = 0; d < 9; d++) {
                System.out.print(tablero[r][d] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Enesimo número de la secuencia fibonacci: " + secuencuaFibonnacci(11));
        int[] conjunto = {3, 34, 4, 12, 5, 2};
        int objetivo = 9;
        int n = conjunto.length;
        System.out.println("Existe un subconjunto en el conjunto: ");
        for (int i = 0; i < conjunto.length; i++)
            System.out.println(conjunto[i]);
        System.out.println(" que sume: " + objetivo);
        if (subset_sum(conjunto, n, objetivo)) {
            System.out.println("Si hay un subjconjunto que sume: " + objetivo);
        } else {
            System.out.println("No hay un subjconjunto que sume: " + objetivo);
        }
        System.out.println("--- Sudoku ---");
        int[][] tablero = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("--- Tablero Inicial ---");
        imprimirTablero(tablero);

        if (resolverSudoku(tablero)) {
            System.out.println("\n--- Sudoku Resuelto ---");
            imprimirTablero(tablero);
        } else {
            System.out.println("\nEl Sudoku no tiene solución.");
        }

    }
}
