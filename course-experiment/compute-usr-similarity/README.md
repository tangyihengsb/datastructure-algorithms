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

试验结果：

![](https://tyh-blog-image.oss-cn-beijing.aliyuncs.com/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95-%E5%9B%BE%E7%89%87/%E8%AF%BE%E7%A8%8B%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/similar-2.png)

![](https://tyh-blog-image.oss-cn-beijing.aliyuncs.com/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95-%E5%9B%BE%E7%89%87/%E8%AF%BE%E7%A8%8B%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/similar-3.png)

![](https://tyh-blog-image.oss-cn-beijing.aliyuncs.com/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95-%E5%9B%BE%E7%89%87/%E8%AF%BE%E7%A8%8B%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/similar-1.png)
