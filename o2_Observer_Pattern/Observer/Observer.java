package o2_Observer_Pattern.Observer;

public interface Observer {
    /**
     * 当气象观测数值改变时, 主题 (Subject) 会把这些状态值当作方法的参数,
     * 传送给观察者 (Observer);
     * These are the state values the Observers get from
     * the Subject when a weather measurement changes;
     * @param temp 气温
     * @param humidity 湿度
     * @param pressure 压强
     * @return 是否更新成功, update successfully return true
     */
    void update(Float temp, Float humidity, Float pressure);

    /**
     * we will call when the display element needs to be displayed.
     */
    void display();
}
