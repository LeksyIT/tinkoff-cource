package secondlesson.second_task;

import secondlesson.second_task.Account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountThreadDeadLock implements Runnable {

    private final Account accountFrom;
    private final Account accountTo;
    private final int money;
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);
    private static int numOfThreads;
    private static int currentThreadId;
    private final int threadId;

    public AccountThreadDeadLock(Account accountFrom, Account accountTo, int money) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.money = money;
        threadId = numOfThreads++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4_000; i++) {
            if (currentThreadId == threadId) {
                synchronized (accountFrom) {
                    synchronized (accountTo) {
                        cardTransaction(accountTo, accountFrom);
                    }
                }
            } else {
                synchronized (accountTo) {
                    synchronized (accountFrom) {
                        cardTransaction(accountTo, accountFrom);
                    }
                }
            }
            System.out.println("Сумма на аккаунтах " + accountFrom.getCacheBalance() + " " + accountTo.getCacheBalance());
        }
        System.out.println("finish!!!");
    }

    private void cardTransaction(Account accountTo, Account accountFrom) {
        accountFrom.takeOffMoney(money);
        accountTo.addMoney(money);
        System.out.println("Перевод на сумму " + money + " с аккаунта " + accountFrom.getId() + " на аккаунт " + accountTo.getId());
        currentThreadId = threadId == numOfThreads - 1 ? 0 : threadId + 1;
    }
}
