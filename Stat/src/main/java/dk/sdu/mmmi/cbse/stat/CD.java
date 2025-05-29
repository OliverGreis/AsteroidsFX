package dk.sdu.mmmi.cbse.stat;

import dk.sdu.mmmi.cbse.common.services.Stats.StatService;

public class CD implements StatService {
    private int cd;

    public CD() {
        this.cd = 5;
    }

    @Override
    public int getStat() {
        return cd;
    }

    @Override
    public void setStat(int stat) {
        this.cd = stat;
    }

    @Override
    public void addStat(int value) {
        this.cd = cd + value;
    }
    @Override
    public void SubtractStat(int value) {
        this.cd = cd - value;
    }

}
