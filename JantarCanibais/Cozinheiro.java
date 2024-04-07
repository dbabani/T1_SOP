package JantarCanibais;

import java.util.Random;

public class Cozinheiro extends Thread{
    private Semaphore mesa;
    private int porcoes;
    private Random random = new Random();


    public Cozinheiro(Semaphore mesa,int porcoes){
        this.mesa = mesa;
        this.porcoes=porcoes;

    }
    
    @Override
    public void run(){
        while (true) {
            try {
                
                while (mesa.value > 0) {
                    Thread.sleep(100);
                }
                
                 
                if(mesa.value == 0){
                // Cozinheiro acorda e prepara mais porções
                System.out.println("\nCozinheiro:vou preparar a comida.");
                mesa.value = this.porcoes;
                System.out.println("Comida pronta! Acordem canibais!");
                mesa.up();
                } 
                
                
                 // Notifica os canibais que mais porções estão disponíveis
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
