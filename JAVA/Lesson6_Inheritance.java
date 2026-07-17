/**
 * 第六课：继承（Inheritance）
 *
 * 继承是OOP三大特性之一（封装、继承、多态）
 * 用 extends 关键字，子类拥有父类的所有属性和方法
 *
 * 期末考试高频考点：
 *   1. extends / super 的用法
 *   2. 构造方法的调用链（子类构造必调父类构造）
 *   3. 方法重写（Override）vs 方法重载（Overload）
 *   4. Object 类（所有类的祖宗）
 */

// ==================== 示例1：基本继承 ====================

// 父类（基类/超类）
class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void eat() {
        System.out.println(name + "在吃东西");
    }

    void sleep() {
        System.out.println(name + "在睡觉");
    }
}

// 子类（派生类）用 extends 继承 Animal
class GuardDog extends Animal {
    String breed;  // 子类自己新增的属性

    // 子类构造方法
    GuardDog(String name, int age, String breed) {
        super(name, age);   // ⚠️ 必须第一行！调用父类构造方法
        this.breed = breed;
    }

    // 子类新增的方法
    void bark() {
        System.out.println(name + "在汪汪叫！");
    }

    // 方法重写（Override）：覆盖父类的同名方法
    // @Override 是注解，告诉编译器"我要重写"，帮你检查写对没
    @Override
    void eat() {
        System.out.println(name + "在吃狗粮");  // 狗吃的不一样
    }
}

// 再写一个子类，感受继承的复用
class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void eat() {
        System.out.println(name + "在吃鱼");
    }

    void meow() {
        System.out.println(name + "在喵喵叫！");
    }
}


// ==================== 示例2：super 的三种用法 ====================

class Parent {
    int money = 100;

    Parent() {
        System.out.println("父类无参构造");
    }

    void show() {
        System.out.println("父类的show方法");
    }
}

class Child extends Parent {
    int money = 200;  // 和父类同名的属性

    Child() {
        super();       // ① super() 调用父类构造（不写也会自动加）
        System.out.println("子类构造");
    }

    void test() {
        System.out.println("money: " + money);           // 200（自己的）
        System.out.println("super.money: " + super.money); // 100（父类的）② super.属性
        super.show();  // ③ super.方法() 调用父类版本
    }

    @Override
    void show() {
        super.show();  // 先调用父类的
        System.out.println("子类的show方法");  // 再加自己的
    }
}


// ==================== 示例3：Object 类 ====================
// Java中所有类都默认继承 Object（即使你没写 extends）
// Object 有几个方法经常被重写：

class PersonDemo {
    String name;
    int age;

    PersonDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 重写 toString() —— 打印对象时自动调用
    // 如果不重写，打印出来是 Person@15db9742 这种地址
    @Override
    public String toString() {
        return "Person{姓名:'" + name + "', 年龄:" + age + "}";
    }

    // 重写 equals() —— 自定义"相等"的标准
    // 如果不重写，equals 和 == 一样，比的是地址
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;        // 同一个引用
        if (obj == null) return false;       // 空
        if (!(obj instanceof PersonDemo)) return false;  // 类型不同
        PersonDemo other = (PersonDemo) obj;         // 向下转型
        return this.age == other.age && this.name.equals(other.name);
    }
}


// ===== 主程序 =====
public class Lesson6_Inheritance {
    public static void main(String[] args) {

        // ===== 1. 基本继承 =====
        System.out.println("=== 基本继承 ===");
        GuardDog dog = new GuardDog("旺财", 3, "金毛");
        dog.eat();     // 重写过的
        dog.sleep();   // 从父类继承的
        dog.bark();    // 子类自己的

        Cat cat = new Cat("咪咪", 2);
        cat.eat();
        cat.meow();

        // ===== 2. super 的用法 =====
        System.out.println("\n=== super 用法 ===");
        Child child = new Child();
        System.out.println("---");
        child.test();
        System.out.println("---");
        child.show();

        // ===== 3. Object 的方法 =====
        System.out.println("\n=== toString / equals ===");
        PersonDemo p1 = new PersonDemo("张三", 20);
        PersonDemo p2 = new PersonDemo("张三", 20);
        PersonDemo p3 = new PersonDemo("李四", 22);

        System.out.println(p1.toString());           // 有了重写，打印才好看
        System.out.println("p1.equals(p2): " + p1.equals(p2));  // true（内容相同）
        System.out.println("p1.equals(p3): " + p1.equals(p3));  // false

        // ===== 4. 重载 vs 重写（面试/考试必考！）=====
        System.out.println("\n=== 重载 vs 重写 ===");
        System.out.println("重载(Overload): 同一个类里，同名方法，参数不同 → 编译时决定");
        System.out.println("重写(Override): 子类覆盖父类方法，参数/返回类型相同 → 运行时决定");
        System.out.println("@Override 注解帮你检查是否真的重写了");
    }
}
