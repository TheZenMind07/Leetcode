public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String str = "abccbd";

        System.out.println("Palindrome : " + new App().isPalindrome(str));

        
    }
    String res;


    private String  isPalindrome(String str) {
        // abccbd
        // N3

        // consider each string and expand over it
        // 2N -1 : N +  N -1 * N  : N2 

        // N*N : check[i][j] : check[0][N-1] : N2 + N2
        
        res = "";
        int n = str.length();
        // odd length palindromes 
        for(int i = 0; i < str.length(); i++){
            int left = i;
            int right = i;
            expandString(left, right, str);
        }

        // even length palindromes
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(i-1)) continue;

            int left = i-1;
            int right = i;
            expandString(left, right, str);
        }
        return res;
    }

    public void expandString(int left, int right, String str){
    

        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }

        if(left >= 0 && right < str.length() && (right - left + 1)> res.length()) {
            res = str.substring(left+1, right);
            System.out.println(res);
        }
    }
}
