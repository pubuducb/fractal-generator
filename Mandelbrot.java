import javax.swing.*;
import java.awt.Dimension;
import java.awt.geom.Line2D;
import java.awt.*;

// A SPECIFIC CLASS TO PRINT THE MANDELBROT FRACTEL
class Mandelbrot extends Panel{

    // THREE CONSTRUCTORS DECLARED FOR THREE POSSIBLE ARGUMENT COMBINATIONS
    public Mandelbrot(int width, int height, double left, double right, double down, double up, int iterations)
        { super(width, height, left, right, down, up , iterations); }

    public Mandelbrot(int width, int height, double left, double right, double down, double up)
        { this(width, height, left, right, down, up , 1000); }

    public Mandelbrot(int width, int height) { this(width, height, -1, 1, -1, 1); }

    @Override
    protected void paintComponent(Graphics g) {

		super.paintComponent(g);

        int x, y, i;
        double a, b;
        ComplexFractal c;
        
        // FOR EACH PIXEL IN THE PANEL...
		for (x = 0; x < 800; x++)
            for (y = 0; y < 800; y++){

                // GETS THE COMPLEX NUMBER CORRESPONDING TO THE POINT
                a = ((double)(this.left + x * (this.right - this.left) / 800));
                b = ((double)(this.down + (800 - y) * (this.up - this.down) / 800));

                c = new ComplexFractal(a, b);

                // THE PROCESS THAT CHECKS WHETHER THE COMPLEX NUMBER IS IN THE SET
                int it = super.isInRange(c);

                // IF IT IS IN THE SET, THE PIXEL GETS PRINTED WITH A PERTICULAR COLOR, OTHERWISE WITH BLACK
                if (it < this.iterations)

                    // THE CORRESPONDING COLOR IS OBTAINED FROM A HUE SPECTRUM
                    // WITH RESPECT TO THE NUMBER OF ITERATIONS, THE COLOR INTENCITY CHANGES 
                    super.printPoint((Graphics2D)g, Color.getHSBColor(it/100f , 1, 1), new Point(x, y));
                else
                    super.printPoint((Graphics2D)g, Color.BLACK, new Point(x, y));
            }
    }
}