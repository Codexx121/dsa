   public void enqueue(Student student) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        if (front == -1) front = 0;
        rear = (rear + 1) % capacity;
        queue[rear] = student;
        size++;
    }
