# Java 面向对象程序设计 — 习题全集

> 提取自 `习题PPT.html`，共 **33 道题**，按题型分为四大类：选择题（20）、阅读程序写结果（7）、程序填空（5）、程序设计题（1）。

---

# 第一部分：选择题（20 道）

## 模块一：Java 基础与数组

### Q01 开发工具
在命令行开发 Java 程序时，用于把源代码翻译成 JVM 可识别中间形式的工具是（  ）。

A. java　　B. javac　　C. javadoc　　D. jar

**答案：B**
**解析：** javac 负责把 .java 源文件编译成 .class 字节码；java 命令用于启动 JVM 执行字节码。

---

### Q02 JVM职责
下列哪项更准确地描述了 JVM 的作用（  ）。

A. 负责编辑 Java 源代码　　B. 负责运行字节码并管理运行时环境　　C. 负责把网页转换为 Java 类　　D. 负责替代操作系统管理所有文件

**答案：B**
**解析：** JVM 负责装载并运行字节码，同时管理运行时内存、类加载等环境。

---

### Q03 字符常量
下列赋值语句中，能够正确声明一个 char 变量的是（  ）。

A. `char grade = 'A';`　　B. `char grade = "A";`　　C. `char grade = true;`　　D. `char grade = 65.5;`

**答案：A**
**解析：** `'A'` 是 char 字符常量；`"A"` 是字符串，`true` 是 boolean，`65.5` 是小数。

---

### Q04 复合赋值
执行 `int x = 4; x += 3 * 2;` 后，x 的值是（  ）。

A. 10　　B. 14　　C. 11　　D. 24

**答案：A**
**解析：** `3 * 2` 先得到 6，`x += 6` 等价于 `x = x + 6`，所以 x 为 10。

---

### Q05 break语句
在 switch 或循环结构中，break 语句通常用于（  ）。

A. 跳过本次循环剩余语句并进入下一次循环　　B. 立即结束所在的 switch 或循环结构　　C. 创建一个新对象　　D. 捕获异常对象

**答案：B**
**解析：** break 会立即结束所在 switch 或循环；continue 只结束本次循环，进入下一次循环判断。

---

### Q07 数组与自增运算
已知 `int[] nums = {4, 7, 9}; int i = 0;` 执行 `nums[++i] = nums[i] + nums[i + 1];` 后，`nums[1]` 的值是（  ）。

A. 7　　B. 13　　C. 16　　D. 9

**答案：C**
**解析：** `++i` 先使 i 变为 1，左侧是 `nums[1]`；右侧 `nums[1] + nums[2]` = 7 + 9 = 16。

---

## 模块二：类、对象与封装

### Q08 方法重载
同一个类中多个方法名称相同，但参数列表不同，这种现象称为（  ）。

A. 方法重载　　B. 方法重写　　C. 自动装箱　　D. 异常传播

**答案：A**
**解析：** 同类中方法名相同但参数个数、类型或顺序不同，称为方法重载。重写发生在继承关系中。

---

### Q11 封装访问
某个成员变量被 private 修饰后，外部类通常应通过什么方式安全访问它（  ）。

A. 直接使用对象名.变量名　　B. 通过公开的 getter 或 setter 方法　　C. 使用 import 语句　　D. 使用 break 语句

**答案：B**
**解析：** private 成员通常通过 public getter/setter 间接访问，这体现封装和访问控制。

---

## 模块三：继承、多态与异常

### Q12 方法重写判断
阅读下面程序，判断编译结果是（  ）。

```java
class Parent {
    void print(int n) {
        System.out.println("P" + n);
    }
}

class Child extends Parent {
    @Override
    void print(String n) {
        System.out.println("C" + n);
    }
}
```

A. 编译通过，Child 正确重写了 print 方法　　B. 编译通过，但运行时才会报错　　C. 编译失败，因为参数列表不同，不构成重写　　D. 编译失败，因为子类不能定义 print 方法

**答案：C**
**解析：** 父类方法参数是 int，子类方法参数是 String，参数列表不同，属于重载而不是重写；加上 @Override 后编译器会报错。

---

### Q13 构造链
创建子类对象时，若构造方法中没有显式调用父类构造方法，系统通常会先尝试调用父类的（  ）。

A. private 方法　　B. 无参数构造方法　　C. main 方法　　D. toString 字段

**答案：B**
**解析：** 子类构造方法没有显式写出父类构造调用时，编译器会默认尝试调用父类无参数构造方法。

---

### Q16 受检异常
下列哪种情况通常需要显式处理或声明可能抛出的受检异常（  ）。

A. 打开文件进行读写　　B. 两个 int 相加　　C. 访问对象的 public 方法　　D. 给 boolean 变量赋值

