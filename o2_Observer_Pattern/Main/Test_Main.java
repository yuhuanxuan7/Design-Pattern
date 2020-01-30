package o2_Observer_Pattern.Main;

import o2_Observer_Pattern.Observer.CurrentConditionDisplay;
import o2_Observer_Pattern.Subject.WeatherData;

/**
 * @Description: $
 * @Author: Jacob Ninja
 * @Date: $
 */
public class Test_Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentDisplay =
                new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurement(80f,65f,30.4F);// 不知道温度是怎么回事

    }
}
