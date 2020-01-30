package o2_Observer_Pattern.Subject;

import o2_Observer_Pattern.Observer.Observer;

public interface Subject {
    /**
     * Both of these methods take an
     * Observer as an argument; that is, the
     * Observer to be registered or removed.
     *
     * @param o Observer 的具体实现类 (the implementation of Observer Class)
     */
    void register(Observer o);
    void remove(Observer o);

    /**
     * This method is called to notify all observers
     * when the Subject’s state has changed.
     * 当主题状态改变时, 这个方法会被调用, 以通知所有的观察者.
     * @return 通知成功返回 true.
     */
    void notifyObserver();
}
