/*
对于十进制数的整数部分，采用保留余数法(逆序)
对于其小数部分，采用乘法保留整数(顺序)
 */
public class DecimalToNDigit {
    private double num; //要转换的十进制数
    private int radix;  //指定进制
    public DecimalToNDigit(double num, int radix) {
        this.num=num;
        this.radix=radix;
    }
    public String convert() throws Exception{
        int num_integer = (int)num; //整数部分
        double num_decimal = num % 1;   //小数部分
        StringBuilder ans=new StringBuilder();  //目标字符串
        Stack<Character> helper=new Stack<>();
        //转换整数部分
        while(num_integer / radix != 0) {
            helper.push( Character.forDigit(num_integer % radix, radix));
            num_integer /= radix;
        }
        helper.push( Character.forDigit(num_integer, radix));
        while(!helper.empty()) {    //逆序输出余数
            ans.append(helper.pop());
        }
        //转换小数部分
        if(num_integer!=0) {
            ans.append('.');
            while(num_decimal!=0) {
                num_decimal *= radix;
                ans.append(Character.forDigit((int)num_decimal, radix));
                num_decimal %= 1;
            }
        }
        return ans.toString();
    }
}
