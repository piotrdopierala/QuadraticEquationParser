package pl.dopierala;

public class QuadraticEquationSolver {
    public static double[] solve(QuadraticEquation eq){
        //Ax^2+Bx+C=0;

        double delta = Math.pow(eq.getA(),2)-4*eq.getA()*eq.getB();
        double sqrtDelta = Math.sqrt(delta);

//        if(Double.isNaN(sqrtDelta))
//            return 0;

        double x1=(-eq.getB()-sqrtDelta)/(2*eq.getA());
        double x2=(-eq.getB()+sqrtDelta)/(2*eq.getA());

        return new double[] {x1,x2};
    }
}
