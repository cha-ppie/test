/**
 * 第二课 配套练习题：运算符与控制流
 * 每个方法对应一道题，按要求填空或实现
 * 运行 main 即可自行批改
 */
public class Lesson2_Exercises {

    // ==================== 题目区 ====================

    /**
     * 题1：计算 BMI
     * BMI = 体重(kg) / 身高(m)²
     * 参数 weight(kg), height(m)，返回 BMI 值（double）
     */
    static double problem1_BMI(double weight, double height) {
        // ------ 在下面写你的代码 ------
        // BMI = 体重 / 身高²
        double bmi = weight / (height * height);
        return bmi; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题2：判断奇偶
     * 参数 n，如果是偶数返回字符串 "偶数"，否则返回 "奇数"
     * 提示：用 % 运算符
     */
    static String problem2_EvenOrOdd(int n) {
        // ------ 在下面写你的代码 ------
        // 提示: n % 2 == 0 就是偶数
        if(n % 2 == 0   ){
            return "偶数";
        }else{
            return "奇数";
        }
         // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题3：取绝对值
     * 参数 n，返回它的绝对值。不能使用 Math.abs()
     * 提示：三元运算符
     */
    static int problem3_Absolute(int n) {
        // ------ 在下面写你的代码 ------
        // 提示: 用三元运算符 条件 ? 真 : 假

        return n < 0 ? -n : n; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题4：成绩等级
     * >=90 → "A",  >=80 → "B",  >=70 → "C",  >=60 → "D",  <60 → "F"
     * 用 if-else 实现
     */
    static String problem4_GradeLevel(int score) {
        // ------ 在下面写你的代码 ------
        // >=90→A, >=80→B, >=70→C, >=60→D, <60→F
        switch (score /10){
            case 10:
            case 9 :return "A";
            case 8 :return "B";
            case 7 :return "C";
            case 6 :return "D";
            default:return "F";
        }
  

        // ------ 上面是你的代码 ------
    }

    /**
     * 题5：星期几（switch版）
     * 输入 1~7，返回对应的中文星期（"星期一"~"星期日"）
     * 输入其他数字返回 "无效"
     * 要求：使用 switch 语句
     */
    static String problem5_Weekday(int day) {
        // ------ 在下面写你的代码 ------
        // 使用 switch 语句，1→星期一, 2→星期二, ... 7→星期日
        String date = "";

        switch (day){
            case 1:date = "星期一";break;
            case 2:date = "星期二";break;
            case 3:date = "星期三";break;
            case 4:date = "星期四";break;
            case 5:date = "星期五";break;
            case 6:date = "星期六";break;
            case 7:date = "星期日";break;
            default:date = "无效";
        }

        return date; // TOD`O: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题6：累加求和
     * 计算 1+2+...+n 的和，用 for 循环实现
     * 提示：高斯公式 n*(n+1)/2 可以用来验证，但请用循环写
     */
    static int problem6_SumToN(int n) {
        // ------ 在下面写你的代码 ------
        // 用 for 循环求 1+2+...+n

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题7：阶乘
     * 计算 n! = 1×2×...×n
     * 用 while 循环实现
     * 规定 0! = 1
     */
    static int problem7_Factorial(int n) {
        // ------ 在下面写你的代码 ------
        // 用 while 循环求 n! (n的阶乘)，0! = 1
        int result = 1;
        while(n != 0){
            result *= n;
            n--;
        }
        return result; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题8：判断质数
     * 参数 n >= 2，如果 n 是质数返回 true，否则返回 false
     * 质数：只能被 1 和它本身整除
     * 提示：从 2 遍历到 n-1（或用 sqrt(n) 优化），用 break 提前跳出
     */
    static boolean problem8_IsPrime(int n) {
        // ------ 在下面写你的代码 ------
        // 质数: 只能被1和自身整除。从2检查到sqrt(n)

        return false; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题9（拔高）：FizzBuzz
     * 参数 n，按以下规则返回字符串：
     * - 能被3整除 → "Fizz"
     * - 能被5整除 → "Buzz"
     * - 能同时被3和5整除 → "FizzBuzz"
     * - 其他情况 → 数字本身的字符串，如 "7"
     *
     * ⚠️ 注意：要先判断"同时整除"的情况！想想为什么。
     */
    static String problem9_FizzBuzz(int n) {
        // ------ 在下面写你的代码 ------
        // 能被3整除→"Fizz", 被5整除→"Buzz", 同时被3和5→"FizzBuzz"
        // ⚠️ 先判断"同时整除"的情况！

        return ""; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题10（拔高）：打印三角形
     * 参数 n，返回一个 n 行由 * 组成的直角三角形字符串
     * 每行以换行符 \n 结尾（包括最后一行）
     * 例如 n=3，返回：
     * "*\n**\n***\n"
     * （即三行：第一行1个星，第二行2个星，第三行3个星）
     */
    static String problem10_PrintTriangle(int n) {
        // ------ 在下面写你的代码 ------
        // n=3 应返回 "*\n**\n***\n"
        // 提示: 嵌套 for 循环，外层控制行，内层控制每行的星号数

        return ""; // TODO: 替换这行

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
        if (Math.abs(expected - actual) < 0.01) {
            System.out.println("  ✅ " + name + ": " + actual);
            passed++;
        } else {
            System.out.println("  ❌ " + name + ": 期望 " + expected + "，实际 " + actual);
        }
    }

    public static void main(String[] args) {
        System.out.println("========== 第二课 练习题批改 ==========\n");

        // 题1
        checkDouble("题1-BMI 70kg/1.75m", 22.86, problem1_BMI(70, 1.75));

        // 题2
        check("题2-偶数", "偶数", problem2_EvenOrOdd(8));
        check("题2-奇数", "奇数", problem2_EvenOrOdd(7));
        check("题2-0是偶数", "偶数", problem2_EvenOrOdd(0));

        // 题3
        checkInt("题3-正数绝对值", 5, problem3_Absolute(5));
        checkInt("题3-负数绝对值", 5, problem3_Absolute(-5));
        checkInt("题3-零的绝对值", 0, problem3_Absolute(0));

        // 题4
        check("题4-95分", "A", problem4_GradeLevel(95));
        check("题4-85分", "B", problem4_GradeLevel(85));
        check("题4-72分", "C", problem4_GradeLevel(72));
        check("题4-60分", "D", problem4_GradeLevel(60));
        check("题4-45分", "F", problem4_GradeLevel(45));

        // 题5
        check("题5-周一", "星期一", problem5_Weekday(1));
        check("题5-周日", "星期日", problem5_Weekday(7));
        check("题5-无效", "无效", problem5_Weekday(8));

        // 题6
        checkInt("题6-1到5求和", 15, problem6_SumToN(5));
        checkInt("题6-1到100求和", 5050, problem6_SumToN(100));

        // 题7
        checkInt("题7-5的阶乘", 120, problem7_Factorial(5));
        checkInt("题7-0的阶乘", 1, problem7_Factorial(0));

        // 题8
        check("题8-7是质数", "true", String.valueOf(problem8_IsPrime(7)));
        check("题8-10不是质数", "false", String.valueOf(problem8_IsPrime(10)));
        check("题8-2是质数", "true", String.valueOf(problem8_IsPrime(2)));

        // 题9
        check("题9-能被3整除", "Fizz", problem9_FizzBuzz(3));
        check("题9-能被5整除", "Buzz", problem9_FizzBuzz(5));
        check("题9-能同时被3和5整除", "FizzBuzz", problem9_FizzBuzz(15));
        check("题9-都不能", "7", problem9_FizzBuzz(7));

        // 题10
        check("题10-3行三角形",
            "*\n**\n***\n",
            problem10_PrintTriangle(3));
        check("题10-1行三角形",
            "*\n",
            problem10_PrintTriangle(1));

        // 汇总
        System.out.println("\n========== 结果: " + passed + "/" + total + " ==========");
        if (passed == total) {
            System.out.println("🎉 全部通过！基础很扎实了！");
        } else {
            System.out.println("💪 还有 " + (total - passed) + " 题没过，看看上面提示吧！");
        }
    }
}
