class Solution{
  static class ListNode{
	int key;
	int val;
	ListNode next;

	ListNode(int key,int val){
	  this.key = key;
	  this.val = val;
	  this.next = null;
	}
  }


  static ListNode[] myHashMap;

  public static void MyHashMap(int size){	
	myHashMap = new ListNode[size];

	for(int i = 0; i < myHashMap.length; i++){
	    myHashMap[i] = new ListNode(-1,-1);
	}
  }

  public static int hash(int key){
	return key % myHashMap.length;
  }

  // put
  public static void put(int key, int value){
     int index = hash(key);
     ListNode current = myHashMap[index];
     while(current.next != null){
	if(current.next.key == key){
	   current.next.val = value;
           return;
	}

	current = current.next;
     }
     current.next = new ListNode(key,value);
     return;

  } 
  // get 
  public static int get(int key){
      int index = hash(key);
      ListNode current = myHashMap[index];
      while(current.next != null){
	if(current.next.key == key){
	   return current.next.val;
	}
	current = current.next;
      }
      return -1;
  }
  // remove

  public static void remove(int key){
	int index = hash(key);
	ListNode current = myHashMap[index];

	while(current.next != null){
	   if(current.next.key == key){
	      current.next = current.next.next;
	      return;
	   }

	   current = current.next;
	}
	return;

  }

  // main class
  public static void main(String[] args){
	MyHashMap(10001);
	put(4,5);
        put(7,455);
	put(9,612);

	remove(7);

	System.out.println(get(4));
	System.out.println(get(7));
	System.out.println(get(9));

	

  }



}
