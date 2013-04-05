public class Q1_6 {
    static void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp;
        for (int offset = 0; offset < n/2; offset++) {
            for (int i = offset; i<offset+n-2*offset-1; i++) {
                tmp = matrix[offset][i];
                matrix[offset][i] = matrix[n-1-i][offset];
                matrix[n-1-i][offset] = matrix[n-1-offset][n-1-i];
                matrix[n-1-offset][n-1-i] = matrix[i][n-1-offset];
                matrix[i][n-1-offset] = tmp;
            }
        }
    }

    static void printMatrix(int[][] m) {
        for (int[] l: m) {
            for (int i: l) {
                System.out.print(i);
            }
            System.out.print("\n");
        }
    }

    public static void main (String [] args)
    {
        System.out.println(4/2);
        int[][] m = { { 1,2,3,0 },{ 4,5,6,1 },{ 7,8,9,2 }, {0,1,2,3} };
        printMatrix(m);
        rotate(m);
        printMatrix(m);
    }
}
