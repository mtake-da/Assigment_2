# Реализация структур данных

## Структуры данных
### Физические структуры данных

1. **MyArrayList**
   - реализация динамического массива
   - автоматическое расширение при необходимости
   - поддерживает все основные операции списка

2. **MyLinkedList**
   - реализация двусвязного списка
   - эффективные операции вставки/удаления
   - предотвращение циклов

### Логические структуры данных

1. **MyStack** (на основе MyArrayList)
   - LIFO (Last In, First Out)
   - основные операции: push, pop, peek

2. **MyQueue** (на основе MyLinkedList)
   - FIFO (First In, First Out)
   - основные операции: enqueue, dequeue, peek

3. **MyMinHeap** (на основе MyArrayList)
   - двоичная минимальная куча
   - основные операции: insert, extractMin, peekMin

## Интерфейсы

### MyList
```java
public interface MyList<T> extends Iterable<T> {
    void add(T item);
    void set(int index, T item);
    void add(int index, T item);
    void addFirst(T item);
    void addLast(T item);
    T get(int index);
    T getFirst();
    T getLast();
    void remove(int index);
    void removeFirst();
    void removeLast();
    void sort();
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);
    Object[] toArray();
    void clear();
    int size();
}
```

## Особенности реализации

- все структуры данных реализованы без использования java.util.* (кроме Iterator)
- поддержка дженериков для типобезопасности
- эффективные алгоритмы для основных операций
- подробное тестирование всех операций

## Запуск

для запуска тестов выполните:
```bash
javac *.java
java DataStructuresTest
``` 
