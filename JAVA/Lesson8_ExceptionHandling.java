/**
 * 第八课：异常处理（Exception Handling）
 *
 * 异常就是程序运行时出现的错误。不处理的后果：
 *   - 程序直接崩溃
 *   - 控制台打印一堆红字（异常栈跟踪）
 *
 * 考试重点：
 *   1. try-catch-finally 语法
 *   2. checked异常 vs unchecked异常
 *   3. throw（抛出异常）和 throws（声明异常）
 *   4. 常见异常类名（NullPointerException, ArrayIndexOutOfBoundsException...）
 */

public class Lesson8_ExceptionHandling {
    public static void main(String[] args) {

        // ===== 1. 没有异常处理会怎样 =====
        System.out.println("=== 没有异常处理 ===");
        // int[] arr = {1, 2, 3};
        // System.out.println(arr[10]);  // ❌ 程序直接挂掉，后面代码不执行
        // System.out.println("这行永远不会执行");
        System.out.println("上面的代码如果运行会崩溃（已注释）");

        // ===== 2. try-catch =====
        // 格式：
        // try {
        //     可能出异常的代码
        // } catch (异常类型 变量名) {
        //     出异常后的处理
        // }
        System.out.println("\n=== try-catch ===");

        // 例A：数组越界
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[10]);  // 会抛 ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获到异常: 数组越界了！" + e.getMessage());
        }
        System.out.println("异常被捕获，程序继续执行 ✅");

        // 例B：除零异常
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("算术异常: " + e);
        }

        // 例C：空指针异常 —— 最最常见的异常！
        try {
            String s = null;
            System.out.println(s.length());  // 对null调用方法 → NullPointerException
        } catch (NullPointerException e) {
            System.out.println("空指针！你是不是忘了new？");
        }

        // ===== 3. 多重 catch =====
        // 一个try可以跟多个catch，子类异常要写在父类前面！
        System.out.println("\n=== 多重catch ===");
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("空指针");
        } catch (RuntimeException e) {
            System.out.println("其他运行时异常");
        } catch (Exception e) {
            System.out.println("兜底：所有异常");
        }
        // ⚠️ 如果把 Exception 写在最前面，后面的catch永远不会执行（编译错误）

        // ===== 4. finally —— 无论如何都会执行 =====
        System.out.println("\n=== finally ===");
        try {
            System.out.println("try块开始");
            int x = 10 / 2;  // 不抛异常
            // int x = 10 / 0;  // 抛异常
            System.out.println("try块结束");
        } catch (ArithmeticException e) {
            System.out.println("catch块");
        } finally {
            System.out.println("finally块：无论是否异常，我都会执行！");
            // 典型用途：关闭文件、释放资源、关闭数据库连接
        }

        // ===== 5. throw 和 throws =====
        // throw：在方法内部手动抛出异常
        // throws：在方法声明上，告诉调用者"我可能抛异常，你处理"

        System.out.println("\n=== throw / throws ===");
        try {
            checkAge(15);  // 年龄不够，会抛异常
        } catch (IllegalArgumentException e) {
            System.out.println("捕获: " + e.getMessage());
        }

        // 调用声明了throws的方法，必须处理（try-catch）或继续往外throws
        try {
            mightFail();
        } catch (Exception e) {
            System.out.println("处理了mightFail的异常: " + e.getMessage());
        }

        // ===== 6. 常见异常类一览（考试可能考选择/填空）=====
        System.out.println("\n=== 常见异常类 ===");
        System.out.println("NullPointerException      - 对null调用方法/属性");
        System.out.println("ArrayIndexOutOfBounds      - 数组下标越界");
        System.out.println("ArithmeticException        - 算术错误（如除零）");
        System.out.println("NumberFormatException      - 字符串转数字格式不对");
        System.out.println("ClassCastException         - 强制类型转换错误");
        System.out.println("IllegalArgumentException   - 参数不合法");
        System.out.println("IOException                - 输入输出异常(checked)");
        System.out.println("SQLException               - 数据库异常(checked)");
        System.out.println("FileNotFoundException      - 文件未找到(checked)");
        System.out.println();
        System.out.println("checked异常：编译器强制要求处理（try-catch或throws）");
        System.out.println("unchecked异常：运行时异常，编译器不管（RuntimeException的子类）");

        System.out.println("\n=== 程序正常结束 ===");
    }

    // throw 演示：主动抛异常
    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("年龄必须>=18，你传的是" + age);
        }
        System.out.println("年龄合格");
    }

    // throws 演示：声明可能抛出的异常
    static void mightFail() throws Exception {
        if (Math.random() > 0.5) {
            throw new Exception("出错了！");
        }
        System.out.println("mightFail: 一切正常");
    }
}
