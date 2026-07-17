/**
 * 接口专题课 —— 彻底搞懂 Interface
 *
 * 口诀：接口 = 契约 = "你必须会这些技能"
 *
 * 生活类比：
 *   - 类(Class)    = 你是什么（人、狗、鸟）
 *   - 接口(Interface) = 你能干什么（会飞、会游泳、会充电）
 *
 * 一条狗是一个人（类），同时可以实现"会跑""会叫"（接口）
 * 一架无人机不是动物（不继承Creature），但也可以"会飞""会充电"（实现相同接口）
 */


// ================================================================
// 一、为什么需要接口？
// ================================================================
// 假设要给"会飞的东西"写一个通用方法，处理鸟、飞机、无人机…
// 鸟和飞机毫无继承关系，怎么能用同一个方法处理？
// → 让它们都实现 IFly 接口！接口是一种"横向切面"的关系

interface IFly {
    void fly();  // 接口里的方法默认就是 public abstract
}

// 鸟是动物（继承）
class Sparrow extends Creature implements IFly {
    Sparrow(String name) { super(name); }
    @Override void eat() { System.out.println(name + "吃虫子"); }
    @Override public void fly() { System.out.println(name + "拍翅膀飞"); }
}

// 飞机不是动物，但也会飞
class Airplane implements IFly {
    String model;
    Airplane(String model) { this.model = model; }
    @Override public void fly() { System.out.println(model + "喷气飞"); }
}

// 同一个方法，能操作完全无关的类 —— 这就是接口的威力
// public void demoFly(IFly f) { f.fly(); }  ← 传鸟也行，传飞机也行


// ================================================================
// 二、接口的基本语法
// ================================================================

// 定义一个接口
interface ICharge {
    // 所有方法默认是 public abstract（你不写也是）
    void charge();
    int getBatteryLevel();

    // 接口不能有实例变量，但可以有常量（默认 public static final）
    int MAX_BATTERY = 100;  // 等价于 public static final int MAX_BATTERY = 100;
}

// 一个类实现接口：必须实现接口中所有的抽象方法
class SmartDevice implements ICharge {
    private int battery = 50;

    @Override
    public void charge() {
        battery = MAX_BATTERY;  // 可以直接用接口里定义的常量
        System.out.println("设备充满电了，电量:" + battery);
    }

    @Override
    public int getBatteryLevel() {
        return battery;
    }
}


// ================================================================
// 三、一个类实现多个接口（Java 单继承的弥补）
// ================================================================
// ⚠️ Java 只能 extends 一个父类，但可以 implements 多个接口！

interface ISwim {
    void swim();
}

// 鸭子继承动物，同时实现"会飞""会游泳"
class MallardDuck extends Creature implements IFly, ISwim {
    MallardDuck(String name) { super(name); }

    @Override void eat() { System.out.println(name + "吃小鱼"); }

    @Override public void fly() { System.out.println(name + "扑腾飞"); }

    @Override public void swim() { System.out.println(name + "水上漂"); }
}


// ================================================================
// 四、接口可以继承接口
// ================================================================

interface IMove {
    void move();
}

// IAmphib 接口继承了两个接口，同时有自己的方法
interface IAmphib extends IMove, ISwim {
    void crawl();  // 爬行
}

// 实现 IAmphib 的类，必须实现 move + swim + crawl 三个方法
class Frog implements IAmphib {
    @Override public void move() { System.out.println("青蛙跳着移动"); }
    @Override public void swim() { System.out.println("青蛙蛙泳"); }
    @Override public void crawl() { System.out.println("青蛙慢慢爬"); }
}


// ================================================================
// 五、default 方法（Java 8+ —— 接口可以有方法体！）
// ================================================================
// 问题：接口已经有3个实现了，突然想加一个新方法，
//       不想修改所有实现类 → 用 default

interface IPrinter {
    void print(String content);

    // default 方法：有方法体，实现类不必重写
    default void printWithBorder(String content) {
        System.out.println("==================");
        print(content);
        System.out.println("==================");
    }
}

