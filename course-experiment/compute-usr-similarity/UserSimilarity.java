/*
实验2
实验名称：
	用户偏好相似度计算
实验目的：
	掌握分治算法的原理以及合并排序算法的编程实现
实验内容：
	给定某音乐网站给出的大众用户对于n首歌曲的喜好程度排序1,2,3, …, n，
	以及键盘输入的某个特定用户X对于这n首歌曲的喜好程度排序k1, k2, k3, …, kn（例如n=5, 键盘输入为2,4,3,1,5），
	计算用户X与大众用户的偏好相似度。
实验原理：
	以大众用户的排序为标准，利用分治算法来计算用户X排序序列中的逆序数量，数值越低则用户X的偏好越接近于大众偏好。
	具体来说，
	将用户X的排序序列等分为左右两个子序列，递归地计算这两个子序列中的逆序数量，
	再加上一个元素在左子序列、一个元素在右子序列的逆序数量，即得原始序列中的逆序数量。
 */
 
public class UserSimilarity {

    private int[] publicLike;
    private int[] privateLike;
    private int similar;

    public UserSimilarity(int[] publicLike, int[] privateLike) {
        this.publicLike=publicLike;
        this.privateLike=privateLike;
        similar=compute();
    }
    public int getSimilar() {
        return similar;
    }
    public int[] getPrivateLike() {return privateLike;}
    /*
    以大众的排序数组为标准，计算该用户的逆序数量
    这里的相似度其实就是逆序的对数*/
    public int compute() {  //[2,4,3,1,5]
        return helper(0, privateLike.length-1);
    }
    public int helper(int start, int end) { //[2,3,4,1,5]
        if(start == end)    return 0;

        //分解, 递归
        int middle=(start+end) / 2;
        int left_similar=helper(start, middle);
        int right_similar=helper(middle+1, end);

        //合并
        int[] left_tmp=new int[middle-start+1]; //[2,3,4]
        int[] right_tmp=new int[end-middle];    //[1,5]
        for(int i=start; i<=end; i++) {
            if(i<=middle)   left_tmp[i-start]=privateLike[i];
            else right_tmp[i-(middle+1)]=privateLike[i];
        }
        int lr_similar=0, m=0, n=0;
        for(int i=start; i<=end; i++) {
            if(m<left_tmp.length && n<right_tmp.length) {
                if(left_tmp[m] <= right_tmp[n])  { privateLike[i]=left_tmp[m]; m++; }
                else { privateLike[i]=right_tmp[n]; lr_similar+=left_tmp.length-m; n++; }
            }
            else if(m==left_tmp.length) { privateLike[i]=right_tmp[n]; n++; }
            else if(n==right_tmp.length) { privateLike[i]=left_tmp[m]; m++; }
        }

        return left_similar+right_similar+lr_similar;
    }
}
