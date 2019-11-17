## [实验四](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/matrix-chain-multiply)

实验名称：
  [矩阵连乘最优计算次序问题](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/matrix-chain-multiply)

实验目的：
  利用动态规划算法设计矩阵连乘积最优加括号算法的编程实现
  
实验内容：
  输入`n + 1`个自然数`p0, p1, p2, p3,…, pn`作为`n`个矩阵`Ai`的维数，, 用动态规划算法求解这`n`个矩阵连乘积![](https://latex.codecogs.com/png.latex?%5Cfn_cs%20A%20%3D%20A_1%5Ctimes%20A_2%20%5Ctimes%20%5Ccdots%20%5Ctimes%20A_n)的最优加括号方式及最少乘法次数。
    
实验原理：
  设计算`A[i: j]` 所需要的最少数乘次数`m[i, j]，1≤ i ≤ j ≤ n`，则原问题的最优值为`m[1, n]`。当`i = j`时，`A[i: j] = Ai`，因此，`m[i, i] = 0，i=1, 2, …, n`；当`i < j`时，可以递归地定义`m[i, j]`为：
  
![](https://latex.codecogs.com/gif.latex?\fn_cs&space;m[i,j]=m[i][k]&plus;m[k&plus;1][j]&plus;p_{i-1}p_kp_j)

这里Ai的维数为。可以递归地定义`m[i,j]`为：

![](https://latex.codecogs.com/png.latex?%5Cfn_cs%20m%5Bi%2Cj%5D%3D%20%5Cbegin%7Bcases%7D%20%26%200%20%5Ctext%7B%20%2C%20if%20%7D%20i%3Dj%20%5C%5C%20%26%20m%5Bi%5D%5Bk%5D&plus;m%5Bk&plus;1%5D%5Bj%5D&plus;p_%7Bi-1%7Dp_kp_j%20%5Ctext%7B%20%2C%20if%20%7D%20i%3Cj%20%5Cend%7Bcases%7D)

`k`的位置只有`j – i`种可能。
