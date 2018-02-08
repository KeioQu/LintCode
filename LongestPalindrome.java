public class LongestPalindrome {
    /*
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        int lp = 0;
        int lpIndex = 0;
        boolean isEven = false;
        char[] sArray = s.toCharArray();
        for(int i=0; i<sArray.length; i++){
            boolean found = false;
            //最长回文子串为奇数个字符，以该处的字符作为对称轴，比较其左右的字符，找到第一个不相同的字符sArray[i-j]，
            //则以该字符为对称轴的最长回文字符串长度为2*(j-1) + 1
            for(int j=0; j<=i && !found; j++){
                if( (i-j) >= 0 && (i+j) < sArray.length && sArray[i-j] == sArray[i+j]){
                    if(lp < (2*j+1)){
                        lp = 2*j+1;
                        lpIndex = i;
                        isEven = false;
                    }
                    
                }else{//遇到边界或者不同的字符时，则跳出循环
                        found = true;
                }
            }
            found = false;
            //最长回文子串为偶数个字符，以该处字符右边的空隙为对称轴，比较其左右的字符，找到第一个不相同的字符sArray[i-j]
            //则以该字符右侧间隙为对称轴的最长回文字符串长度为2*j
            for(int j=0; j<=i && !found; j++){
                if((i-j) >= 0 && (i+j+1) < sArray.length && sArray[i-j] == sArray[i+j+1]){
                    if(lp < 2*(j+1)){
                        lp = 2*(j+1);
                        lpIndex = i;
                        isEven = true;
                    }
                }else{
                    found = true;
                }
            }
        }
        
        //最长回文子串为奇数个字符
        if(!isEven){
            return new String(sArray, lpIndex-(lp-1)/2, lp );
        }
        //最长回文子串为偶数个字符
        return new String(sArray, lpIndex-lp/2+1, lp);
    }
}
