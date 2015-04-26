package main;

public class CircularBuffer {
  private int size;
  private int maxSize;
  private int frontPtr = 0;
  private int rearPtr = 0;
  private int[] buffer;

  public CircularBuffer(int maxSize) {
    this.maxSize = maxSize;
    this.frontPtr = 0;
    this.rearPtr = 0;
    this.size = 0;
    this.buffer = new int[maxSize];
  }

  public int remove() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }
    size--;
    frontPtr = (frontPtr + 1) % maxSize;
    return buffer[frontPtr];
  }

  public void add(int item) {
    if (isFull()) {
      throw new IllegalStateException("Queue is full");
    }
    size++;
    rearPtr = (rearPtr + 1) % maxSize;
    buffer[rearPtr] = item;
  }

  private boolean isEmpty() {
    return this.size == 0;
  }

  private boolean isFull() {
    return this.size == this.maxSize;
  }
}
