/**
 * <h2>Lab3.java - Add methods to make our LinkedList look more like a List.</h2>
 * <p><b>Problem Statement:</b> Add the add(E), add(int, E), remove(int), and remove(Object).  Also
 *    change a few methods to use iterators.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ol style="margin-left: 40px;">
 *   <li>Start with the final version of the LinkedList class from the last exercise.</li>
 *   <li>Add "add(E)" and "add(int, E) methods.</li>
 *   <li>Add "remove(Object)" and remove(int) methods using an iterator.</li>
 *   <li>Add a "set(E)" method using an iterator.</li>
 *   <li>Change the "size" and "indexOf" methods to use iterators.</li>
 *   <li>Add and remove words to make a famous quote by Thomas Edison:
 *       "I failed my way to success."</li>
 * </ol>
 * @author Brian Nguyen
 * @version Module 3, Lab
 */

/**class LinkedList<E> {
    private Node<E> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean add(E e) {
        add(size, e);
        return true;
    }

    public void add(int index, E element) {
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            index = size;
        }

        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new Node<>(element, current.next);
        }
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        E removed;
        if (index == 0) {
            removed = head.data;
            head = head.next;
        } else {
            removed = current.next.data;
            current.next = current.next.next;
        }

        size--;
        return removed;
    }

    public boolean remove(Object o) {
        Node<E> current = head;
        Node<E> previous = null;

        while (current != null) {
            if ((o == null && current.data == null) || (o != null && o.equals(current.data))) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public E set(int index, E element) {
        if (index < 0) {
            add(0, element);
            return null;
        }
        if (index >= size) {
            add(size, element);
            return null;
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        E oldValue = current.data;
        current.data = element;
        return oldValue;
    }

    public int size() {
        return size;
    }

    public int indexOf(Object o) {
        Node<E> current = head;
        int index = 0;

        while (current != null) {
            if ((o == null && current.data == null) || (o != null && o.equals(current.data))) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public ListIterator iterator() {
        return new ListIterator();
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public class ListIterator {
        private Node<E> nextNode;
        private Node<E> lastReturned;

        private ListIterator() {
            nextNode = head;
            lastReturned = null;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            lastReturned = nextNode;
            E value = nextNode.data;
            nextNode = nextNode.next;
            return value;
        }

        public boolean hasPrevious() {
            return false;
        }

        public E previous() {
            throw new UnsupportedOperationException();
        }
    }
}
*/
public class Lab3 {

    public static void main(String[] args) {

        // Create a linked list of Strings.  Add a few words, remove some of them,
        // then print the final message.
        LinkedList<String> message = new LinkedList<>();
        message.add("failure");
        message.add("your");
        message.add("electricity");
        message.add("to");
        message.set(5, "generics");
        message.remove(1);
        message.add(0, "failed");
        message.add("- Thomas");
        message.add(4, "success.");
        message.add(0, "light");
        message.remove("electricity");
        message.add(-1, "light");
        message.set(0, "I");
        message.set(2, "my");
        message.add(3, "way");
        message.remove("failure");
        message.add("Edison");

        // Print the message using an iterator
        printMessage("Final Message:", message);
    }

    // Show what the prior statement did and print the resulting message
    private static <E> void printMessage(String heading, LinkedList<E> list) {
        System.out.printf("%-30s: ", heading);
        LinkedList<E>.ListIterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}