/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku4;

/**
 *
 * @author Albert Workstation
 */

/* Programa Generador de sudoku */
public class Sudoku {

    public static int[] solucio[]; // SOLUCIO 
    int[] mat[]; // MATRIU D'INTEGERS 
    int N; // NOMBRE DE COLUMNES
    int SRN; // ARREL QUADRADA N 
    int K; // BUITS

    // CONSTRUCTOR DEL OBJECTE SUDOKU 
    Sudoku(int N, int K) {
        this.N = N; //COLUMNES
        this.K = K; //BUITS

        // CALCULA ARREL QUADRADA del nombre N 
        // 
        Double SRNd = Math.sqrt(N);
        SRN = SRNd.intValue();

        // ASSIGNA A LA MATRIU COLUMNES 
        mat = new int[N][N];

    }

    // Sudoku Generator 
    public int[][] ompleValors() {
        // Omple les matrius 3*3 horitzontals
        // Explicacio al document de text.

        ompleBlocsHoritzontals();

        // Omplim les matrius 3*3 restants 
        // fent les comprovacions pertinents
        ompleMatriuRestant(0, SRN);

        // Generem els buits on omplira l'usuari
        generaBuits();

        return mat;
    }

    // Fill the diagonal SRN number of SRN x SRN matrices 
    void ompleBlocsHoritzontals() {

        for (int i = 0; i < N; i = i + SRN) // for diagonal box, start coordinates->i==j 
        {
            ompleBloc(i, i);
        }
    }

    // Returns false if given 3 x 3 block contains num. 
    boolean comprovaNumerosQuadrant(int rowStart, int colStart, int num) {
        //System.out.println("Comprovanumerosquadrant"+rowStart+colStart);
        for (int i = 0; i < SRN; i++) {
            for (int j = 0; j < SRN; j++) {
                if (mat[rowStart + i][colStart + j] == num) {
                   
                    return false;
                }
            }
        }

        return true;
    }

    // Omple un bloc 3*3 
    void ompleBloc(int row, int col) {
        int num;
        for (int i = 0; i < SRN; i++) {
            for (int j = 0; j < SRN; j++) {
                do {
                    num = generadorAleatoris(N);
                } while (!comprovaNumerosQuadrant(row, col, num));

                mat[row + i][col + j] = num;
            }
        }
    }

    // Random generator 
    int generadorAleatoris(int num) {
        return (int) Math.floor((Math.random() * num + 1));
    }

    // fa totes les comprovacions , horitzontal,vertical i sector.
    public boolean validaNumero(int i, int j, int num) {

        return (comprovaFila(i, num) && comprovaColumna(j, num) && comprovaNumerosQuadrant(i - i % SRN, j - j % SRN, num));

    }

    // check in the row for existence 
    boolean comprovaFila(int i, int num) {
        //System.out.println("comprovafila:"+i+"num:"+num);

        for (int j = 0; j < N; j++) {

            if (mat[i][j] == num) {
                  
                return false;
            }

        }

        return true;
    }

    // check in the row for existence 
    boolean comprovaColumna(int j, int num) {
        //System.out.println("comprovacolumna"+j+"Numero:"+num);
        for (int i = 0; i < N; i++) {
            if (mat[i][j] == num) {
                
                return false;
            }
        }

        return true;
    }

    // Funcio recursiva que omple els valors que no son blocs horitzontals
    boolean ompleMatriuRestant(int i, int j) {
        // System.out.println(i+" "+j); 
        if (j >= N && i < N - 1) {
            i = i + 1;
            j = 0;
        }
        if (i >= N && j >= N) {
            return true;
        }

        if (i < SRN) {
            if (j < SRN) {
                j = SRN;
            }
        } else if (i < N - SRN) {
            if (j == (int) (i / SRN) * SRN) {
                j = j + SRN;
            }
        } else {
            if (j == N - SRN) {
                i = i + 1;
                j = 0;
                if (i >= N) {
                    return true;
                }
            }
        }

        for (int num = 1; num <= N; num++) {
            if (validaNumero(i, j, num)) {
                mat[i][j] = num;
                if (ompleMatriuRestant(i, j + 1)) {
                    return true;
                }

                mat[i][j] = 0;
            }
        }
        return false;
    }

    // Elimina de la matriu nombres aleatoris per aconseguir 
    // La dificultat desitjada 
    // 
    public void generaBuits() {

        //FIX PARA EL OUT OF BOUNDS DE la columna 9 
        //int cellId = randomGenerator(N*N) - 1;
        //QUITAR 
        //if (j != 0)
        //j = j - 1;
        int count = K;
        while (count != 0) {
            int cellId = generadorAleatoris(N * N) - 1;

            //System.out.println(cellId); 
            // extract coordinates i and j 
            int i = (cellId / N);
            int j = cellId % 9;

            // System.out.println(i+" "+j); 
            if (mat[i][j] != 0) {
                count--;
                mat[i][j] = 0;
            }
        }
    }

    // Print sudoku 
    public void imprimeixSudoku() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
