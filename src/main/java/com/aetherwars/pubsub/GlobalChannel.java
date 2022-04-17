package com.aetherwars.pubsub;

public class GlobalChannel extends Channel {
    private static GlobalChannel instance;

    public GlobalChannel() {
        super();
    }

    public static GlobalChannel getInstance() {
        if (instance == null) {
            instance = new GlobalChannel();
        }
        return instance;
    }
}
