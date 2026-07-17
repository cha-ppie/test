/**
 * 第一课 配套练习题：变量与基本类型
 * 每个方法对应一道题，按要求填空或实现
 * 运行 main 即可自行批改
 */
public class Lesson1_Exercises {

    // ==================== 题目区 ====================

    /**
     * 题1：声明变量
     * 声明一个 int 类型变量 year，赋值 2026
     * 声明一个 double 类型变量 price，赋值 99.9
     * 声明一个 boolean 类型变量 isJavaFun，赋值 true
     * 声明一个 char 类型变量 grade，赋值 'A'
     * 返回这四个值拼接成的字符串，格式："2026-99.9-true-A"
     */
    static String problem1_BasicTypes() {
        // ------ 在下面写你的代码 ------
        // 1. 声明 int year = 2026
        // 2. 声明 double price = 99.9
        // 3. 声明 boolean isJavaFun = true
        // 4. 声明 char grade = 'A'
        // 5. 返回拼接字符串
        int year = 2026;
        double price = 99.9;
        boolean isJavaFun = true;
        char grade = 'A';

        return year + "-" + price + "-" + isJavaFun + "-" + grade; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题2：温度转换
     * 摄氏度 → 华氏度：F = C * 9/5 + 32
     * 参数 celsius 是摄氏度（double），返回华氏度（double）
     * 小提示：用 9.0/5.0 而不是 9/5，否则整数除法会得到1
     */
    static double problem2_CelsiusToFahrenheit(double celsius) {
        // ------ 在下面写你的代码 ------
        // 公式: F = C * 9/5 + 32
        // 注意: 用 9.0/5.0 而不是 9/5
        double fahrenheit = celsius * 9.0 / 5.0 + 32;
        return fahrenheit; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题3：强制类型转换
     * 参数 d 是一个小数（double），请将它强制转换为 int 并返回
     */
    static int problem3_CastToInt(double d) {
        // ------ 在下面写你的代码 ------
        // 把 double 强制转成 int
        int result = (int) d;
        return result; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题4：计算圆的周长
     * 参数 radius 是半径，使用 Math.PI，返回周长（2 * π * r）
     */
    static double problem4_CirclePerimeter(double radius) {
        // ------ 在下面写你的代码 ------
        // 周长 = 2 * π * r，π 用 Math.PI
        double end = 2 * Math.PI * radius;
        return end; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题5：字符串处理
     * 参数 name 是一个名字（如 "zhangSan"），请：
     * 1. 把它转成大写
     * 2. 返回 "HELLO, " + 大写名字
     * 例如输入 "xiaoming"，返回 "HELLO, XIAOMING"
     */
    static String problem5_GreetLoudly(String name) {
        // ------ 在下面写你的代码 ------
        // 1. 把 name 转成大写
        // 2. 前面拼接 "HELLO, "
        name = name.toUpperCase();
        return "HELLO, " + name; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题6（拔高）：不用第三个变量交换两个整数
     * 有 int a = x, b = y
     * 在不引入第三个变量的前提下交换它们的值
     * 返回交换后拼接的字符串，格式："b的值-a的值"
     * 例如 x=10, y=20 → 返回 "20-10"
     *
     * 提示：可以用加减法或异或运算
     */
    static String problem6_SwapWithoutTemp(int a, int b) {
        // ------ 在下面写你的代码 ------
        // 不用第三个变量，交换 a 和 b 的值
        // 提示: 加减法 — a=a+b; b=a-b; a=a-b
        a = a + b;
        b = a - b;
        a = a - b;
        return a + "-" + b; // TODO: 替换这行 — 返回格式: a + "-" + b

        // ------ 上面是你的代码 ------
    }


    // ==================== 自动批改区（不用看）====================

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

    static void checkInt(String name, int expected, int actual) {
        check(name, String.valueOf(expected), String.valueOf(actual));
    }

    static void checkDouble(String name, double expected, double actual) {
        total++;
        // 浮点数比较允许微小误差
        if (Math.abs(expected - actual) < 0.01) {
            System.out.println("  ✅ " + name + ": " + actual);
            passed++;
        } else {
            System.out.println("  ❌ " + name + ": 期望 " + expected + "，实际 " + actual);
        }
    }

    public static void main(String[] args) {
        System.out.println("========== 第一课 练习题批改 ==========\n");

        // 题1
        check("题1-基本类型声明", "2026-99.9-true-A", problem1_BasicTypes());

        // 题2
        checkDouble("题2-0°C→32°F", 32.0, problem2_CelsiusToFahrenheit(0));
        checkDouble("题2-100°C→212°F", 212.0, problem2_CelsiusToFahrenheit(100));
        checkDouble("题2-37°C→98.6°F", 98.6, problem2_CelsiusToFahrenheit(37));

        // 题3
        checkInt("题3-3.14→3", 3, problem3_CastToInt(3.14));
        checkInt("题3-9.99→9", 9, problem3_CastToInt(9.99));

        // 题4
        checkDouble("题4-半径1", 2 * Math.PI, problem4_CirclePerimeter(1));
        checkDouble("题4-半径5", 10 * Math.PI, problem4_CirclePerimeter(5));

        // 题5
        check("题5-小写转大写", "HELLO, ZHANGSAN", problem5_GreetLoudly("zhangSan"));
        check("题5-普通名字", "HELLO, TOM", problem5_GreetLoudly("Tom"));

        // 题6
        check("题6-交换10和20", "20-10", problem6_SwapWithoutTemp(10, 20));
        check("题6-交换1和99", "99-1", problem6_SwapWithoutTemp(1, 99));

        // 汇总
        System.out.println("\n========== 结果: " + passed + "/" + total + " ==========");
        if (passed == total) {
            System.out.println("🎉 全部通过！可以进入下一课了。");
        } else {
            System.out.println("💪 还有 " + (total - passed) + " 题没对，加油！");
        }
    }
}
