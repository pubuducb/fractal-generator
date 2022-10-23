import javax.swing.*;
import java.awt.Dimension;
import java.awt.geom.Line2D;
import java.awt.*;

// A SPECIFIC CLASS TO PRINT THE JULIA FRACTEL
class Julia extends Panel{

    private double constA, constB;

    // THREE CONSTRUCTORS DECLARED FOR THREE POSSIBLE ARGUMENT COMBINATIONS
    public Julia(int width, int height, int iterations, double constA, double constB){
        super(width, height, -1, 1, -1, 1, iterations);
        this.constA = constA;
        this.constB = constB;
    }

    public Julia(int width, int height, double constA, double constB) { this(width, height, 1000, constA, constB); }

    public Julia(int width, int height) { this(width, height, -0.4, 0.6); }

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
                // SINCE THE CARTESIAN PLANE IS FIXED FOR JULIA SET, THE COMPLEX VALUES ARE TAKEN AS FOLLOWS;
                a = ((double)(x - 400)) / 400;
                b = ((double)(400 - y)) / 400;
                
                c = new ComplexFractal(a, b, this.constA, this.constB);

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