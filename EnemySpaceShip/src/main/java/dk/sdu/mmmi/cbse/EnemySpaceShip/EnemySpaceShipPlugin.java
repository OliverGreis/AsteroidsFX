package dk.sdu.mmmi.cbse.EnemySpaceShip;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Timer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EnemySpaceShipPlugin implements IGamePluginService {

    private Entity enemy;


    public EnemySpaceShipPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);

    }

    private Entity createEnemyShip(GameData gameData) {
        Entity EnemyShip = new EnemySpaceShip();
        EnemyShip.setCurrentTime(0);
        EnemyShip.setPolygonCoordinates(-5,-5,10,0,-5,5);
        EnemyShip.setX((gameData.getDisplayHeight()/2)-300);
        EnemyShip.setY((gameData.getDisplayWidth()/2)+20);
        EnemyShip.setRadius(8);

        return EnemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }
}
