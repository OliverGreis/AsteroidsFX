package dk.sdu.mmmi.cbse.stat;

import dk.sdu.mmmi.cbse.common.services.Stats.StatService;

public class HP implements StatService {
    private int hp;

    public HP() {
        this.hp = 2;
    }

    @Override
    public int getStat() {
        return hp;
    }

    @Override
    public void setStat(int hp) {
        this.hp = hp;
    }

    @Override
    public void addStat(int value) {
        this.hp = hp + value;
    }
    @Override
    public void SubtractStat(int value) {
        this.hp = hp - value;
    }


}
