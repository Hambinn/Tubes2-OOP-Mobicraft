package com.aetherwars.pubsub;

public interface Subscriber<T extends Event> {
    boolean on(T event);
}
