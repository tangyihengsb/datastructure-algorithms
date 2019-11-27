/*************************************************************************
    > File Name: HuffmanTree.java
    > Author: 唐以恒
    > Mail: 1021953309tyh@gmail.com 
    > Created Time: 2019年11月27日 星期三 20时11分24秒
 ************************************************************************/
/*
huffman tree
 */
public class HuffmanTree {
    TreeNode root;      //根结点

    public HuffmanTree(char element, int weight) {  //创建只有一个结点的huffman树
        root = new TreeNode(element, weight);
    }
    public HuffmanTree(HuffmanTree t1, HuffmanTree t2) {    //合并两个huffman树
        root = new TreeNode();
        root.left = t1.root;
        root.right = t2.root;
        root.weight = t1.root.weight + t2.root.weight;   //更新权重
    }

    public class TreeNode {
        char element;   //字符
        int weight;     //权重
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(char e, int w) {
            element = e;
            weight = w;
        }
    }
}
