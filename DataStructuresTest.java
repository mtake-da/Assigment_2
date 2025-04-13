public class DataStructuresTest {
    public static void main(String[] args) {
        System.out.println("тестирование структур данных...");
        
        testArrayList();
        testLinkedList();
        testStack();
        testQueue();
        testMinHeap();
        
        System.out.println("все тесты пройдены");
    }

    private static void testArrayList() {
        System.out.println("\nтестирование myArrayList:");
        MyArrayList<Integer> list = new MyArrayList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("размер: " + list.size());
        System.out.println("элементы: " + java.util.Arrays.toString(list.toArray()));
        
        System.out.println("первый: " + list.getFirst());
        System.out.println("последний: " + list.getLast());
        
        list.remove(1);
        System.out.println("после удаления: " + java.util.Arrays.toString(list.toArray()));
        
        list.add(0);
        list.sort();
        System.out.println("после сортировки: " + java.util.Arrays.toString(list.toArray()));
    }

    private static void testLinkedList() {
        System.out.println("\nтестирование myLinkedList:");
        MyLinkedList<String> list = new MyLinkedList<>();
        
        list.add("первый");
        list.add("второй");
        list.addFirst("нулевой");
        System.out.println("размер: " + list.size());
        System.out.println("элементы: " + java.util.Arrays.toString(list.toArray()));
        
        System.out.println("первый: " + list.getFirst());
        System.out.println("последний: " + list.getLast());
        
        list.removeFirst();
        System.out.println("после удаления: " + java.util.Arrays.toString(list.toArray()));
    }

    private static void testStack() {
        System.out.println("\nтестирование myStack:");
        MyStack<Integer> stack = new MyStack<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("размер: " + stack.size());
        
        System.out.println("верхний: " + stack.peek());
        System.out.println("извлечен: " + stack.pop());
        System.out.println("новый размер: " + stack.size());
    }

    private static void testQueue() {
        System.out.println("\nтестирование myQueue:");
        MyQueue<String> queue = new MyQueue<>();
        
        queue.enqueue("первый");
        queue.enqueue("второй");
        queue.enqueue("третий");
        System.out.println("размер: " + queue.size());
        
        System.out.println("первый: " + queue.peek());
        System.out.println("извлечен: " + queue.dequeue());
        System.out.println("новый размер: " + queue.size());
    }

    private static void testMinHeap() {
        System.out.println("\nтестирование myMinHeap:");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        
        heap.insert(5);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        System.out.println("размер: " + heap.size());
        
        System.out.println("минимум: " + heap.peekMin());
        System.out.println("извлечен: " + heap.extractMin());
        System.out.println("новый минимум: " + heap.peekMin());
        System.out.println("новый размер: " + heap.size());
    }
} 