/*************************************************************************
    > File Name: Test.java
    > Author: 唐以恒
    > Mail: 1021953309tyh@gmail.com 
    > Created Time: 2019年11月27日 星期三 20时06分35秒
 ************************************************************************/
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=null;
        try {
            scanner=new Scanner(System.in);
            System.out.println("请输入需要编码的字符序列：");
            String[] chars=scanner.nextLine().split(" ");
            char[] elements=new char[chars.length];
            for(int i=0; i<elements.length; i++) {
                elements[i]=chars[i].charAt(0);
            }
            System.out.println("请输入字符序列的权重：");
            chars=scanner.nextLine().split(" ");
            int[] weights=new int[chars.length];
            for(int i=0; i<weights.length; i++) {
                weights[i]=Integer.parseInt(chars[i]);
            }
            System.out.println("最优前缀编码如下：");
            HuffmanEncode huffmanEncode=new HuffmanEncode(elements, weights);
            Map<Character, String> encodeMap=huffmanEncode.elementEncode;
            for(Character key : encodeMap.keySet()) {
                System.out.println(key+":"+encodeMap.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            scanner=null;
        }
    }
}

