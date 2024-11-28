import graphics.Asset;
import state.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.sql.SQLOutput;

public class Window extends JFrame implements Runnable {
    public static final int  WIDTH = 800,HEIGHT=600;
    private Canvas canvas;
    private Thread thread; //es un hilo interno no entendi bien para que funciona
    private  boolean running = false;


    private BufferStrategy bs;
    private Graphics g;


    private final int FPS = 60;
    private double  TARGETTIME = 1000000000/ FPS;
    private double delta = 0;
    private int AVERAGEFPS = FPS;

    private GameState gameState;

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


    private void update(){
        gameState.update();
    }

    private void draw(){
        bs = canvas.getBufferStrategy();

        if (bs == null){
            canvas.createBufferStrategy(3);
            return;
        }

        g= bs.getDrawGraphics();
        //---------empiza el dibujo
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT );
        gameState.draw(g);
        g.drawString(""+AVERAGEFPS,10,10);

        //---------termina el dibujo

        g.dispose();
        bs.show();

    }


    private void init(){

        Asset.init();
        gameState = new GameState();
    }

    @Override
    public void run() {

        long now = 0;
        long lastTime = System.nanoTime();
        int frames=0;
        long time = 0;

        init();


        while (running){
            now = System.nanoTime();
            delta += (now- lastTime)/TARGETTIME;
            time += (now- lastTime);
            lastTime=now;

            if (delta >= 1){
                update();
                draw();
                delta --;
                frames++;
            }
            if (time >= 1000000000){
                AVERAGEFPS= frames;
                frames = 0;
                time = 0;
            }

        }


        stop();
    }

    private void start(){
        thread = new Thread(this);/*significa que esta va a ser la clase que implementa la interface Runnable
        en otras palabras esta clase recibe como parametro en el constructor una clase que implementa la interface Runnable
        que en este caso es nuestra clase Window*/
        thread.start();//llama al metodo run de arriba
        running = true;
    }

    private void stop(){
       try{
           thread.join();
           running = false;
       } catch (InterruptedException e){
           e.printStackTrace();
       }
    }

}