**答案：A**
**解析：** 文件读写可能因为路径、权限等原因失败，通常需要捕获或声明 IOException；普通 int 运算不需要。

---

### Q17 catch顺序
如果多个 catch 同时可能匹配同一种异常，较具体的异常类型通常应写在（  ）。

A. 较通用异常类型之后　　B. 较通用异常类型之前　　C. finally 块之后　　D. 类声明之外

**答案：B**
**解析：** 多个 catch 从上到下匹配，子类异常应写在父类异常之前（先具体，后一般），否则会出现不可达代码问题。

---

## 模块四：实用类、集合与泛型

### Q20 包装类转换
下列语句执行后，变量 n 的值是（  ）。

```java
int n = Integer.valueOf("15");
```

A. 0　　B. 5　　C. 15　　D. `"15"`

**答案：C**
**解析：** `Integer.valueOf("15")` 将字符串形式的整数转换为 Integer，赋给 int 时发生自动拆箱，结果为整数 15。

---

### Q22 Queue特点
在 Java 集合框架中，Queue 接口最常用于表示哪类数据结构（  ）。

A. 先进先出的队列　　B. 键值映射表　　C. 不可变字符串　　D. 文件路径

**答案：A**
**解析：** Queue 常表示队列结构，典型访问顺序是 FIFO，先进先出。

---

### Q23 Collections工具类
若要反转 List 中元素的排列顺序，可以使用的方法是（  ）。

A. `Collections.reverse(list)`　　B. `list.keySet()`　　C. `Math.reverse(list)`　　D. `Arrays.length(list)`

**答案：A**
**解析：** `Collections.reverse(list)` 可反转 List 中元素顺序；keySet 属于 Map，`Arrays.length` 不是合法方法。

---

### Q26 泛型集合
已知 `List<String> names = new ArrayList<>();` 下列哪条语句能够正确加入一个元素（  ）。

A. `names.add("Java")`　　B. `names.add(100)`　　C. `names.put("Java")`　　D. `names.length()`

**答案：A**
**解析：** names 是 `List<String>`，只能添加字符串元素；add 是 List 添加元素的方法。

---

## 模块五：IO、多线程与综合设计

### Q28 try-with-resources
try-with-resources 语句的主要好处是（  ）。

A. 自动关闭实现 AutoCloseable 的资源　　B. 自动启动新线程　　C. 自动排序集合元素　　D. 自动把 int 转换为 boolean

**答案：A**
**解析：** try-with-resources 会在语句结束时自动关闭实现 AutoCloseable 的资源，减少忘记 close 的问题。

---

### Q29 IO包
在 Java 程序中使用常见文件读写类时，通常需要导入的包是（  ）。

A. `java.io`　　B. `java.time`　　C. `java.awt`　　D. `java.net`

**答案：A**
**解析：** java.io 包中提供了多种输入输出相关类。

---

### Q31 sleep方法
`Thread.sleep(1000)` 通常表示（  ）。

A. 让当前线程暂停约 1 秒　　B. 永久停止所有线程　　C. 创建一个文件　　D. 把集合转换为数组

**答案：A**
**解析：** `Thread.sleep(1000)` 让当前线程暂停约 1000 毫秒，之后仍可继续运行。

---

### Q32 线程基础概念
下列哪项最符合 Java 中线程的含义（  ）。

A. 程序中一条可以独立执行的执行路径　　B. 专门保存键值对的数据结构　　C. 用于表示文件路径的类　　D. 只能保存字符串的数组

**答案：A**
**解析：** 线程表示程序中的一条执行路径，可与其他线程并发执行。

---

# 第二部分：阅读程序写结果（7 道）

## Q06 数组与循环
写出下面程序的输出结果。

```java
public class TestBasic {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 6};
        int total = 0;
        for (int n : nums) {
            if (n % 3 == 0) {
                continue;
            }
            total += n;
        }
        System.out.println(total);
    }
}
```

**输出：**
```
5
```
**解析：** 3 和 6 能被 3 整除，会执行 continue；只累加 1 和 4，所以 total 为 5。

---

## Q10 对象参数
写出下面程序的输出结果。

```java
class Box {
    int count;
    Box(int count) {
        this.count = count;
    }
}

public class TestObject {
    static void change(Box b) {
        b.count += 3;
        b = new Box(9);
        b.count++;
    }

    public static void main(String[] args) {
        Box x = new Box(2);
        change(x);
        System.out.println(x.count);
    }
}
```

**输出：**
```
5
```
**解析：** `b.count += 3` 修改了 x 指向的对象，count 从 2 变为 5；之后 b 指向新 Box，不影响 x。

---

## Q15 动态绑定与引用修改
写出下面程序的输出结果。

