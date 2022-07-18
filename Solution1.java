import java.util.LinkedList;
import java.util.Scanner;

// 自然数的拆分问题
// https://www.luogu.com.cn/problem/P2404
public class Solution1 {

    public static void main(String[] args) {
        // 1.输入数字
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        // 2.输出表达式
        helper(num, num,1, new LinkedList<>());
    }

    private static void helper(int num,int tagert, int index, LinkedList<Integer> subList) {
        if (num == 0) {
            print(subList);
        } else if (num > 0 && index <tagert) {
            // 可以多次选当前这个
            subList.add(index);
            helper(num - index,tagert, index, subList);
            subList.removeLast();

            // 不选当前这个
            helper(num, tagert,index + 1, subList);
        }

    }

    private static void print(LinkedList<Integer> subList) {
        for (int i = 0; i < subList.size() - 1; i++) {
            System.out.print(subList.get(i) + "+");
        }
        System.out.println(subList.getLast());
    }
}
