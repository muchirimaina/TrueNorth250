import java.util.*;

class Solution{

   public static int numberOfBoats(int[] people, int limit){
	int max = 0;
	for(int n: people){
	  max = Math.max(max,n);
	}
	int[] count = new int[max+1];

	for(int n: people){
	   count[n]++;
	}
	
        int index = 0;
	for(int i = 0; i < count.length; i++){
	   while(count[i] > 0){
		people[index++] = i;
		count[i]--;
	   } 
	}

	int l = 0;
	int r = people.length-1;
	int boats = 0;
	while(l <= r){
	   if(people[l]+people[r] <= limit){
		l++;
	   }

	   r--;
	   boats++;
	}
	return boats;
   }




   public static void main(String[] args){
	int[] people = {1,3,2,3,2};
	int limit = 3;
	System.out.println(numberOfBoats(people,limit));
	// 4
   }



}
