# tinkoff-cource
# 1 задание
### Задача №1

Написать метод, который на вход получает массив (или список) строк в формате 
“имя_игрока количество_очков”. Требуется вывести на экран имя победителя. 
Победителем считается тот, кто набрал больше всех очков и сделал это раньше 
остальных (у нескольких игроков может быть одинаковое количество очков). 
Порядок начисления очков определяется порядком следования элементов в массиве.

Пример:

- на вход: «Ivan 5», «Petr 3», «Alex 10», «Petr 8», «Ivan 6», «Alex 5», 
«Ivan 1», «Petr 5», «Alex 1»
- победитель: Petr
- объяснение: у Alex и Petr одинаково наибольшее количество очков (	16), 
но т.к. Petr набрал их раньше, чем Alex, поэтому победителем является Petr


Реализовать метод showWinner:

```
public static void showWinner(List<String> competitors){
       // implement
}
```


### Задача №2

Дан массив(список) из 1 млн. не отсортированных постов. Требуется найти 10 самых залайканых постов. 
Необходимо реализовать наиболее оптимальное решение по скорости и памяти.

Реализовать метод getTop10

```
public static List<Post> getTop10(List<Post> posts){
       // implement
}

public class Post{
    private String text;
    private Integer likesCount;
}
```


### Задача №3

Задача на Stream API. Необходимо создать класс клиента со следующими полями: 
уникальный идентификатор, имя, возраст. Также у клиента есть список телефонов. 
Класс телефона содержит само значение и тип (стационарный или мобильный). 
Создать массив клиентов и выполнить следующие задания:

   1. Рассчитать суммарный возраст для определенного имени.
   2. Получить Set, который содержит в себе только имена клиентов в порядке их упоминания в исходном массиве.
   3. Узнать, содержит ли список хотя бы одного клиента, у которого возраст больше заданного числа.
   4. Преобразовать массив в Map, у которой ключ - уникальный идентификатор, значение - имя. 
   Поддержать порядок, в котором клиенты добавлены в массив.
   5. Преобразовать массив в Map, у которой ключ - возраст, 
   значение - коллекция клиентов с таким возрастом.
   6. Получить строку, содержащую телефоны всех клиентов через запятую. Предусмотреть, что у клиента телефонов может и не быть.
   7. Найти самого возрастного клиента, которой пользуется стационарным телефоном



### Задача №4
Василий хочет продать автомобиль. 
У Василия много друзей и от кого-то когда-то он слышал, что какая-то 
Наташа хочет купить авто именно его марки. 
Василий проактивный, хочет побыстрее найти покупателя, однако, 
Наташа может быть другом одного или нескольких друзей Василия, 
но может быть и другом Василия через несколько рукопожатий (друг одного друга другого друга ...).

Помогите Василию найти всех Наташ и продать машину, напишите методы поиска по друзьям: 
поиск в ширину, и поиск в глубину, реализовав интерфейс SearchService

```
interface SearchService {
    List<User> searchForFriendsInWidth(User me, String name);
    List<User> searchForFriendsInDepth(User me, String name);
}
```

Входные параметры методов: 
- пользователь, от которого начинаем поиск
- имя пользователя, которого хотим найти
Методы возвращают список всех пользователей, у которых имя совпадает с запрашиваемым.

Класс пользователя:
```
public class User {
    private Long id;
    private String name;
    private List<User> friends;
    public User(String name) {
        this.name = name;
        this.id = new Random().nextLong();
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<User> getFriends() {
        return friends;
    }
    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
```
Метод getFriends возвращает список объектов других пользователей - всех друзей пользователя. 
В этих объектах так же есть списки друзей, и у объектов из этих списков тоже есть 
списки друзей и так далее.

Условимся, что у каждого пользователя есть уникальный идентификатор, но имена 
у пользователей могут совпадать.

