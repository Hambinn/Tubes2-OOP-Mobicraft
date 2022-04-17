package com.aetherwars.pubsub;

import org.jetbrains.annotations.NotNull;

public interface Publisher {
    @NotNull Channel getChannel();
}
