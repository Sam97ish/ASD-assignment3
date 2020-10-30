package main.assignment3;

public interface BinaryHeap<AnyType> {

        public void insert(AnyType t);

        public AnyType deleteMin();

        public boolean isEmpty();

        public int size();

        public AnyType findMin();

}
