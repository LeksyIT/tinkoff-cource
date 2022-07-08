package secondlesson.first_task;

public class LegV2 implements Runnable {

    private final String name;
    private static int numOfThreads;
    private static int currentThreadId;
    private final int threadId;

    public LegV2(String name) {
        this.name = name;
        threadId = numOfThreads++;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (System.out) {
                if (currentThreadId == threadId) {
                    System.out.println(name);
                    currentThreadId = threadId == numOfThreads - 1 ? 0 : threadId + 1;
                }
            }

        }
    }
}
