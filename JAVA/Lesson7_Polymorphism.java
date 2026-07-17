/**
 * 第七课：多态、抽象类、接口
 *
 * 这三个是期末考试的重灾区，概念题和编程题都爱考
 *
 * 本节内容：
 *   1. 多态（Polymorphism）—— 父类引用指向子类对象
 *   2. 抽象类（abstract class）—— 不能new的类，给子类继承的
 *   3. 接口（interface）—— 比抽象类更纯粹的"契约"
 */


// ==================== 第一部分：多态 ====================
// 核心口诀：父类引用指向子类对象
// Animal a = new Dog();  ← 左边是Animal，右边是Dog

class Shape {
    // 普通方法
    void draw() {
        System.out.println("画一个形状");
    }

    double getArea() {
        return 0;  // 父类不知道具体怎么算面积
    }
}

class CircleShape extends Shape {
    double radius;

    CircleShape(double r) { this.radius = r; }

    @Override
    void draw() {
        System.out.println("画一个圆，半径" + radius);
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

class RectShape extends Shape {
    double width, height;

    RectShape(double w, double h) { this.width = w; this.height = h; }

    @Override
    void draw() {
        System.out.println("画一个矩形，" + width + "×" + height);
    }

    @Override
    double getArea() {
        return width * height;
    }
}


// ==================== 第二部分：抽象类 ====================
// 特征：
//   - 用 abstract 修饰
//   - 不能 new（不能实例化）
//   - 可以有抽象方法（只有声明，没有方法体）和普通方法
//   - 子类必须实现所有抽象方法，否则子类也得是抽象类

abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // 普通方法：有实现
    void clockIn() {
        System.out.println(name + "打卡上班");
    }

    // 抽象方法：没有方法体，强制子类实现
    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(String name, int id, double salary) {
        super(name, id);
        this.monthlySalary = salary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;  // 全职：固定月薪
    }
}

class PartTimeEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    PartTimeEmployee(String name, int id, double rate, int hours) {
        super(name, id);
        this.hourlyRate = rate;
        this.hoursWorked = hours;
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;  // 兼职：时薪×小时
    }
}


// ==================== 第三部分：接口 ====================
// 接口是比抽象类更纯粹的"契约" —— 只定义"能做什么"，不管"怎么做"
// 特征：
//   - 用 interface 声明
//   - 方法默认是 public abstract（不用写）
//   - 不能有构造方法，不能有实例变量
//   - 一个类可以实现（implements）多个接口（但只能继承一个类！）
//   - Java 8+ 可以有 default 方法（有方法体）

// 接口1
interface Flyable {
    void fly();  // 默认就是 public abstract
}

// 接口2
interface Swimmable {
    void swim();
}

// 一个类可以实现多个接口（弥补Java单继承的限制）
class Duck implements Flyable, Swimmable {
    String name;

    Duck(String name) { this.name = name; }

    @Override
    public void fly() {
        System.out.println(name + "在飞");
    }

    @Override
    public void swim() {
        System.out.println(name + "在游泳");
    }
}

// 接口也可以继承接口
interface Amphibious extends Flyable, Swimmable {
    void walk();  // 两栖动物还会走
}


// ===== 主程序 =====
public class Lesson7_Polymorphism {
    public static void main(String[] args) {

        // ===== 1. 多态演示 =====
        System.out.println("=== 多态 ===");

        // 向上转型：子类对象赋给父类引用（自动的，安全的）
        Shape s1 = new CircleShape(3);       // Shape引用 → CircleShape对象
        Shape s2 = new RectShape(4, 5); // Shape引用 → RectShape对象

        // 同一个方法调用，表现出不同行为 —— 这就是多态
        s1.draw();          // 实际调用CircleShape的draw
        s2.draw();          // 实际调用RectShape的draw
        System.out.println("s1面积: " + s1.getArea());  // CircleShape的getArea
        System.out.println("s2面积: " + s2.getArea());  // RectShape的getArea

        // 多态的好处：写一个方法，能处理所有子类
        Shape[] shapes = {new CircleShape(2), new RectShape(3, 4), new CircleShape(5)};
        double totalArea = 0;
        for (Shape s : shapes) {
            totalArea += s.getArea();  // 不用管具体是哪个子类
        }
        System.out.println("总面积: " + totalArea);

        // 向下转型（强制，有风险！）
        // s1 实际是 CircleShape，所以可以转回来
        CircleShape c = (CircleShape) s1;
        System.out.println("转回来后的半径: " + c.radius);

        // RectShape r = (RectShape) s1;  // ❌ 运行时报错！s1实际是CircleShape
        // 安全写法：instanceof 检查
        if (s1 instanceof RectShape) {
            RectShape r = (RectShape) s1;
        } else {
            System.out.println("s1不是RectShape，不能转型");
        }

        // ===== 2. 抽象类演示 =====
        System.out.println("\n=== 抽象类 ===");
        // Employee e = new Employee("xx", 1);  // ❌ 抽象类不能new！

        Employee[] staff = {
            new FullTimeEmployee("张三", 1001, 8000),
            new PartTimeEmployee("李四", 1002, 50, 80)
        };

        for (Employee emp : staff) {
            emp.clockIn();
            System.out.println("  工资: " + emp.calculateSalary());
        }

        // ===== 3. 接口演示 =====
        System.out.println("\n=== 接口 ===");
        Duck duck = new Duck("唐老鸭");
        duck.fly();
        duck.swim();

        // 接口也是一种类型！（多态的另一种形式）
        Flyable f = new Duck("飞鸭");
        f.fly();  // 只能调Flyable定义的方法
        // f.swim();  // ❌ Flyable类型没有swim方法
    }
}
