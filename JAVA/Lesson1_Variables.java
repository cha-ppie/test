/**
 * 第一课：Java 变量与基本类型
 * 对比 Python 和 C 来理解
 */
public class Lesson1_Variables {
    public static void main(String[] args) {

        // ========== 1. 基本类型（8种）==========
        // Java有8种"原始类型"，类比C的 int, float 等

        byte   b = 127;          // 1字节，-128~127
        short  s = 32767;        // 2字节
        int    i = 2147483647;   // 4字节（最常用）
        long   l = 9223372036854775807L;  // 8字节，注意末尾L

        float  f = 3.14f;        // 4字节，注意末尾f
        double d = 3.1415926535; // 8字节（小数默认用这个）

        char   c = 'A';          // 2字节，Unicode（和C的1字节不同！）
        boolean flag = true;     // 布尔值，只有true/false

        // 打印试试
        System.out.println("整数: " + i);
        System.out.println("小数: " + d);
        System.out.println("字符: " + c);
        System.out.println("布尔: " + flag);

        // ========== 2. 类型必须匹配 ==========
        // Python可以：x = 10; x = "hello"
        // Java不行！

        int age = 25;
        // age = "二十五";  // ❌ 编译错误！int不能存字符串
        String name = "小明";  // String是引用类型（首字母大写）

        // ========== 3. 自动类型转换 ==========
        // 小范围 → 大范围：自动（和C一样）
        int small = 100;
        double big = small;      // int自动转double ✅
        System.out.println("自动转换: " + big);

        // 大范围 → 小范围：必须强制转换
        double pi = 3.14159;
        int piInt = (int) pi;    // 强制转换，小数部分丢失
        System.out.println("强制转换: " + piInt);  // 输出3

        // ========== 4. 常量 ==========
        // 用 final 关键字（类似C的const，Python没这概念）
        final double GRAVITY = 9.8;
        // GRAVITY = 10;  // ❌ 编译错误！常量不能改

        // ========== 5. 字符串 ==========
        String hello = "Hello";
        String world = "World";
        System.out.println(hello + " " + world);      // + 拼接
        System.out.println(hello.length());            // 方法调用
        System.out.println(hello.toUpperCase());       // 转大写

        // ========== 练手 ==========
        // 试着声明变量计算圆的面积
        double radius = 5.0;
        double area = Math.PI * radius * radius;  // Math.PI是Java内置圆周率
        System.out.println("半径" + radius + "的圆面积: " + area);
    }
}
