package o2_Observer_Pattern.Observer;

import o2_Observer_Pattern.Subject.Subject;

/**
 * @Description: $ Code Examples from Head First Design Pattern Chapter 2
 *  Observer Pattern;
 * @Author: Jacob Ninja
 * @Date: $ 30/01/2020
 */
public class CurrentConditionDisplay implements Observer {
    private Float temperature;
    private Float humidity;
    private Subject weatherData;

    /**
     * The constructor is passed the weatherData object (the Subject)
     * and we use it to register the display as an observer.
     * 构造器需要 weatherData 对象 [也就是 主题(Subject) 作为注册之用]
     * @param weatherData Subject 作为注册用
     */
    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.register(this);
    }

    /**
     * 当 update() 被调用的时候, 我们把温度和湿度保存起来,
     * 然后调用 display();
     * @param temperature 温度
     * @param humidity 湿度
     * @param pressure 压强
     * @return
     */
    @Override
    public void update(Float temperature, Float humidity, Float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current condition: "+ temperature +
                "F degrees and " + humidity +
                "% humidity");
    }

}
