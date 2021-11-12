#### Code review on the existing codebase provided to you

##### discussion on the use of OOP design principles

面向对象是一种计算机编程模型，它围绕数据或对象组织软件设计，而不是功能和逻辑。 对象可以定义为具有唯一属性的数据字段
和行为，面向对象编程可以提高代码可重用性、可扩展性和效率。在现有的代码库中,使用到了大量的OOP特性。例如在继承方面，在behaviour文件夹下，以接口BehaviourStrategy为基准，定义了所有entity的规约方法void behave(DynamicEntity entity,double frameDurationMilli)，类AggressiveEnerBehaviourStrategy、FloatingCloudBehaviourStrategy、PassiveEntityBehaviourStrategy、ScaredEnemyBehaviourStrategy等等都implements了接口BehaviourStrategy，并根据类自身的功能性特点，在behave方法中实现了不同的逻辑属性，重写父类的方法来方便地实现对父类的扩展。同样在collison文件夹中，在接口CollisionStrategy中定义了规约方法void collideWith(Entity currentEntity,Entity hitEntity)，该接口定义了游戏中所有物体的碰撞策略，例如聚焦主角的碰撞策略类BallboyCollisionStrategy、聚焦敌人的碰撞策略类EnemyCollisionStrategy以及聚焦passive collision的碰撞策略类PassiveCollisionStrategy，上述碰撞策略类都是接口CollisionStrategy的实现，通过自身功能类属性的定位来重写collideWith方法。

在现有的代码库中,不仅仅使用了接口以及其实现的方式完成继承的特性，还使用了部分抽象类的方式。例如抽象类DynamicEntity，该抽象类定义了较多entity的抽象行为方法，并在其子类DynamicEntityImpl中重写了所有父类的抽象方法。不管是上述描述中的接口还是抽象类，都充分体现了OOP中的继承特性，定义好规则，实现模块化开发，降低了程序的耦合性，对外提供统一的接口，加强了代码可读性。同样，由于codebase 使用了大量的继承特性，因此造就了较多的多态特性。例如在所有BehaviourStrategy以及其实现方法中，都实现了方法behave，在该方法中有一个参数entity，该实例参数的类型是DynamicEntity ，该抽象类是所有entity的父类，因此可以传入该抽象类的所有子类作为参数，任何后边新增的子类都可以作为参数传入该方法，提升了程序的可扩展性。同样，在接口CollisionStrategy以及其四个实现类中，方法collideWith的签名中，有一个currentEntity实例，该实例类型是Entity类型，Entity接口是游戏中所有物体的顶层接口，因此在方法collideWith中，可以通过传入Entity不同的实现子类，来处理不同的场景状态。多态的使用，提升了整个codebase的接口性、扩展性、灵活性。最后谈一谈codebase的封装特性，在类GameWindow中，定义了大量的私有属性，例如VIEWPORT_MARGIN_X、VIEWPORT_MARGIN_Y等等实例。该私有属性之类在本类的方法中使用，通过不同的访问控制符来约束实例的使用范围，对外提供public方法run，提供整个代码库的运行入口。通过对封装特性的使用，通过严格的接口控制，提升了整个codebase的安全性，也让其更容易理解与维护，通过良好的封装能减少代码耦合，提升了整个codebase的安全性。

以下是codebase有关面向对象特性应用的UML图：

![image-20211112085251682](C:\Users\wuyanYRF\AppData\Roaming\Typora\typora-user-images\image-20211112085251682.png)

##### discussion on the use of design patterns

