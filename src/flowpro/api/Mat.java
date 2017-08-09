package flowpro.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Mathematical library expecially for handling matrices and vectors. It works
 * with matrices of type double[][] and vectors of type double[]. Its
 * functionality is provided via static methods.
 *
 * @author ales
 */
public class Mat {

    private static final Pattern WHITESPACES = Pattern.compile("\\s+");

    /**
     * Forbids to create an object of the class.
     */
    private Mat() {
        throw new UnsupportedOperationException();
    }

    public static int mod(int i, int j) {
        return ((i % j) + j) % j;
    }

    /**
     *
     * @param a
     * @param b
     * @param n
     * @return
     */
    public static double[] linspace(double a, double b, int n) {
        double[] x = new double[n];
        if (n == 1) {
            x[0] = (a + b) / 2;
        } else {
            for (int i = 0; i < n; i++) {
                double xi = (double) i / (n - 1);
                x[i] = (1 - xi) * a + xi * b;
            }
        }
        return x;
    }

    public static double distance(double[] u, double[] v) {
        double dist = 0;
        for (int i = 0; i < u.length; ++i) {
            double temp = u[i] - v[i];
            dist += temp * temp;
        }
        dist = Math.sqrt(dist);

        return dist;
    }

    public static double L1Norm(double[] v) {
        double norm = 0;
        for (double val : v) {
            norm += Math.abs(val);
        }

        return norm;
    }

    public static double L2Norm(double[] v) {
        double norm = 0;
        for (double val : v) {
            norm += val * val;
        }

        return Math.sqrt(norm);
    }

