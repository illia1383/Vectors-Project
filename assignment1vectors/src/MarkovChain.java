/**
 * @author Illia Lotfalian
 * @version 1.0
 * @since 2023-02-08
 */
public class MarkovChain {
    // making the private instance variables
    private Vector stateVector;
    private Matrix transitionMatrix;

    /**
     * intiliazing the instance variables
     * @param sVector
     * @param tMatrix
     */
    public MarkovChain(Vector sVector, Matrix tMatrix){
        stateVector = sVector;
        transitionMatrix = tMatrix;

    }
    // this method checks to see if the instance varibales are valid

    /**
     * is valid method to check if the conditions are met or not
     * @return
     */

    private boolean rangeReq(double val){
        if (val >= 0.99 && val <= 1.01){
            return true;
        }else{
            return false;
        }
    }
    public boolean isValid(){
        // checks to see if the matrix is square or not returns false if it is not
        if (transitionMatrix.getNumRows() != transitionMatrix.getNumCols()){   // returns false because it is not equal
            return false;
        }
        //checks to see if the size of the matrix and vector are equal if they arent it returns false
        if (transitionMatrix.getNumCols() != stateVector.getNumCols()){
            return false;
        }
        double val = 0;
        for(int i = 0; i < stateVector.getNumCols(); i++){
            val += stateVector.getElement(i);
        }
        if (rangeReq(val) == false) {
            return false;
        }
        for (int i = 0; i < transitionMatrix.getNumCols(); i++){
            val = 0;
            for (int j = 0; j < transitionMatrix.getNumRows(); j++){
                val += transitionMatrix.getElement(i,j);
            }
            if (rangeReq(val) == false){ // once again checking to see if val is between 0.99 and 1
                return false;
            }
        }

        //retuns true if all conditions are met
        return true;




    }

    /**
     * ComputePomputeProbablityMatrix
     *
     * @param numSteps
     * @return
     */
    public Matrix computeProbabilityMatrix(int numSteps){
        if (isValid() ==  false){
            return null;
        }
        Matrix m = transitionMatrix;
        for (int i = 0; i < numSteps - 1; i++){
            m = m.multiply(transitionMatrix);

        }
        return stateVector.multiply(m);
    }

}



