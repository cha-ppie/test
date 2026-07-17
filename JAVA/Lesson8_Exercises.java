/**
 * 第八课 配套练习题：异常处理
 * 考试通常考 try-catch-finally 语法和常见异常类名
 */
public class Lesson8_Exercises {

    // ==================== 题目区 ====================

    /**
     * 题1：try-catch 捕获除零异常
     * 参数 a 和 b，返回 a/b 的结果（double）
     * 如果 b==0，捕获异常并返回 Double.NaN
     */
    static double problem1_SafeDivide(int a, int b) {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题2：try-catch 捕获数组越界
     * 从 arr 中取索引 index 的元素
     * 如果越界，返回 -1
     */
    static int problem2_SafeGet(int[] arr, int index) {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题3：try-catch-finally
     * 返回一个字符串，展示 finally 的执行顺序
     * 要求返回格式："try-finally"
     * 提示：在 try 里写 return "try"，finally 总会执行但你无法
     *       从 finally 里改返回值……所以直接在 try 里拼好字符串。
     *       简化版：直接返回 "try-finally" 就行（理解 finally 语义即可）
     *
     * 真正考法：下面 testProblem3 会验证你对 finally 的理解
     * 写一个方法，在 try { return "try"; } finally { 打印"finally执行了"; }
     * 然后调用它，观察输出顺序
     */
    static String problem3_FinallyDemo() {
        // ------ 在下面写你的代码 ------
        // 要求：打印 "finally执行了"，然后返回 "try"

        return ""; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题4：throw 抛出异常
     * 参数 score 是分数，如果 <0 或 >100，
     * 抛出 IllegalArgumentException("分数不合法: " + score)
     * 如果正常，返回 "OK"
     */
    static String problem4_ValidateScore(int score) {
        // ------ 在下面写你的代码 ------

        return ""; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题5（拔高）：字符串转整数
     * 参数 s 是字符串，尝试用 Integer.parseInt 转整数并返回
     * 如果解析失败（NumberFormatException），返回 -999
     * 如果 s 是 null（NullPointerException），返回 -1
     */
    static int problem5_ParseIntSafe(String s) {
        // ------ 在下面写你的代码 ------
        // 提示：需要两个catch块

        return 0; // TODO: 替换这行

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

    static void checkDouble(String name, double expected, double actual) {
        total++;
        if (Double.isNaN(expected) && Double.isNaN(actual)) {
            System.out.println("  ✅ " + name + ": NaN");
            passed++;
        } else if (Math.abs(expected - actual) < 0.01) {
            System.out.println("  ✅ " + name + ": " + actual);
            passed++;
        } else {
            System.out.println("  ❌ " + name + ": 期望 " + expected + "，实际 " + actual);
        }
    }

    public static void main(String[] args) {
        System.out.println("========== 第八课 练习题批改 ==========\n");

        // 题1
        System.out.println("--- 题1: 安全除法 ---");
        checkDouble("题1-10/2", 5.0, problem1_SafeDivide(10, 2));
        checkDouble("题1-10/0", Double.NaN, problem1_SafeDivide(10, 0));

        // 题2
        System.out.println("--- 题2: 安全取数组 ---");
        int[] arr = {10, 20, 30};
        check("题2-正常取", "20", String.valueOf(problem2_SafeGet(arr, 1)));
        check("题2-越界取", "-1", String.valueOf(problem2_SafeGet(arr, 5)));

        // 题3
        System.out.println("--- 题3: finally ---");
        System.out.print("  题3-输出: ");
        String result = problem3_FinallyDemo();
        check("题3-返回值", "try", result);

        // 题4
        System.out.println("--- 题4: throw ---");
        check("题4-合法分数", "OK", problem4_ValidateScore(85));
        try {
            problem4_ValidateScore(150);
            check("题4-非法分数应抛异常", "❌未抛异常", "❌未抛异常");
        } catch (IllegalArgumentException e) {
            check("题4-非法分数抛异常", "分数不合法: 150", e.getMessage());
        }

        // 题5
        System.out.println("--- 题5: 安全解析 ---");
        check("题5-正常解析", "123", String.valueOf(problem5_ParseIntSafe("123")));
        check("题5-解析失败", "-999", String.valueOf(problem5_ParseIntSafe("abc")));
        check("题5-null", "-1", String.valueOf(problem5_ParseIntSafe(null)));

        System.out.println("\n========== 结果: " + passed + "/" + total + " ==========");
        if (passed == total) {
            System.out.println("🎉 异常处理已掌握！考试不慌了！");
        } else {
            System.out.println("💪 还有 " + (total - passed) + " 项没过，加油！");
        }
    }
}
