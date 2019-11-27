## [实验三](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/design-optimal-prefix-code)

实验名称：

  [最优前缀编码设计](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/design-optimal-prefix-code)
  
实验目的：

  利用贪心算法设计最优前缀编码算法的编程实现
  
实验内容：

  用户输入`n`个正整数作为文件中`n`个字符出现的次数，请实现霍夫曼编码算法对该文件`n`个字符进行编码，并输出编码表。
  
实验原理：

  根据给定的`n`个权值`{w1,w2,……wn}`，构造`n`棵只有根结点的二叉树。在森林中选取两棵根结点权值最小的树作左右子树，构造一棵新的二叉树，置新二叉树根结点权值为其左右子树根结点权值之和。在森林中删除这两棵树，同时将新得到的二叉树加入森林中。重复上述两步，直到只含一棵树为止，这棵树即霍夫曼树。按`左0右1`的规定，从根结点走到一个叶结点，完成一个字符的译码。

实验结果：

![](https://tyh-blog-image.oss-cn-beijing.aliyuncs.com/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95-%E5%9B%BE%E7%89%87/%E8%AF%BE%E7%A8%8B%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/prefix.png)

