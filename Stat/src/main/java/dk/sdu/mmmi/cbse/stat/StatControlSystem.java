package dk.sdu.mmmi.cbse.stat;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class StatControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world){

        for (Entity entity : world.getEntities()) {

            if(CheckNoHp(entity)){
                world.removeEntity(entity);
            }
            CheckCd(entity);


        }




        }
        public boolean CheckNoHp(Entity entity){
            if(entity.getStat("HP") != null){
                if(entity.getStat("HP").getStat() <= 0){
                    return true;
                }
            }
            return false;
        }
        public void CheckCd(Entity entity){
            if(entity.getStat("CD") != null){
                if(entity.getStat("CD").getStat() >= 30){
                    entity.getStat("CD").setStat(0);
                }
                else{
                    entity.getStat("CD").addStat(1);
                }
            }
        }

}
