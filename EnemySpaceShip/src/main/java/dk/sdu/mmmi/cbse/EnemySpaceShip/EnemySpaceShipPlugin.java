package dk.sdu.mmmi.cbse.EnemySpaceShip;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.Stats.StatService;

import java.util.HashMap;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EnemySpaceShipPlugin implements IGamePluginService {

    private HashMap<String, StatService> StatMap = new HashMap<>();
    private Entity enemy;
    List<StatService> StatServices = loadStats();


    public EnemySpaceShipPlugin() {
        for (StatService service : StatServices) {
            StatMap.put(service.getClass().getSimpleName(),service);
        }
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
        EnemyShip.addStat(StatMap.get("HP"));
        EnemyShip.addStat(StatMap.get("CD"));


        return EnemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }

    public static List<StatService> loadStats() {
        ServiceLoader<StatService> loader = ServiceLoader.load(StatService.class);
        return StreamSupport.stream(loader.spliterator(), false).collect(Collectors.toList());
    }
}