Для тестирования можно использовать:
```
public class SearchServiceTest {

    @Test
    public void test1() {
        User vasilii = new User("Василий");
        User arina = new User("Арина");
        User yulya = new User("Юля");
        User evgenii = new User("Евгений");
        User konstantin = new User("Константин");
        User vladimir = new User("Владимир");
        User mariya = new User("Мария");
        User dmitrii = new User("Дмитрий");
        User anatolii = new User("Анатолий");
        User gennadii = new User("Геннадий");
        User anna = new User("Анна");
        User mikhail = new User("Михаил");
        User sergei = new User("Сергей");
        User natasha = new User("Наташа");
        vasilii.setFriends(Arrays.asList(arina, yulya));
        arina.setFriends(Arrays.asList(vasilii, dmitrii));
        yulya.setFriends(Arrays.asList(vasilii, konstantin, evgenii));
        evgenii.setFriends(Arrays.asList(yulya, natasha));
        konstantin.setFriends(Arrays.asList(yulya, vladimir, mariya, natasha));
        vladimir.setFriends(Arrays.asList(konstantin, mariya));
        mariya.setFriends(Arrays.asList(konstantin, vladimir));
        dmitrii.setFriends(Arrays.asList(arina, anatolii, sergei));
        anatolii.setFriends(Arrays.asList(dmitrii, gennadii, mikhail));
        gennadii.setFriends(Arrays.asList(anatolii, anna));
        anna.setFriends(Arrays.asList(gennadii, mikhail));
        mikhail.setFriends(Arrays.asList(anatolii, sergei, anna, natasha));
        sergei.setFriends(Arrays.asList(dmitrii, mikhail));
        natasha.setFriends(Arrays.asList(konstantin, evgenii, mikhail));
 
        SearchService service = new SearchServiceImpl();

        List<User> foundFriends = service.searchForFriendsInDepth(vasilii, "Наташа");
        Assert.assertTrue(foundFriends.contains(natasha));
        foundFriends = service.searchForFriendsInWidth(vasilii, "Наташа");
        Assert.assertTrue(foundFriends.contains(natasha));
    }

    @Test
    public void test2() {
        User vasilii = new User("Василий");
        User arina = new User("Арина");
        User yulya = new User("Юля");
        User evgenii = new User("Евгений");
        User konstantin = new User("Константин");
        User vladimir = new User("Владимир");
        User mariya = new User("Мария");
        User dmitrii = new User("Дмитрий");
        User anatolii = new User("Анатолий");
        User gennadii = new User("Геннадий");
        User anna = new User("Анна");
        User mikhail = new User("Михаил");
        User sergei = new User("Сергей");
        User natasha = new User("Наташа");
        User natasha2 = new User("Наташа");
        vasilii.setFriends(Arrays.asList(arina, yulya));
        arina.setFriends(Arrays.asList(vasilii, dmitrii, natasha2));
        yulya.setFriends(Arrays.asList(vasilii, evgenii));
        evgenii.setFriends(Arrays.asList(yulya));
        konstantin.setFriends(Arrays.asList(vladimir, mariya));
        vladimir.setFriends(Arrays.asList(konstantin));
        mariya.setFriends(Arrays.asList(konstantin, vasilii));
        dmitrii.setFriends(Arrays.asList(arina, anatolii, natasha));
        anatolii.setFriends(Arrays.asList(dmitrii, gennadii));
        gennadii.setFriends(Arrays.asList(anatolii));
        anna.setFriends(Arrays.asList(mikhail));
        mikhail.setFriends(Arrays.asList(sergei, anna));
        sergei.setFriends(Arrays.asList(natasha, mikhail));
        natasha.setFriends(Arrays.asList(dmitrii, sergei));
        natasha2.setFriends(Arrays.asList(arina));

        SearchService service = new SearchServiceImpl();

        List<User> foundFriends = service.searchForFriendsInDepth(vasilii, "Наташа");
        Assert.assertTrue(foundFriends.contains(natasha));
        Assert.assertTrue(foundFriends.contains(natasha2));
        foundFriends = service.searchForFriendsInWidth(vasilii, "Наташа");
        Assert.assertTrue(foundFriends.contains(natasha));
        Assert.assertTrue(foundFriends.contains(natasha2));
    }

    @Test
    public void test3() {
        User vasilii = new User("Василий");
        User arina = new User("Арина");
        User mariya = new User("Мария");
        User vladimir = new User("Владимир");
        User evgenii = new User("Евгений");
        User yulya = new User("Юля");
        User konstantin = new User("Константин");
        User dmitrii = new User("Дмитрий");
        User natasha = new User("Наташа");
        vasilii.setFriends(Arrays.asList(arina, mariya, vladimir, evgenii));
        arina.setFriends(Arrays.asList(vasilii, dmitrii, vasilii));
        yulya.setFriends(Arrays.asList(konstantin, evgenii, vladimir, dmitrii));
        evgenii.setFriends(Arrays.asList(yulya, vasilii, dmitrii));
        konstantin.setFriends(Arrays.asList(vladimir, mariya, yulya, natasha));
        vladimir.setFriends(Arrays.asList(konstantin, vasilii, yulya));
        mariya.setFriends(Arrays.asList(konstantin, vasilii, natasha));
        dmitrii.setFriends(Arrays.asList(arina, evgenii, natasha, yulya));
        natasha.setFriends(Arrays.asList(dmitrii, arina, konstantin, mariya));
        SearchService service = new SearchServiceImpl();
        List<User> foundFriends = service.searchForFriendsInDepth(vasilii, "Наташа");
        Assert.assertTrue(foundFriends.contains(natasha));
        foundFriends = service.searchForFriendsInWidth(vasilii, "Наташа");
        Assert.assertTrue(foundFriends.contains(natasha));
    }
}
```
# 2 задание
### Задача 1. 

