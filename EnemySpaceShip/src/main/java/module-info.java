import dk.sdu.mmmi.cbse.EnemySpaceShip.EnemySpaceShipControlSystem;
import dk.sdu.mmmi.cbse.EnemySpaceShip.EnemySpaceShipPlugin;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.Stats.StatService;

module Enemy {
    requires Common;
    requires CommonBullet;
    requires java.desktop;
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    uses StatService;
    provides IGamePluginService with EnemySpaceShipPlugin;
    provides IEntityProcessingService with EnemySpaceShipControlSystem;
    
}
