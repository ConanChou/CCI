/**
 * write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column are set to 0.
 */


public class Q1_7 {

    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4,5,6,7,8},
            {1,3,5,7,9,0,2,4},
            {2,4,6,8,1,1,3,5},
            {1,4,8,3,6,9,1,0}
        };

        markLines(matrix);

        for (int[] rows: matrix) {
            for (int i: rows) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    static void markLines(int[][] m) {
        boolean[] column = new boolean[m.length];
        boolean[] row = new boolean[m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    column[i] = true;
                    row[j] = true;
                }
            }
        }

        for (int i = 0; i < column.length; i++) {
            for (int j = 0; j < row.length; j++) {
                if (column[i] || row[j]) {
                    m[i][j] = 0;
                }
            }
        }
    }
}