在codebase的设计模式上，使用了非常不错的MVC设计模式。MVC是Model-View-Controller(*模型-视图-控制器)*的缩写，是一种混合设计模式。用到这种设计模式时，我们所创建的对象要分为：Model 对象，View对象和Controller对象。Model对象：负责存储数据以及定义如何操作这些数据。View对象：负责展示而且允许用户编辑来自应用程序的Model对象，View对象用来构建用户界面，与用户交互。Controller对象：是Model对象与View对象的中间人，负责传递数据，监听各种事件，管理其他对象的生命周期等。在codebase中，将游戏中所有涉及的model类型归并为entity、factory、level和GameEngine等等大类型，然后将涉及到的接口或者类中都统一归并为MVC模型中的Model，负责存储游戏数据；同理，对于游戏中的有关视图view的元素都统一归并为MVC模型中的View，例如EntityView、BlockedBackground和GameWindow等等负责展示游戏界面的类；最后使用类App作为整个codebase的控制器，传递数据，监听各种事件，管理codebase的生命周期。通过使用MVC设计模式，视图层和业务层分离，这样就允许更改视图层代码而不用重新编译模型和控制器代码，降低耦合性，增强高重用性和可适用性以及增强维护性。不仅使用了MVC设计模式，entity的创建中还使用了工厂模式，工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。在接口EntityFactory中定义了工厂实现方法createEntity，该方法通过配置文件的配置参数，创建对应类型的entity类。其中，BallboyFactory类用于创建Ballboy entities，CloudFactory用于创建cloud entities等等。通过工厂模式的使用，使codebase具有一下优点：调用者想创建一个对象，只要知道其名称就可以了；扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以；屏蔽产品的具体实现，调用者只关心产品的接口。同时EntityBehaviour和CollisionResolution使用了策略模式，以**Strategy**、**ConcreteStrategy**、**Context**三大设计思想来设计整个上述两个类的策略。策略模式是一种对象行为型模式。 策略模式包含三个角色：环境类在解决某个问题时可以采用多种策略，在环境类中维护一个对抽象策略类的引用实例；抽象策略类为所支持的算法声明了抽象方法，是所有策略类的父类；具体策略类实现了在抽象策略类中定义的算法。 策略模式是对算法的封装，它把算法的责任和算法本身分割开，委派给不同的对象管理。

以下是codebase有关设计模式特性应用的UML图：

策略模式：

![image-20211112085440712](C:\Users\wuyanYRF\AppData\Roaming\Typora\typora-user-images\image-20211112085440712.png)

工厂模式：

![image-20211112085508655](C:\Users\wuyanYRF\AppData\Roaming\Typora\typora-user-images\image-20211112085508655.png)



##### discussion on the documentation 

在codebase关于documentation方面，做到特别详尽。首先是在注释方面，写代码和注释的第一目的是帮助人理解代码，理解作者的意图。codebase的注释表达了“我的代码为什么要这么做？”这种需求，同时也遵循了奥卡姆剃刀原则：如无必要，勿增实体。回到代码中来，在codebase中，所有的类都具有类注释，例如下面代码所示：

```
/**
 * An aggressive strategy that makes the entity follow the ballboy.
 * Acceleration is applied horizontally in the direction of the ballboy
 * until a maximum velocity is reached.
 */
public class AggressiveEnemyBehaviourStrategy implements BehaviourStrategy {
```

在类头中，清晰的注释了该类的作用和作者的意图，让后面的程序维护人员阅读和扩展的时候，简单明了，大大减少了维护的成本。但是在类注释中，缺少了作者和时间信息，确实了部分类注释需要的元素。

同样，在一些重要且逻辑较为复杂的方法中，也详尽的表明了注释，例如下面代码所示：

```
/**
 * Sets the vertical velocity of the current entity to a value that will increase its vertical bounce height
 * relative to the floor by a fixed amount.
 *
 * @return boolean True if boost was successfully applied.
 */
public boolean boostHeight() {
```

方法注释紧靠在方法定义的前面，主要声明方法参数、返回值、异常等信息。codebase中按照方法注释常规的做法，添加注释信息。

- @param 变量描述：对当前方法的参数部分添加一个说明
- @return 返回类型描述：对当前方法添加返回值部分
- @throws 异常类描述：表示这个方法有可能抛出异常。

