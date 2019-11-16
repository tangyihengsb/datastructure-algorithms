/*
* 实验1
实验名称：
	十进制数到N进制数的转换
实验目的：
	掌握顺序栈的入栈出栈等基本操作的编程实现
实验内容：
	利用顺序栈实现将从键盘输入的十进制数转换为N（如二进制、八进制、十六进制）进制数据。
实验原理：
	转换方法利用除留余数法。所转换的N进制数按低位到高位的顺序产生，而通常的输出是从高位到低位的，
	* 恰好与计算过程相反，因此转换过程中每得到一位N进制数则进栈保存，转换完毕后依次出栈则正好是转换结果。
*/

public class Decimal_to_N_digit {

    private double num;
    private int radix;

    public DecimalDigit(double num, int radix) {
        this.num=num;
        this.radix=radix;
    }

    /*
    对于十进制数的整数部分，采用保留余数法(逆序)
    对于其小数部分，采用乘法保留整数(顺序)
     */

    public String convert() {
        int num_integer = (int)num; //整数部分
        double num_decimal = num % 1;   //小数部分
        String ans="";  //目标字符串
        Stack<Character> helper=new Stack<>();
        //转换整数部分
        while(num_integer / radix != 0) {
            helper.push(
                    Character.forDigit(
                    num_integer % radix, radix));
            num_integer /= radix;
        }
        helper.push(Character.forDigit(num_integer, radix));
        while(!helper.empty()) {
            ans += helper.pop();
        }
        if(num_decimal == 0) return ans;
        else {
            //转换小数部分
            ans+=".";
            while(num_decimal!=0) {
                num_decimal *= radix;
                ans +=
                        Character.forDigit(
                            (int)num_decimal, radix);
                num_decimal %= 1;
            }
            return ans;
        }
    }
}
