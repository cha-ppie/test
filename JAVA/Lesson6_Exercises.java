/**
 * 第六课 配套练习题：继承
 * 题目要求写完整的子类
 */
public class Lesson6_Exercises {

    // ==================== 题目区 ====================

    /**
     * 题1：写一个 Student 子类
     * 父类 Human 已写好，你写 Student 继承它：
     *   - 新增属性：private String school
     *   - 构造方法：Student(String name, int age, String school)，用super调父类构造
     *   - 重写 introduce()：返回 "我是xxx，在xxx上学"
     *   - getSchool()：返回学校名
     */
    static class Human {
        protected String name;
        protected int age;

        Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String introduce() {
            return "我是" + name;
        }
    }

    static class Student extends Human {
        // ------ 在下面写你的代码 ------
        // 1. 声明 private String school
        // 2. 构造方法用 super(name, age)
        // 3. 重写 introduce() 返回 "我是xxx，在xxx上学"
        // 4. 写 getSchool() 方法


        // ------ 上面是你的代码 ------

        // 占位骨架（请用你的实现替换掉）
        Student(String name, int age, String school) { super(name, age); }
        @Override String introduce() { return ""; }
        String getSchool() { return ""; }
    }


    /**
     * 题2：写一个 SmartPhone 子类
     * 父类 Phone 已写好，你写 SmartPhone：
     *   - 新增属性：private String os（操作系统）
     *   - 构造方法：SmartPhone(String brand, double price, String os)，用super
     *   - 重写 getInfo()：返回 "品牌:xxx, 价格:xxx, 系统:xxx"
     */
    static class Phone {
        protected String brand;
        protected double price;

        Phone(String brand, double price) {
            this.brand = brand;
            this.price = price;
        }

        String getInfo() {
            return "品牌:" + brand + ", 价格:" + price;
        }
    }

    static class SmartPhone extends Phone {
        // ------ 在下面写你的代码 ------


        // ------ 上面是你的代码 ------

        // 占位骨架
        SmartPhone(String brand, double price, String os) { super(brand, price); }
        @Override String getInfo() { return ""; }
    }


    /**
     * 题3：super 的运用
     * 父类 Vehicle 已写好，写 Car 子类：
     *   - 构造方法：Car(String brand, int speed)
     *   - 重写 show()：先调用 super.show()，再打印 "这是汽车"
     */
    static class Vehicle {
        String brand;
        int speed;

        Vehicle(String brand, int speed) {
            this.brand = brand;
            this.speed = speed;
        }

        void show() {
            System.out.print("品牌:" + brand + ", 速度:" + speed);
        }
    }

    static class Car extends Vehicle {
        // ------ 在下面写你的代码 ------


        // ------ 上面是你的代码 ------

        // 占位骨架
        Car(String brand, int speed) { super(brand, speed); }
        @Override void show() {}
    }


    /**
     * 题4（拔高）：重写 toString() 和 equals()
     * 写一个 Book 类：
     *   - 属性：String title, String author
     *   - 构造方法：Book(String title, String author)
     *   - 重写 toString()：返回 "《xxx》by xxx"
     *   - 重写 equals(Object obj)：书名和作者都相同就是同一本书
     */
    static class Book {
        // ------ 在下面写你的代码 ------


        // ------ 上面是你的代码 ------

        // 占位骨架
        Book(String title, String author) {}
        @Override public String toString() { return ""; }
        @Override public boolean equals(Object obj) { return false; }
    }


    // ==================== 自动批改区 ====================

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

    public static void main(String[] args) {
        System.out.println("========== 第六课 练习题批改 ==========\n");

        // 题1
        System.out.println("--- 题1: Student子类 ---");
        Student stu = new Student("小明", 18, "清华大学");
        check("题1-introduce", "我是小明，在清华大学上学", stu.introduce());
        check("题1-getSchool", "清华大学", stu.getSchool());

        // 题2
        System.out.println("--- 题2: SmartPhone子类 ---");
        SmartPhone sp = new SmartPhone("华为", 4999, "鸿蒙OS");
        check("题2-getInfo", "品牌:华为, 价格:4999.0, 系统:鸿蒙OS", sp.getInfo());

        // 题3
        System.out.println("--- 题3: super运用 ---");
        Car car = new Car("宝马", 200);
        System.out.print("  实际输出: ");
        car.show();
        System.out.println();
        // 手动检查输出内容
        total++;

        // 题4
        System.out.println("--- 题4: toString/equals ---");
        Book b1 = new Book("活着", "余华");
        Book b2 = new Book("活着", "余华");
        Book b3 = new Book("三体", "刘慈欣");
        check("题4-toString", "《活着》by 余华", b1.toString());
        check("题4-equals相同", "true", String.valueOf(b1.equals(b2)));
        check("题4-equals不同", "false", String.valueOf(b1.equals(b3)));
        check("题4-equals null", "false", String.valueOf(b1.equals(null)));

        System.out.println("\n========== 结果: " + passed + "/" + total + " ==========");
        if (passed == total) {
            System.out.println("🎉 继承掌握得很扎实！");
        } else {
            System.out.println("💪 还有 " + (total - passed) + " 项没过，加油！");
        }
    }
}
