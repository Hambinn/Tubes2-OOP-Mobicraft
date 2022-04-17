package com.aetherwars.pubsub;

import org.jetbrains.annotations.NotNull;

import java.lang.ref.WeakReference;
import java.util.*;

public class Channel {
    private final @NotNull Map<Class<? extends Event>, List<WeakReference<Subscriber<?>>>> subscribers;

    public Channel() {
        subscribers = new HashMap<>();
    }

    public <E extends Event> void subscribe(@NotNull Class<E> topic, @NotNull Subscriber<E> subscriber) {
        List<WeakReference<Subscriber<?>>> topicSubs = subscribers.computeIfAbsent(topic, k -> new ArrayList<>());
        topicSubs.add(new WeakReference<>(subscriber));
    }

    public <E extends Event> void unsubscribe(@NotNull Class<E> topic, @NotNull Subscriber<E> subscriber) {
        List<WeakReference<Subscriber<?>>> topicSubs = subscribers.get(topic);
        topicSubs.removeIf(ref -> Objects.equals(ref.get(), subscriber));
    }

    public <E extends Event> void publish(@NotNull E event) {
        List<WeakReference<Subscriber<?>>> subs = subscribers.get(event.getClass());
        for (WeakReference<Subscriber<?>> ref : subs) {
            Subscriber<E> sub = (Subscriber) ref.get();
            if (sub != null) {
                if (!sub.on(event)) {
                    break;
                }
            }
        }

        subs.removeIf(ref -> ref.get() == null);
    }
}
