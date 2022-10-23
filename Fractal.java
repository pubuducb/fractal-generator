import javax.swing.*;
import java.awt.Dimension;
import java.awt.*;

// A CLASS TO RUN THE MAIN METHOD AND TO HANDLE CL ARGUMENTS
class Fractal{
    public static void main(String[] args){

        JFrame frame = new JFrame("Fractals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ARGUMENT HANDLING
        try{
            // DEFAULT ARGUMENT
            if (args.length == 0)
                frame.setContentPane(new Mandelbrot(800, 800));

            else if (args[0].equals("Mandelbrot")){
                if (args.length == 1)
                    frame.setContentPane(new Mandelbrot(800, 800));
                else if (args.length == 5)
                    frame.setContentPane(new Mandelbrot(800, 800, Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4])));
                else if (args.length == 6)
                    frame.setContentPane(new Mandelbrot(800, 800, Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Integer.parseInt(args[5])));
            }
                    
            else if (args[0].equals("Julia")){
                if (args.length == 1)
                    frame.setContentPane(new Julia(800, 800));
                else if (args.length == 3)
                    frame.setContentPane(new Julia(800, 800, Double.parseDouble(args[1]), Double.parseDouble(args[2])));
                else if (args.length == 4)
                    frame.setContentPane(new Julia(800, 800, Integer.parseInt(args[3]), Double.parseDouble(args[1]), Double.parseDouble(args[2])));
            }
            else{
                // USAGE
                System.out.println("Wrong use of CL Arguments");
                System.out.println("Usage: java Fractal [Mandelbrot/Julia]");
                System.out.println("Usage: java Fractal Mandelbrot [-1 1 -1 1] [1000]");
                System.out.println("Usage: java Fractal Julia [-0.4 0.6] [1000]");
            }
        }
        catch (Exception e){
            // ERROR MESSAGE AND USAGE
            System.out.println("There's an error!");
            System.out.println("Usage: java Fractal [Mandelbrot/Julia]");
            System.out.println("Usage: java Fractal Mandelbrot [-1 1 -1 1] [1000]");
            System.out.println("Usage: java Fractal Julia [-0.4 0.6] [1000]");
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}