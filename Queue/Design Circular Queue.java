class MyCircularQueue {

    int[] a;
    int front, rear = -1, len = 0;
    
    public MyCircularQueue(int k) {
        a = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(!isFull()){
            rear = (rear + 1) % a.length;
            a[rear] = value;
            len++;
            return true;
        }
        
        return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty()){
            front = (front + 1) % a.length;
            len--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        return isEmpty() ? -1 : a[front];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : a[rear];
    }
    
    public boolean isEmpty() {
        return len == 0;
    }
    
    public boolean isFull() {
        return len == a.length;
    }
}