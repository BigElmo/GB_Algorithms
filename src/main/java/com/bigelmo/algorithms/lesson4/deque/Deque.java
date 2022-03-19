package com.bigelmo.algorithms.lesson4.deque;

import com.bigelmo.algorithms.lesson3.queue.Queue;

public interface Deque<E> extends Queue<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();
}