在整个codebase还有一些todo注释的标识，说明标识处有功能代码待编写，待实现的功能在说明中简略说明。例如下述代码：

```
KeyboardInputHandler(GameEngine model) {
    this.model = model;
    // TODO (longGoneUser): Is there a better place for this code?
    // TODO (bobbob): Move sound choice/production into the model before alpha is released to the new devs
    // TODO (bobbob): Just commenting this out while I debug my driver - don't forget to revert this before anyone
```

在整个codebase，作者通过良好的注释，提高了代码的阅读性，并作为调试程序的重要方法。注释是一个程序员必须要具有的良好编程习惯，在写代码的过程中可以将自己的思想通过注释先整理出来，再用代码去体现。

同样，对于README文件，README 文件后缀名为 md，是是由markdown语法编写的。是一种轻量级的「标记语言」。它用「标记」语法，来代替常见的字处理软件中大量的排版格式，从而让大家能够更专注于文字内容，是适合所有人的写作语言。往往对于项目的README文件，会通过简介高效的语句介绍本项目的信息，让代码读者能够更好的理解代码的整体情况。在codebase的README 文件中，介绍了项目的Overview状况，以及如何使用gradle命令来运行Running、Building、Testing。以及游戏如何操作的"Game Controls"介绍信息，包括游戏参数的配置文件的参数解释和整个项目使用到的设计模式等等信息。介绍语言简洁高效，排版清晰。作为整个项目的介绍和补充恰到好处。



##### discussion on how easy or difficult the above made it to achieve your required functionality and the reason

通过阅读整个codebase的代码，我在此基础上完成扩展的首要难点在于整个代码较为复杂，涉及到的接口、类较多，并且所给的codebase非常简洁完整，如果在维系简洁完整的基础上来扩充我的功能类，需要对新增加的功能类同样设计出色，这需要我花费更多的精力。并且配置文件较为复杂，如何基于配置文件的格式来实现save和load功能，也是我后边的难点。但是，良好的codebase也给我提供了方便，我通过详尽的注释、项目文档以及代码风格，不仅能够建立很好的理解基础，还可以在此基础上按照codebase的设计思想所提供的启发，来设计我的扩展接口，这能够让我的工作更简单。同样，codebase出色的设计模式的运用，也让我在扩展代码的过程中，如何使用Observer design pattern和Memento design pattern提供了极大的启发和借鉴，这也简化了我的扩展工作。



#### A discussion on your feature extension including

##### Describe the actual extension you have made in your code

首先，我按照本次作业的要求完成Level Transition模块，我创建了接口ScoredLevel，该接口继承自接口Level，是接口Level的子类，定义了addScoreObserver、isFinished等等方法。同理，我创建了接口MultiLevelGameEngine，该接口继承自接口GameEngine，是接口GameEngine的子类，在接口GameEngine定义的所有规约方法之外，还定义了level升级相关的接口规范，例如addScoreObserver、getLevelScores等等方法。当然还提供了该接口的实现类MultiLevelGameEngineImpl，根据作业的要求，完成接口MultiLevelGameEngine定义的方法。为了达到玩家成功完成游戏的第N关后，现实“Winner”图样，我创建了类WinLevelImpl，该类是接口ScoredLevel的实现，通过构造函数，初始化玩家通关后所需元素的实例变量。最后，我在游戏配置文件config.json文件中，添加了几个关卡信息，达到玩家至少可以通过三关才能“Winner”的作业要求。

