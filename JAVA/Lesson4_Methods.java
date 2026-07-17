/**
 * 第四课：Java 方法（函数）
 * 对比 Python 函数和 C 函数来理解
 *
 * Python: def greet(name): return "Hello " + name
 * C:      char* greet(char name[]) { ... }
 * Java:   static String greet(String name) { ... }
 *
 * Java方法的完整格式：
 *   [修饰符] 返回类型 方法名(参数类型 参数名, ...) { 方法体 }
 *
 * 本节重点：
 *   1. 方法的定义与调用
 *   2. 参数传递（值传递 vs 引用传递）
 *   3. 方法重载（Overloading）
 *   4. 递归
 *   5. 可变参数
 */
public class Lesson4_Methods {

    // ===== 1. 基本方法定义 =====
    // 格式: static 返回类型 方法名(参数列表) { return 值; }
    // void 表示无返回值（类似Python隐式return None）

    static void sayHello() {
        System.out.println("Hello!");
        // 没有return，因为是void
    }

    static int add(int a, int b) {
        return a + b;
    }

    static String greet(String name) {
        return "你好, " + name + "!";
    }

    // ===== 2. 参数传递：Java只有值传递！=====
    // ⚠️ 基本类型：传的是值的拷贝，方法内修改不影响外面
    // ⚠️ 引用类型（数组、对象）：传的是引用的拷贝，但指向同一个对象！

    static void tryChangeInt(int x) {
        x = 999;  // 只改了副本，外面不变
    }

    static void tryChangeArray(int[] arr) {
        arr[0] = 999;  // 改了同一个数组，外面也变了！
    }

    // ===== 3. 方法重载（Overloading）=====
    // 同名方法，参数不同（个数/类型/顺序）
    // 编译器根据调用时传入的参数自动匹配
    // Python没有这个特性（后定义会覆盖先定义）

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int max(int a, int b, int c) {
        return max(max(a, b), c);  // 调用上面的两个数版本
    }

    static double max(double a, double b) {
        return a > b ? a : b;
    }

    static String max(String a, String b) {
        // 字符串的"大"：比较长度
        return a.length() > b.length() ? a : b;
    }

    // ===== 4. 递归 =====
    // 方法调用自己，必须有终止条件
    // 和C/Python的递归概念一模一样

    static int factorial(int n) {
        if (n <= 1) return 1;       // 终止条件（递归基）
        return n * factorial(n - 1); // 递归调用
    }

    static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ===== 5. 可变参数（varargs）=====
    // 可以传任意数量的参数，编译器自动打包成数组
    // 相当于 Python 的 *args

    static int sumAll(int... numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    // 可变参数要放在最后面
    static String format(String prefix, int... nums) {
        StringBuilder sb = new StringBuilder(prefix);
        for (int n : nums) {
            sb.append(" ").append(n);
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        // ===== 1. 基本调用 =====
        System.out.println("=== 基本方法调用 ===");
        sayHello();
        System.out.println("3 + 5 = " + add(3, 5));
        System.out.println(greet("小明"));

        // ===== 2. 参数传递演示 =====
        System.out.println("\n=== 参数传递 ===");
        int num = 10;
        tryChangeInt(num);
        System.out.println("tryChangeInt后: " + num + "  ← 没变！（基本类型值传递）");

        int[] myArr = {1, 2, 3};
        tryChangeArray(myArr);
        System.out.println("tryChangeArray后: [" + myArr[0] + ", " + myArr[1] + ", " + myArr[2] + "]  ← 变了！（引用传递）");

        // ===== 3. 重载演示 =====
        System.out.println("\n=== 方法重载 ===");
        System.out.println("max(10, 20) = " + max(10, 20));
        System.out.println("max(10, 20, 5) = " + max(10, 20, 5));
        System.out.println("max(3.14, 2.71) = " + max(3.14, 2.71));
        System.out.println("max(\"hello\", \"world!\") = " + max("hello", "world!"));

        // ===== 4. 递归演示 =====
        System.out.println("\n=== 递归 ===");
        System.out.println("5! = " + factorial(5));          // 120
        System.out.print("斐波那契前10项: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        // ===== 5. 可变参数演示 =====
        System.out.println("\n=== 可变参数 ===");
        System.out.println("sumAll(1, 2, 3) = " + sumAll(1, 2, 3));
        System.out.println("sumAll(10, 20, 30, 40, 50) = " + sumAll(10, 20, 30, 40, 50));
        System.out.println("sumAll() = " + sumAll());  // 可以不传
        System.out.println(format("分数:", 95, 88, 76));

        // ===== 练手：判断回文数 =====
        System.out.println("\n=== 练手：回文数判断 ===");
        System.out.println("121 是回文数? " + isPalindrome(121));   // true
        System.out.println("123 是回文数? " + isPalindrome(123));   // false
        System.out.println("-121 是回文数? " + isPalindrome(-121)); // false
    }

    // 回文数：正读反读一样，如121、1221
    // 不能用字符串，用数学方法反转数字
    static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }
}
