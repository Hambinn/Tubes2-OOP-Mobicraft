package com.aetherwars.pubsub;

import org.jetbrains.annotations.NotNull;

public class GlobalChannel extends Channel {
    private static GlobalChannel instance;

    public GlobalChannel() {
        super();
    }

    public static @NotNull GlobalChannel getInstance() {
        if (instance == null) {
            instance = new GlobalChannel();
        }
        return instance;
    }
}
