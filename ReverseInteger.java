public class ReverseInteger {
    /*
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        // write your code here
        //1 将整数转换为字符串，字符串反转
//         String s = String.valueOf(n);
// 		String reverseS = "";
// 		if (n >= 0) {
// 			for (int i = s.length(); i > 0; i--) {
// 				reverseS += s.charAt(i-1);
// 			}
// 			return Long.parseLong(reverseS) > Integer.MAX_VALUE ? 0 : (int)Long.parseLong(reverseS);
// 		}else {
// 			for (int i = s.length(); i > 1; i--) {
// 				reverseS += s.charAt(i-1);
// 			}
// 			return -Long.parseLong(reverseS) < Integer.MIN_VALUE ? 0 : -(int)Long.parseLong(reverseS);
// 		}

        //2 整数不断的求余，将余数乘以10，再求和。
        int pN = n;
        if(n < 0) pN = -n;
        long r = 0;
        while(pN > 0){
            r = r*10 + pN % 10;
            pN /= 10;
        }
        if(r > Integer.MAX_VALUE) r=0;
        return n<0 ? -(int)r : (int)r;
    }
}
