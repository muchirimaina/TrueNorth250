import java.util.HashSet;
import java.util.Set;

class Solution{
    public static boolean containsDuplicate(int[] arr){

        Set<Integer> set = new HashSet<>();

        for(int num: arr){
            if(!set.add(num)){
                return true;
            }
        }

        return false;


    }

    public static void main(String[] args){
        int[] arr = {1,2,3,3};
        
        System.out.println(containsDuplicate(arr));
    }
}