Условие. Посмотрите на код ниже. Необходимо модифицировать его так, чтобы обеспечить порядок 
движения ног робота. Если выводится left, то робот двигает левую ногу, если right, то правую. 
Модифицировать можно любой участок кода, но необходимо, чтобы сохранялся запуск 2 потоков. 
Привести не менее 2 вариантов решения
```
public class Leg implements Runnable {

    private final String name;

    public Leg(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        CompletableFuture.allOf(
            CompletableFuture.runAsync(new Leg("left")),
            CompletableFuture.runAsync(new Leg("right"))
        ).join();
    }
}
```

### Задача 2. 

Условие. Даны 2 аккаунта. У каждого аккаунта есть поле, 
отвечающее за количество денег. Также, даны 2 потока: 
поток 1 переводит деньги с аккаунта 1 на аккаунт 2, 
а поток 2 - с аккаунта 2 на аккаунт 1. 
Реализовать перевод денег с одного счета на другой, 
если на нем достаточно средств. При этом реализовать 2 случая:
Ситуацию дедлока
Починить ситуацию дедлока, обеспечив безопасный перевод денег
Класс аккаунта:
```
public class Account {

    private int cacheBalance;

    public Account(int cacheBalance) {
        this.cacheBalance = cacheBalance;
    }

    public void addMoney(int money) {
        this.cacheBalance += money;
    }

    public boolean takeOffMoney(int money) {
        if (this.cacheBalance < money) {
            return false;
        }

        this.cacheBalance -= money;
        return true;
    }

    public int getCacheBalance() {
        return cacheBalance;
    }

}
```

Класс потока:
```
public class AccountThread implements Runnable {

    private final Account accountFrom;
    private final Account accountTo;
    private final int money;

    public AccountThread(Account accountFrom, Account accountTo, int money) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.money = money;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4000; i++) {
            // implement
        }
    }
}
```

Main:
```
public class AccountMain {

    public static void main(String[] args) {
        Account firstAccount = new Account(100_000);
        Account secondAccount = new Account(100_000);

        AccountThread firstThread = new AccountThread(firstAccount, secondAccount, 100);
        AccountThread secondThread = new AccountThread(secondAccount, firstAccount, 100);

        CompletableFuture.allOf(
                CompletableFuture.runAsync(firstThread),
                CompletableFuture.runAsync(secondThread)
        ).join();

        System.out.println("Cash balance of the first account: " + firstAccount.getCacheBalance());
        System.out.println("Cash balance of the second account: " + secondAccount.getCacheBalance());
    }
}
```

### Задача 3

Условие: На заводе 5 станков и 8 фрезеровщиков, которые работают на станках. 
На каждом станке в один момент времени может работать только 1 рабочий. 
Чтобы все работники получили получку за рабочую смену, каждый должен поработать на станке. 

Решить задачу 2мя способами:

- С использованием пула потоков
- С использованием синхронайзера из java.util.concurrent


Для работы на станке можно использовать метод
```
private static void workOnMachine(int workerId) {
        try {
            System.out.println("worker " + workerId + " occupy production machine ...");
            Thread.sleep(2000);
            System.out.println("worker " + workerId + " release production machine");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
```



Вывод в консоль будет примерно таким (только порядок может быть другой):
```
worker 1 occupy production machine ...
worker 3 occupy production machine ...
worker 0 occupy production machine ...
worker 4 occupy production machine ...
worker 2 occupy production machine ...
worker 0 release production machine
worker 2 release production machine
worker 4 release production machine
worker 1 release production machine
worker 3 release production machine
worker 5 occupy production machine ...
worker 6 occupy production machine ...
worker 7 occupy production machine ...
worker 5 release production machine
worker 6 release production machine
worker 7 release production machine
```
