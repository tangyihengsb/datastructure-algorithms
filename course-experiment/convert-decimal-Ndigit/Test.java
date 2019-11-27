import java.util.Scanner;
public class Test {
    public static void main(String[] args) throws Exception{
        Scanner scanner=null;
        try {
            scanner=new Scanner(System.in);
            System.out.println("请输入你想转换的十进制数：");
            double num=scanner.nextDouble();
            System.out.println("请输入你想转换的进制：");
            int radix=scanner.nextInt();
            System.out.println("转换结果是:"+new DecimalToNDigit(num, radix).convert());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            scanner.close();
            scanner=null;
        }
    }
}
