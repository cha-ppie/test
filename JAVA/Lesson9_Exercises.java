/**
 * 第九课 配套练习题：集合（ArrayList & HashMap）
 * 考试必考：遍历、增删改查
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Lesson9_Exercises {

    // ==================== 题目区 ====================

    /**
     * 题1：ArrayList 基本操作
     * 创建 ArrayList<String>，依次添加 "Java", "Python", "C++"
     * 然后把索引1的元素改成 "JavaScript"
     * 返回拼接字符串，格式："0-Java,1-JavaScript,2-C++"
     */
    static String problem1_ArrayList() {
        // ------ 在下面写你的代码 ------

        return ""; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题2：ArrayList 求和
     * 参数 list 是 ArrayList<Integer>，返回所有元素之和
     */
    static int problem2_SumList(ArrayList<Integer> list) {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题3：找出大于平均值的元素
     * 参数 list 非空，返回一个新 ArrayList<Integer>，
     * 包含所有大于平均值的元素
     */
    static ArrayList<Integer> problem3_AboveAverage(ArrayList<Integer> list) {
        // ------ 在下面写你的代码 ------
        // 第一步：求平均值
        // 第二步：筛选

        return new ArrayList<>(); // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题4：HashMap 基本操作
     * 创建 HashMap<String, Integer>，存入：
     *   "苹果"→8, "香蕉"→5, "橘子"→6
     * 返回 "苹果" 对应的价格（用 get）
     */
    static int problem4_HashMapGet() {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题5：HashMap 遍历求和
     * 参数 map 的值是 Integer，返回所有值之和
     */
    static int problem5_SumValues(HashMap<String, Integer> map) {
        // ------ 在下面写你的代码 ------
        // 提示：for (int v : map.values())

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题6（拔高）：统计词频
     * 参数 words 是一个字符串数组，统计每个单词出现的次数
     * 返回 HashMap<String, Integer>（单词→次数）
     * 例如 {"a","b","a","c","b","a"} → {"a":3, "b":2, "c":1}
     */
    static HashMap<String, Integer> problem6_WordCount(String[] words) {
        // ------ 在下面写你的代码 ------
        // 遍历 words，对每个单词：
        //   if map包含该单词 → 次数+1
        //   else → 放入，次数=1

        return new HashMap<>(); // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }


    // ==================== 自动批改区 ====================

    static int passed = 0;
    static int total = 0;

    static void check(String name, String expected, String actual) {
        total++;
        if (expected.equals(actual)) {
            System.out.println("  ✅ " + name + ": " + actual);
            passed++;
        } else {
            System.out.println("  ❌ " + name + ": 期望 \"" + expected + "\"，实际 \"" + actual + "\"");
        }
    }

    static String mapToString(HashMap<String, Integer> map) {
        return map.toString();
    }

    public static void main(String[] args) {
        System.out.println("========== 第九课 练习题批改 ==========\n");

        // 题1
        System.out.println("--- 题1: ArrayList ---");
        check("题1-基本操作", "0-Java,1-JavaScript,2-C++", problem1_ArrayList());

        // 题2
        System.out.println("--- 题2: 求和 ---");
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10); nums.add(20); nums.add(30);
        check("题2-求和{10,20,30}", "60", String.valueOf(problem2_SumList(nums)));

        // 题3
        System.out.println("--- 题3: 大于平均值 ---");
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(1); nums2.add(2); nums2.add(3); nums2.add(4); nums2.add(5);
        ArrayList<Integer> result = problem3_AboveAverage(nums2);
        check("题3-大于平均{1..5}", "[4, 5]", result.toString());

        // 题4
        System.out.println("--- 题4: HashMap ---");
        check("题4-苹果价格", "8", String.valueOf(problem4_HashMapGet()));

        // 题5
        System.out.println("--- 题5: HashMap求和 ---");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 10); map.put("b", 20); map.put("c", 30);
        check("题5-值求和", "60", String.valueOf(problem5_SumValues(map)));

        // 题6
        System.out.println("--- 题6: 词频统计 ---");
        String[] words = {"a", "b", "a", "c", "b", "a"};
        HashMap<String, Integer> freq = problem6_WordCount(words);
        check("题6-词频", "{a=3, b=2, c=1}", freq.toString());

        System.out.println("\n========== 结果: " + passed + "/" + total + " ==========");
        if (passed == total) {
            System.out.println("🎉 集合操作已掌握！考试够用了！");
        } else {
            System.out.println("💪 还有 " + (total - passed) + " 项没过，加油！");
        }
    }
}
