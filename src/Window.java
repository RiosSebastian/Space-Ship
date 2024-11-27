import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {
    public static final int  WIDTH = 800,HEIGHT=600;
    private Canvas canvas;

    private Thread thread; //es un hilo interno no entendi bien para que funciona

    private  boolean running;

    public Window(){
        setTitle("Space Ship Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//con esto permitimos que la ventana se pueda cerrar cuando se haga clik en la X
        setResizable(false);//para que la ventana no se pueda redimencionar
        setLocationRelativeTo(null);//permite que la ventana se desplieje en el centro de la pantalla
        setVisible(true);//hacer visible la ventana

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(true);//le permite recibir entradas por parte de teclado


        add(canvas);//agregamos el canvas a la ventana

    }



    public static void main(String[] args) {

      new Window().start();
    }

    @Override
    public void run() {



        stop();
    }

    private void start(){
        thread = new Thread(this);/*significa que esta va a ser la clase que implementa la interface Runnable
        en otras palabras esta clase recibe como parametro en el constructor una clase que implementa la interface Runnable
        que en este caso es nuestra clase Window*/
        thread.start();//llama al metodo run de arriba
    }

    private void stop(){
       try{ thread.join();
       } catch (InterruptedException e){
           e.printStackTrace();
       }
    }

}