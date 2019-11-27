/*************************************************************************
    > File Name: Test.java
    > Author: 唐以恒
    > Mail: 1021953309tyh@gmail.com 
    > Created Time: 2019年11月27日 星期三 20时36分51秒
 ************************************************************************/
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=null;
        try {
            scanner=new Scanner(System.in);
            System.out.println("请输入矩阵链的规模：");
            String[] nums=scanner.nextLine().split(" ");
            int[] p=new int[nums.length];
            for(int i=0; i<p.length; i++) {
                p[i]=Integer.parseInt(nums[i]);
            }
            MatrixChainMultiply matrixChain=new MatrixChainMultiply(p);
            System.out.println("该矩阵链的最优括号方式：");
            matrixChain.printParens();
            System.out.println("该矩阵链的有少乘法次数：");
            System.out.println(matrixChain.getCost());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            scanner=null;
        }
    }
}
