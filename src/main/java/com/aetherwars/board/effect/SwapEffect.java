package com.aetherwars.board.effect;

public class SwapEffect extends Effect {
    public SwapEffect(SwapSpell spell) {
        super(spell);
    }

    @Override
    public int getAttackBuff() {
        return 0;
    }

    @Override
    public int receiveAttack(int attack) {
        return 0;
    }
}
