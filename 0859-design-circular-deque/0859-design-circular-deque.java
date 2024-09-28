class MyCircularDeque {
    public int[] queue;
    int front=-1,rear=-1;
    int len=0;
    int size;
    public MyCircularDeque(int k) {
        this.queue=new int[k];
        this.size=k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        if(front==-1){
            front++;
            rear++;
        }else{
            front=(front-1+size)%size;
        }
        queue[front]=value;
        len++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        if(front==-1){
            front=0;
            rear=0;
        }else{
            rear=(rear+1)%size;
        }
        queue[rear]=value;
        len++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        if(front==rear){
            front=-1;
            rear=-1;
            return true;
        }
        front=(front+1)%size;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        if(front==rear){
            front=-1;
            rear=-1;
            return true;
        }
        rear=(rear-1+size)%size;
        len--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty())
            return -1;
        return queue[front];
    }
    
    public int getRear() {
        if(isEmpty())
            return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return front==-1;
    }
    
    public boolean isFull() {
        return (rear+1)%size==front;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */