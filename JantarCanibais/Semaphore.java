package JantarCanibais;

class Semaphore {
    int value;

    public Semaphore(int initial) {
        this.value = initial;
    }

    public synchronized void up() {
        value++;
        notify();
    }

    public synchronized void down() throws InterruptedException {
        while (value <= 0){
            wait();
        }
            
        value--;
        notify(); // Notificar os canibais que o recurso foi atualizado
    }
}
