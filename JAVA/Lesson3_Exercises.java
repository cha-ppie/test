/**
 * 第三课 配套练习题：数组
 * 每题在方法体内写代码，运行 main 自行批改
 */
public class Lesson3_Exercises {

    // ==================== 题目区 ====================

    /**
     * 题1：创建并返回数组
     * 返回一个长度为5的int数组，值为 {10, 20, 30, 40, 50}
     */
    static int[] problem1_CreateArray() {
        // ------ 在下面写你的代码 ------

        return new int[]{0, 0, 0, 0, 0}; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题2：数组求和
     * 参数 arr 是int数组，返回所有元素之和
     */
    static int problem2_ArraySum(int[] arr) {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题3：找最大值
     * 参数 arr 非空，返回数组中最大的元素
     */
    static int problem3_ArrayMax(int[] arr) {
        // ------ 在下面写你的代码 ------
        // 提示：先假设第一个最大，再遍历比较

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题4：反转数组
     * 参数 arr，返回一个新数组，元素顺序和arr相反
     * 例如输入 {1,2,3}，返回 {3,2,1}
     * 不要修改原数组
     */
    static int[] problem4_Reverse(int[] arr) {
        // ------ 在下面写你的代码 ------
        // 提示：new一个同长度的数组，倒着填

        return new int[arr.length]; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题5：统计大于平均值的元素个数
     * 参数 arr 非空，先求平均值，再数有多少个元素大于平均值
     */
    static int problem5_CountAboveAverage(int[] arr) {
        // ------ 在下面写你的代码 ------
        // 第一步：求平均值（double）
        // 第二步：遍历计数

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题6：查找目标值
     * 在 arr 中查找 target，找到返回索引，找不到返回 -1
     */
    static int problem6_FindIndex(int[] arr, int target) {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题7：二维数组对角线之和
     * 参数 matrix 是 n×n 的二维数组，求主对角线元素之和
     * 主对角线 = matrix[0][0] + matrix[1][1] + ... + matrix[n-1][n-1]
     */
    static int problem7_DiagonalSum(int[][] matrix) {
        // ------ 在下面写你的代码 ------

        return 0; // TODO: 替换这行

        // ------ 上面是你的代码 ------
    }

    /**
     * 题8（拔高）：移除指定元素
     * 参数 arr 和 val，返回一个新数组，去掉所有等于val的元素
     * 例如 arr={3,2,2,3}, val=3 → 返回 {2,2}
     * 提示：先数有多少个不等于val的，再创建数组
     */
    static int[] problem8_RemoveElement(int[] arr, int val) {
        // ------ 在下面写你的代码 ------
        // 第一遍：统计不等于val的个数
        // 第二遍：把不等于val的元素填入新数组

        return new int[0]; // TODO: 替换这行

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

    static void checkInt(String name, int expected, int actual) {
        check(name, String.valueOf(expected), String.valueOf(actual));
    }

    static String arrayToString(int[] arr) {
        if (arr == null) return "null";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    static void checkArray(String name, int[] expected, int[] actual) {
        check(name, arrayToString(expected), arrayToString(actual));
    }

    public static void main(String[] args) {
        System.out.println("========== 第三课 练习题批改 ==========\n");

        // 题1
        checkArray("题1-创建数组", new int[]{10, 20, 30, 40, 50}, problem1_CreateArray());

        // 题2
        checkInt("题2-求和{1,2,3,4,5}", 15, problem2_ArraySum(new int[]{1, 2, 3, 4, 5}));
        checkInt("题2-求和{100,-50,25}", 75, problem2_ArraySum(new int[]{100, -50, 25}));

        // 题3
        checkInt("题3-最大值{3,7,2,9,1}", 9, problem3_ArrayMax(new int[]{3, 7, 2, 9, 1}));
        checkInt("题3-最大值{-5,-1,-3}", -1, problem3_ArrayMax(new int[]{-5, -1, -3}));

        // 题4
        checkArray("题4-反转{1,2,3}", new int[]{3, 2, 1}, problem4_Reverse(new int[]{1, 2, 3}));
        checkArray("题4-反转{5}", new int[]{5}, problem4_Reverse(new int[]{5}));

        // 题5
        checkInt("题5-大于平均{1,2,3,4,5}", 2, problem5_CountAboveAverage(new int[]{1, 2, 3, 4, 5}));
        checkInt("题5-大于平均{10,10,10}", 0, problem5_CountAboveAverage(new int[]{10, 10, 10}));

        // 题6
        checkInt("题6-查找{5,8,3,9},3", 2, problem6_FindIndex(new int[]{5, 8, 3, 9}, 3));
        checkInt("题6-查找{5,8,3,9},7", -1, problem6_FindIndex(new int[]{5, 8, 3, 9}, 7));

        // 题7
        checkInt("题7-对角线{{1,2},{3,4}}", 5, problem7_DiagonalSum(new int[][]{{1, 2}, {3, 4}}));
        checkInt("题7-对角线{{1,0,0},{0,1,0},{0,0,1}}", 3, problem7_DiagonalSum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));

        // 题8
        checkArray("题8-移除{3,2,2,3}中的3", new int[]{2, 2}, problem8_RemoveElement(new int[]{3, 2, 2, 3}, 3));
        checkArray("题8-移除{1,2,3,4}中的5", new int[]{1, 2, 3, 4}, problem8_RemoveElement(new int[]{1, 2, 3, 4}, 5));

        System.out.println("\n========== 结果: " + passed + "/" + total + " ==========");
        if (passed == total) {
            System.out.println("🎉 全部通过！数组操作已经熟练了！");
        } else {
            System.out.println("💪 还有 " + (total - passed) + " 题没过，加油！");
        }
    }
}
