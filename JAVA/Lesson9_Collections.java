/**
 * 第九课：集合 —— ArrayList 与 HashMap
 *
 * 数组的痛点：长度固定，不能动态增减
 * 集合的出现：想加就加，想删就删，长度自动变
 *
 * Python对照：
 *   list   → ArrayList  （有序、可重复、有索引）
 *   dict   → HashMap    （键值对、键唯一）
 *
 * 考试重点：
 *   1. ArrayList 的增删改查遍历
 *   2. HashMap 的 put/get/遍历
 *   3. 包装类（int → Integer）
 *   4. 泛型 <>
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Lesson9_Collections {
    public static void main(String[] args) {

        // ================================================================
        // 一、ArrayList —— 动态数组（Python: list）
        // ================================================================

        System.out.println("========== ArrayList ==========");

        // 创建（泛型：尖括号里指定元素类型）
        ArrayList<String> names = new ArrayList<>();
        //                   ↑ 泛型：这个list只能放String

        // 增
        names.add("张三");
        names.add("李四");
        names.add("王五");
        System.out.println("添加后: " + names);  // [张三, 李四, 王五]

        // 插入到指定位置
        names.add(1, "赵六");  // 索引1插入，后面的后移
        System.out.println("插入后: " + names);  // [张三, 赵六, 李四, 王五]

        // 查
        System.out.println("索引1的元素: " + names.get(1));     // 赵六（Python: names[1]）
        System.out.println("元素个数: " + names.size());        // 4（不是length！）

        // 改
        names.set(0, "张三丰");  // 索引0改成张三丰
        System.out.println("修改后: " + names);

        // 删
        names.remove(2);      // 删索引2
        names.remove("王五");  // 删指定元素
        System.out.println("删除后: " + names);

        // 判断
        System.out.println("包含李四? " + names.contains("李四"));
        System.out.println("为空? " + names.isEmpty());

        // 遍历方式A：for循环（有索引）
        System.out.print("for遍历: ");
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + " ");
        }
        System.out.println();

        // 遍历方式B：for-each（简洁）
        System.out.print("foreach遍历: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        // ⚠️ 泛型不能是基本类型，要用包装类
        // int  → Integer
        // double → Double
        // boolean → Boolean
        // char → Character   ← 注意不是Char，是Character！
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(95);  // 自动装箱：int自动包成Integer
        scores.add(88);
        scores.add(76);
        int first = scores.get(0);  // 自动拆箱：Integer自动转int
        System.out.println("分数: " + scores);

        // ================================================================
        // 二、HashMap —— 键值对（Python: dict）
        // ================================================================

        System.out.println("\n========== HashMap ==========");

        // 创建
        HashMap<String, Integer> ageMap = new HashMap<>();
        //              ↑键类型  ↑值类型

        // 增/改（put 既是增也是改）
        ageMap.put("张三", 20);
        ageMap.put("李四", 22);
        ageMap.put("王五", 18);
        ageMap.put("张三", 21);  // 键相同 → 覆盖旧值
        System.out.println("HashMap: " + ageMap);  // {张三=21, 李四=22, 王五=18}

        // 查
        System.out.println("张三的年龄: " + ageMap.get("张三"));  // 21
        System.out.println("不存在的键: " + ageMap.get("不存在"));  // null
        System.out.println("更好的查法: " + ageMap.getOrDefault("不存在", -1));  // -1

        // 判断
        System.out.println("包含键'张三'? " + ageMap.containsKey("张三"));
        System.out.println("包含值22? " + ageMap.containsValue(22));
        System.out.println("大小: " + ageMap.size());

        // 删
        ageMap.remove("王五");
        System.out.println("删除王五后: " + ageMap);

        // 遍历方式A：遍历所有键
        System.out.print("键遍历: ");
        for (String key : ageMap.keySet()) {
            System.out.print(key + "=" + ageMap.get(key) + " ");
        }
        System.out.println();

        // 遍历方式B：遍历所有键值对（推荐）
        System.out.print("entry遍历: ");
        for (HashMap.Entry<String, Integer> entry : ageMap.entrySet()) {
            System.out.print(entry.getKey() + "→" + entry.getValue() + " ");
        }
        System.out.println();

        // ================================================================
        // 三、综合示例：学生成绩管理
        // ================================================================
        System.out.println("\n=== 综合：学生成绩管理 ===");

        // 用HashMap存学生姓名→分数
        HashMap<String, Double> scoreMap = new HashMap<>();
        scoreMap.put("小明", 92.5);
        scoreMap.put("小红", 55.0);
        scoreMap.put("小刚", 78.0);
        scoreMap.put("小丽", 88.5);

        // 求平均分
        double sum = 0;
        for (double s : scoreMap.values()) {
            sum += s;
        }
        System.out.println("平均分: " + sum / scoreMap.size());

        // 找出不及格的人
        System.out.print("不及格: ");
        for (String name : scoreMap.keySet()) {
            if (scoreMap.get(name) < 60) {
                System.out.print(name + " ");
            }
        }
        System.out.println();

        // 用ArrayList存所有及格的人名
        ArrayList<String> passed = new ArrayList<>();
        for (String name : scoreMap.keySet()) {
            if (scoreMap.get(name) >= 60) {
                passed.add(name);
            }
        }
        System.out.println("及格名单: " + passed);
    }
}
