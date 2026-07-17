/**
 * Java 常用 API 速查 —— 练习题里会用到的所有实用方法
 * 不需要全记住，用到时回来翻就行
 *
 * 每个方法旁边标了 Python 的对应写法，方便对照
 */
public class API_Reference {
    public static void main(String[] args) {

        // ================================================================
        // 一、String 的常用方法
        // Python: s = "hello"   →   s.upper(), s.lower(), len(s)...
        // Java:   String s = "hello";  →  s.toUpperCase(), s.length()...
        // ================================================================

        System.out.println("========== String 方法 ==========");
        String s = "Hello World";

        // 大小写转换 (Python: s.upper() / s.lower())
        System.out.println("toUpperCase(): " + s.toUpperCase());  // "HELLO WORLD"
        System.out.println("toLowerCase(): " + s.toLowerCase());  // "hello world"

        // 长度 (Python: len(s))
        System.out.println("length(): " + s.length());            // 11

        // 取某个位置的字符 (Python: s[0])
        System.out.println("charAt(0): " + s.charAt(0));          // 'H'

        // 截取子串 (Python: s[0:5])
        System.out.println("substring(0,5): " + s.substring(0, 5));  // "Hello"
        System.out.println("substring(6): " + s.substring(6));       // "World"

        // ⚠️ 判断相等 —— Java里千万不能用 == 比较字符串！
        String a = "hello";
        String b = new String("hello");
        System.out.println("a == b: " + (a == b));           // false（比地址）
        System.out.println("a.equals(b): " + a.equals(b));   // true（比内容）

        // 忽略大小写比较
        System.out.println("equalsIgnoreCase: "
            + "Hello".equalsIgnoreCase("hello"));  // true

        // 判断包含/开头/结尾 (Python: in, .startswith, .endswith)
        System.out.println("contains(\"Wor\"): " + s.contains("Wor"));       // true
        System.out.println("startsWith(\"He\"): " + s.startsWith("He"));     // true
        System.out.println("endsWith(\"ld\"): " + s.endsWith("ld"));         // true

        // 替换 (Python: s.replace("l", "X"))
        System.out.println("replace('l','X'): " + s.replace('l', 'X'));

        // 去首尾空白 (Python: s.strip())
        String dirty = "  你好  ";
        System.out.println("trim(): \"" + dirty.trim() + "\"");

        // 分割 (Python: s.split(","))
        String csv = "苹果,香蕉,橘子";
        String[] fruits = csv.split(",");
        System.out.print("split: ");
        for (String f : fruits) System.out.print("[" + f + "] ");
        System.out.println();

        // ================================================================
        // 二、数字 ↔ 字符串 互转  （练习题里高频出现！）
        // ================================================================

        System.out.println("\n========== 数字 ↔ 字符串 ==========");

        // 数字 → 字符串
        int num = 42;
        String s1 = String.valueOf(num);   // ✅ 最推荐
        System.out.println("int→String: " + s1);

        double pi = 3.14;
        System.out.println("double→String: " + String.valueOf(pi));

        boolean flag = true;
        System.out.println("boolean→String: " + String.valueOf(flag));

        // 字符串 → 数字
        int parsed = Integer.parseInt("123");     // Python: int("123")
        double dParsed = Double.parseDouble("3.14"); // Python: float("3.14")
        System.out.println("String→int: " + parsed);
        System.out.println("String→double: " + dParsed);

        // ================================================================
        // 三、StringBuilder —— 高效拼接字符串
        // 练习题打印三角形、乘法表时会用到
        // ================================================================

        System.out.println("\n========== StringBuilder ==========");

        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        sb.append("!");
        System.out.println(sb.toString());  // "Hello World!"

        // 链式调用
        sb = new StringBuilder();
        sb.append("分数:").append(95).append(", ").append(88);
        System.out.println(sb.toString());

        // 什么时候用？题目要你拼一个多行字符串时
        // 比如打印三角形：
        StringBuilder tri = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= i; j++) {
                tri.append("*");
            }
            tri.append("\n");
        }
        System.out.print(tri.toString());

        // ================================================================
        // 四、Math 方法
        // Python: import math
        // Java:   直接用，不用 import
        // ================================================================

        System.out.println("\n========== Math 方法 ==========");
        System.out.println("Math.abs(-10): " + Math.abs(-10));
        System.out.println("Math.max(3,8): " + Math.max(3, 8));
        System.out.println("Math.min(3,8): " + Math.min(3, 8));
        System.out.println("Math.sqrt(16): " + Math.sqrt(16));
        System.out.println("Math.pow(2,10): " + Math.pow(2, 10));
        System.out.println("Math.PI: " + Math.PI);
        System.out.println("Math.round(3.6): " + Math.round(3.6));

        // ================================================================
        // 五、数组打印  （Java直接打印数组是乱码！）
        // Python: print([1,2,3])
        // ================================================================

        System.out.println("\n========== 数组打印 ==========");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("直接打印: " + arr);  // ❌ [I@xxxx
        System.out.println("正确: " + java.util.Arrays.toString(arr));  // ✅ [1,2,3,4,5]

        // 排序
        int[] messy = {5, 2, 8, 1, 9};
        java.util.Arrays.sort(messy);
        System.out.println("排序: " + java.util.Arrays.toString(messy));

        // ================================================================
        // 六、转义字符
        // ================================================================

        System.out.println("\n========== 转义字符 ==========");
        System.out.println("\\n 换行: 第一行\n第二行");
        System.out.println("\\t 制表: A\tB\tC");
        System.out.println("\\\" 引号: 他说\"你好\"");

        // ================================================================
        // 练手
        // ================================================================
        System.out.println("\n========== 练手 ==========");

        // 1. 把名字变大写
        String name = "zhangSan";
        System.out.println("Hello, " + name.toUpperCase());

        // 2. String → int → 运算
        String scoreStr = "95";
        int score = Integer.parseInt(scoreStr);
        System.out.println(scoreStr + " + 5 = " + (score + 5));
    }
}
