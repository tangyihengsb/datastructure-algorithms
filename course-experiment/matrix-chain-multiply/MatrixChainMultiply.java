/*************************************************************************
    > File Name: MatrixChainMultiply.java
    > Author: 唐以恒
    > Mail: 1021953309tyh@gmail.com 
    > Created Time: 2019年11月27日 星期三 20时36分28秒
 ************************************************************************/
public class MatrixChainMultiply {
    int[] p;    //规模数组
    int n;  //矩阵链中个数
    int[][] dp;     //保存矩阵子链的惩乘法次数
    int[][] loc;    //记录划分位置的数组

    public MatrixChainMultiply(int[] p) {
        this.p = p;
        n = p.length-1;
        dp = new int[n+1][n+1];
        loc = new int[n+1][n+1];
        generateDP_Loc();    //构造dp和loc
    }
    //构造状态数组
    private void generateDP_Loc() {
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
    void printDP() {
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[i].length; j++) {
                System.out.printf("%-8d", dp[i][j]);
            }
            System.out.println();
        }
    }
    //打印分割数组
    void printLOC() {
        for(int i=1; i<loc.length; i++) {
            for(int j=1; j<loc[i].length; j++) {
                System.out.printf("%-8d", loc[i][j]);
            }
            System.out.println();
        }
    }
    //返回最优解所需要的代价
    int getCost() {
        return dp[1][n];
    }
    //回溯构造最优解
    void printParens() {
        solve(1, n);
    }
    private void solve(int i, int j) {
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
