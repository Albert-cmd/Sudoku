package sudoku4;

public class Solver {

    // SI NO ESTA REPETIDO devuelve FALSE 
    // SI ESTA REPETIDO devuelve TRUE 
    // SI DEVUELVEN LOS 3 METODOS FALSE, ENTONCES ES CORRECTO PONER EL NUMERO.
    int matriu[][];

    // we check if a possible number is already in a row
    public boolean isInRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (matriu[row][i] == number) {
                return true;
            }
        }

        return false;
    }

    // we check if a possible number is already in a column
    public boolean isInCol(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (matriu[i][col] == number) {
                return true;
            }
        }

        return false;
    }

    // we check if a possible number is in its 3x3 box
    public boolean isInBox(int row, int col, int number) {
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
    // SI ESTA EL NUMERO, DEVUELVE FALSE 
    public boolean isOk(int row, int col, int number) {

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
