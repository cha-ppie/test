# Java 期末模拟卷（三）：综合冲刺篇

> 范围：全部 9 课  
> 时间：120分钟 | 满分：100分  
> 难度：⭐⭐⭐（比前两套难，接近真实期末考）

---

## 一、选择题（每题3分，共30分）

**1.** 以下代码编译后会怎样？
```java
short s = 10;
s = s + 1;
```
A. s 的值变成 11　　B. 编译错误，需要强转  
C. 运行时报错　　D. s 的值不变

**2.** 下列代码输出什么？
```java
int x = 0;
while (x < 3) {
    x++;
}
System.out.println(x);
```
A. 2　　B. 3　　C. 4　　D. 0

**3.** 关于 `static`，说法**错误**的是？  
A. static 方法可以直接调用，不需要创建对象  
B. static 方法中可以访问实例变量  
C. static 变量被该类的所有对象共享  
D. 可以用 `类名.static方法()` 调用

**4.** `int[][] arr = new int[3][];` 执行后，`arr[0]` 的值是？  
A. 0　　B. [0,0,0]　　C. null　　D. 编译错误

**5.** 以下哪个不是 Java 中异常处理的关键字？  
A. try　　B. catch　　C. finally　　D. except

**6.** 接口和抽象类的区别，正确的是？  
A. 接口可以有构造方法  
B. 一个类只能实现一个接口  
C. 接口中的方法默认是 public abstract  
D. 抽象类不能有普通方法

**7.** 以下关于 `this` 的说法**错误**的是？  
A. `this.属性` 用来区分属性和参数  
B. `this()` 调用本类其他构造方法  
C. `this()` 必须写在构造方法第一行  
D. 静态方法中也可以使用 `this`

**8.** 下列哪个集合类存储的是键值对？  
A. ArrayList　　B. LinkedList　　C. HashMap　　D. HashSet

**9.** 以下输出是什么？
```java
String a = "abc";
String b = "abc";
System.out.print(a == b);
System.out.print(a.equals(b));
```
A. truetrue　　B. truefalse　　C. falsetrue　　D. falsefalse

**10.** 关于方法重写，正确的是？  
A. 重写的方法可以改变返回值类型  
B. 重写的方法访问权限可以比父类更严格  
C. 父类的 private 方法可以被重写  
D. 重写的方法不能抛出父类没声明的 checked 异常

---

## 二、填空题（每题3分，共15分）

**1.** Java 中所有类的祖宗是 `________` 类。

**2.** `int[] arr = {1,2,3};` 中，`arr.length` 的值是 `____`。

**3.** 一个类实现接口使用关键字 `________`，继承父类使用关键字 `________`。

**4.** 异常处理中，`________` 块用于无论是否异常都会执行的代码。

**5.** `ArrayList<Integer>` 中，删除索引为 2 的元素用 `________` 方法。

---

## 三、读代码写输出（每题5分，共25分）

**1.**
```java
int a = 3, b = 4;
System.out.println(a + b + " = a + b");
System.out.println("a + b = " + a + b);
```
输出第一行：\_\_\_\_\_\_\_\_\_\_\_
输出第二行：\_\_\_\_\_\_\_\_\_\_\_

**2.**
```java
class A {
    A() { System.out.print("A"); }
}
class B extends A {
    B(int x) { System.out.print("B" + x); }
}
B b = new B(5);
```
输出：\_\_\_\_\_\_\_

**3.**
```java
int[] nums = {2, 4, 6, 8, 10};
for (int i = nums.length - 1; i >= 0; i -= 2) {
    System.out.print(nums[i] + " ");
}
```
输出：\_\_\_\_\_\_\_

**4.**
```java
String s = "Java";
String result = "";
for (int i = s.length() - 1; i >= 0; i--) {
    result += s.charAt(i);
}
System.out.println(result);
```
输出：\_\_\_\_\_\_\_

**5.**
```java
try {
    int[] arr = new int[3];
    arr[0] = 10;
    System.out.print(arr[0] / 0);
} catch (ArithmeticException e) {
    System.out.print("数学错");
} catch (Exception e) {
    System.out.print("其他错");
} finally {
    System.out.print("-finally");
}
```
输出：\_\_\_\_\_\_\_

---

## 四、编程题（共30分）

**1. (10分)** 写一个方法 `isPalindrome(String s)`，判断字符串是否是回文串（正读反读一样，如 "radar"），返回 boolean。
> 提示：用 charAt 或 数组

**2. (10分)** 定义一个抽象类 `Shape`，有抽象方法 `double area()`。写两个子类：
- `Circle(double radius)`：area 返回 π × r²
- `Square(double side)`：area 返回 边长²

然后用多态：创建一个 `Shape[]` 数组包含一个圆(r=3)和一个正方形(边长=4)，遍历打印各自的面积。

**3. (10分)** 写一个方法 `removeDuplicates(ArrayList<Integer> list)`，接收一个有重复元素的 ArrayList，返回去重后的新 ArrayList（保持第一次出现的顺序）。
> 提示：用 ArrayList 的 contains() 方法判断是否已存在

---

---

# 参考答案

## 一、选择题
1. B（s+1 结果是 int，不能直接赋给 short，需要 `s = (short)(s + 1);`）  
2. B（x=0→1→2→3，循环结束）  
3. B（静态方法不能访问实例变量——类加载时实例还不存在）  
4. C（只声明了第一维，第二维没初始化，默认 null）  
5. D（Java 用 catch，不是 except）  
6. C  
7. D（静态方法没有 this）  
8. C  
9. A（字符串常量池：字面量 "abc" 复用同一个对象，所以 a==b 是 true；equals 当然是 true）  
10. D（重写不能抛出父类没声明的 checked 异常；A 返回值类型可以协变但不能改；B 访问权限不能更严格；C private 方法对子类不可见，不叫重写）

## 二、填空题
1. `Object`  
2. `3`  
3. `implements` / `extends`  
4. `finally`  
5. `remove(2)`

## 三、读代码写输出

**1.** 第一行：`7 = a + b`（a+b 先算成 7，再拼字符串）  
第二行：`a + b = 34`（字符串拼接从左到右，"a + b = " + 3 = "a + b = 3"，再 + 4 = "a + b = 34"）

**2.** `AB5`（B构造中没写 super(x)，默认调用无参 super() → A的无参构造打印"A"；然后打印"B5"）

**3.** `10 6 2`（从末尾倒序遍历，步长2：i=4→2→0，对应 nums[4]=10, nums[2]=6, nums[0]=2）

**4.** `avaJ`（倒着拼字符串）

**5.** `数学错-finally`（除零是 ArithmeticException，被第一个 catch 捕获）

## 四、编程题

**1.**
```java
static boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) return false;
        left++;
        right--;
    }
    return true;
}
```

**2.**
```java
abstract class Shape {
    abstract double area();
}
class Circle extends Shape {
    double radius;
    Circle(double r) { this.radius = r; }
    @Override double area() { return Math.PI * radius * radius; }
}
class Square extends Shape {
    double side;
    Square(double s) { this.side = s; }
    @Override double area() { return side * side; }
}
// 使用：
Shape[] shapes = {new Circle(3), new Square(4)};
for (Shape s : shapes) {
    System.out.println(s.area());
}
```

**3.**
```java
static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
    ArrayList<Integer> result = new ArrayList<>();
    for (Integer item : list) {
        if (!result.contains(item)) {
            result.add(item);
        }
    }
    return result;
}
```