接着，我按照作业要求完成Squarecat模块，我在behavior文件夹下添加了一种关于Square的策略，类SquareAroundHeroBehaviourStrategy像其它策略类一样，实现接口BehaviourStrategy，按照Squarecat的游戏行为设定，编写方法behave中的行为逻辑代码，让Squarecat可以在游戏中按照设定移动。当然，我也在collision文件下，添加了类SquarecatCollisionStrategy，该类像其它碰撞策略类一样，都是接口CollisionStrategy的实现类，按照游戏设定，Squarecat碰到游戏物体，会直接kill掉该游戏物体，因此在方法collideWith中，调用level.kill((ColorEnemyEntity) hitEntity)来使被碰撞的敌人消失。在factory的文件夹下，创建了Squarecat的工厂方法SquarecatFactory，该方法像所有其它游戏物体的工厂方法一样，是接口EntityFactory的实现类，实现了方法createEntity，用来创建Squarecat的实例。

然后，我按照作业要求完成Score (Observer design pattern)模块，因为该模块需要使用观察者模式来完成，所以我首先创建了接口ScoreObserver，在该接口中定义了观察后需要更新的update方法以及改变RGB分数值的reset方法。在类ScoredLevelImpl中，运用观察者模式，更新游戏中的分数元素。例如，当玩家消灭一个敌人后，玩家的分数需要做出相应的调整，实际代码如下：

```
public void kill(ColorEnemyEntity entity) {
   entities.remove(entity);
   Integer score = scores.getOrDefault(entity.getColor(), 0);
   scores.put(entity.getColor(), score + 1);
   for (ScoreObserver observer : observers) {
      observer.update();
   }
}
```

循环整个observer集合，调用集合所包含元素的update方法，更新相应的分数值。游戏分数主要分两块，一块是总分数，另外一块是每一关的分数。在完成总分数的展示要求中，我定义了TotalScoreViewStrategy类，该类是接口ScoreViewStrategy的实现类，在该类中，调用方法reset，清零分数数据，调用方法getScores获取RGB三类分数值。同理，在完成每一关分数的展示要求中，我定义了LevelScoreViewStrategy类，该类同样是ScoreViewStrategy的实现类，和TotalScoreViewStrategy通过方法调用每一关的RGB三类分数值和清零分数数据。

最后，我按照作业要求完成Save and Load (Memento design pattern)模块，因为该模块需要使用Memento design pattern来实现，所以我按照该设计模式的要求，编写了备忘录角色类Memento，在该类中定义了几个私有属性，该私有属性能够存储最近一次玩家备份的所有游戏数据，将Originator对象的内战状态存储起来。接着，我创建了Caretaker角色类CareTaker，该类负责保存备忘录对象Memento，并且不检查备忘录对象的内容。在MultiLevelGameEngineImpl类中，编写load和save方法来完成游戏状态的保存和加载。具体代码如下所示：

```
@Override
public void save() {
   careTaker.setMemento(createMemento());
}

@Override
public void load() {
   if (careTaker.getMemento() != null) {
      restoreMemeto(careTaker.getMemento());
   }
}
```

通过存储游戏数据状态和获取游戏数据状态，来达到save和load的功能。

##### Highlight your application of OOP design principles in your extensions and explain what they motivated you to do and why

在本次作业中，我使用了大量面向对象的特性，来拓展我所需要完成的功P能。例如，我创建了用于编写Square的行为逻辑的策略类SquareAroundHeroBehaviourStrategy，该类像其它策略类一样，实现接口BehaviourStrategy，利用了面向对象的继承特性，让新增的接口能够无感知的融合到codebase中。同理，在完成多关卡多颜色展示分数的要求中，定义了分数策略接口ScoreViewStrategy，游戏二类分数展示：总分数和关卡分数分别涉及到的类TotalScoreViewStrategy和LevelScoreViewStrategy都是该接口的实现子类，通过面向对象这种接口的继承特性，每一个接口的子类严格按照接口的约束方法来实现各自的特定逻辑，简约了代码，统一了接口，加强了整个程序的健壮性。面向对象的封装特性，在游戏的存档加载环节体现的较为恰当。在备忘录角色类Memento中，封装了代表当前等级的currentLevel属性、代表所有等级状态的levelState属性、代表总分数的totalScores属性和代表每一关卡分数的levelScores的属性。这些封装的属性或方法，对于角色类CareTaker都是无感知的，CareTaker只需要关注自身类的特有属性就可以了，而无需关注Memento中的属性含义，通过提供公共的访问方式来隐藏实现细节，提高整体代码的复用性。在实现游戏分数展示的环节中，按照题目要求运用观察者模式，在观察者模式的运用过程中，体现了面向对象的多态特性，例如，当玩家消灭一个敌人后，玩家的分数需要做出相应的调整，我编写的逻辑代码如下：
```
public void kill(ColorEnemyEntity entity) {
   entities.remove(entity);
   Integer score = scores.getOrDefault(entity.getColor(), 0);
   scores.put(entity.getColor(), score + 1);
   for (ScoreObserver observer : observers) {
      observer.update();
   }
}
```

