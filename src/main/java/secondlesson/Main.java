package secondlesson;

import secondlesson.first_task.LegV1;
import secondlesson.first_task.LegV2;
import secondlesson.second_task.Account;
import secondlesson.second_task.AccountThread;
import secondlesson.second_task.AccountThreadDeadLock;
import secondlesson.third_task.WorkOnMachine;
import secondlesson.third_task.WorkOnMachineSink;
import secondlesson.third_task.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
//        //1.1
//        CompletableFuture.allOf(
//                CompletableFuture.runAsync(new LegV1("left")),
//                CompletableFuture.runAsync(new LegV1("right"))
//        ).join();
//        //1.2
//        CompletableFuture.allOf(
//                CompletableFuture.runAsync(new LegV2("left")),
//                CompletableFuture.runAsync(new LegV2("right"))
//        ).join();

//        //2 DeadLock
//        Account firstAccount = new Account(100_000,1);
//        Account secondAccount = new Account(100_000,2);
//
//        AccountThreadDeadLock firstThread = new AccountThreadDeadLock(firstAccount, secondAccount, 100);
//        AccountThreadDeadLock secondThread = new AccountThreadDeadLock(secondAccount, firstAccount, 100);
//
//        CompletableFuture.allOf(
//                CompletableFuture.runAsync(firstThread),
//                CompletableFuture.runAsync(secondThread)
//        ).join();
//
//        System.out.println("Cash balance of the first account: " + firstAccount.getCacheBalance());
//        System.out.println("Cash balance of the second account: " + secondAccount.getCacheBalance());
//        //2 fixDeadLock
//        Account firstAccount = new Account(100_000_000, 1);
//        Account secondAccount = new Account(100_000_000, 2);
//
//        AccountThread firstThread = new AccountThread(firstAccount, secondAccount, 100);
//        AccountThread secondThread = new AccountThread(secondAccount, firstAccount, 100);
//
//        CompletableFuture.allOf(
//                CompletableFuture.runAsync(firstThread),
//                CompletableFuture.runAsync(secondThread)
//        ).join();
//
//        System.out.println("Cash balance of the first account: " + firstAccount.getCacheBalance());
//        System.out.println("Cash balance of the second account: " + secondAccount.getCacheBalance());

//        //3 FixedThreadPool
//        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(5);
//        List<Worker> workerList = new ArrayList<>();
//        for (int i = 0; i < 8; i++) {
//            workerList.add(new Worker(String.valueOf(i)));
//        }
//        for (int i = 0; i < 8; i++) {
//            threadPoolExecutor.execute(new WorkOnMachine(workerList.get(i)));
//        }
//        System.out.println("Конец работы");
//        //java.util.concurrent синхронайзер
//        for (int i = 0; i < 8; i++) {
//            new Thread(new WorkOnMachineSink(new Worker(String.valueOf(i)))).start();
//        }
//        System.out.println("Конец работы");

    }
}
