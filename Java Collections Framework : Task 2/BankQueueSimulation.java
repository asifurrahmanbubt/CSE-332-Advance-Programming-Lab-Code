import java.util.*;

public class BankQueueSimulation {

    public static void main(String[] args) {
        Queue<String> customerQueue = new LinkedList<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        customerQueue.offer("Alice");
        customerQueue.offer("Bob");
        customerQueue.offer("Charlie");
        customerQueue.offer("Dave");

        System.out.println("Queue before serving: " + customerQueue);

        String servedCustomer = customerQueue.poll();
        System.out.println("Serving customer: " + servedCustomer);

        System.out.println("Queue after serving: " + customerQueue);

        String nextCustomer = customerQueue.peek();
        System.out.println("Next customer to be served: " + nextCustomer);


        while (!priorityQueue.isEmpty()) {
            System.out.println("Serving prioritized customer: " + priorityQueue.poll());
        }
    }
}
