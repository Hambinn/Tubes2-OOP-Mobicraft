package com.aetherwars.pubsub;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.function.Function;

public class Channel {
    private final Map<Class<? extends Event>, List<WeakReference<Subscriber<?>>>> subscribers;

    public Channel() {
        subscribers = new HashMap<>();
    }

    public <E extends Event> void subscribe(Class<E> topic, Subscriber<E> subscriber) {
        List<WeakReference<Subscriber<?>>> topicSubs = subscribers.get(topic);
        if (topicSubs == null) {
            subscribers.put(topic, new ArrayList<>());
        }

        topicSubs.add(new WeakReference<>(subscriber));
    }

    public <E extends Event> void publish(E event) {
        List<WeakReference<Subscriber<?>>> subs = subscribers.get(event.getClass());
        for (WeakReference<Subscriber<?>> ref : subs) {
            Subscriber<E> sub = (Subscriber) ref.get();
            if (sub != null) {
                if (!sub.on(event)) {
                    break;
                }
            }
        }

        subs.removeIf(Objects::isNull);
    }
}
