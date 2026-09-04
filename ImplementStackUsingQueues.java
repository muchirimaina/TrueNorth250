class Sonlution{
	Queue<Object> q;
	public MyStack(){
		q = null;
	}

	public void push(int x){
	   Queue<Object> newQ = new LinkedList<>();
	   newQ.add(x);
	   newQ.add(q);
	   q = newQ;

	}

	public int pop(){
	  if(q == null) return -1;
	  int val = (int) q.poll();
	  q = (Queue<Object>) q.poll();
	  return val;

	}

	public int top(){
	   if(q == null) return -1;
	   return (int) q.peek();
	}
	
	public boolean empty(){
	   return q == null;
	}




}
