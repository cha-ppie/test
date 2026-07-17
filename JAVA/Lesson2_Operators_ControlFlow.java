/**
 * 第二课：Java 运算符与控制流
 * 对比 Python 和 C 来理解
 */
public class Lesson2_Operators_ControlFlow {
    public static void main(String[] args) {

        // ========== 1. 算术运算符 ==========
        // 和C一模一样：+ - * / %
        int a = 10, b = 3;

        System.out.println("=== 算术运算符 ===");
        System.out.println("a + b = " + (a + b));   // 13
        System.out.println("a - b = " + (a - b));   // 7
        System.out.println("a * b = " + (a * b));   // 30
        System.out.println("a / b = " + (a / b));   // 3（整数除法，截断！）
        System.out.println("a % b = " + (a % b));   // 1（取余）

        // 如果要小数结果，至少一个操作数是小数
        System.out.println("a / 3.0 = " + (a / 3.0)); // 3.333...

        // 自增/自减（和C一样）
        int x = 5;
        System.out.println("x++ = " + (x++));  // 5（先用后加）
        System.out.println("现在 x = " + x);    // 6
        System.out.println("++x = " + (++x));  // 7（先加后用）

        // ========== 2. 赋值运算符 ==========
        System.out.println("\n=== 赋值运算符 ===");
        int n = 10;
        n += 5;   // 等价 n = n + 5
        System.out.println("n += 5 → " + n);  // 15
        n -= 3;   // n = n - 3
        System.out.println("n -= 3 → " + n);  // 12
        n *= 2;   // n = n * 2
        System.out.println("n *= 2 → " + n);  // 24
        n /= 4;   // n = n / 4
        System.out.println("n /= 4 → " + n);  // 6
        n %= 4;   // n = n % 4
        System.out.println("n %= 4 → " + n);  // 2

        // ========== 3. 比较运算符 ==========
        // 结果都是 boolean（true/false）
        System.out.println("\n=== 比较运算符 ===");
        System.out.println("5 == 5 → " + (5 == 5));   // true
        System.out.println("5 != 3 → " + (5 != 3));   // true
        System.out.println("5 > 3  → " + (5 > 3));    // true
        System.out.println("5 < 3  → " + (5 < 3));    // false
        System.out.println("5 >= 5 → " + (5 >= 5));   // true
        System.out.println("5 <= 3 → " + (5 <= 3));   // false

        // ⚠️ String 比较不能用 ==！要用 .equals()
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println("s1 == s2       → " + (s1 == s2));        // false（比地址！）
        System.out.println("s1.equals(s2) → " + s1.equals(s2));      // true（比内容！）

        // ========== 4. 逻辑运算符 ==========
        System.out.println("\n=== 逻辑运算符 ===");
        boolean t = true, f = false;
        System.out.println("t && f → " + (t && f));  // false（与：两边都真才真）
        System.out.println("t || f → " + (t || f));  // true （或：一边真就真）
        System.out.println("!t     → " + (!t));      // false（非：取反）

        // 短路求值：&& 左边为false就不看右边；|| 左边为true就不看右边
        int score = 80;
        // 如果score < 0，后半段根本不会执行（避免除零错误，虽然这里没有）
        boolean valid = score >= 0 && score <= 100;
        System.out.println("分数有效: " + valid);

        // ========== 5. 三元运算符 ==========
        // 条件 ? 真时值 : 假时值   （Python: val if cond else other）
        System.out.println("\n=== 三元运算符 ===");
        int age = 20;
        String status = (age >= 18) ? "成年" : "未成年";
        System.out.println(age + "岁 → " + status);

        // ========== 6. if / else if / else ==========
        // 和C一样，记得条件用 ()
        System.out.println("\n=== if-else ===");
        int grade = 85;

        if (grade >= 90) {
            System.out.println("优秀");
        } else if (grade >= 80) {
            System.out.println("良好");
        } else if (grade >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        // ========== 7. switch ==========
        // Java 7+ 支持 String；和C一样有"穿透"，要加break
        System.out.println("\n=== switch ===");
        String day = "周一";

        switch (day) {
            case "周一":
                System.out.println("痛苦的开始");
                break;   // 没有break会继续执行下一个case！
            case "周五":
                System.out.println("即将解放");
                break;
            case "周六":
            case "周日":   // 两个case共享同一段代码
                System.out.println("周末愉快！");
                break;
            default:
                System.out.println("普通的一天");
        }

        // ========== 8. for 循环 ==========
        // 和C一模一样
        System.out.println("\n=== for 循环 ===");
        System.out.print("1到5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 增强for循环（foreach），遍历数组或集合
        System.out.print("遍历数组: ");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ========== 9. while 循环 ==========
        System.out.println("\n=== while 循环 ===");
        int count = 1;
        while (count <= 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();

        // do-while：至少执行一次（先do后判断）
        System.out.print("do-while: ");
        int num = 10;
        do {
            System.out.print(num + " ");
            num++;
        } while (num <= 5);  // 条件不成立，但已经执行了一次
        System.out.println("← 至少执行了一次");

        // ========== 10. break 和 continue ==========
        System.out.println("\n=== break / continue ===");
        System.out.print("break（到5就停）: ");
        for (int i = 1; i <= 10; i++) {
            if (i > 5) break;
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("continue（跳过偶数）: ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;  // 跳过本次循环剩余代码
            System.out.print(i + " ");
        }
        System.out.println();

        // ========== 练手：九九乘法表 ==========
        System.out.println("\n=== 练手：九九乘法表 ===");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
