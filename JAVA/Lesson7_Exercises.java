/**
 * 第七课 配套练习题：多态、抽象类、接口
 * 期末考试重灾区，每题都是经典题型
 */
public class Lesson7_Exercises {

    // ==================== 题目区 ====================

    /**
     * 题1：多态 —— 父类引用指向子类对象
     * 按要求实现方法：
     * 1. 创建一个 Fruit 类型的变量 f1，给它赋值一个 Apple 对象
     * 2. 创建一个 Fruit 类型的变量 f2，给它赋值一个 Banana 对象
     * 3. 返回 f1.taste() + "-" + f2.taste()
     */
    static class Fruit {
        String name;
        Fruit(String name) { this.name = name; }
        String taste() { return "不知道什么味"; }
    }
    static class Apple extends Fruit { Apple() { super("苹果"); } @Override String taste() { return "甜的"; } }
    static class Banana extends Fruit { Banana() { super("香蕉"); } @Override String taste() { return "软的"; } }

    static String problem1_Polymorphism() {
        // ------ 在下面写你的代码 ------

        return ""; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题2：编写抽象类及其子类
     * 在下面找到 Animal2/Dog2/Cat2 的骨架，把方法体补全：
     *   - Dog2.makeSound() 返回 "汪汪"
     *   - Cat2.makeSound() 返回 "喵喵"
     */
    static abstract class Animal2 {
        String name;
        Animal2(String name) { this.name = name; }
        // 抽象方法：把 abstract 留着，子类来实现
        abstract String makeSound();
    }
    static class Dog2 extends Animal2 {
        Dog2(String name) { super(name); }
        // ------ 在下面写你的代码 ------
        @Override String makeSound() { return ""; } // TODO: 替换这行
        // ------ 上面是你的代码 ------
    }
    static class Cat2 extends Animal2 {
        Cat2(String name) { super(name); }
        // ------ 在下面写你的代码 ------
        @Override String makeSound() { return ""; } // TODO: 替换这行
        // ------ 上面是你的代码 ------
    }

    /**
     * 题3：编写接口及实现类
     * 在下面找到 USB 接口和 Mouse 类，把方法体补全：
     *   - Mouse.connect() 打印 "鼠标已连接"
     *   - Mouse.disconnect() 打印 "鼠标已断开"
     */
    interface USB {
        // ------ 在下面补充完整 ------
        void connect();
        void disconnect();
        // ------ 上面是你的代码 ------
    }
    static class Mouse implements USB {
        // ------ 在下面写你的代码 ------
        @Override public void connect() { /* TODO: 打印"鼠标已连接" */ }
        @Override public void disconnect() { /* TODO: 打印"鼠标已断开" */ }
        // ------ 上面是你的代码 ------
    }

    /**
     * 题4（拔高）：instanceof 判断
     * 参数 obj 是一个 Object，判断它的实际类型：
     *   - 如果 obj 是 String 类型 → "字符串"
     *   - 如果 obj 是 Integer 类型 → "整数"
     *   - 其他 → "未知类型"
     */
    static String problem4_CheckType(Object obj) {
        // ------ 在下面写你的代码 ------
        // 提示：obj instanceof String

        return ""; // TODO: 替换这行

        // ------ 上面是你的代码 ------
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
        System.out.println("========== 第七课 练习题批改 ==========\n");

        // 题1
        System.out.println("--- 题1: 多态 ---");
        check("题1-多态", "甜的-软的", problem1_Polymorphism());

        // 题2
        System.out.println("--- 题2: 抽象类 ---");
        Animal2 d = new Dog2("旺财");
        Animal2 c = new Cat2("咪咪");
        check("题2-Dog叫", "汪汪", d.makeSound());
        check("题2-Cat叫", "喵喵", c.makeSound());

        // 题3
        System.out.println("--- 题3: 接口 ---");
        Mouse m = new Mouse();
        System.out.print("  题3-connect: ");
        m.connect();
        System.out.print("  题3-disconnect: ");
        m.disconnect();

        // 题4
        System.out.println("--- 题4: instanceof ---");
        check("题4-String", "字符串", problem4_CheckType("hello"));
        check("题4-Integer", "整数", problem4_CheckType(42));
        check("题4-Double", "未知类型", problem4_CheckType(3.14));

        System.out.println("\n========== 结果: " + passed + "/" + total + " ==========");
        if (passed == total) {
            System.out.println("🎉 多态/抽象类/接口已掌握！这是考试重点！");
        } else {
            System.out.println("💪 还有 " + (total - passed) + " 项没过，加油！");
        }
    }
}
