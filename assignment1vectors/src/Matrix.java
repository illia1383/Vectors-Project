/**
 * @author Illia Lotfalian
 * @version 1.0
 * @since 2023-02-08
 */




public class Matrix {
    //intializing the instance variables
    private int numRows;
    private int numCols;
    private double[][] data;

    // making the constructors

    /**
     * Matrix constructor
     * @param r
     * @param c
     */
    public Matrix(int r , int c ){
        numRows = r;
        numCols = c;
        data = new double[numRows][numCols];
    }

    /**
     *
     * @param r
     * @param c
     * @param linArr
     */
    public Matrix (int r, int c , double[] linArr){
        numRows = r;
        numCols = c;
        data = new double[r][c];
        for (int i = 0; i<r; i++){ // converting the array into 2d array by using a nested forloop
            for (int j = 0; j<c; j++ ) {
                data[i][j] = linArr[numCols * i + j];

            }
        }
    }
    // Getters and Setters
    public int getNumRows() {
        return numRows;
    }
    public int getNumCols() {
        return numCols;
    }

    public double[][] getData() {
        return data;
    }
    public double getElement(int r , int c ){
        return data[r][c];
    }
    public void setElement(int r , int c , double value){
       data[r][c] =  value;

    }


    /**
     * Transpose method, used to swap rows and columns
     */
    public void transpose(){

        Matrix m = new Matrix(numCols,numRows); //making the new matrix (intilizating) the new matrix that will be transposed
        // for loop to swap the rows and columns
        for(int i=0; i<m.getNumRows(); i++){
            for (int j=0; j<getNumRows(); j++){
                m.setElement(i,j,getElement(j,i));
            }
        }
        // setting the varibles of matrix to the  transposed matrix
        numRows = m.getNumRows();
        numCols = m.getNumCols();
        data = m.getData();
    }

    /**
     * Matrix Multiply
     * @param scalar
     * @return
     */
    public Matrix multiply (double scalar){
        Matrix m2 = this;
        for(int i = 0; i< data.length;i++){
            for (int j = 0; j< data[i].length; j++){
                m2.setElement(i,j, m2.getElement(i,j) * scalar);
            }
        }
        return m2;
    }

    /**
     * Matrix multiply
     * @param other
     * @return
     */

    public Matrix multiply (Matrix other){
        if(numCols != other.getNumRows()){
            return null;
        }

        Matrix m2 = new Matrix(numRows, other.getNumRows()); //making a new matrix using num rows from this and other  gotta be the same
        double value;
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j<getNumCols(); j++){
                value = 0;
                for (int h = 0; h < other.getNumCols(); h++){
                    value += data[i][h] * other.getElement(h,j);
                }
                m2.setElement(i,j,value);
            }
        }
        return m2;
    }
    public String toString(){
        String s = "";
        if (data.length==0){
            return ("Empty matrix");
        }
        else{// loops through the matrix to format the print out matrix
            for(int i=0; i<data.length; i++){
                for (int j=0; j<data[i].length; j++){
                    s += String.format("%8.3f", getElement(i, j));
                }
                if(i + 1 != data.length){
                    s += "\n";
                }

            }
        }
        return s;

    }


    public static void main(String[] args) {
        double[] lin = {1,2,3,4,5,6};
        Matrix m1 = new Matrix(3,2,lin);
        System.out.println(m1.toString());

    }
}