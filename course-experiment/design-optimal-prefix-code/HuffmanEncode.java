/*************************************************************************
    > File Name: HuffmanEncode.java
    > Author: 唐以恒
    > Mail: 1021953309tyh@gmail.com 
    > Created Time: 2019年11月27日 星期三 20时07分13秒
 ************************************************************************/
import java.util.*;
/*
生成霍夫曼树
得到各个字符的编码
 */
public class HuffmanEncode {
    int size;   //字符的种数
    int cost;
    Map<Character, Integer> elementWeight;  //字符-权重表
    Map<Character, String> elementEncode;   //字符-前缀码表
    Comparator<HuffmanTree> comparator;     //自定义比较器
    Queue<HuffmanTree> pq;      //优先队列(最小堆实现)
    HuffmanTree huffmanTree;    //huffman树

    public HuffmanEncode(char[] elements, int[] weights) {
        initial(elements, weights);     //初始化
        createHuffmanTree();    //利用优先队列构造huffman树
        generateEncode();   //生成编码表
    }

    private void initial(char[] elements, int[] weights) {
        elementWeight = new HashMap<>();
        elementEncode = new HashMap<>();
        comparator = new Comparator<HuffmanTree>() {
            @Override
            public int compare(HuffmanTree t1, HuffmanTree t2) {
                if(t1.root.weight < t2.root.weight) {
                    return -1;
                }else if(t1.root.weight > t2.root.weight) {
                    return 1;
                }else {
                    return 0;
                }
            }
        };
        pq = new PriorityQueue<>(comparator);
        size = elements.length;
        for(int i=0; i<size; i++) {
            elementWeight.put(elements[i], weights[i]);
        }
    }

    private void createHuffmanTree() {
        for(Character element: elementWeight.keySet()) {    //每个字符结点作为一棵huffman树
            pq.add(new HuffmanTree(element, elementWeight.get(element)));
        }
        while(pq.size() > 1) {  //直到队列只有一个huffman树
            HuffmanTree t1 = pq.poll(); //每次取出来两个权重最小的两个huffman树
            HuffmanTree t2 = pq.poll();
            HuffmanTree ret = new HuffmanTree(t1, t2);  //合并为一个huffman树
            pq.add(ret);    //放回队列
        }
        if(pq.size() == 1) {
            huffmanTree = pq.poll();
        }
    }

    private void generateEncode() {
        solve(huffmanTree.root, "");
    }
    private void solve(HuffmanTree.TreeNode root, String tmp) {     //递归搜索huffman树的叶子结点
        if(root.left==null && root.right==null) {   //叶子结点 表示字符
            elementEncode.put(root.element, tmp);
        }else {
            solve(root.left, tmp+"0");
            solve(root.right, tmp+"1");
        }
    }
    public void getCost() {
        cost = 0;
        for(Character element : elementWeight.keySet()) {
            cost += elementWeight.get(element) * elementEncode.get(element).length();
        }
    }
}
