Design principle of Strategy Pattern
1. Identify the aspects of your application that vary and separate them from what stays the same.
   找出应用中可能需要变化之处, 把它们独立出来, 不要和那些不需要变化的代码混在一起.

2. Program to an interface, not an implementation.
  针对接口编程, 而不是针对实现编程.
  
3. Favor composition over inheritance.
  多用组合, 少用继承.
  
  composition BrE /ˌkɒmpəˈzɪʃn/ NAmE /ˌkɑːmpəˈzɪʃn/
noun
[uncountable] the different parts which sth is made of; the way in which the different parts are organized 成分；构成；组合方式
the chemical composition of the soil土壤的化学成分
the composition of the board of directors董事会的组成

The Chapter 1 describe a "Strategy Pattern".
**The Strategy Pattern** defines a family of algorithms, encapsulates each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

策略模式正式定义:
策略模式定义了算法族, 分别封装起来, 让它们之间可以互相替换, 此模式让算法的变化独立于使用算法的客户.
