# Java 期末模拟卷（二）：面向对象篇

> 范围：类与对象 → 集合（Lesson 5-9） + 基础回顾  
> 时间：90分钟 | 满分：100分

---

## 一、选择题（每题4分，共40分）

**1.** 以下哪个是构造方法的正确特征？  
A. 返回类型为 void　　B. 方法名与类名相同　　C. 必须用 static 修饰　　D. 可以写返回值

**2.** `private` 修饰的成员，访问范围是？  
A. 所有类　　B. 同一个包　　C. 子类　　D. 仅本类内部

**3.** 以下代码输出什么？
```java
class Parent {
    void show() { System.out.print("P"); }
}
class Child extends Parent {
    void show() { System.out.print("C"); }
}
Parent p = new Child();
p.show();
```
A. P　　B. C　　C. PC　　D. 编译错误

**4.** 关于 `abstract` 抽象类，说法正确的是？  
A. 抽象类可以被 new  
B. 抽象类中所有方法都必须是抽象方法  
C. 子类必须实现所有抽象方法，否则子类也得是抽象类  
D. 抽象类不能有构造方法

**5.** 以下哪个是接口的正确声明？  
A. `class USB { }`  
B. `interface USB { void connect(); }`  
C. `abstract USB { void connect(); }`  
D. `interface USB { void connect() { } }`

**6.** `ArrayList<Integer>` 中添加元素用哪个方法？  
A. `put()`　　B. `add()`　　C. `insert()`　　D. `append()`

**7.** 以下代码输出什么？
```java
String s = null;
try {
    System.out.print(s.length());
} catch (NullPointerException e) {
    System.out.print("空指针");
} finally {
    System.out.print("-结束");
}
```
A. 空指针　　B. 空指针-结束　　C. null-结束　　D. 程序崩溃

**8.** `HashMap<String, Integer>` 中获取键对应的值用哪个方法？  
A. `getValue()`　　B. `fetch()`　　C. `get()`　　D. `retrieve()`

**9.** 关于 `super` 关键字，说法**错误**的是？  
A. `super()` 调用父类构造方法  
B. `super.方法名()` 调用父类版本的方法  
C. `super()` 必须写在构造方法的第一行  
D. `super` 可以访问父类的 private 成员

**10.** 重载(Overload)和重写(Override)的区别，正确的是？  
A. 重载发生在父子类之间，重写发生在同一个类里  
B. 重载看参数列表不同，重写看方法签名相同  
C. 重载必须加 `@Override` 注解  
D. 重写的方法名可以和父类不同

---

## 二、判断题（每题2分，共10分）

**1.** Java 中一个类可以同时继承多个父类。（　　）

**2.** 接口中的方法默认是 `public abstract` 的。（　　）

**3.** `instanceof` 用来判断一个对象是否是某个类的实例。（　　）

**4.** `finally` 块中的代码无论是否发生异常都会执行。（　　）

**5.** `int` 可以直接存入 `ArrayList<Integer>`，因为泛型支持基本类型。（　　）

---

## 三、读代码写输出（每题5分，共25分）

**1.**
```java
class Animal {
    Animal() { System.out.print("A"); }
}
class Dog extends Animal {
    Dog() { System.out.print("D"); }
}
Dog d = new Dog();
```
输出：\_\_\_\_\_\_\_

**2.**
```java
int[] arr = {1, 2, 3};
try {
    System.out.print(arr[3]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.print("越界");
}
System.out.print("结束");
```
输出：\_\_\_\_\_\_\_

**3.**
```java
ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add(1, "C");
list.remove(0);
System.out.println(list);
```
输出：\_\_\_\_\_\_\_

**4.**
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("张三", 90);
map.put("李四", 80);
map.put("张三", 95);
System.out.println(map.get("张三"));
System.out.println(map.containsKey("王五"));
```
输出：\_\_\_\_\_\_\_ / \_\_\_\_\_\_\_

**5.**
```java
interface Flyable { void fly(); }
class Bird implements Flyable {
    public void fly() { System.out.print("飞"); }
}
Flyable f = new Bird();
f.fly();
```
输出：\_\_\_\_\_\_\_

---

## 四、编程题（共25分）

**1. (8分)** 写一个 `Calculator` 类：
- 私有属性 `int result`，初始值 0
- 方法 `add(int n)` 将 n 加到 result
- 方法 `subtract(int n)` 从 result 减去 n
- 方法 `getResult()` 返回当前 result

**2. (8分)** 写一个 `Student` 类继承 `Person`：
- `Person` 有属性 `String name`，构造方法 `Person(String name)`
- `Student` 新增属性 `String school`，构造方法 `Student(String name, String school)`
- 重写 `toString()` 返回 `"姓名:xxx, 学校:xxx"`

**3. (9分)** 写一个方法 `countWords(String[] words)`，返回 `HashMap<String, Integer>`，统计每个单词的出现次数。

---

---

# 参考答案

## 一、选择题
1. B　　2. D　　3. B（多态：父类引用指向子类对象，实际调用子类方法）  
4. C　　5. B　　6. B　　7. B  
8. C　　9. D（super 不能访问父类的 private 成员）  
10. B

## 二、判断题
1. ❌（Java 单继承）　2. ✅　3. ✅　4. ✅  
5. ❌（泛型不支持基本类型，int 靠自动装箱变成 Integer）

## 三、读代码写输出

**1.** `AD`（先调父类构造，再调子类构造）

**2.** `越界结束`（catch捕获后程序继续执行）

**3.** `[C, B]`（add(1,"C")插入索引1变成[A,C,B]，remove(0)删掉A）

**4.** `95` / `false`（键相同覆盖旧值；王五不存在）

**5.** `飞`

## 四、编程题

**1.**
```java
class Calculator {
    private int result = 0;
    void add(int n) { result += n; }
    void subtract(int n) { result -= n; }
    int getResult() { return result; }
}
```

**2.**
```java
class Person {
    String name;
    Person(String name) { this.name = name; }
}
class Student extends Person {
    String school;
    Student(String name, String school) {
        super(name);
        this.school = school;
    }
    @Override public String toString() {
        return "姓名:" + name + ", 学校:" + school;
    }
}
```

**3.**
```java
static HashMap<String, Integer> countWords(String[] words) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String w : words) {
        map.put(w, map.getOrDefault(w, 0) + 1);
    }
    return map;
}
```
