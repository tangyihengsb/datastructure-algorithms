/*
实验四
实验名称：
  矩阵连乘最优计算次序问题
实验目的：
  利用动态规划算法设计矩阵连乘积最优加括号算法的编程实现
实验内容：
  输入n + 1个自然数p0, p1, p2, p3,…, pn作为n个矩阵Ai的维数，, 
  用动态规划算法求解这n个矩阵连乘积A = A1×A2×A3×…×An的最优加括号方式及最少乘法次数。
实验原理：
  
*/

public class matrixChainMultiply {
    static final int[] p = {30, 35, 15, 5, 10, 20, 25};   //矩阵链的规模
    static final int n = p.length-1;      //矩阵链中矩阵的个数
    static int[][] dp = new int[n+1][n+1];      //最优解的状态数组
    static int[][] loc = new int[n+1][n+1];     //记录最优解的划分

    public static void main(String[] args) {
        getDP();

        System.out.println("状态数组：");
        printDP();

        System.out.println("分割数组：");
        printLOC();

        System.out.println("最优方案的代价是："+getCost());

        System.out.println("最优完全化括号方案是：");
        printParens();
    }

    //构造状态数组
    private static void getDP() {
        for(int i=1; i<dp.length; i++) {    //初始化
            for(int j=i; j<dp[i].length; j++) {
                if(i == j) {
                    dp[i][j] = 0;       //矩阵链长度为1
                }else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int l=2; l<=n; l++) {   //l表示矩阵链的长度     矩阵链长度大于1
            for(int i=1; i<=n-l+1; i++) {
                int j = i+l-1;
                //状态转移 得到使得父问题最优的对于两个子问题的划分
                for(int k=i; k<j; k++) {
                    int tmp = dp[i][k] + dp[k+1][j] + p[i-1]*p[k]*p[j];
                    if(tmp < dp[i][j]) {
                        dp[i][j] = tmp;
                        loc[i][j] = k;
                    }
                }
            }
        }
    }

    //打印状态数组
    private static void printDP() {
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[i].length; j++) {
                System.out.printf("%-8d", dp[i][j]);
            }
            System.out.println();
        }
    }

    //打印分割数组
    private static void printLOC() {
        for(int i=1; i<loc.length; i++) {
            for(int j=1; j<loc[i].length; j++) {
                System.out.printf("%-8d", loc[i][j]);
            }
            System.out.println();
        }
    }

    //返回最优解所需要的代价
    private static int getCost() {
        return dp[1][n];
    }

    //回溯构造最优解
    private static void printParens() {
        solve(1, n);
    }
    private static void solve(int i, int j) {
        if(i == j) {
            System.out.print("A"+i);
        }else {
            System.out.print("(");
            solve(i, loc[i][j]);
            solve(loc[i][j]+1, j);
            System.out.print(")");
        }
    }
}