从上述代码可以看出，RGB不同的分数类型，对于for循环中的状态更新，都是接口ScoreObserver类型的，但是代码会依据该接口的不同的子类类型，调用相应的update方法更新自己的分数值。在格式的体现上，父类引用指向子类对象，体现多态的扩展性与便利。



##### Document any design patterns used and rationalise their usage in terms of SOLID and GRASP

在扩展代码中，我使用了两种设计模式观察者模式和备忘录模式。

首先是观察者模式，观察者模式是定义对象间一种一对多的依赖关系，使得当每一个对象改变状态，则所有依赖于它的对象都会得到通知并自动更新，观察者模式是一种**对象行为型模式**。接口ScoreObserver是观察者模式中的**观察者**，观察者将对观察目标的改变做出反应，观察者一般定义为**接口**，该接口声明了更新数据的方法 `update()`，因此又称为**抽象观察者**。类ScoreView是**具体观察者**，在具体观察者中维护一个指向具体目标对象的引用，它存储具体观察者的有关状态，这些状态需要和具体目标的状态保持一致；它实现了在抽象观察者 Observer 中定义的 update()方法。类ScoreViewStrategy的方法 getScores获取的分数Map为观察者模式中的**目标**，是被观察者，它是指被观察的对象。在扩展代码中实现观察者模式的优点是降低了目标与观察者之间的耦合关系，目标与观察者之间建立了一套触发机制。

接着是备忘录模式，备忘录模式在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，这样以后就可将该对象恢复到原先保存的状态。在游戏中，玩家可能会实时保存用户的参数状态，等需要接着玩的时候，加载之前保存的游戏状态，正好符合备忘录模式的需求。在扩展代码的编写过程中，我编写了备忘录角色类Memento，在该类中定义了几个私有属性，该私有属性能够存储最近一次玩家备份的所有游戏数据，将Originator对象的内战状态存储起来。接着，我创建了Caretaker角色类CareTaker，该类负责保存备忘录对象Memento，并且不检查备忘录对象的内容。在MultiLevelGameEngineImpl类中，编写load和save方法来完成游戏状态的保存和加载。具体代码如下所示：

```
@Override
public void save() {
   careTaker.setMemento(createMemento());
}

@Override
public void load() {
   if (careTaker.getMemento() != null) {
      restoreMemeto(careTaker.getMemento());
   }
}
```

通过存储游戏数据状态和获取游戏数据状态，来达到save和load的功能。备忘录模式的使用，给游戏玩家提供了一种可以恢复状态的机制，可以使玩家能够比较方便地回到某个历史的状态，并且实现了信息的封装，使得玩家不需要关心状态的保存细节，只需要指导按Q键保存当前游戏状态，按L键加载之前保存的游戏状态。

以下是扩展代码有关设计模式特性应用的UML图：

观察者模式：

![image-20211112085811592](C:\Users\wuyanYRF\AppData\Roaming\Typora\typora-user-images\image-20211112085811592.png)

备忘录模式:

