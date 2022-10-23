// A CLASS OF COMPLEX NUMBERS WITH MORE SPECIFIC FEATURES FOR FRACTALS
class ComplexFractal extends Complex{ 

    private double constA, constB, temp;

    public ComplexFractal(double a, double b, double constA, double constB){
        super(a, b);
        this.constA = constA;
        this.constB = constB;
    }

    // SPECIFIC CONSTRUCTOR FOR MANDELBROT FRACTAL
    public ComplexFractal(double constA, double constB) { this(0, 0, constA, constB); }
    
    // A FUNCTION TO PERFORM THE NEXT ITERATION (ADDING THE CONSTANT TO THE SQUARE OF ITSELF)
    public void nextIteration(){
    	this.temp = this.a;                                                                                                         
        this.a = this.a * this.a - this.b * this.b + this.constA;   // a = a^2 - b^2 + a'                                                             
        this.b = 2 * temp * this.b + this.constB;                   // b = 2ab + b'                                                                                   
    }
}