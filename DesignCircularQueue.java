class MyCircularQueue{

    int front;
    int back;
    int size;
    int capacity;
    int[] arr;

    public MyCircularQueue(int k) {
        capacity = k;
        arr = new int[k];
        front = 0;
        back = capacity-1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if(size == capacity){
            return false;
        }

        back = (back+1)%capacity;
        arr[back] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        front = (front+1)%capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if(size == 0){
            return -1;
        }

        return arr[front];
    }
    
    public int Rear() {
        if(size == 0){
            return -1;
        }

        return arr[back];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }



	public static void main(String[] args){
	   MyCircularQueue queue = new MyCircularQueue(3);
	   System.out.println(queue.enQueue(1));

	}



}
