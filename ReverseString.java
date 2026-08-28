import java.util.*;
class Solution{
    public static String reverseString(char[] arr){
        int l = 0;
        int r = arr.length-1;

        while(l < r){
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        return Arrays.toString(arr);
    }
    
    public static void main(String[] args){
        char[] test = {'n','e','e','t'};

        System.out.println(reverseString(test));

    }
}