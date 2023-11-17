import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//
//        {0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0},
//
        int[][] matrixToSolve = {
                {0, 0, 0, 0, 9, 0, 0, 0, 0},
                {7, 6, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 8, 0, 0, 3, 0, 0},
                {0, 0, 0, 0, 0, 9, 2, 0, 0},
                {0, 3, 0, 0, 0, 0, 0, 0, 7},
                {8, 0, 4, 0, 0, 5, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 7, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 4},
                {2, 9, 0, 0, 0, 7, 0, 0, 5},
        };
        solve(matrixToSolve);
        printMatrix(matrixToSolve);
    }

    private static boolean solve(int[][] matrixToSolve) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrixToSolve[i][j] == 0) {
                    for (int k = 1; k < 10; k++) {
                        if (isNumberPotentialAnswer(matrixToSolve, i, j, k)) {
                            matrixToSolve[i][j] = k;
//                          //recursion -> if solve return false then we backtrack
                            if(!solve(matrixToSolve)){
                                matrixToSolve[i][j] = 0;
                            };
                        }
                    }
                    //backtracking releaser
                    if(matrixToSolve[i][j] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrixToSolve) {
        for (int[] ints : matrixToSolve) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

    private static boolean isNumberPotentialAnswer(int[][] matrixToSolve, int x, int y, int number) {
        int[][] smallMatrix = {
                {matrixToSolve[(x / 3) * 3][(y / 3) * 3], matrixToSolve[(x / 3) * 3][(y / 3) * 3 + 1], matrixToSolve[(x / 3) * 3][(y / 3) * 3 + 2]},
                {matrixToSolve[(x / 3) * 3 + 1][(y / 3) * 3], matrixToSolve[(x / 3) * 3 + 1][(y / 3) * 3 + 1], matrixToSolve[(x / 3) * 3 + 1][(y / 3) * 3 + 2]},
                {matrixToSolve[(x / 3) * 3 + 2][(y / 3) * 3], matrixToSolve[(x / 3) * 3 + 2][(y / 3) * 3 + 1], matrixToSolve[(x / 3) * 3 + 2][(y / 3) * 3 + 2]},
        };
        for (int i = 0; i < 9; i++) {
            if (matrixToSolve[x][i] == number) {
                return false;
            }
            if (matrixToSolve[i][y] == number) {
                return false;
            }
        }
        for (int[] matrix : smallMatrix) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i] == number) {
                    return false;
                }
            }
        }
        return true;
    }

}