package secondlesson.second_task;

public class Account {

    private int cacheBalance;
    private final int id;

    public Account(int cacheBalance, int id) {
        this.id = id;
        this.cacheBalance = cacheBalance;
    }

    public void addMoney(int money) {
        this.cacheBalance += money;
    }

    public void takeOffMoney(int money) {
        if (this.cacheBalance < money) {
            return;
        }

        this.cacheBalance -= money;
    }

    public int getCacheBalance() {
        return cacheBalance;
    }

    public int getId() {
        return id;
    }

}