    public static int max(int[][] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] > max) {
                    max = A[i][j];
                }
            }
        }
        return max;
    }

    public static double max(double[] v) {
        double max = 0;
        for (double val : v) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    public static int max(int[] v) {
        int max = 0;
        for (int val : v) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    public static double min(double[] v) {
        double min = Double.MAX_VALUE;
        for (double val : v) {
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    public static double sum(double[] v) {
        double sum = 0;
        for (double val : v) {
            sum += val;
        }
        return sum;
    }

    public static double[] normVector(double[] v) {
        double norm = L2Norm(v);
        double[] s = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            s[i] = v[i] / norm;
        }
        return s;
    }

    /**
     * u = u + v
     *
     * @param u
     * @param v
     */
    public static void plusEqual(double[] u, double[] v) {
        for (int i = 0; i < u.length; i++) {
            u[i] += v[i];
        }
    }

    public static double[] plusVec(double[] u, double[] v) {
        double[] out = new double[u.length];
        for (int i = 0; i < u.length; i++) {
            out[i] = u[i] + v[i];
        }
        return out;
    }

    public static double[] plusVec(double[] u, double[] v, double[] w) {
        double[] out = new double[u.length];
        for (int i = 0; i < u.length; i++) {
            out[i] = u[i] + v[i] + w[i];
        }
        return out;
    }

    public static double[] plusMinMinVec(double[] u, double[] v, double[] w) {
        double[] out = new double[u.length];
        for (int i = 0; i < u.length; i++) {
            out[i] = u[i] - v[i] - w[i];
        }
        return out;
    }

    public static double[] minusVec(double[] u, double[] v) {
        double[] out = new double[u.length];
        for (int i = 0; i < u.length; i++) {
            out[i] = u[i] - v[i];
        }
        return out;
    }

    /**
     * Adds two matrices of the same dimension.
     *
     * @param A n x m matrix
     * @param B n x m matrix
     * @return n x m matrix C = A + B
     */
    public static double[][] plus(double[][] A, double[][] B) {
        int m = A.length;
        int n = A[0].length;
        double[][] C = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static double[] plus(double[] u, double c) {
        double[] out = new double[u.length];
        for (int i = 0; i < u.length; i++) {
            out[i] = u[i] + c;
        }
        return out;
    }

    public static double[][] plus(double[][] A, double b) {
        int m = A.length;
        int n = A[0].length;
        double[][] C = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + b;
            }
        }
        return C;
    }

    public static int[][] plus(int[][] A, int b) {
        int m = A.length;
        int n = A[0].length;
        int[][] C = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + b;
            }
        }
        return C;
    }

    /**
     * Subtracts two matrices of the same dimension.
     *
     * @param A n x m matrix
     * @param B n x m matrix
     * @return n x m matrix C = A - B
     */
    public static double[][] minus(double[][] A, double[][] B) {
        int m = A.length;
        int n = A[0].length;
        double[][] C = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    /**
     * Element-wise multiplication of two matrices which have the same
     * dimension.
     *
     * @param A n x m matrix
     * @param B n x m matrix
     * @return n x m matrix C = A * B (element-wise)
     */
    public static double[][] timesByElems(double[][] A, double[][] B) {
        int m = A.length;
        int n = A[0].length;
        double[][] C = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] * B[i][j];
            }
        }
        return C;
    }

    /**
     * matrix-matrix multiplication
     *
     * @param A m x n matrix
     * @param B n x k matrix
     * @return m x k matrix C = A * B
     */
    public static double[][] times(double[][] A, double[][] B) {
        int ma = A.length;
        int na = A[0].length;
        int nb = B[0].length;
        double[][] C = new double[ma][nb];
        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < nb; j++) {
                for (int k = 0; k < na; k++) {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    /**
     * matrix-vector multiplication
     *
     * @param A m x n matrix
     * @param b vector of length n
     * @return vector x = A * b of length m
     */
    public static double[] times(double[][] A, double[] b) {
        int ma = A.length;
        int na = A[0].length;
        double[] c = new double[ma];
        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < na; j++) {
                c[i] = c[i] + A[i][j] * b[j];
            }
        }
        return c;
    }

    /**
     * Multiplies all entries of the matrix A by the constant c.
     *
     * @param A m x n matrix
     * @param c constant
     * @return m x n matrix B = c * A (element-wise)
     */
    public static double[][] times(double[][] A, double c) {
        int ma = A.length;
        int na = A[0].length;
        double[][] C = new double[ma][na];
        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < na; j++) {
                C[i][j] = C[i][j] + A[i][j] * c;
            }
        }
        return C;
    }

    public static double[] times(double[] v, double c) {
        int n = v.length;
        double[] C = new double[n];
        for (int i = 0; i < n; i++) {
            C[i] = v[i] * c;
        }
        return C;
    }

    public static void divide(double[][] A, double b) {
        int ma = A.length;
        int na = A[0].length;
        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < na; j++) {
                A[i][j] /= b;
            }
        }
    }

    public static double scalar(double[] a, double[] b) {

        double c = 0;
        if (a != null && b != null) {
            for (int i = 0; i < a.length; i++) {
                c += a[i] * b[i];
            }
        }
        return c;
    }

    public static double[] cross(double[] a, double[] b) {
        int n = a.length;
        double[] c = new double[n];
        c[0] = a[1] * b[2] - a[2] * b[1];
        c[1] = a[2] * b[0] - a[0] * b[2];
        c[2] = a[0] * b[1] - a[1] * b[0];
        return c;
    }

    /**
     * Calculates the bilinear form y = x*A*x'.
     *
     * @param A n x n matrix
     * @param x vector of length n
     * @return the outcome of bilinear form
     */
    public static double bilinearForm(double[][] A, double[] x) {
        int ma = A.length;
        double[] B = new double[ma];
        for (int i = 0; i < ma; i++) {
            B[i] = Mat.dot(A[i], x);
        }
        return Mat.dot(x, B);
    }

    /**
     * Takes a square root of each entry of a matrix.
     *
     * @param A m x n matrix
     * @return m x n matrix with square rooted elements
     */
    public static double[] sqrt(double[] A) {
        int m = A.length;
        double[] C = new double[m];
        for (int i = 0; i < m; i++) {
            C[i] = Math.sqrt(A[i]);
        }
        return C;
    }

    /**
     * Element wise averaging of two matrices.
     *
     * @param A n x m matrix
     * @param B n x m matrix
     * @return n x m matrix C = 0.5 * (A + B)
     */
    public static double[][] average(double[][] A, double[][] B) { // vypocet aritmetickeho prumeru
        int ma = A.length;
        int na = A[0].length;
        double[][] C = new double[ma][na];
        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < na; j++) {
                C[i][j] = (A[i][j] + B[i][j]) / 2;
            }
        }
        return C;
    }

    /**
     * Executes the dot product of two vectors.
     *
     * @param u vector of length l
     * @param v vector of length l
     * @return dot product u * v of vectors u and v
     */
    public static double dot(double[] u, double[] v) { // skalarni nasobeni
        double c = 0;
        for (int i = 0; i < u.length; i++) {
            c = c + u[i] * v[i];
        }
        return c;
    }

    public static double det(double[][] A) { // determinant
        return A[0][0] * A[1][1] * A[2][2] + A[0][1] * A[1][2] * A[2][0] + A[0][2] * A[1][0] * A[2][1] - A[0][0] * A[1][2] * A[2][1] - A[0][1] * A[1][0] * A[2][2] - A[0][2] * A[1][1] * A[2][0];
    }

    /**
     * Carries out the partial-pivoting Gaussian elimination.
     *
     * @param A square matrix on which the Gaussian elimination is to be applied
     * @return array which contains the pivoting order
     */
    public static int[] gaussian(double A[][]) {
        int n = A.length;
        int index[] = new int[n];

        double c[] = new double[n];

        // Initialize the index
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(A[i][j]);
                if (c0 > c1) {
                    c1 = c0;
                }
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(A[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = A[index[i]][j] / A[index[j]][j];

                // Record pivoting ratios below the diagonal
                A[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l) {
                    A[index[i]][l] -= pj * A[index[j]][l];
                }
            }
        }

        return index;
    }

    /**
     * Transposes a square matrix without making a copy. Input matrix will be
     * modified!
     *
     * @param A square matrix
     * @return transposed matrix
     */
    public static double[][] transposeInPlace(double A[][]) {
        int n = A.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                double temp = A[j][i];
                A[j][i] = A[i][j];
                A[i][j] = temp;
            }
        }

        return A;
    }

    /**
     * Transposes a matrix.
     *
     * @param A m x n matrix
     * @return transposed n x m matrix
     */
    public static double[][] transpose(double A[][]) {
        int m = A.length;
        int n = A[0].length;
        double B[][] = new double[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                B[i][j] = A[j][i];
            }
        }

        return B;
    }

    /**
     * Inverts a square matrix.
     *
     * @param A square matrix
     * @return inverted matrix
     */
    public static double[][] invert(double A[][]) { // inverze matice
        int n = A.length;
        double invA[][] = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, invA[i], 0, n);
        }

        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        for (int i = 0; i < n; ++i) {
            b[i][i] = 1;
        }

        // Transform the matrix into an upper triangle
        int[] index = gaussian(invA);

        // Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    b[index[j]][k]
                            -= invA[index[j]][i] * b[index[i]][k];
                }
            }
        }

        // Perform backward substitutions
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / invA[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= invA[index[j]][k] * x[k][i];
                }
                x[j][i] /= invA[index[j]][j];
            }
        }
        return x;
    }

    /**
     * Prints a vector on the screen.
     *
     * @param vect the vector to be printed
     */
    public static void print(double[] vect) { // tiskne matici
        print(vect, "%.2f");
    }

    public static void print(int[] vect) { // tiskne matici
        int m = vect.length;
        for (int i = 0; i < m; i++) {
            System.out.printf(vect[i] + " ");
        }
        System.out.println();
    }

    /**
     * Prints a vector on the screen.
     *
     * @param vect the vector to be printed
     * @param format
     */
    public static void print(double[] vect, String format) {
        if (vect == null) {
            System.out.println("null");
            return;
        }

        int m = vect.length;
        for (int i = 0; i < m; i++) {
            System.out.printf(format + " ", vect[i]);
        }
        System.out.println();
    }

    /**
     * Prints a matrix on the screen.
     *
     * @param A the matrix to be printed
     */
    public static void print(double[][] A) { // tiskne matici
        print(A, "%.2f");
    }

    /**
     * Prints a matrix on the screen.
     *
     * @param A the matrix to be printed
     * @param format
     */
    public static void print(double[][] A, String format) { // tiskne matici
        if (A == null) {
            System.out.println("null");
            return;
        }

        for (double[] row : A) {
            for (int j = 0; j < row.length; j++) {
                System.out.printf(format + " ", row[j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print(int[][] A) { // tiskne matici
        if (A == null) {
            System.out.println("null");
            return;
        }

        for (int[] row : A) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Reads integers from a file and copies it into an array (vector).
     *
     * @param fileName name of a file containing integers separated by space or
     * new line characters
     * @return array of integers
     * @throws IOException
     */
    public static int[] loadIntArray(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // find out the number of integers in the file
        int elems = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            elems += line.split(" ").length;
        }
        reader.close();

        int[] array = new int[elems];
        reader = new BufferedReader(new FileReader(fileName));

        // copy data from file to a two-dimensional array
        int index = 0;
        for (int i = 0; i < elems; ++i) {
            String[] strArray = reader.readLine().split(" ");

            for (int j = 0; j < strArray.length; ++j) {
                array[index] = Integer.parseInt(strArray[j]);
                ++index;
            }
        }
        reader.close();

        return array;
    }

    /**
     * Reads integers from a file and copies it into a two-dimensional array
     * (matrix).
     *
     * @param fileName name of a file containing integers separated by space
     * characters, each line represents a row
     * @return two dimensional array of integers
     * @throws IOException
     */
    public static int[][] loadIntMatrix(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // find out the number of lines in the file (or rows of the array)
        int rows = 0;
        while (reader.readLine() != null) {
            ++rows;
        }
        reader.close();

        int[][] matrix = new int[rows][];
        reader = new BufferedReader(new FileReader(fileName));

        // copy data from file to a two-dimensional array
        for (int i = 0; i < rows; ++i) {
            String[] strArray = reader.readLine().split(" ");
            matrix[i] = new int[strArray.length];

            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = Integer.parseInt(strArray[j]);
            }
        }
        reader.close();

        return matrix;
    }

    /**
     * Reads integers from a file and copies it into a two-dimensional array
     * (matrix).
     *
     * @param fileName name of a file containing integers separated by space
     * characters, each line represents a row
     * @param rowLengths array specifying length of each row of the matrix
     * (number of integers on each line of the input file)
     * @return integer matrix
     * @throws IOException
     */
    public static int[][] loadIntMatrix(String fileName, int[] rowLengths) throws IOException {
        int rows = rowLengths.length; // number of rows of the matrix (lines in the input file)

        int[][] matrix = new int[rows][];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // copy data from file to a two-dimensional array
        for (int i = 0; i < rows; ++i) {
            String line;
            if ((line = reader.readLine()) == null) {
                throw new IOException("file " + fileName
                        + " has got less lines than expected");
            }
            String[] strArray = line.split(" ");
            if (strArray.length < rowLengths[i]) {
                throw new IOException("file " + fileName + " at line "
                        + Integer.toString(i) + " has less integers than expected");
            }
            matrix[i] = new int[rowLengths[i]];

            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = Integer.parseInt(strArray[j]);
            }
        }
        reader.close();

        return matrix;
    }

    public static String[] removeEmpty(String[] tokens) {
        int numNonEmpty = 0;
        for (String str : tokens) {
            if (!str.isEmpty()) {
                ++numNonEmpty;
            }
        }

        String[] newTokens = new String[numNonEmpty];
        int idx = 0;
        for (String str : tokens) {
            if (!str.isEmpty()) {
                newTokens[idx] = str;
                ++idx;
            }
        }

        return newTokens;
    }

    public static double[] loadDoubleArray(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // find out the number of integers in the file
        int elems = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            elems += line.split(" ").length;
        }
        reader.close();

        double[] array = new double[elems];
        reader = new BufferedReader(new FileReader(fileName));

        // copy data from file to a two-dimensional array
        int index = 0;
        for (int i = 0; i < elems; ++i) {
            String[] strArray = reader.readLine().split(" ");

            for (int j = 0; j < strArray.length; ++j) {
                array[index] = Double.valueOf(strArray[j]);
                ++index;
            }
        }
        reader.close();

        return array;
    }

    /**
     * Reads doubles from a file and copies it into a two-dimensional array
     * (matrix).
     *
     * @param fileName name of a file containing doubles separated by space
     * characters, each line represents a row
     * @return two-dimensional array of doubles
     * @throws IOException
     */
    public static double[][] loadDoubleMatrix(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // find out the number of lines in the file (or rows of the array)                    
        int rows = 0;
        while (reader.readLine() != null) {
            ++rows;
        }
        reader.close();

        double[][] matrix = new double[rows][];
        reader = new BufferedReader(new FileReader(fileName));

        // copy data from file to a two-dimensional array
        for (int i = 0; i < rows; ++i) {
            String[] tokens = WHITESPACES.split(reader.readLine()); //reader.readLine().split(" ");
            tokens = removeEmpty(tokens);
            matrix[i] = new double[tokens.length];

            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = Double.valueOf(tokens[j]);
            }
        }
        reader.close();

        return matrix;
    }

    /**
     * Reads doubles from a file and copies it into a two-dimensional array
     * (matrix).
     *
     * @param fileName name of a file containing doubles separated by space
     * characters, each line represents a row
     * @param rowLengths array specifying length of each row of the matrix
     * (number of integers on each line of the input file)
     * @return double matrix
     * @throws IOException
     */
    public static double[][] loadDoubleMatrix(String fileName, int[] rowLengths) throws IOException {
        int rows = rowLengths.length; // number of rows of the matrix (lines in the input file)

        double[][] matrix = new double[rows][];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // copy data from file to a two-dimensional array
        for (int i = 0; i < rows; ++i) {
            String line;
            if ((line = reader.readLine()) == null) {
                throw new IOException("file " + fileName
                        + " has got less lines than expected");
            }
            String[] strArray = line.split(" ");
            if (strArray.length < rowLengths[i]) {
                throw new IOException("file " + fileName + " at line "
                        + Integer.toString(i) + " has less integers than expected");
            }
            matrix[i] = new double[rowLengths[i]];

            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = Double.parseDouble(strArray[j]);
            }
        }
        reader.close();

        return matrix;
    }

    public static void save(double[][] A, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (double[] row : A) {
                for (double entry : row) {
                    writer.write(entry + " ");
                }
                writer.newLine();
            }
            writer.close();
        }
    }

    public static void save(int[][] A, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int[] row : A) {
                for (int entry : row) {
                    writer.write(entry + " ");
                }
                writer.newLine();
            }
            writer.close();
        }
    }

    public static void save(double[] vec, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (double entry : vec) {
                writer.write(Double.toString(entry));
                writer.newLine();
            }
            writer.close();
        }
    }

    public static void save(int[] vec, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int entry : vec) {
                writer.write(Integer.toString(entry));
                writer.newLine();
            }
            writer.close();
        }
    }

    public static void quicksort(double[] a, int[] index, int left, int right) {
        if (right <= left) {
            return;
        }
        int i = partition(a, index, left, right);
        quicksort(a, index, left, i - 1);
        quicksort(a, index, i + 1, right);
    }

    // partition a[left] to a[right], assumes left < right
    private static int partition(double[] a, int[] index, int left, int right) {
        int i = left - 1;
        int j = right;
        while (true) {
            while (less(a[++i], a[right])); // find item on left to swap                               // a[right] acts as sentinel
            while (less(a[right], a[--j])) { // find item on right to swap
                if (j == left) {
                    break;           // don't go out-of-bounds
                }
            }
            if (i >= j) {
                break;                  // check if pointers cross
            }
            exch(a, index, i, j);               // swap two elements into place
        }
        exch(a, index, i, right);               // swap with partition element
        return i;
    }

    // is x < y ?
    private static boolean less(double x, double y) {
        return (x < y);
    }

    // exchange a[i] and a[j]
    private static void exch(double[] a, int[] index, int i, int j) {
        double swap = a[i];
        a[i] = a[j];
        a[j] = swap;
        int b = index[i];
        index[i] = index[j];
        index[j] = b;
    }
}
