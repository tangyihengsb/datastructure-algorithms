## [实验一](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/convert-decimal-Ndigit)

实验名称：

  [十进制数到N进制数的转换](https://github.com/tangyihengsb/datastructure-algorithms/tree/master/course-experiment/convert-decimal-Ndigit)
  
实验目的：

  掌握顺序栈的入栈出栈等基本操作的编程实现
  
实验内容：

  利用顺序栈实现将从键盘输入的十进制数转换为N（如二进制、八进制、十六进制）进制数据。
  
实验原理：

  转换方法利用除留余数法。所转换的N进制数按低位到高位的顺序产生，而通常的输出是从高位到低位的，恰好与计算过程相反，因此转换过程中每得到一位N进制数则进栈保存，转换完毕后依次出栈则正好是转换结果。

试验结果：

测试数据：`12.34`

![](https://tyh-blog-image.oss-cn-beijing.aliyuncs.com/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95-%E5%9B%BE%E7%89%87/%E8%AF%BE%E7%A8%8B%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/decimal-1.png)

![](https://tyh-blog-image.oss-cn-beijing.aliyuncs.com/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95-%E5%9B%BE%E7%89%87/%E8%AF%BE%E7%A8%8B%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/decimal-8.png)

![](https://tyh-blog-image.oss-cn-beijing.aliyuncs.com/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95-%E5%9B%BE%E7%89%87/%E8%AF%BE%E7%A8%8B%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/decimal-16.png)

