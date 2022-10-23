// A CLASS TO HOLD COMPLEX NUMBERS AND TO MANIPULATE THEM
class Complex{ 

    // SINCE THE SUBCLASS, ComplexFractal HANDLES THE ATTRIBUTES OF THIS CLASS, THE ACCESS MODIFIER OF THEM HAS MADE DEFAULT
    double a, b;                                                                                                               

    public Complex(double a, double b){                                                                                               
        this.a = a;                                                                                                                   
        this.b = b;                                                                                                                   
    }                                                                                                                                 
    
    // GETTING THE SQUARE OF THE ABSOLUTE VALUE IS MORE EFFICIENT
    public double getAbsoluteSquare() { return a * a + b * b; }                                                                                                                                 
}                                                                                                                                     