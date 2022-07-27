public class inclass{
	public class Queue <E> {

    private List<E> elements;
    private int size;

    public Queue() {
        this.elements = new ArrayList<E>();
        this.size = 0;
    }

    public Queue enQueue (E e) {
        ArrayList<E> a = new ArrayList<E>(elements);
        a.add(e);
        return a;
    }

    public E peek()
    {
    	if (size == 0) throw new IllegalStateException("Queue.deQueue");
    	E result = elements.get(0);
    	return result;
    }

    public Queue deQueue () {
        if (size == 0) throw new IllegalStateException("Queue.deQueue");
        ArrayList<E> a = new ArrayList<E>(elements);
        a.remove(0);
        size--;
        return a;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
}