import java.util.*;
class Solution{

	public static int boatsToSave(int[]people, int limit){
		int max = people[0];

		for(int n: people){
		   max = Math.max(n,max);
		}


		int[]count = new int[max+1];

		for(int n: people){
		   count[n]++;
		}
		
		int k = 0;
		// NB: it is the count array we loop through not the original array when fixing in-place
		for(int i = 0; i < count.length; i++){
		    while(count[i] > 0){
			people[k++] = i;
			count[i]--;
		    }
		}


		int boats = 0;
		int l = 0;
		int r = people.length-1;

		while(l <= r){
		   if(people[l] + people[r] <= limit){
			l++;
		   }
		   r--;
		   boats++;
		}
		
		return boats;

	}

	public static void main(String[] args){
	  int[] people = {3,4,18,7,8,21,6,2};
	  int limit = 22;

	  System.out.println(boatsToSave(people,limit));
	}


}
