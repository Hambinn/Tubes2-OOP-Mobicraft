package com.aetherwars.pubsub;

import org.jetbrains.annotations.NotNull;

public interface Subscriber<T extends Event> {
    boolean on(@NotNull T event);
}
