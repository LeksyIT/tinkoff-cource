package secondlesson.third_task;

import secondlesson.third_task.Worker;

public class WorkOnMachine implements Runnable {

    private final String name;

    public WorkOnMachine(Worker worker) {
        this.name = worker.getName();
    }

    @Override
    public void run() {
        workOnMachine(name);
    }

    private static void workOnMachine(String name) {
        try {
            System.out.println("worker " + name + " occupy production machine ...");
            Thread.sleep(2000);
            System.out.println("worker " + name + " release production machine");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
