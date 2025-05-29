package dk.sdu.mmmi.cbse.stat;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class StatControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world){

        for (Entity entity : world.getEntities()) {
            if(entity.getStat("HP") != null){
                if(entity.getStat("HP").getStat() <= 0){
                    world.removeEntity(entity);
                }
            }





        }




        }
}
