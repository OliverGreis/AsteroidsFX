package dk.sdu.mmmi.cbse.playersystem;

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

public class PlayerPlugin implements IGamePluginService {

    private HashMap<String, StatService> playerStats = new HashMap<>();
    private Entity player;
    List<StatService> StatServices = loadStats();

    public PlayerPlugin() {
        for (StatService service : StatServices) {
            playerStats.put(service.getClass().getSimpleName(),service);
        }
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        player = createPlayerShip(gameData);
        world.addEntity(player);
    }

    private Entity createPlayerShip(GameData gameData) {

        Entity playerShip = new Player();
        playerShip.setPolygonCoordinates(-5,-5,10,0,-5,5);
        playerShip.setX(gameData.getDisplayHeight()/2);
        playerShip.setY(gameData.getDisplayWidth()/2);
        playerShip.setRadius(8);
        playerShip.addStat(playerStats.get("HP"));
        playerShip.addStat(playerStats.get("CD"));

        return playerShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(player);
    }

    public static List<StatService> loadStats() {
        ServiceLoader<StatService> loader = ServiceLoader.load(StatService.class);
        return StreamSupport.stream(loader.spliterator(), false).collect(Collectors.toList());
    }

}
