import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static Man character = new Man();
    private static Man enemy = new Man();
    private static Man enemy2 = new Man();

    private static Man lover = new Man();
    private static Man boss = new Man();

    public static void game() {
        System.out.println("вы зашли в игру");
        System.out.println("введите имя главного героя");
        String characterName = scanner.next();
        System.out.println("введите возраст главного героя");
        int characterAge = scanner.nextInt();
        System.out.println("введите пол главного героя");
        boolean characterSexType = scanner.hasNext();
        character = new Man(characterAge, 40, characterSexType, characterName, 10, 20);
        System.out.println("введите имя первого врага");
        String enemyName = scanner.next();
        System.out.println("введите возраст первого врага");
        int enemyAge = scanner.nextInt();
        System.out.println("введите пол первого врага");
        boolean enemySexType = scanner.hasNext();
        enemy = new Man(enemyAge, 120, enemySexType, enemyName, 70, 130);
        System.out.println("введите имя второго врага");
        String enemy2Name = scanner.next();
        System.out.println("введите возраст второго врага");
        int enemy2Age = scanner.nextInt();
        System.out.println("введите пол второго врага");
        boolean enemy2SexType = scanner.hasNext();
        enemy2 = new Man(enemy2Age, 150, enemy2SexType, enemy2Name, 100, 170);
        System.out.println("введите имя главного босса");
        String bossName = scanner.next();
        System.out.println("введите возраст главного босса");
        int bossAge = scanner.nextInt();
        System.out.println("введите пол главного босса");
        boolean bossSexType = scanner.hasNext();
        boss = new Man(bossAge, 200, bossSexType, bossName, 150, 200);
        System.out.println("введите имя любовницы");
        String loverName = scanner.next();
        System.out.println("введите возраст любовницы");
        int loverAge = scanner.nextInt();
        System.out.println("введите пол любовницы");
        boolean loverSexType = scanner.hasNext();
        lover = new Man(loverAge, 50, loverSexType, loverName, 30, 80);
        System.out.println("ИГРА НАЧАЛАСЬ!!!");
        System.out.println(boss.getNick() + " напал на " + character.getNick());
        System.out.println(character.getNick() + "получил пизды");
    }

    private static void startGame() {
        System.out.println("""
                Его силы на исходе, надо восстановится
                персонаж должен покушать
                1.покушать - 20$
                """);
        System.out.println("баланс равен - " + balance());
        int choice = scanner.nextInt();
        if (choice == 1) {
            character.eat();
            System.out.println("баланс - " + balance());
            System.out.println("здоровье - " + health());
            System.out.println("сила - " + power());
        } else {
            startGame();
        }
        System.out.println(character.getNick() + "должен поработать чтобы получить деньги");
        job();
        System.out.println("что будет делать дальше " + character.getNick());
    }

    private static void action() {
        System.out.println("""
                1.потренироваться в качалке
                2.провести тяжёлую тренировку в качалке
                3.заняться любовью
                4.убить человека
                5.поспать
                6.покушать
                7.пойти на работу
                """);
        int act = scanner.nextInt();
        if (act == 1) {
            training();
        } else if (act == 2) {
            hardTraining();
        } else if (act == 3) {

        }
    }

    private static void fuck() {
        System.out.println("чтобы заняться любовью у" + character.getNick() +
                " должно быть больше сил чем у " + lover.getNick());
        character.rape(character, lover);
    }

    private static void hardTraining() {
        System.out.println("чтобы потренироваться нужны деньги");
        System.out.println("баланс - " + balance());
        if (character.getCash() < 100) {
            System.out.println("недостаточно денег");
            action();
        }
        System.out.println("""
                1.потренироваться - 100
                """);
        int choice1 = scanner.nextInt();
        if (choice1 == 1) {
            character.hardWorkout();
            System.out.println("баланс - " + balance());
            System.out.println("здоровье - " + health());
            System.out.println("сила - " + power());
        } else {
            hardTraining();
        }
    }

    private static void training() {
        System.out.println("чтобы потренироваться нужны деньги");
        System.out.println("баланс - " + balance());
        if (character.getCash() < 50) {
            System.out.println("недостаточно денег");
            action();
        }
        System.out.println("""
                1.потренироваться
                """);
        int choice1 = scanner.nextInt();
        if (choice1 == 1) {
            character.workout();
            System.out.println("баланс - " + balance());
            System.out.println("здоровье - " + health());
            System.out.println("сила - " + power());
        } else {
            training();
        }
    }

    private static void job() {
        System.out.println("чтобы поработать нужны силы");
        System.out.println("сила - " + power());
        if (character.getStrong() < 20) {
            System.out.println("недостаточно сил");
            action();
        }
        System.out.println("""
                1.пойти на работу - 20
                """);
        int choice1 = scanner.nextInt();
        if (choice1 == 1) {
            character.work();
            System.out.println("баланс - " + balance());
            System.out.println("сила - " + power());
        } else {
            job();
        }
    }

    private static int balance() {
        return character.getCash();
    }

    private static int health() {
        return character.getHp();
    }

    private static int power() {
        return character.getStrong();
    }

    private static int years() {
        return character.getAge();
    }
}
