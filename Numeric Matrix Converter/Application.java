package processor;

public class Application extends Main{
    private int matrixRow, matrixColumn;
    float[][] matrix;

    public void setMatrixColumn(int matrixColumn) {
        this.matrixColumn = matrixColumn;
    }
    public void setMatrixRow(int matrixRow) {
        this.matrixRow = matrixRow;
    }

    public void getMatrix(){
        matrix = new float[getMatrixRow()][getMatrixColumn()];
        for(int i = 0; i < getMatrixRow(); i++){
            for(int j = 0; j < getMatrixColumn(); j++){
                matrix[i][j] = sc.nextFloat();
            }
        }
    }

    public int getMatrixColumn() {
        return matrixColumn;
    }
    public int getMatrixRow() {
        return matrixRow;
    }

    protected void operations(){
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "5. Calculate a determinant\n" +
                "0. Exit");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        performOperations(choice);
    }

    protected void performOperations(int choice) {
        Operations matrixOperations = new Operations();
        switch (choice){
            case 1: matrixOperations.addMatrix();
                break;
            case 2: matrixOperations.multiplyByConstant();
                break;
            case 3: matrixOperations.multiplyTwoMatrix();
                break;
            case 4: matrixOperations.transpose();
                    break;
            case 5: matrixOperations.determinant();
                break;
            case 0: System.exit(0);
                break;
            default:
                System.out.println("Wrong Input");
                operations();
                break;
        }
    }

    protected void getSizeOfMatrix(){
        setMatrixRow(sc.nextInt());
        setMatrixColumn(sc.nextInt());
    }



}
