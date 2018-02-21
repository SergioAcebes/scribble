import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);  
        myCanvas.erase();
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }

    /**
     * Draw a triangle on the screen.
     */
    public void drawTriangle(int xPosition, int yPosition)
    {
        Pen pen = new Pen(xPosition,yPosition, myCanvas);
        pen.setColor(Color.GREEN);
        for(int i=0;i<3;i++){    
            pen.move(100);
            pen.turn(-120);

        }
    }

    /**
     * Draw a pentagon on the screen.
     */
    public void drawPentagon(int xPosition, int yPosition)
    {
        Pen pen = new Pen(xPosition,yPosition, myCanvas);
        pen.setColor(Color.GREEN);
        for(int i=0;i<5;i++){    
            pen.move(100);
            pen.turn(-72);

        }
    }

    /**
     * Draw a polygon on the screen.
     */
    public void drawPolygon(int xPosition, int yPosition,int nLados)
    {
        Pen pen = new Pen(xPosition,yPosition, myCanvas);
        pen.setColor(Color.PINK);

        if(nLados > 2){
            for(int i=0;i<nLados;i++){    
                pen.move(300/nLados);
                pen.turn(360/nLados);

            }
        }
        else{
            System.out.println("un poligono tiene que tener al menos 3 lados");
        }
    }
    
    /**
     * Draw a spiral on the screen.
     */
    public void drawSpiral(int xPosition, int yPosition,int nSpiral)
    {
        Pen pen = new Pen(xPosition,yPosition, myCanvas);
        pen.setColor(Color.CYAN);
        for(int i=2;i<nSpiral;i++){    
            pen.move(i*3);
            pen.turn(-90);

        }
    }
    

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));

            pen.randomSquiggle();
        }
    }

    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
