package collections;

class Node<T> {
    T data;
    Node<T> nextNode;
    Node<T> previousNode;

    Node(T data) {
        this.data = data;
        nextNode = null;
        previousNode = null;
    }

}
