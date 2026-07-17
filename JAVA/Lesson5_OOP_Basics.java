/**
 * 第五课：Java 面向对象基础
 *
 * 从这一课开始，你真正进入 Java 的核心领域。
 * Python和C都可以写面向对象，但Java是"一切皆类"的纯面向对象语言。
 *
 * 核心概念：
 *   类(Class)  = 蓝图/模板  — 描述一类事物有什么属性、能做什么
 *   对象(Object) = 实例      — 根据蓝图造出来的具体事物
 *
 * 类比：
 *   - "人"是类，"张三"是对象
 *   - "汽车图纸"是类，"你开的那辆"是对象
 */


// ==================== 示例1：最简单的类 ====================
// 一个类 = 属性（字段） + 行为（方法）

class Student {
    // 属性（字段）
    String name;
    int age;
    double score;

    // 构造方法：创建对象时自动调用，负责初始化
    // 和类同名，没有返回类型（连void都不写！）
    Student(String n, int a, double s) {
        name = n;
        age = a;
        score = s;
    }

    // 无参构造方法（如果不写，Java会自动给一个空的）
    // 但如果你写了有参构造，又想用无参，就必须手动写
    Student() {
        name = "未命名";
        age = 0;
        score = 0;
    }

    // 行为（方法）
    void introduce() {
        System.out.println("我叫" + name + "，今年" + age + "岁，成绩" + score);
    }

    boolean isPassed() {
        return score >= 60;
    }
}


// ==================== 示例2：封装 ====================
// 原则：属性私有（private），通过公共方法（public）访问
// Python在属性前面加_表示约定私有；Java用private关键字强制执行

class SafeAccount {
    // 私有属性：外部不能直接访问
    private String owner;
    private double balance;

    // 构造方法
    SafeAccount(String owner, double initialMoney) {
        this.owner = owner;   // this.owner 指属性；owner 指参数
        this.balance = initialMoney;
    }

    // 公共方法：提供受控的访问通道
    // getter —— 读取
    public String getOwner() { return owner; }
    public double getBalance() { return balance; }

    // setter —— 写入（可以加校验逻辑）
    public void setOwner(String owner) {
        if (owner != null && !owner.isEmpty()) {
            this.owner = owner;
        }
    }

    // 业务方法
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("存入 " + amount + "，余额: " + balance);
        } else {
            System.out.println("存款金额必须大于0");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("取出 " + amount + "，余额: " + balance);
        } else {
            System.out.println("余额不足或金额无效");
        }
    }
}


// ==================== 示例3：this 关键字 ====================
// this 代表"当前对象"的引用
// 用于：区分属性和参数、调用本类其他构造方法

class Book {
    String title;
    String author;
    double price;

    // 全参构造
    Book(String title, String author, double price) {
        this.title = title;    // this.title 是属性，title 是参数
        this.author = author;
        this.price = price;
    }

    // 用 this() 调用另一个构造方法
    Book(String title) {
        this(title, "佚名", 0.0);  // 必须写在第一行
    }

    Book() {
        this("未命名");  // 链式调用
    }

    void showInfo() {
        System.out.println("《" + title + "》 作者:" + author + " 价格:¥" + price);
    }

    // 返回 this 可以链式调用（方法链）
    Book setPrice(double price) {
        this.price = price;
        return this;
    }
}


// ==================== 示例4：static 关键字 ====================
// static 成员属于类本身，不属于某个对象
// 所有对象共享同一份 static 变量

class CounterDemo {
    // 实例变量：每个对象各有一套
    int id;

    // 静态变量：所有对象共享
    static int totalCount = 0;

    CounterDemo() {
        totalCount++;       // 每次创建对象，计数+1
        this.id = totalCount;
    }

    // 静态方法：属于类，不需要对象就能调用
    // 静态方法里不能访问实例变量（因为不知道是哪个对象的）
    static int getTotalCount() {
        return totalCount;
    }

    // 实例方法：可以访问静态变量和实例变量
    void showId() {
        System.out.println("我是第" + id + "个对象，总共" + totalCount + "个");
    }
}


// ===== 主程序 =====
public class Lesson5_OOP_Basics {
    public static void main(String[] args) {

        // ===== 1. 创建对象 =====
        System.out.println("=== 创建对象 ===");
        Student s1 = new Student("小明", 18, 92.5);
        Student s2 = new Student("小红", 19, 55.0);
        Student s3 = new Student();  // 无参构造

        s1.introduce();
        s2.introduce();
        s3.introduce();

        System.out.println("小明及格? " + s1.isPassed());
        System.out.println("小红及格? " + s2.isPassed());

        // ===== 2. 封装 =====
        System.out.println("\n=== 封装演示 ===");
        SafeAccount account = new SafeAccount("张三", 1000);
        // account.balance = 99999;  // ❌ 编译错误！balance是private

        System.out.println("账户: " + account.getOwner());
        System.out.println("余额: " + account.getBalance());

        account.deposit(500);
        account.withdraw(200);
        account.withdraw(9999);  // 余额不足

        // ===== 3. this 演示 =====
        System.out.println("\n=== this 演示 ===");
        Book b1 = new Book("Java核心技术", "Cay Horstmann", 99.0);
        Book b2 = new Book("三体");        // 只有书名
        Book b3 = new Book();              // 无参

        b1.showInfo();
        b2.showInfo();
        b3.showInfo();

        // 链式调用
        b3.setPrice(59.0).showInfo();  // setPrice返回this，可以继续调方法

        // ===== 4. static 演示 =====
        System.out.println("\n=== static 演示 ===");
        System.out.println("创建前总数: " + CounterDemo.getTotalCount());  // 静态方法，用类名调用

        CounterDemo c1 = new CounterDemo();
        CounterDemo c2 = new CounterDemo();
        CounterDemo c3 = new CounterDemo();

        c1.showId();
        c2.showId();
        c3.showId();
        System.out.println("当前总数: " + CounterDemo.totalCount);  // 静态变量，也是类名访问

        // ===== 练手：综合 =====
        System.out.println("\n=== 练手：Rectangle 类 ===");
        Rectangle r = new Rectangle(5, 3);
        System.out.println("面积: " + r.getArea());
        System.out.println("周长: " + r.getPerimeter());
        System.out.println("是正方形? " + r.isSquare());
    }
}


// 练手用的类（通常每个类单独放一个文件，这里集中展示）
class Rectangle {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getArea() {
        return width * height;
    }

    double getPerimeter() {
        return 2 * (width + height);
    }

    boolean isSquare() {
        return width == height;
    }
}
