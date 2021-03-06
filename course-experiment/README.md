# 课程实验

## [实验一](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/convert-decimal-Ndigit)

实验名称：
  [十进制数到N进制数的转换](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/convert-decimal-Ndigit)
  
实验目的：
  掌握顺序栈的入栈出栈等基本操作的编程实现
  
实验内容：
  利用顺序栈实现将从键盘输入的十进制数转换为N（如二进制、八进制、十六进制）进制数据。
  
实验原理：
  转换方法利用除留余数法。所转换的N进制数按低位到高位的顺序产生，而通常的输出是从高位到低位的，恰好与计算过程相反，因此转换过程中每得到一位N进制数则进栈保存，转换完毕后依次出栈则正好是转换结果。

## [实验二](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/compute-usr-similarity)

实验名称：
  [用户偏好相似度计算](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/compute-usr-similarity)
  
实验目的：
  掌握分治算法的原理以及合并排序算法的编程实现
  
实验内容：
  给定某音乐网站给出的大众用户对于`n`首歌曲的喜好程度排序，以及某个特定用户X对于这n首歌曲的喜好程度排序，计算用户X与大众用户的偏好相似度。

实验原理：
  以大众用户的排序为标准，利用分治算法来计算用户X排序序列中的逆序数量，数值越低则用户X的偏好月接近于大众偏好。
  具体来说，将用户X的排序序列等分为左右两个子序列，递归地计算这两个个子序列中的逆序数量，再加上一个元素在左子序列、一个元素在右子序列的逆序数量，即得原始序列中的逆序数量。

## [实验三](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/design-optimal-prefix-code)

实验名称：
  [最优前缀编码设计](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/design-optimal-prefix-code)
  
实验目的：
  利用贪心算法设计最优前缀编码算法的编程实现
  
实验内容：
  用户输入`n`个正整数作为文件中`n`个字符出现的次数，请实现霍夫曼编码算法对该文件`n`个字符进行编码，并输出编码表。
  
实验原理：
  根据给定的`n`个权值`{w1,w2,……wn}`，构造`n`棵只有根结点的二叉树。在森林中选取两棵根结点权值最小的树作左右子树，构造一棵新的二叉树，置新二叉树根结点权值为其左右子树根结点权值之和。在森林中删除这两棵树，同时将新得到的二叉树加入森林中。重复上述两步，直到只含一棵树为止，这棵树即霍夫曼树。按`左0右1`的规定，从根结点走到一个叶结点，完成一个字符的译码。


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
