import javax.swing.*;
import java.awt.Dimension;
import java.awt.geom.Line2D;
import java.awt.*;

// A CLASS TO PRINT THE FRACTEL ON THE CANVAS
class Panel extends JPanel{

    private int width, height;

    // SINCE THE SUBCLASSES, Manelbrot AND Julia HANDLE THE FOLLOWING ATTRIBUTES OF THE CLASS, THE ACCESS MODIFIERS OF THEM HAS MADE DEFAULT
    int iterations;
    double left, right, down, up;

    public Panel(int width, int height, double left, double right, double down, double up, int iterations){
        this.width = width;
        this.height = height;
        this.left = left;
        this.right = right;
        this.down = down;
        this.up = up;
        this.iterations = iterations;

        // SETS THE DIMENTIONS OF THE PANEL
        setPreferredSize(new Dimension(width, height));
    }

    // A FUNCTION TO PRINT THE PIXEL CORRESPONDING TO THE GIVEN POINT
    public static void printPoint(Graphics2D frame, Color c, Point p) {
		frame.setColor(c);
		frame.draw(new Line2D.Double(p.getX(), p.getY(), p.getX(), p.getY()));
    }

    // THE FOLLOWING METHOD IS FURTHER OVERRIDEN IN THE SUBCLASSES
    @Override
    protected void paintComponent(Graphics g) { super.paintComponent(g); }

    // THE METHOD TO CHECK WHETHER THE COMPLEX NUMBER IS BELONG TO THE FRACTAL
    // PERFORMS THE ITERATION UPTO THE GIVEN (OR THE DEFAULT) VALUE
    // IF THE COMPLEX NUMBER IS IN THE SET, RETURNS THE CORRESPONDING ITERATION
    // IF THE COMPLEX NUMBER IS NOT IN THE SET, THE ULTIMATE VALUE GETS RETURNED
    public int isInRange(ComplexFractal c){

        int i;
        for (i = 0; c.getAbsoluteSquare() <= 4 && i < this.iterations; i++)
            c.nextIteration();
            
        return i;
    }
}