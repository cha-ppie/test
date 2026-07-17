/**
 * 第五课 配套练习题：面向对象基础
 * 根据题目要求编写完整的类
 * 运行 main 自行批改
 *
 * 题目格式：给你一个需求，写一个类出来
 * 这和真实开发场景更像 —— 给你需求，你设计类
 */


// ==================== 题目区 ====================

/**
 * 题1：写一个 Dog 类
 * 要求：
 *   - 属性：String name, int age（私有）
 *   - 构造方法：Dog(String name, int age)
 *   - 方法：bark()，返回 name + "在汪汪叫！"
 *   - 方法：getAge()，返回年龄
 *
 * 使下面 testProblem1() 中的检查通过
 */
class Dog {
    // ------ 在下面写你的代码 ------



    // ------ 上面是你的代码 ------

    // 占位骨架（请用你的实现替换下面这些）
    Dog(String name, int age) {}
    String bark() { return ""; }
    int getAge() { return 0; }
}


/**
 * 题2：写一个 Calculator 类
 * 要求：
 *   - 属性：int result（私有），初始值0（无参构造）
 *   - 方法：add(int n)，把n加到result上
 *   - 方法：subtract(int n)，从result减去n
 *   - 方法：getResult()，返回当前result
 */
class Calculator {
    // ------ 在下面写你的代码 ------

    private int result = 0;


    // ------ 上面是你的代码 ------

    // 占位骨架（请用你的实现替换下面这些）
    void add(int n) {}
    void subtract(int n) {}
    int getResult() { return 0; }
}


/**
 * 题3：写一个 Circle 类
 * 要求：
 *   - 属性：double radius（私有）
 *   - 构造方法：Circle(double radius)，如果参数<=0则设为1.0
 *   - 方法：getArea()，返回面积（π * r²）
 *   - 方法：getCircumference()，返回周长（2 * π * r）
 *   使用 Math.PI
 */
class Circle {
    // ------ 在下面写你的代码 ------



    // ------ 上面是你的代码 ------

    // 占位骨架（请用你的实现替换下面这些）
    Circle(double radius) {}
    double getArea() { return 0; }
    double getCircumference() { return 0; }
}


/**
 * 题4：写一个 Person 类（构造方法重载）
 * 要求：
 *   - 属性：String name, int age（私有）
 *   - 构造方法1：Person(String name, int age)
 *   - 构造方法2：Person(String name) —— age默认18，用this()调用构造方法1
 *   - 构造方法3：Person() —— name默认"无名", age默认18，用this()调用
 *   - 方法：getInfo()，返回 "姓名:xxx, 年龄:xx"
 */
class Person {
    // ------ 在下面写你的代码 ------



    // ------ 上面是你的代码 ------

    // 占位骨架（请用你的实现替换下面这些）
    Person(String name, int age) {}
    Person(String name) {}
    Person() {}
    String getInfo() { return ""; }
}


/**
 * 题5：写一个 Counter 类（static 的运用）
 * 要求：
 *   - 私有静态变量 static int count，记录创建了多少个Counter对象
 *   - 无参构造方法，每次创建对象时count加1
 *   - 静态方法 getCount()，返回当前count
 *   - 实例方法 getSerial()，返回该对象的编号（即创建它是第几个）
 *     提示：在构造方法里把当前count赋值给实例变量
 */
class Counter {
    // ------ 在下面写你的代码 ------



    // ------ 上面是你的代码 ------

    // 占位骨架（请用你的实现替换下面这些）
    Counter() {}
    static int getCount() { return 0; }
    int getSerial() { return 0; }
}


/**
 * 题6（拔高）：写一个 BankAccount 类
 * 要求：
 *   - 属性：private String owner, private double balance
 *   - 构造方法：BankAccount(String owner, double initialBalance)
 *              如果initialBalance < 0，设balance为0
 *   - getter：getOwner(), getBalance()
 *   - deposit(double amount)：存款，amount<=0时打印"存款金额无效"，不操作
 *   - withdraw(double amount)：取款，余额不足时打印"余额不足"，不操作
 *   - transfer(BankAccount other, double amount)：转账给另一个账户
 *     自己余额不足时打印"转账失败"，不操作
 */
class BankAccount {
    // ------ 在下面写你的代码 ------



    // ------ 上面是你的代码 ------

    // 占位骨架（请用你的实现替换下面这些）
    BankAccount(String owner, double initialBalance) {}
    String getOwner() { return ""; }
    double getBalance() { return 0; }
    void deposit(double amount) {}
    void withdraw(double amount) {}
    void transfer(BankAccount other, double amount) {}
}


// ==================== 自动批改区 ====================

public class Lesson5_Exercises {

    static int passed = 0;
    static int total = 0;

    static void check(String name, String expected, String actual) {
        total++;
        if (expected.equals(actual)) {
            System.out.println("  ✅ " + name + ": " + actual);
            passed++;
        } else {
            System.out.println("  ❌ " + name + ": 期望 \"" + expected + "\"，实际 \"" + actual + "\"");
        }
    }

