package secondlesson.third_task;

import java.util.concurrent.Semaphore;

public class WorkOnMachineSink implements Runnable {

    private final String name;

    private static final Semaphore SEMAPHORE = new Semaphore(5, true);

    public WorkOnMachineSink(Worker worker) {
        this.name = worker.getName();
    }

    @Override
    public void run() {
        workOnMachine(name);
    }

    private static void workOnMachine(String name) {
        try {
            SEMAPHORE.acquire();
            System.out.println("worker " + name + " occupy production machine ...");
            Thread.sleep(2000);
            System.out.println("worker " + name + " release production machine");
            SEMAPHORE.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
