/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Albert Workstation
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static int[][] matriu = {
        {8, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 3, 6, 0, 0, 0, 0, 0},
        {0, 7, 0, 0, 9, 0, 2, 0, 0},
        {0, 5, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 0, 4, 4, 5, 7, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 3, 0},
        {0, 0, 1, 0, 0, 0, 0, 6, 8},
        {0, 0, 8, 5, 0, 0, 0, 1, 0},
        {0, 9, 0, 0, 0, 0, 4, 0, 0}

    };

    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println(isOk(0, 0, 8));

        System.out.println(isInRow(0, 1));

        System.out.println(isInCol(0, 1));

        System.out.println(isInBox(4, 4, 3));

    }

    // we check if a possible number is already in a row
    public static boolean isInRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (matriu[row][i] == number) {
                return true;
            }
        }

        return false;
    }

    // we check if a possible number is already in a column
    private static boolean isInCol(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (matriu[i][col] == number) {
                return true;
            }
        }

        return false;
    }

    // we check if a possible number is in its 3x3 box
    private static boolean isInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (matriu[i][j] == number) {
                    return true;
                }
            }
        }

        return false;
    }

    // combined method to check if a number possible to a row,col position is ok
    public static boolean isOk(int row, int col, int number) {

//                for (int i = 0; i < matriu.length; i++) {
//                    for (int j = 0; j < matriu[i].length; j++) {
//                        System.out.print(matriu[i][j]);
//                    }
//                    System.out.println("");
//            }
        if (isInRow(row, number) && isInCol(col, number) && isInBox(row, col, number) == false) {

            return true;
            
        } else {

            return false;

        }

    }
}