    static void checkDouble(String name, double expected, double actual) {
        total++;
        if (Math.abs(expected - actual) < 0.01) {
            System.out.println("  ✅ " + name + ": " + actual);
            passed++;
        } else {
            System.out.println("  ❌ " + name + ": 期望 " + expected + "，实际 " + actual);
        }
    }

    // 各题测试方法（题目里写好的类，调用自动检测对应的测试）

    static void testProblem1_Dog() {
        System.out.println("--- 题1: Dog 类 ---");
        Dog d = new Dog("旺财", 3);
        check("bark()", "旺财在汪汪叫！", d.bark());
        check("getAge()", "3", String.valueOf(d.getAge()));
    }

    static void testProblem2_Calculator() {
        System.out.println("--- 题2: Calculator 类 ---");
        Calculator c = new Calculator();
        c.add(10);
        check("add(10)后", "10", String.valueOf(c.getResult()));
        c.subtract(3);
        check("subtract(3)后", "7", String.valueOf(c.getResult()));
        c.add(100);
        check("add(100)后", "107", String.valueOf(c.getResult()));
    }

    static void testProblem3_Circle() {
        System.out.println("--- 题3: Circle 类 ---");
        Circle c = new Circle(3.0);
        checkDouble("半径3的面积", Math.PI * 9, c.getArea());
        checkDouble("半径3的周长", Math.PI * 6, c.getCircumference());

        Circle c2 = new Circle(-5);  // 非法值应设为1.0
        checkDouble("非法半径→1的面积", Math.PI, c2.getArea());
    }

    static void testProblem4_Person() {
        System.out.println("--- 题4: Person 类 ---");
        Person p1 = new Person("张三", 25);
        check("全参构造", "姓名:张三, 年龄:25", p1.getInfo());

        Person p2 = new Person("李四");
        check("单参构造(age默认18)", "姓名:李四, 年龄:18", p2.getInfo());

        Person p3 = new Person();
        check("无参构造", "姓名:无名, 年龄:18", p3.getInfo());
    }

    static void testProblem5_Counter() {
        System.out.println("--- 题5: Counter 类 ---");
        // 注意：static变量不重置，所以当前测试依赖题目顺序
        // 我们直接测这三个新对象
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        // 因为前面可能已经有其他测试创建过，所以用getSerial判断相对位置
        // 改为宽松测试：至少 c1, c2, c3 的编号递增
        if (c1.getSerial() > 0 && c2.getSerial() > c1.getSerial() && c3.getSerial() > c2.getSerial()) {
            System.out.println("  ✅ 对象编号递增: " + c1.getSerial() + " < " + c2.getSerial() + " < " + c3.getSerial());
            passed += 3;  // 三个断言都通过
            total += 3;
        } else {
            System.out.println("  ❌ 对象编号未递增: " + c1.getSerial() + ", " + c2.getSerial() + ", " + c3.getSerial());
            total += 3;
        }

        // getCount 应该 >= 3
        if (Counter.getCount() >= 3) {
            System.out.println("  ✅ getCount() >= 3: " + Counter.getCount());
            passed++;
        } else {
            System.out.println("  ❌ getCount() < 3: " + Counter.getCount());
        }
        total++;
    }

    static void testProblem6_BankAccount() {
        System.out.println("--- 题6: BankAccount 类 ---");
        BankAccount a1 = new BankAccount("张三", 1000);
        BankAccount a2 = new BankAccount("李四", 500);

        check("a1.getOwner()", "张三", a1.getOwner());
        checkDouble("a1.getBalance()", 1000, a1.getBalance());

        a1.deposit(200);
        checkDouble("a1存入200后", 1200, a1.getBalance());

        a1.deposit(-50);  // 无效，余额不变
        checkDouble("a1无效存款后", 1200, a1.getBalance());

        a1.withdraw(300);
        checkDouble("a1取300后", 900, a1.getBalance());

        a1.withdraw(9999);  // 余额不足，不变
        checkDouble("a1超额取款后", 900, a1.getBalance());

        // 转账测试
        a1.transfer(a2, 200);
        checkDouble("转账200后a1", 700, a1.getBalance());
        checkDouble("转账200后a2", 700, a2.getBalance());

        a1.transfer(a2, 9999);  // 余额不足
        checkDouble("失败转账后a1", 700, a1.getBalance());
    }

    public static void main(String[] args) {
        System.out.println("========== 第五课 练习题批改 ==========\n");

        testProblem1_Dog();
        testProblem2_Calculator();
        testProblem3_Circle();
        testProblem4_Person();
        testProblem5_Counter();
        testProblem6_BankAccount();

        System.out.println("\n========== 结果: " + passed + "/" + total + " ==========");
        if (passed == total) {
            System.out.println("🎉 全部通过！OOP入门已经掌握！");
        } else {
            System.out.println("💪 还有 " + (total - passed) + " 项没过，加油！");
        }
    }
}