![image-20211112090116938](C:\Users\wuyanYRF\AppData\Roaming\Typora\typora-user-images\image-20211112090116938.png)



##### Reflect on your extension design, highlighting any outstanding issues or improvements or discussing your impact on the extensibility of the code

在UML的绘制过程中，我发现我在程序的扩展实施中，增加了大量的类和接口，导致整体项目的代码量增加，客观上使整个codebase越来越难维护。但是，我遵循面向对象封装、继承、多态特性，结合老师给的codebase代码的良好设计，又避免了代码过于臃肿凌乱。再加上我运用了设计模式的思想，让扩展后的代码更加具有灵活性，代码逻辑清晰透明，层次分明，健壮性也更高。






##### A UML class diagram of the after-extension version of your codebase, highlighting the design patterns you have used **for your** **extension** and identifying the participants in each design pattern you have used.

![ballboy](C:\Users\wuyanYRF\Downloads\ballboy.svg)



##### Any acknowledgement/reference required

需要明白什么是面向对象三大特性：

1、封装
 隐藏对象的属性和实现细节，仅对外提供公共访问方式，将变化隔离，便于使用，提高复用性和安全性。
 2、继承
 提高代码复用性；继承是多态的前提。
 3、多态
 父类或接口定义的引用变量可以指向子类或具体实现类的实例对象。提高了程序的拓展性。

引用网址：https://www.jianshu.com/p/7a5b0043b035



接着，需要储备什么是观察者模式：

**观察者模式(Observer Pattern)**： 定义对象间一种一对多的依赖关系，使得当每一个对象改变状态，则所有依赖于它的对象都会得到通知并自动更新。观察者模式是一种**对象行为型模式**。

观察者模式的别名包括发布-订阅（Publish/Subscribe）模式、模型-视图（Model/View）模式、源-监听器（Source/Listener）模式或从属者（Dependents）模式。

**Subject（目标）**：被观察者，它是指被观察的对象。这个角色可以是接口，也可以是抽象类或者具体的类，因为很多情况下会与其他的模式混用，所以使用抽象类的情况比较多。

**ConcreteSubject（具体目标）**：具体目标是目标类的子类，通常它包含经常发生改变的数据，当它的状态发生改变时，向它的各个观察者发出通知。同时它还实现了在目标类中定义的抽象业务逻辑方法（如果有的话）。如果无须扩展目标类，则具体目标类可以省略

**Observer（观察者）**：观察者将对观察目标的改变做出反应，观察者一般定义为**接口**，该接口声明了更新数据的方法 `update()`，因此又称为**抽象观察者**。

**ConcreteObserver（具体观察者）**：在具体观察者中维护一个指向具体目标对象的引用，它存储具体观察者的有关状态，这些状态需要和具体目标的状态保持一致；它实现了在抽象观察者 Observer 中定义的 update()方法。

引用网址：https://juejin.cn/post/6844904100459446285



最后，需要清楚什么是备忘录模式：

备忘录模式（Memento Pattern）在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。可以这样理解备忘录模式：现实生活中的备忘录是用来记录某些要去做的事情， 或者是记录已经达成的共同意见的事情，以防忘记了。而在软件层面，备忘录 模式有着相同的含义，备忘录对象主要用来记录一个对象的某种状态，或者某 些数据，当要做回退时，可以从备忘录对象里获取原来的数据进行恢复操作。备忘录模式属于行为型模式。

备忘录模式的设计模型如下:

**Memento**（备忘录）：包含了要被恢复的对象的状态，是快照的具体存储位置。

**Originator**（原发器）：创建并在 Memento 对象中存储状态，可以看作是需要被快照的对象，通常包含某些状态数据。

**Caretake**（恢复器）：负责从 Memento 中恢复对象的状态，可以看作是一个记录提取器或者说恢复器。

引用网址：https://juejin.cn/post/7023756227611983908
