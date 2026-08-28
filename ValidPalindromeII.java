// class Solution{

    // public static boolean isPalindromeII(String s){

    //     // Check if all the chars match each other - return true
    //     int l = 0;
    //     int r = s.length();

    //     while(l < r){
    //         if(Character.isLetterOrDigit(Character.toLowerCase(s.charAt(l))) != Character.isLetterOrDigit(Character.toLowerCase(s.charAt(r)))){

    //             return isPalindrome(s.substring(l,r-1)) || isPalindrome(l+1,r);

    //         }
    //         l++;
    //         r--;
    //     }

    //     return true;
    //     // If one misses- assume it and check whether the right or left is palindrome
    // }

    // public static boolean isPalindrome(String s){

    //     int l = 0;
    //     int r = s.length();
    //     while(l < r){
    //         if(Character.isLetterOrDigit(Character.toLowerCase(s.charAt(l))) != Character.isLetterOrDigit(Character.toLowerCase(s.charAt(r)))){
    //             return false;
    //         }

    //         l++;
    //         r--;
    //     }

    //     return true;
    // }

    // public static void main(String[] args){
    //     String str1 = "racecaru";   //true
    //     String str2 = "awua";   //true
    //     String str3 = "Billy";  //false

    //     System.out.println(isPalindromeII(str1));
    // }
// }


class Solution{
    public static boolean canBePalindrome(String str){
        int l = 0;
        int r = str.length()-1;

        while(l < r){
            if(str.charAt(l) == str.charAt(r)){
                l++;
                r--;
            }else{
                return isPalindrome(str,l+1,r) || isPalindrome(str,l,r-1);
            }
        }

        return true;
    }

    public static boolean isPalindrome(String str,int l,int r){
        while(l < r){
            if(str.charAt(l) == str.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }

    
    public static void main(String[] args){
        String str1 = "racecaru";   //true
        String str2 = "awua";   //true
        String str3 = "Billy";  //false

        System.out.println(canBePalindrome(str3));
    }
}