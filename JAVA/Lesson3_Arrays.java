/**
 * 第三课：Java 数组
 * 对比 Python 的 list 和 C 的数组来理解
 */
public class Lesson3_Arrays {
    public static void main(String[] args) {

        // ========== 1. 数组的声明与创建 ==========
        // Java数组和C很像：固定长度、相同类型
        // Python: nums = [1, 2, 3]          ← 动态，可以混类型
        // C:      int nums[3] = {1, 2, 3}; ← 固定长度
        // Java:   int[] nums = {1, 2, 3};   ← 固定长度，更安全

        System.out.println("=== 数组声明 ===");

        // 方式1：声明+初始化（知道所有元素）
        int[] scores = {95, 88, 76, 100, 65};
        System.out.println("第一个分数: " + scores[0]);   // 索引从0开始
        System.out.println("分数个数: " + scores.length); // length是属性，不是方法！
        // Python用len(list)，Java用arr.length（没有括号！）

        // 方式2：声明+指定长度（先占位，后面赋值）
        int[] nums = new int[5];     // 创建长度为5的数组，默认值全是0
        nums[0] = 10;
        nums[1] = 20;
        nums[4] = 50;
        // nums[5] = 60;  // ❌ 运行时异常！ArrayIndexOutOfBoundsException

        System.out.print("nums数组: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        // 方式3：String数组
        String[] names = {"张三", "李四", "王五"};

        // ========== 2. 遍历数组的三种方式 ==========
        System.out.println("\n=== 遍历方式 ===");

        double[] prices = {9.9, 19.9, 29.9, 39.9};

        // 方式A：传统for（有索引，最灵活）
        System.out.print("传统for: ");
        for (int i = 0; i < prices.length; i++) {
            System.out.print(prices[i] + " ");
        }
        System.out.println();

        // 方式B：增强for-each（简洁，但不能获取索引）
        System.out.print("for-each: ");
        for (double p : prices) {
            System.out.print(p + " ");
        }
        System.out.println();

        // 方式C：Java 8 Stream（函数式风格，了解即可）
        // 后面学到集合再细讲

        // ========== 3. 数组默认值 ==========
        // new 出来的数组，元素有默认值：
        // int[] → 0, double[] → 0.0, boolean[] → false, String[] → null
        System.out.println("\n=== 默认值 ===");
        int[] empty = new int[3];
        System.out.println("新int数组: [" + empty[0] + ", " + empty[1] + ", " + empty[2] + "]");

        boolean[] boolArr = new boolean[2];
        System.out.println("新boolean数组: [" + boolArr[0] + ", " + boolArr[1] + "]");

        String[] strArr = new String[2];
        System.out.println("新String数组: [" + strArr[0] + ", " + strArr[1] + "]  ← null表示没对象");

        // ========== 4. 数组常见操作 ==========
        System.out.println("\n=== 常见操作 ===");

        int[] data = {23, 45, 12, 67, 34, 89, 11};

        // 求和
        int sum = 0;
        for (int v : data) {
            sum += v;
        }
        System.out.println("求和: " + sum);

        // 找最大值
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        System.out.println("最大值: " + max);

        // 查找某个值
        int target = 67;
        int index = -1;  // -1 代表没找到
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                index = i;
                break;    // 找到就停
            }
        }
        System.out.println(target + " 在索引: " + index);

        // ========== 5. 二维数组 ==========
        // Python: matrix = [[1,2],[3,4]]
        // Java:   int[][] matrix = {{1,2},{3,4}};
        System.out.println("\n=== 二维数组 ===");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("矩阵遍历:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 不规则二维数组（每行列数可以不同）
        int[][] triangle = new int[3][];  // 先不指定列数
        triangle[0] = new int[]{1};
        triangle[1] = new int[]{2, 3};
        triangle[2] = new int[]{4, 5, 6};

        System.out.println("不规则数组（杨辉三角结构）:");
        for (int[] row : triangle) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // ========== 6. 数组与方法的交互 ==========
        System.out.println("\n=== 数组作为参数 ===");
        int[] myScores = {88, 92, 75, 96};
        System.out.println("平均分: " + calcAverage(myScores));

        // ⚠️ 数组是引用类型！传给方法的是引用，方法内修改会影响外面
        int[] test = {1, 2, 3};
        modifyArray(test);
        System.out.println("方法修改后: [" + test[0] + ", " + test[1] + ", " + test[2] + "]");
        // Python中list也是这样，C中传指针同理

        // ========== 练手：冒泡排序 ==========
        System.out.println("\n=== 练手：冒泡排序 ===");
        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("排序前: ");
        printArray(unsorted);

        bubbleSort(unsorted);

        System.out.print("排序后: ");
        printArray(unsorted);
    }

    // ===== 辅助方法 =====

    static double calcAverage(int[] arr) {
        double sum = 0;
        for (int v : arr) {
            sum += v;
        }
        return sum / arr.length;
    }

    static void modifyArray(int[] arr) {
        arr[0] = 999;  // 修改了原数组！
    }

    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
