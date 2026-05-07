package data_structures.queue;

import java.util.*;

public class QueueEx {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();

        q.offer("Order 1");
        q.offer("Order 2");
        q.offer("Order 3");

        System.out.println("Queue order: " + q);
        System.out.println("Processing: " + q.poll());
        System.out.println("Next order pending: " + q.peek());

        // Priority queue
        Queue<Integer> emergencyRooms = new PriorityQueue<>();
        emergencyRooms.offer(5);
        emergencyRooms.offer(3);
        emergencyRooms.offer(4);

        System.out.println("Emergency order");
        while (!emergencyRooms.isEmpty()) {
            System.out.println("Purchasing patient level: " + emergencyRooms.poll());
        }

        // Dequeue
        Deque<String> deque = new ArrayDeque<>();
        deque.push("Order 1");
        deque.push("Order 2");
        deque.push("Order 3");
        System.out.println("Deque order: " + deque);
        System.out.println("Processing: " + deque.pop());
    }
}
