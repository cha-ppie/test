/**
 * 第四课 配套练习题：方法
 * 每题在方法体内写代码，运行 main 自行批改
 */
public class Lesson4_Exercises {

    // ==================== 题目区 ====================

    /**
     * 题1：编写一个方法
     * 方法名 maxOfThree，接收三个 int，返回最大值
     */
    static int problem1_MaxOfThree(int a, int b, int c) {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题2：判断闰年
     * 闰年规则：能被4整除但不能被100整除，或者能被400整除
     * 是闰年返回true，否则false
     */
    static boolean problem2_IsLeapYear(int year) {
        // ------ 在下面写你的代码 ------

        return false; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题3：方法重载 —— 求平均值
     * 编写两个版本的 average：
     *   一个接收两个 int，返回 double
     *   一个接收三个 int，返回 double
     *
     * 注意：方法名都是 average，参数个数不同
     */
    static double average(int a, int b) {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    static double average(int a, int b, int c) {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题4：递归 —— 计算 a 的 n 次方
     * 用递归实现 power(a, n)，返回 a^n（a的n次方）
     * n >= 0，规定 a^0 = 1
     * 提示：a^n = a * a^(n-1)
     *
     * 不能用 Math.pow()，不能用循环，必须用递归
     */
    static int problem4_Power(int a, int n) {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题5：可变参数 —— 求乘积
     * 编写方法 product，接收可变数量的 int，返回它们的乘积
     * 如果没传参数，返回 1
     */
    static int problem5_Product(int... nums) {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题6：判断质数（方法版）
     * 把判断质数的逻辑封装成方法 isPrime(int n)
     * n <= 1 返回 false
     */
    static boolean problem6_IsPrime(int n) {
        // ------ 在下面写你的代码 ------

        return false; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题7（拔高）：递归反转字符串
     * 用递归实现字符串反转
     * 例如 "hello" → "olleh"
     * 提示：reverse(s) = reverse(s[1:]) + s[0]
     *
     * 不能用循环，不能用 StringBuilder.reverse()
     */
    static String problem7_ReverseString(String s) {
        // ------ 在下面写你的代码 ------
        // 递归基：空串或长度为1的串直接返回
        // 递归：最后一个字符 + 前面部分的递归结果

        return ""; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题8（拔高）：打印乘法口诀表
     * 参数 n，返回 n×n 乘法表的字符串，格式如下（n=3为例）：
     * "1x1=1\t1x2=2\t1x3=3\n2x1=2\t2x2=4\t2x3=6\n3x1=3\t3x2=6\t3x3=9\n"
     * 注意：每行末尾都有 \n，包括最后一行
     */
    static String problem8_MultiplicationTable(int n) {
        // ------ 在下面写你的代码 ------
        // 嵌套循环 i从1到n, j从1到n

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

    static void checkInt(String name, int expected, int actual) {
        check(name, String.valueOf(expected), String.valueOf(actual));
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

    public static void main(String[] args) {
        System.out.println("========== 第四课 练习题批改 ==========\n");

        // 题1
        checkInt("题1-max(3,7,2)", 7, problem1_MaxOfThree(3, 7, 2));
        checkInt("题1-max(-1,-5,-3)", -1, problem1_MaxOfThree(-1, -5, -3));
        checkInt("题1-max(5,5,5)", 5, problem1_MaxOfThree(5, 5, 5));

        // 题2
        check("题2-2000是闰年", "true", String.valueOf(problem2_IsLeapYear(2000)));
        check("题2-2024是闰年", "true", String.valueOf(problem2_IsLeapYear(2024)));
        check("题2-1900不是闰年", "false", String.valueOf(problem2_IsLeapYear(1900)));
        check("题2-2025不是闰年", "false", String.valueOf(problem2_IsLeapYear(2025)));

        // 题3
        checkDouble("题3-average(10,20)", 15.0, average(10, 20));
        checkDouble("题3-average(10,20,30)", 20.0, average(10, 20, 30));

        // 题4
        checkInt("题4-2的3次方", 8, problem4_Power(2, 3));
        checkInt("题4-5的0次方", 1, problem4_Power(5, 0));
        checkInt("题4-3的4次方", 81, problem4_Power(3, 4));

        // 题5
        checkInt("题5-product(2,3,4)", 24, problem5_Product(2, 3, 4));
        checkInt("题5-product(5,6)", 30, problem5_Product(5, 6));
        checkInt("题5-product()", 1, problem5_Product());

        // 题6
        check("题6-7是质数", "true", String.valueOf(problem6_IsPrime(7)));
        check("题6-1不是质数", "false", String.valueOf(problem6_IsPrime(1)));
        check("题6-12不是质数", "false", String.valueOf(problem6_IsPrime(12)));
        check("题6-13是质数", "true", String.valueOf(problem6_IsPrime(13)));

        // 题7
        check("题7-反转\"hello\"", "olleh", problem7_ReverseString("hello"));
        check("题7-反转\"Java\"", "avaJ", problem7_ReverseString("Java"));
        check("题7-反转\"\"（空串）", "", problem7_ReverseString(""));

        // 题8
        check("题8-3×3乘法表",
            "1x1=1\t1x2=2\t1x3=3\n2x1=2\t2x2=4\t2x3=6\n3x1=3\t3x2=6\t3x3=9\n",
            problem8_MultiplicationTable(3));

        System.out.println("\n========== 结果: " + passed + "/" + total + " ==========");
        if (passed == total) {
            System.out.println("🎉 全部通过！方法掌握得很扎实！");
        } else {
            System.out.println("💪 还有 " + (total - passed) + " 题没过，加油！");
        }
    }
}
