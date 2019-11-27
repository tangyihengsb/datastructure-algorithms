import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner=null;
        try {
            scanner=new Scanner(System.in);
            String[] nums=null;
            System.out.println("请输入个人用户对歌曲的喜好程度排名：");
            nums=scanner.nextLine().split(" ");
            int[] array=new int[nums.length];
            for(int i=0; i<nums.length; i++) {
                array[i]=Integer.valueOf(nums[i]);
            }
            System.out.println("该用户与大众用户的相似度为："+
                    new ComputeUserSimilarity(array).getSimilarity());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            scanner.close();
            scanner=null;
        }
    }
}
