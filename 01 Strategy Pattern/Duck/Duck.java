package o1_strategy_pattern.Duck;

import o1_strategy_pattern.FlyBehavior.FlyBehavior;
import o1_strategy_pattern.QuackBehavior.QuackBehavior;

public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck(){
    }

    public void swim(){
        System.out.println("I can swim");
    }

    public abstract void display();

    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Duck)) return false;

        Duck duck = (Duck) o;

        if (flyBehavior != null ? !flyBehavior.equals(duck.flyBehavior) : duck.flyBehavior != null) return false;
        return quackBehavior != null ? quackBehavior.equals(duck.quackBehavior) : duck.quackBehavior == null;
    }

    @Override
    public int hashCode() {
        int result = flyBehavior != null ? flyBehavior.hashCode() : 0;
        result = 31 * result + (quackBehavior != null ? quackBehavior.hashCode() : 0);
        return result;
    }
}
