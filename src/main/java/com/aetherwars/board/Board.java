package com.aetherwars.board;

import java.util.*;

public class Board {
    private static List<String> slotNames;
    static {
        slotNames = new ArrayList<>(
                Arrays.asList("A", "B", "C", "D", "E")
        );
        slotNames = Collections.unmodifiableList(slotNames);
    }

    private Map<String, ActiveCharacter> slots;

    public Board() {
        this.slots = new HashMap<>(5);
        for (String name: slotNames) {
            this.slots.put(name, null);
        }
    }

    public ActiveCharacter get(String name) {
        return slots.get(name);
    }

    public void put(String name, ActiveCharacter character) throws Exception {
        if (!slotNames.contains(name)) {
            throw new Exception();
        }
        if (slots.get(name) != null) {
            throw new Exception();
        }
        slots.put(name, character);
    }
}
