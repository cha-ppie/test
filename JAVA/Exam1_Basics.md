# Java 期末模拟卷（一）：基础篇

> 范围：变量 → 方法（Lesson 1-4）  
> 时间：60分钟 | 满分：100分

---

## 一、选择题（每题4分，共40分）

**1.** 以下哪个是合法的 Java 变量名？  
A. `2name`　　B. `_name`　　C. `int`　　D. `name!`

**2.** `double x = 5 / 2;` 执行后，x 的值是多少？  
A. 2.5　　B. 2.0　　C. 3　　D. 2

**3.** `String s1 = "abc"; String s2 = new String("abc");` 则 `s1 == s2` 的结果是？  
A. true　　B. false　　C. 编译错误　　D. null

**4.** `int[] arr = new int[3];` 则 `arr[0]` 的值是？  
A. null　　B. 编译错误　　C. 0　　D. 不确定

**5.** 以下哪个不是 Java 的基本数据类型？  
A. int　　B. boolean　　C. String　　D. double

**6.** `for(int i=0; i<5; i++){}` 循环体执行了多少次？  
A. 4　　B. 5　　C. 6　　D. 无限

**7.** 以下代码段输出什么？
```java
int x = 10;
System.out.println(x++);
```
A. 10　　B. 11　　C. 9　　D. 编译错误

**8.** 以下哪种写法能正确声明一个长度为 5 的 int 数组？  
A. `int arr = new int[5];`  
B. `int[] arr = new int[5];`  
C. `int arr[5];`  
D. `int[5] arr;`

**9.** `5 > 3 && 10 < 5` 的结果是？  
A. true　　B. false　　C. 编译错误　　D. 5

**10.** 以下关键字中，哪个用来定义常量？  
A. static　　B. const　　C. final　　D. constant

---

## 二、判断题（每题2分，共10分）

**1.** Java 中 `int` 可以自动转换成 `double`。（　　）

**2.** `while` 循环的条件如果一开始就是 false，循环体一次都不会执行。（　　）

**3.** Java 数组的长度可以用 `.length()` 方法获得。（　　）

**4.** `break` 语句用于跳出当前循环。（　　）

**5.** 方法重载要求方法名相同、参数列表不同。（　　）

---

## 三、读代码写输出（每题5分，共25分）

**1.**
```java
int a = 5, b = 2;
System.out.println(a / b);
System.out.println(a % b);
System.out.println((double) a / b);
```
输出：\_\_\_\_\_\_\_ / \_\_\_\_\_\_\_ / \_\_\_\_\_\_\_

**2.**
```java
int[] nums = {1, 3, 5, 7, 9};
int sum = 0;
for (int i = 0; i < nums.length; i += 2) {
    sum += nums[i];
}
System.out.println(sum);
```
输出：\_\_\_\_\_\_\_

**3.**
```java
int x = 3;
switch (x) {
    case 1: System.out.print("A"); break;
    case 2: System.out.print("B");
    case 3: System.out.print("C");
    case 4: System.out.print("D"); break;
    default: System.out.print("E");
}
```
输出：\_\_\_\_\_\_\_

**4.**
```java
String s = "Hello";
System.out.println(s.length());
System.out.println(s.charAt(1));
System.out.println(s.toUpperCase());
```
输出：\_\_\_\_\_\_\_ / \_\_\_\_\_\_\_ / \_\_\_\_\_\_\_

**5.**
```java
public static int mystery(int n) {
    if (n == 1) return 1;
    return n + mystery(n - 1);
}
// 调用 mystery(4) 返回什么？
```
输出：\_\_\_\_\_\_\_

---

## 四、编程题（共25分）

**1. (8分)** 写一个方法 `isEven(int n)`，偶数返回 true，奇数返回 false。

**2. (8分)** 写一个方法 `maxOfArray(int[] arr)`，返回数组中的最大值。

**3. (9分)** 用嵌套 for 循环打印以下图案（n=4）：
```
*
**
***
****
```

---

---

# 参考答案

## 一、选择题
1. B　　2. B（整数除法得2，赋给double为2.0）  
3. B（==比地址，equals比内容）  
4. C（int默认值0）  
5. C（String是引用类型）  
6. B（i=0,1,2,3,4）  
7. A（x++先用后加）  
8. B　　9. B（短路：左边true，右边false，整体false）  
10. C

## 二、判断题
1. ✅　2. ✅　3. ❌（是.length，没有括号）　4. ✅　5. ✅

## 三、读代码写输出

**1.** `2` / `1` / `2.5`

**2.** `15`（nums[0]+nums[2]+nums[4] = 1+5+9 = 15）

**3.** `CD`（case 3 匹配，没有 break，穿透到 case 4 执行了 D）

**4.** `5` / `e` / `HELLO`

**5.** `10`（4+3+2+1 = 10）

## 四、编程题

**1.**
```java
static boolean isEven(int n) {
    return n % 2 == 0;
}
```

**2.**
```java
static int maxOfArray(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) max = arr[i];
    }
    return max;
}
```

**3.**
```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("*");
    }
    System.out.println();
}
```
