package processor;

public class Operations extends Application{

    private void getUserInput(Application matrixOne, Application matrixTwo){
        System.out.print("Enter size of first matrix: ");
        matrixOne.getSizeOfMatrix();
        System.out.println("Enter first matrix:");
        matrixOne.getMatrix();
        System.out.print("Enter size of second matrix: ");
        matrixTwo.getSizeOfMatrix();
        System.out.println("Enter second matrix:");
        matrixTwo.getMatrix();
    }
    private void getUserInput(Application matrixByUser){
        System.out.print("Enter size of matrix: ");
        matrixByUser.getSizeOfMatrix();
        System.out.println("Enter matrix:");
        matrixByUser.getMatrix();
    }

    protected void addMatrix() {
        Application matrixOne = new Application();
        Application matrixTwo = new Application();
        getUserInput(matrixOne, matrixTwo);
        System.out.println("The result is:");
        addGivenMatrix(matrixOne, matrixTwo);
        operations();
    }
    protected void multiplyByConstant() {
        Application matrixByUser = new Application();
        getUserInput(matrixByUser);
        int scalar = sc.nextInt();
        System.out.println("The result is:");
        multiplyByConstantGivenMatrix(matrixByUser, scalar);
        operations();
    }
    protected void multiplyTwoMatrix() {
        Application matrixOne = new Application();
        Application matrixTwo = new Application();
        getUserInput(matrixOne, matrixTwo);
        System.out.println("The result is:");
        multiplyGivenMatrix(matrixOne, matrixTwo);
        operations();

    }
    protected void transpose() {
        System.out.println("1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        transposeCase(choice);
        operations();
    }

    protected void determinant(){
        Application matrixByUser = new Application();
        getUserInput(matrixByUser);
        System.out.println("The Result is:");
        System.out.println(determinantOfMatrix(matrixByUser.matrix, matrixByUser.getMatrixRow()));
        operations();
    }

    public void getCofactor(float[][] mat, float[][] temp,
                            int q, int n)
    {
        int i = 0, j = 0;

        // Looping for each element of
        // the matrix
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                // Copying into temporary matrix
                // only those element which are
                // not in given row and column
                if (row != 0 && col != q)
                {
                    temp[i][j++] = mat[row][col];
                    // Row is filled, so increase
                    // row index and reset col
                    // index
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /* Recursive function for finding determinant
    of matrix. n is current dimension of mat[][]. */
    public float determinantOfMatrix(float[][] mat, int n)
    {
        float D = 0; // Initialize result

        // Base case : if matrix contains single
        // element
        if (n == 1)
            return mat[0][0];

        // To store cofactors
        float[][] temp = new float[n][n];

        // To store sign multiplier
        int sign = 1;

        // Iterate for each element of first row
        for (int f = 0; f < n; f++)
        {
            // Getting Cofactor of mat[0][f]
            getCofactor(mat, temp, f, n);
            D += sign * mat[0][f]
                    * determinantOfMatrix(temp, n - 1);

            // terms are to be added with
            // alternate sign
            sign = -sign;
        }

        return D;
    }



    private void addGivenMatrix(Application matrixOne, Application matrixTwo){
        for (int i = 0; i < matrixOne.getMatrixRow(); i++) {
            for (int j = 0; j < matrixOne.getMatrixColumn(); j++) {
                float elemAdd = matrixOne.matrix[i][j] + matrixTwo.matrix[i][j];
                System.out.print(elemAdd + " ");
            }
            System.out.println();
        }
    }
    private void multiplyByConstantGivenMatrix(Application matrixByUser, int scalar){
        for(int i = 0; i < matrixByUser.getMatrixRow(); i++){
            for(int j = 0; j < matrixByUser.getMatrixColumn(); j++){
                int elm = (int)matrixByUser.matrix[i][j] * scalar;
                System.out.print(elm + " ");
            }
            System.out.println();
        }
    }
    private void multiplyGivenMatrix(Application matrixOne, Application matrixTwo){

        if (matrixTwo.getMatrixRow() != matrixOne.getMatrixColumn()) {
            System.out.println("Multiplication Not Possible");
            return;
        }
        float varToStoreRes = 0;
        for (int i = 0; i < matrixOne.getMatrixRow(); i++) {
            for (int j = 0; j < matrixTwo.getMatrixColumn(); j++) {
                for (int k = 0; k < matrixTwo.getMatrixRow(); k++) {
                    varToStoreRes += matrixOne.matrix[i][k] * matrixTwo.matrix[k][j];
                }
                System.out.println(varToStoreRes + " ");
                varToStoreRes = 0;
            }
        }
    }
    private void transposeCase(int choice){
        Application matrixByUser = new Application();

        switch (choice){
            case 1: mainDiagonal(matrixByUser);
                break;
            case 2: sideDiagonal(matrixByUser);
                break;
            case 3: verticalDiagonal(matrixByUser);
                break;
            case 4: horizontalDiagonal(matrixByUser);
                break;
            default:
                System.out.println("Wrong Input");
                transpose();
                break;
        }

    }


    private void mainDiagonal(Application matrixByUser){
        getUserInput(matrixByUser);
        int length = matrixByUser.getMatrixRow();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i < j){
                   // swap(matrixByUser.matrix[i][j], matrixByUser.matrix[length-i-1][length-j-1]);
                    float temp = matrixByUser.matrix[i][j];
                    matrixByUser.matrix[i][j] = matrixByUser.matrix[j][i];
                    matrixByUser.matrix[j][i] = temp;

                }
            }
        }
        printMatrix(matrixByUser);
    }
    private void sideDiagonal(Application matrixByUser){
        getUserInput(matrixByUser);
        int length = matrixByUser.getMatrixRow();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((i + j) >= length){
                 //   swap(matrixByUser.matrix[i][j], matrixByUser.matrix[length - (j+1)][length - (i+1)]);
                    float temp = matrixByUser.matrix[i][j];
                    matrixByUser.matrix[i][j] = matrixByUser.matrix[length - (j+1)][length - (i+1)];
                    matrixByUser.matrix[length - (j+1)][length - (i+1)] = temp;

                }
            }
        }
        printMatrix(matrixByUser);
    }
    private void verticalDiagonal(Application matrixByUser){
        getUserInput(matrixByUser);
        int length = matrixByUser.getMatrixRow();

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length/2; j++) {
        //        swap(matrixByUser.matrix[i][j], matrixByUser.matrix[i][(length-1) - j] );
                float temp = matrixByUser.matrix[i][j];
                matrixByUser.matrix[i][j] = matrixByUser.matrix[i][(length-1) - j];
                matrixByUser.matrix[i][(length-1) - j] = temp;
            }
        }
        printMatrix(matrixByUser);
    }
    private void horizontalDiagonal(Application matrixByUser){
        getUserInput(matrixByUser);

        int length = matrixByUser.getMatrixRow();

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length/2; j++) {
               // swap(matrixByUser.matrix[j][i], matrixByUser.matrix[i][length-1-j]);
                float temp = matrixByUser.matrix[j][i];
                matrixByUser.matrix[j][i] = matrixByUser.matrix[length-1-j][i];
                matrixByUser.matrix[length-1-j][i] = temp;
            }
        }
        printMatrix(matrixByUser);
    }
/*
JAVA IS PASS BY VALUE -- REMEMBER BOI
    private void swap(float var1, float var2){
        float temp = var1;
        var1 = var2;
        var2 = temp;
    }

 */
    private void printMatrix(Application matrixByUser){
        int length = matrixByUser.getMatrixRow();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrixByUser.matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
