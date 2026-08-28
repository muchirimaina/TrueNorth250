class Solution{

	static class ListNode{
	     int val;
   	     ListNode next;

   	     ListNode(int val){
        	this.val = val;
       	        this.next = null;
   	     }
	}

	static ListNode[] hashSet;
	public static void baseClass(int size){
		hashSet = new ListNode[size];
		for(int i = 0; i < hashSet.length; i++){
		     hashSet[i] = new ListNode(0);
		}
	}

	public static int hash(int key){
	   return Math.floorMod(key,hashSet.length);
	}

	public static void add(int key){

		int index = hash(key);
		ListNode current = hashSet[index];

		while(current.next != null){
			if(current.next.val == key){
			   return;
			}
			current = current.next;
		}
		current.next = new ListNode(key);

	}

	public static void remove(int key){
		int index = hash(key);
		ListNode current = hashSet[index];
		
		while(current.next != null){
			if(current.next.val == key){
			   current.next = current.next.next;
			   return;
			}
			current = current.next;
		}

	}

	public static boolean keyExists(int key){
		int index = hash(key);
		ListNode current = hashSet[index];

		while(current.next != null){
		       if(current.next.val == key){
			   return true;
			}
			current = current.next;
		}

		return false;
	} 

	public static void main(String[] args){
	      baseClass(10001);
	      add(300);
	      add(100);
	      System.out.println("This key exists? "+ keyExists(300));
	      remove(100);
	      System.out.println("This key exists? "+ keyExists(100));
	}

}
