/**
 * @author Illia Lotfalian
 * @version 1.0
 * @since 2023-02-08
 */


/**
 * Vector class is an inheritance class of Matrix
 */
class Vector extends Matrix{

    public Vector(int c) {

        super(1,c);
    }
    public Vector(int c, double[] linArr){

        super(1,c,linArr); // Making it 1 row also inlitilizating linArr
    }


    public double getElement(int c) {

        return super.getElement(0, c);
    }
}