class ConsolePrinter implements IPrinter {
    @Override
    public void print(String content) {
        System.out.println(content);
    }
    // 不用重写 printWithBorder，直接继承默认实现
}


// ================================================================
// 六、static 方法（Java 8+ —— 接口可以有静态工具方法）
// ================================================================

interface IMathTool {
    // 静态方法：属于接口本身，不用实例化就能调用
    static int square(int x) {
        return x * x;
    }

    static double average(int a, int b) {
        return (a + b) / 2.0;
    }
}


// ================================================================
// 七、接口作为"类型"使用（多态）
// ================================================================
// 接口也是一种类型！变量声明的类型可以是接口

class FlyShow {
    static void performFly(IFly f) {
        System.out.print("表演飞行: ");
        f.fly();  // 不管传进来的是鸟还是飞机，都调它的fly()
    }
}


// ================================================================
// 八、接口 vs 抽象类（期末考试高频对比！）
// ================================================================
//     抽象类(abstract class)           接口(interface)
//   ──────────────────────────   ─────────────────────────
//   用 extends 继承               用 implements 实现
//   只能继承一个                  可以实现多个
//   可以有构造方法                没有构造方法
//   可以有实例变量                只能有常量(static final)
//   可以有普通方法                方法默认 abstract（Java 8+ 可有 default/static）
//   描述"是什么"的关系            描述"能做什么"的关系


// ===== 主程序 =====
public class Lesson7b_Interface_Deep {
    public static void main(String[] args) {

        // ===== 1. 接口的基本使用 =====
        System.out.println("===== 基本使用 =====");
        SmartDevice d = new SmartDevice();
        System.out.println("当前电量: " + d.getBatteryLevel());
        d.charge();

        // ===== 2. 多态：接口类型变量 =====
        System.out.println("\n===== 接口多态 =====");
        IFly bird = new Sparrow("麻雀");
        IFly plane = new Airplane("波音747");

        bird.fly();   // 实际调Sparrow的fly
        plane.fly();  // 实际调Airplane的fly

        // 数组里放所有会飞的东西
        IFly[] flyingThings = {
            new Sparrow("老鹰"),
            new Airplane("空客A380"),
            new MallardDuck("唐老鸭")
        };
        System.out.println("所有会飞的东西:");
        for (IFly f : flyingThings) {
            f.fly();
        }

        // ===== 3. 多接口实现 =====
        System.out.println("\n===== 多接口 =====");
        MallardDuck duck = new MallardDuck("可达鸭");
        duck.eat();   // 从Creature继承
        duck.fly();   // 从IFly
        duck.swim();  // 从ISwim

        // ===== 4. default 方法演示 =====
        System.out.println("\n===== default方法 =====");
        ConsolePrinter cp = new ConsolePrinter();
        cp.printWithBorder("你好世界");

        // ===== 5. static 方法演示 =====
        System.out.println("\n===== static方法 =====");
        System.out.println("5² = " + IMathTool.square(5));
        System.out.println("10和20的平均: " + IMathTool.average(10, 20));
        // IMathTool.square(3);  ← 直接用接口名调用，不需要new

        // ===== 6. 通用方法 =====
        System.out.println("\n===== 通用方法 =====");
        FlyShow.performFly(new Sparrow("燕子"));
        FlyShow.performFly(new Airplane("C919"));

        // ===== 7. 接口继承接口 =====
        System.out.println("\n===== 接口继承 =====");
        Frog frog = new Frog();
        frog.move();
        frog.swim();
        frog.crawl();

        // ===== 8. instanceof 检查接口 =====
        System.out.println("\n===== instanceof 接口 =====");
        Object obj = new MallardDuck("检查鸭");
        System.out.println("是IFly? " + (obj instanceof IFly));
        System.out.println("是ISwim? " + (obj instanceof ISwim));
        System.out.println("是ICharge? " + (obj instanceof ICharge));  // false
    }
}


// ===== 父类 Creature（给上面的 Sparrow 和 MallardDuck 用）=====
class Creature {
    String name;
    Creature(String name) { this.name = name; }
    void eat() { System.out.println(name + "在吃东西"); }
}
