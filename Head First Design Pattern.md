# Head First Design Pattern

## Design Principle (设计原则)

1. Identify the aspects of your application that vary and separate them from what stays the same.

   找出应用中可能需要变化之处, 把它们独立出来, 不要和那些不需要变化的代码混在一起.

2. Program to an interface, not an implementation.

   针对接口编程, 而不是针对实现编程.

3. Favour composition over inheritance.

   多用组合, 少用继承.

4. Strive for loosely coupled designs between objects that interact.  

   为交互对象之间的松耦合设计而努力;

5. Classes should be open for extension, but closed for modification;

   向扩展开放, 向修改关闭;

6. The Hollywood Principle: Don't call us, we will call you.



## Reminder:

In design pattern, the phrase "implement an interface" does not always mean "write a class the implement a Java interface, by using the 'implements' keyword in the class declaration." In the general use of the phrase, a concrete class implementing a method from a supertype (which could be a class OR interface ) is still considered to be "implementing the interface" of that supertype.



## Chapter 1

### Design Principles

1. Identify the aspects of your application that vary and separate them from what stays the same.

   找出应用中可能需要变化之处, 把它们独立出来, 不要和那些不需要变化的代码混在一起.

2. Program to an interface, not an implementation.

   针对接口编程, 而不是针对实现编程.

3. Favour composition over inheritance.

   多用组合, 少用继承.

The Chapter 1 describe a "Strategy Pattern".

**The Strategy Pattern** defines a family of algorithms, encapsulates each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

策略模式正式定义:

```
策略模式定义了算法族, 分别封装起来, 让它们之间可以互相替换, 此模式让算法的变化独立于使用算法的客户.
```

---



## Chapter 2

### Observer Pattern

Observer Pattern defines a one-to-many dependency between objects so that when one objects changes state, all of its dependents are notified and updated automatically. 



Note: there are a few different ways to implement the observer pattern but most revolve around a class design that includes Subject and Observer interfaces. 



### New Additional Design Principle(新增的设计原则)

Strive for loosely coupled designs between objects that interact.  

为交互对象之间的松耦合设计而努力;

---



## Chapter 3

### Decorating Objects

One of the most significant design principles:

```
Classes should be open for extension, but closed for modification;

```



Our goal is to allow classes to be easily extended to incorporate new behaviour without modifying existing code. What do we get if we accomplish this? Designs that are resilient to change and flexible enough to take on new functionality to meet changing requirements.



Be careful when choosing the areas of code that need to be extended; applying the Open-Closed Principle EVERYWHERE is wasteful, unnecessary, and can lead to complex, hard to understand code.



```
The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
```

Traditionally the Decorator Pattern does specify an abstract component, but in Java, obviously, we could use an interface. But we always try to avoid altering existing code, so don’t “fix” it if the abstract class will work just fine.

---



## Chapter 4

### The Factory Pattern



```
The Factory Method Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
```



Abstract Factory allows a client to use an abstract interface to create a set of related products without knowing (or caring) about the concrete products that are actually produced. In this way, the client is decoupled from any of the specifics of the concrete products.



### Design Principle

```
Depend upon abstractions. Do not depend upon concrete classes.
```

A few guidelines to help follow the Principle:

* No variable should hold a reference to a concrete class.



```
If you use new, you’ll be holding a reference to a concrete class. Use a factory to get around that!
```

* No class should derive from a concrete class;



```
If you derive from a concrete class, you’re depending on a concrete class. Derive from an abstraction, like an interface or an abstract class.
```

* No method should override an implemented method of any of its base classes.



```
If you override an implemented method, then your base class wasn’t really an abstraction to start with. Those
methods implemented in the base class are meant to be shared by all your subclasses.
```

instanceof in Java will return false when comparing a subclass to its superclass.



## Chapter 6 

### Command Pattern

```
The Command Pattern encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue or log requests, and support undoable operations.
```



## Chapter 8 

### the Template Method Pattern

```
The Template Method Pattern defi nes the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the
algorithm’s structure.
```

Note: 此模式主要用于创建一个算法的模板, 具体的结构为:

* 父类:

1. 抽象类(abstract), 其中定义多个方法;
2. 不可变的方法声明为 final ;
3. 可以变的方法用 abstract 修饰或者方法体中的内容为空 ;

* 子类:

1. 负责父类方法中抽象方法的具体实现;

2. 或 override 父类中方法内容为空的方法;



Q&A:

1. 创建一个模板方法时, 何时使用 abstract(抽象) 方法, 何时使用方法内容为空的方法?

* 必须实现的用abstract, 选择性的用空方法, 以下为书中原话: 

```  
Use abstract methods when your subclass MUST provide an implementation
of the method or step in the algorithm. Use hooks when that part of the algorithm is optional. With hooks, a subclass may choose to implement that hook, but it doesn’t have to.
```

---

2. It seems like I should keep my abstract methods small in number, otherwise it will be a big job to implement them in the subclass. (要控制抽象方法的数量)

* 可以让算法内的步骤不要切割的太细, 但是如果步骤太少的话, 会比较没有弹性, 所以要看情况折中. 以下为书中原话: 

``` 
That’s a good thing to keep in mind when you write template methods. Sometimes this can be done by not making the steps of your algorithm too granular. But it’s obviously a trade off: the less granularity, the less flexibility. Remember, too, that some steps will be optional; so you can implement these as hooks rather than abstract methods, easing the burden on the subclasses of your abstract class.
```

3. 低层组件不可以调用高层组件中的方法吗? 

* 并不尽然, 事实上, 低层组件在结束时, 常常会调用从超类中继承的方法. 我们所要做的是, 避免高层组件和低层组件之间有明显的环状依赖.

  

---



The Hollywood Principle: Don't call us, we will call you.



另外的例子, Java API 中的 Arrays.sort() 方法, 以下是简化版代码:

```
/** The first method, sort(), is just a helper method that creates a copy of the array and passes it along as the destination array to the mergeSort() method. It also passes along the length of the array and tells
the sort to start at the first element.
*/
public static void sort(Object[] a) {
	Object aux[] = (Object[])a.clone();
	mergeSort(aux, a, 0, a.length, 0);
}

/** The mergeSort() method contains the sort algorithm, and relies
on an implementation of the compareTo() method to complete the
algorithm. If you’re interested in the nitty gritty of how the
sorting happens, you’ll want to check out the Sun source code.
 *
 */
 //Think of this as the template method.
private static void mergeSort(Object src[], Object dest[],
int low, int high, int off){
	for (int i=low; i<high; i++){
		for (int j=i; j>low &&
		((Comparable)dest[j-1]).compareTo((Comparable)dest[j])>0; j--){
			swap(dest, j, j-1);
				}
			}
		return;
	}
```

被比较的对象需要 implement Comparable 接口;