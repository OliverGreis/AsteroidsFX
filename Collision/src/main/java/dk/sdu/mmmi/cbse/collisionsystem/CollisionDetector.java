package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.ArrayList;
import java.util.List;

public class CollisionDetector implements IPostEntityProcessingService {

    public CollisionDetector() {
    }

    @Override
    public void process(GameData gameData, World world) {
        // two for loops for all entities in the world
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                // if the two entities are identical, skip the iteration
                if (entity1.getID().equals(entity2.getID())) {
                    continue;                    
                }

                // CollisionDetection
                if (this.collides(entity1, entity2)) {
                    String En1 = getEntityType(entity1);
                    String En2 = getEntityType(entity2);
                    Entity[] entities = {entity1, entity2};
                    List<String> EntityMap = new ArrayList<>();
                    EntityMap.add(En1);
                    EntityMap.add(En2);
                    System.out.println(EntityMap);
                    System.out.println(entities.toString());
                    if(EntityMap.contains("Player") && EntityMap.contains("Bullet")){
                        entities[EntityMap.indexOf("Player")].getStat("HP").SubtractStat(1);
                        world.removeEntity(entities[EntityMap.indexOf("Bullet")]);
                    }

                    if(EntityMap.contains("Enemy") && EntityMap.contains("Bullet")){
                        entities[EntityMap.indexOf("Enemy")].getStat("HP").SubtractStat(1);
                        world.removeEntity(entities[EntityMap.indexOf("Bullet")]);
                    }

                    if( EntityMap.contains("Player") && EntityMap.contains("Asteroid")){
                        world.removeEntity(entity1);
                        world.removeEntity(entity2);
                    }

                    if( EntityMap.contains("Bullet") && EntityMap.contains("Asteroid")){
                        entities[EntityMap.indexOf("Asteroid")].setDestroyed(true);
                        world.removeEntity(entities[EntityMap.indexOf("Bullet")]);
                    }


                }
            }
        }

    }

    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }

    public String getEntityType(Entity en){
        if(en.getClass().getSimpleName().contains("Player")){
            return "Player";
        }

        if(en.getClass().getSimpleName().contains("Asteroid")){
            return "Asteroid";
        }

        if(en.getClass().getSimpleName().contains("Bullet")){
            return "Bullet";
        }

        if(en.getClass().getSimpleName().contains("Enemy")){
            return "Enemy";
        }
        return null;
    }


}
