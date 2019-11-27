/*************************************************************************
    > File Name: Heap.java
    > Author: 唐以恒
    > Mail: 1021953309tyh@gmail.com 
    > Created Time: 2019年11月27日 星期三 20时12分29秒
 ************************************************************************/
/*
自定义类：最小堆
每次弹出最小元素
 */
public class Heap{
    HuffmanTree[] list;     //最小堆的内部数组
    int size;

    public Heap(char[] elements, int[] weights) {       //创建最小堆
        list = new HuffmanTree[elements.length];
        for(int i=0; i<elements.length; i++) {
            list[i] = new HuffmanTree(elements[i], weights[i]);
        }
        size = list.length;
        adjustMinHeap();
    }
    //堆排序(小到大)
    private void adjustMinHeap() {
        for(int i=0; i<size/2; i++) {
            adjustMinHeap(i);
        }
    }
    private void adjustMinHeap(int i) {    //向下调整堆
        int left=2*i+1, right=2*i+2, min=i;
        if(left<size && list[left].root.weight<list[i].root.weight) {
            min = left;
        }
        if(right<size && list[right].root.weight<list[min].root.weight) {
            min = right;
        }
        if(min != i) {
            HuffmanTree tmp = list[i];
            list[i] = list[min];
            list[min] = tmp;

            adjustMinHeap(min);
        }
    }
    //增加元素
    public void add(HuffmanTree tree) {
        list[size] = tree;
        size++;
        adjustMinHeap();
    }
    //弹出最小元素
    public HuffmanTree poll() {
        HuffmanTree ret = list[0];
        list[0] = list[size-1];
        list[size-1] = null;
        size--;
        adjustMinHeap();
        return ret;
    }
    //删除指定元素
}
