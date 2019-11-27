public class ComputeUserSimilarity {
    private int[] privateLike;  //个人对歌曲喜好程度排序
    private double similarity;  //相似度：1- (逆序对数/总对数)

    public ComputeUserSimilarity(int[] privateLike) {
        this.privateLike=privateLike;
    }
    public double getSimilarity() {
        int n=privateLike.length;
        similarity=1 - compute() / (n*(n-1)/2.0);
        return similarity;
    }
    public int[] getPrivateLike() {return privateLike;}
    //计算逆序对数
    public int compute() {
        return helper(0, privateLike.length-1);
    }
    public int helper(int start, int end) {
        if(start == end)    return 0;
        //分解, 递归
        int middle=(start+end) / 2;
        int left_similar=helper(start, middle);
        int right_similar=helper(middle+1, end);
        //合并
        int[] left_tmp=new int[middle-start+1];
        int[] right_tmp=new int[end-middle];
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
