package o2_Observer_Pattern.Subject;

import o2_Observer_Pattern.Observer.Observer;
import java.util.ArrayList;

public class WeatherData implements Subject {
    private Float temperature;
    private Float humidity;
    private Float pressure;
    /**
     * We’ve added an ArrayList to hold the Observers, and we
     * create it in the constructor.
     * 我们加上了一个 ArrayList 来记录观察者, 此 ArrayList
     * 是在构造器中创建的.
     */
    private ArrayList observers;

    public WeatherData() {
        this.observers = new ArrayList();
    }

    /**
     * When an observer registers, we just
     * add it to the end of the list.
     * 当注册观察者时, 只需要把他加到 ArrayList
     * 最后即可.
     * @param o Observer 的具体实现类 (the implementation of Observer Class)
     */
    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    /**
     * Likewise, when an observer wants to un-register,
     * we just take it off the list.
     * 同理, 当观察者想取消注册, 从 ArrayList 中删除即可.
     * @param o Observer 的具体实现类 (the implementation of Observer Class)
     * @return True 如果删除成功的话.
     */
    @Override
    public void remove(Observer o) {
        int i = observers.indexOf(o);
        if (i>=0)
            observers.remove(i);
    }

    /**
     * Here’s the fun part; this is where we tell all the observers about the state.
     * Because they are all Observers, we know they all implement update(), so
     * we know how to notify them.
     * 有趣的地方来了, 在这里我们把状态告诉了每一个观察者. 因为观察者都实现了 update(),
     * 所以我们知道如何通知他们;
     * @return true if notify successfully;
     */
    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            // 强制类型转换, 所有实现类都 implement 了 Observer 接口;
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    /**
     * 当气象站得到了更新观测值, 我们
     * 通知观察者.
     */
    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurement(Float temperature, Float humidity, Float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // other methods in Class WeatherData
}
