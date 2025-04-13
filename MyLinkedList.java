import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {

    private class Node {

        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        Node node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);

        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }

        Node newNode = new Node(item);
        Node current = getNode(index);
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return tail.data;
    }

    @Override
    public void remove(int index) {
        Node node = getNode(index);
        removeNode(node);
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }
    }

    @Override
    public void removeLast() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        tail = tail.prev;
        size--;
        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }
    }

    @Override
    public void sort() {
        if (size <= 1) return;

        // Используем сортировку вставками
        Node current = head.next;
        while (current != null) {
            T key = current.data;
            Node j = current.prev;

            while (j != null && ((Comparable<T>) j.data).compareTo(key) > 0) {
                j.next.data = j.data;
                j = j.prev;
            }

            if (j == null) {
                head.data = key;
            } else {
                j.next.data = key;
            }

            current = current.next;
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            if (
                object == null
                    ? current.data == null
                    : object.equals(current.data)
            ) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (Node current = tail; current != null; current = current.prev) {
            if (
                object == null
                    ? current.data == null
                    : object.equals(current.data)
            ) {
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node current = head; current != null; current = current.next) {
            result[i++] = current.data;
        }
        return result;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    private void removeNode(Node node) {
        if (node.prev == null) {
            removeFirst();
            return;
        }
        if (node.next == null) {
            removeLast();
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }
    }
}