```java
class Notice {
    String title;

    Notice(String title) {
        this.title = title;
    }

    void show() {
        System.out.println("Notice:" + title);
    }
}

class EmailNotice extends Notice {
    int count;

    EmailNotice(String title, int count) {
        super(title);
        this.count = count;
    }

    void add() {
        count += 2;
    }

    void show() {
        System.out.println("Email:" + title + ":" + count);
    }
}

public class TestExt {
    public static void main(String[] args) {
        Notice n = new EmailNotice("Exam", 1);
        EmailNotice e = (EmailNotice) n;
        e.add();
        e.title = "Review";
        n.show();
    }
}
```

**输出：**
```
Email:Review:3
```
**解析：** n 实际指向 EmailNotice 对象，强制转换后的 e 与 n 指向同一对象。e.add() 使 count 从 1 变为 3，e.title 改为 Review；n.show() 动态绑定到 EmailNotice 的 show 方法。

---

## Q18 异常捕获结构
写出下面程序的输出结果。

```java
public class Test {
    public static void main(String[] args) {
        try {
            String text = null;
            System.out.println(text.length());
            System.out.println("ok");
        } catch (NullPointerException e) {
            System.out.println("empty text");
        } finally {
            System.out.println("finish check");
        }
    }
}
```

**输出：**
```
empty text
finish check
```
**解析：** text 为 null，调用 length() 时抛出 NullPointerException，进入 catch 输出 empty text；try 中的 ok 不会输出；finally 输出 finish check。

---

## Q19 String方法
写出下面程序的输出结果。

```java
public class TestText {
    public static void main(String[] args) {
        String text = "  Java-Exam  ";
        String clean = text.trim();
        String left = clean.substring(0, 4);
        String right = clean.substring(clean.indexOf("-") + 1);
        System.out.println(left.toLowerCase() + ":" + right.length());
        System.out.println(clean.startsWith("Java"));
    }
}
```

**输出：**
```
java:4
true
```
**解析：** trim 后为 `"Java-Exam"`；left 是 `"Java"`，right 是 `"Exam"`，长度为 4；clean 以 `"Java"` 开头。

---

## Q21 StringBuilder修改
写出下面程序的输出结果。

```java
public class TestUtil {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("classroom");
        sb.replace(0, 5, "Java");
        sb.deleteCharAt(4);
        sb.insert(4, "-");
        sb.append(sb.length());
        System.out.println(sb.toString());
    }
}
```

**输出：**
```
Java-oom8
```
**解析：** replace(0, 5, "Java") 将 class 替换为 Java，得到 Javaroom；deleteCharAt(4) 删除 r，得到 Javaoom；insert(4, "-") 得到 Java-oom；此时长度为 8，append(8) 后输出 Java-oom8。

---

## Q24 List下标增删
写出下面程序的输出结果。

```java
import java.util.*;

public class TestJcf {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove(1);
        list.add(1, "D");
        for (String s : list) {
            System.out.print(s);
        }
    }
}
```

**输出：**
```
ADC
```
**解析：** 初始列表为 A、B、C；remove(1) 删除 B，变为 A、C；add(1, "D") 后变为 A、D、C，所以输出 ADC。

---

# 第三部分：程序填空（5 道）

## Q09 构造方法与成员方法
根据输出结果补全程序。

**目标输出：** `Java:36`

```java
class Course {
    private String name;
    private int hours;

    public Course(String name, int hours) {
        this.name = ________;        // ①
        this.hours = ________;       // ②
    }

    public void addHours(int n) {
        hours += ________;           // ③
    }

    public String info() {
        return name + ":" + hours;
    }
}

public class Test {
    public static void main(String[] args) {
        Course c = new Course("Java", 32);
        c.addHours(4);
        System.out.println(c.________());  // ④
    }
}
```

**答案：** ① name　② hours　③ n　④ info
**解析：** 构造方法把参数保存到成员变量；addHours(4) 让 hours 从 32 变为 36；info 方法返回 Java:36。

---

## Q14 抽象类实现
补全程序，使其输出：`Circle:9.0`

```java
abstract class Figure {
    abstract double area();
}

class Circle extends Figure {
    private double r;
    public Circle(double r) {
        this.r = r;
    }
    public double ________() {    // ①
        return r * r;
    }
}

public class Test {
    public static void main(String[] args) {
        Figure f = new ________(3);     // ②
        System.out.println("Circle:" + f.________());  // ③
    }
}
```

**答案：** ① area　② Circle　③ area
**解析：** Circle 实现抽象方法 area；Figure f = new Circle(3) 体现父类引用指向子类对象。

---

## Q25 Iterator遍历集合
补全程序，使用迭代器输出集合元素。

