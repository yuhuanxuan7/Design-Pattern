package o1_strategy_pattern.Duck;

import o1_strategy_pattern.FlyBehavior.FlyWithWings;
import o1_strategy_pattern.QuackBehavior.Quack;

public class MallardDuck extends Duck {

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I am a mallard duck");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
