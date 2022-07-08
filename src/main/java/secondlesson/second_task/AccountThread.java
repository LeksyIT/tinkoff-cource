package secondlesson.second_task;

import secondlesson.second_task.Account;

public class AccountThread implements Runnable {

    private final Account accountFrom;
    private final Account accountTo;
    private final int money;
    private static final Object mutex = new Object();


    public AccountThread(Account accountFrom, Account accountTo, int money) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.money = money;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4_000; i++) {
            synchronized (mutex) {
                accountFrom.takeOffMoney(money);
                accountTo.addMoney(money);
                System.out.println("Перевод на сумму " + money + " с аккаунта " + accountFrom.getId() + " на аккаунт " + accountTo.getId());
            }
        }
        System.out.println("finish!!!");
    }
}
