# 设计模式

## 面向对象的设计原则

### 开闭原则：对扩展开放，对修改关闭
在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。
### 里氏代换原则
父类的引用可以引用任何子类的实例。
子类不能比父类更多的约束。
### 单一职责原则
一个类,引起它变化的原因只有一个.宏观上面向方面的编程。
### 合成复用原则
原则是尽量使用合成/聚合的方式，而不是使用继承。把 is-a 关系改成 has-a 关系。
### 接口隔离原则
提炼接口隔离变化并统一行为。**适配器模式**是最好的体现。
类型转换的功能：对象适配器，类适配器
缺省适配器（抽象类）：解决接口肥胖问题；多加了一层隔离
### 依赖倒转原则
面对接口编程，依赖于抽象而不依赖于具体。
### 迪米特法则
一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。



## 常用的设计模式

### 创建型（使用者和创建者分离,使使用者更方便）

- 简单工厂（不在23中设计模式中）

    一般负责单个具体产品对象创建
    对于多个不同的产品可使用配置文件加反射实现（由编译时加载改成运行时加载）；
    
- 工厂方法 factory method

    一个抽象产品，一个抽象工厂
    添加新产品就添加新的工厂
    使用者需要知道新产品对于的新工厂
    
- 抽象工厂 abstract factory

    提供一个接口，用于创建**相关的或依赖对象的家族**，而不需要明确指定具体类。
        
- 单例模式 singleton

    对象有且只有一个；
    构造方法私有化，通过静态方法返回
    对象数目固定且已知：枚举
    线程范围内单例 threadLocal 
    
- 原型模式 prototype

    用于创建重复的对象
    浅拷贝：object 实现cloneAble接口
    深拷贝：序列化和反序列化
    arrayList的序列化：writeObject,readObject

- 构建者模式 builder

    Builder：生成器接口，定义创建一个Product对象所需的各个部件的操作。
    ConcreteBuilder：具体的生成器实现，实现各个部件的创建，并负责组装Product对象的各个部件，提供获取产品对象的方法。
    Director：统一组装过程
    Product：产品，表示被生成器构建的复杂对象，包含多个部件。
    创建一个对象的过程比较复杂
    由多个小对象组成，小对象又是变化的
    如套餐：主食、辅食、饮料等构成A套餐，B套餐；
    

### 结构型

- 适配器模式 adapter

    目标（Target）：定义一个客户端使用的特定接口。
    客户端（Client）：使用目标接口，与和目标接口一致的对象合作。
    被适配者（Adaptee）：一个现存需要适配的接口。
    适配器（Adapter）：负责将Adaptee的接口转换为Target的接口。适配器是一个具体的类，这是该模式的核心。
    接口隔离的体现
    对象适配器，类适配器
    解决肥胖接口（缺省配置，增加了一层隔离）
    
- 装饰器模式(包装模式) decorator

    在不改变原有类代码的基础上添加新功能
    new D(new C((new B(new A())))
    A有父类X;
    求B,C,D的父类Y，使得B,C,D可以任意换位置
    class Y extens X{
    private X x;
    public Y(X x){this.x = x}
    }
    jdk 中的io

- 代理模式 proxy （aop思想的核心）

    静态代理模式
        代理类和目标类实现同一接口
        方法必须一个一个去拦截
    动态代理
        jdk支持的动态代理（必须面向接口编程）
        spring中的增强，前置增强，后置增强
        cglib 代理（不用面向接口）
    和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。 
    和装饰器模式的区别：装饰器模式为了增强功能，而代理模式是为了加以控制。

- 享元模式 flyweight

    对象反复创建，销毁
    创建出来并缓存，下次直接使用
    jvm 数据类型在一定范围内的装箱拆箱操作
    多线程情况下：java中的读写锁的使用 reentrantReadWriteLock
    内存紧张的情况，使用软引用
    
- 桥接模式 bridge

    单一职责原则，组合聚合复用原则
    把is-a 改成 has-a

- 组合模式 composite （使用少）
    
    又叫部分整体模式
    它在我们树型结构的问题中，模糊了简单元素和复杂元素的概念，
    客户程序可以向处理简单元素一样来处理复杂元素，从而使得客户程序与复杂元素的内部结构解耦。
    
- 外观模式 facade（使用少）

    隐藏系统的复杂性
    降低访问复杂系统的内部子系统时的复杂度，简化客户端与之的接口。


### 行为型

- 命令模式 command

    将"行为请求者"与"行为实现者"解耦
    行为实现者 往往没有共同的抽象

- 策略模式 strategy  

- 状态模式 state

    类的行为是基于它的状态改变的
    状态模式对"开闭原则"的支持并不太好，对于可以切换状态的状态模式，增加新的状态类需要修改那些负责状态转换的源代码

- 观察者模式 observer

    目标对象一旦发生变化，通知观察者
    目标对象要有容器存放观察者

- 模板方法模式 template method

    定义一个算法的步骤（步骤不能变）
    步骤中的每一步操作具体实现子类实现

- 迭代器（一般不用自己实现）

    如果提供了聚集就需要提供查找和遍历的方法，且不暴露具体实现

- 责任链模式（使用少）

- 中介者模式（使用少）

    把多对多的网状关系改变成1对多的星型关系
    降低多个对象和类之间的通信复杂性。这种模式提供了一个中介类，该类通常处理不同类之间的通信

- 备忘录模式（使用少）

    对象状态发生改变就保存起来，想要恢复的时候就重新取出来（撤销操作）

- 访问者模式（使用少）


- 解释器模式（使用极少）

    编译器中使用的比较多



## 解耦方式

配置文件
反射
表驱动
依赖注入

## 写一个功能一般的过程

- 找出可变化的因素
- 提炼稳定接口
- 完成具体功能（面向接口编程）
- 抽象的具体实现（将来完全可扩展）

- 创建型模式创建对象
- 解耦具体实现


## related

- https://www.runoob.com/design-pattern/design-pattern-tutorial.html