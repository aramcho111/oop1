import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Man {
    private int age;
    private int cash;
    private boolean sexType;
    private String nick;
    private int strong;
    private int hp;

    public void sleep() {
        if (this.hp <= 10) {
            this.age += 1;
            this.hp += 20;
            this.strong += 10;
            if (this.age >= 70) {
                suicide();
                System.out.println(this.nick + " умер во сне от старости");
            }
            System.out.println(this.nick + " поспал ");
        } else {
            System.out.println(this.nick + "слишком бодрый чтобы заснуть");
        }
    }

    public void hardWorkout() {
        this.cash -= 100;
        this.strong += 50;
        this.hp += 50;
        System.out.println(this.nick + " накачался");
    }

    public void eat() {
        if (this.cash >= 20) {
            this.cash -= 20;
            this.hp += 20;
            this.strong += 10;
            System.out.println(this.nick + " покушал ");
        }
    }

    public void work() {
        if (this.strong > 20) {
            this.cash += 100;
            this.strong -= 20;
            System.out.println(this.nick + " поработал и заработал 100$. У вас" + this.cash + "$");
        } else {
            System.out.println(this.nick + " слишком устал. Он не может работать");
        }
    }


    public void workout() {
        this.cash -= 50;
        this.strong += 20;
        this.hp += 20;
        System.out.println(this.nick + " накачался");
    }

    public void kill(Man manKiller, Man man) {
        if (manKiller.strong > man.strong) {
            System.out.println(manKiller.nick + " убил " + man.nick);
            manKiller.strong += 10;
            setPoints(manKiller, 100, true);
        } else {
            System.out.println(manKiller.nick + " получил пизды от " + man.nick);
            setHp(manKiller, 50, false);
            setPoints(manKiller, 10, false);
        }
    }

    public void rape(Man men, Man woman) {
        if (men.strong > woman.strong) {
            if (men.sexType && !woman.sexType) {
                System.out.println(woman.nick + " была износилована - " + men.nick);
                setPoints(men, 100, true);
                if (men.age >= 18 && woman.age < 18) {
                    System.out.println(men.nick + " педофил");
                    setPoints(men, 100, false);
                }
            } else if (woman.sexType) {
                System.out.println(men.nick + " занялся любовью с мужиком");
                setPoints(men, 100, false);
                if (men.age >= 18 && woman.age < 18) {
                    System.out.println(men.nick + " занялся любовью с мужиком к тому же вы пидофил");
                    setPoints(men, 100, false);
                }
            }
        } else if (men.strong == woman.strong) {
            System.out.println("ничего не случилось");
        } else {
            System.out.println(men.nick + " получил пизды от " + woman.nick);
            men.hp -= 50;
            men.strong -= 10;
            men.cash -= 10;
            System.out.println("здоровье - " + men.hp);
            System.out.println("сила - " + men.strong);
            System.out.println("баланс - " + men.cash);
        }
    }

    private void setHp(Man man, int number, boolean isPlus) {
        if (isPlus) {
            man.hp += number;
        } else {
            man.hp -= number;
            isKilled(man);
        }
    }

    private void suicide() {
        this.cash = 0;
        this.strong = 0;
        this.hp = 10;
    }

    private void isKilled() {
        if (this.hp <= 0) {
            suicide();
            System.out.println(this.nick + " был побеждён");
        }
    }

    private void isKilled(Man man) {
        if (man.hp <= 0) {
            man.cash = 0;
            man.strong = 0;
            man.hp = 10;
            System.out.println(man.nick + " был побеждён");
        }
    }

    private void setPoints(Man man, int number, boolean isPlus) {
        if (isPlus) {
            man.cash += number;
        } else {
            man.cash -= number;
        }
        System.out.println(cash + "$");
    }
}