**目标输出：** `A B C`

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        Iterator<String> it = list.________();   // ①
        while (it.________()) {                   // ②
            System.out.print(it.________() + " ");// ③
        }
    }
}
```

**答案：** ① iterator　② hasNext　③ next
**解析：** list.iterator() 得到迭代器；hasNext() 判断是否还有元素；next() 取出当前元素并移动到下一个。

---

## Q27 泛型方法补全
补全程序，使其输出：

```
Java
90
```

```java
public class Test {
    public static <T> ________ first(T[] data) {  // ①
        return ________;                           // ②
    }

    public static void main(String[] args) {
        String[] names = {"Java", "OOP"};
        Integer[] scores = {90, 80};
        System.out.println(Test.________(names));   // ③
        System.out.println(Test.________(scores));  // ④
    }
}
```

**答案：** ① T　② data[0]　③ first　④ first
**解析：** `<T>` 声明方法级泛型参数，返回值类型为 T；first(names) 返回第一个字符串 Java，first(scores) 返回第一个整数 90。

---

## Q30 字节输出流
补全程序，将字节数组写入 data.bin。

```java
import java.io.*;

public class Test {
    public static void main(String[] args) {
        byte[] data = {65, 66, 67};
        try (
            OutputStream out = new ________("data.bin")  // ①
        ) {
            out.________(data);                           // ②
        } ________ (IOException e) {                      // ③
            e.printStackTrace();
        }
    }
}
```

**答案：** ① FileOutputStream　② write　③ catch
**解析：** FileOutputStream 是文件字节输出流；write(data) 写出整个字节数组；IO 操作用 catch 处理 IOException。

---

# 第四部分：程序设计题（1 道）

## Q33 校园通知发送程序

设计一个校园通知发送程序。

**程序输出结果如下：**
```
Email[teacher@school.com]:Exam
SMS[13800000000]:Exam
```

**要求：**
1. 定义接口 Notifier，包含 `send(String message)` 方法。
2. 定义 EmailNotifier 类实现 Notifier，包含 String address 属性和构造方法。
3. 定义 SmsNotifier 类实现 Notifier，包含 String phone 属性和构造方法。
4. EmailNotifier 的 send 按 `Email[address]:message` 格式输出。
5. SmsNotifier 的 send 按 `SMS[phone]:message` 格式输出。
6. 在测试类中创建 `List<Notifier>`，依次放入 `EmailNotifier("teacher@school.com")` 和 `SmsNotifier("13800000000")`。
7. 遍历集合并调用 `send("Exam")` 方法，体现接口、多态、集合和泛型。

**参考答案：**
```java
import java.util.*;

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    private String address;

    public EmailNotifier(String address) {
        this.address = address;
    }

    public void send(String message) {
        System.out.println("Email[" + address + "]:" + message);
    }
}

class SmsNotifier implements Notifier {
    private String phone;

    public SmsNotifier(String phone) {
        this.phone = phone;
    }

    public void send(String message) {
        System.out.println("SMS[" + phone + "]:" + message);
    }
}

public class Test {
    public static void main(String[] args) {
        List<Notifier> list = new ArrayList<>();
        list.add(new EmailNotifier("teacher@school.com"));
        list.add(new SmsNotifier("13800000000"));

        for (Notifier notifier : list) {
            notifier.send("Exam");
        }
    }
}
```

### 得分点拆解

| 分值 | 要求 |
|------|------|
| 2分 | 接口 Notifier：send(String message) 方法声明正确。 |
| 3分 | EmailNotifier 和 SmsNotifier 正确实现接口，并通过构造方法保存 address、phone。 |
| 3分 | send 方法分别按 `Email[address]:message` 和 `SMS[phone]:message` 格式输出。 |
| 2分 | 测试类使用 `List<Notifier>`，按顺序加入指定邮箱和手机号两个通知对象。 |
| 2分 | 使用增强 for 遍历集合并调用 `send("Exam")`，最终输出与题目完全一致。 |

---

# 附录：题型与模块对照表

## 按题型统计

| 题型 | 数量 | 题号 |
|------|------|------|
| 选择题 | 20 | Q01-Q05, Q07-Q08, Q11-Q13, Q16-Q17, Q20, Q22-Q23, Q26, Q28-Q29, Q31-Q32 |
| 阅读程序写结果 | 7 | Q06, Q10, Q15, Q18, Q19, Q21, Q24 |
| 程序填空 | 5 | Q09, Q14, Q25, Q27, Q30 |
| 程序设计题 | 1 | Q33 |

## 按模块统计

| 模块 | 知识点 | 题号 |
|------|--------|------|
| 模块一 | Java 基础与数组 | Q01-Q07 |
| 模块二 | 类、对象与封装 | Q08-Q11 |
| 模块三 | 继承、多态与异常 | Q12-Q18 |
| 模块四 | 实用类、集合与泛型 | Q19-Q27 |
| 模块五 | IO、多线程与综合设计 | Q28-Q33 |
