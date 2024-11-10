package Models;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    public final Queue<Order> queue = new LinkedList<>();

    public void enqueue(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Cannot enqueue a null order.");
        }
        queue.add(order);
    }

    public Order dequeue() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Cannot dequeue from an empty queue.");
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
