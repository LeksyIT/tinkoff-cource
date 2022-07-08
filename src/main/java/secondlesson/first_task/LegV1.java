package secondlesson.first_task;

import java.util.concurrent.CompletableFuture;

public class LegV1 implements Runnable {

    private final String name;
    private final static Object lock = new Object();
    private static int numOfThreads;
    private static int currentThreadId;
    private final int threadId;

    public LegV1(String name) {
        this.name = name;
        threadId = numOfThreads++;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (currentThreadId == threadId) {
                    System.out.println(name);
                    currentThreadId = threadId == numOfThreads - 1 ? 0 : threadId + 1;
                }
            }
        }
    }
}