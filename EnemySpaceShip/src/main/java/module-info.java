import dk.sdu.mmmi.cbse.EnemySpaceShip.EnemySpaceShipControlSystem;
import dk.sdu.mmmi.cbse.EnemySpaceShip.EnemySpaceShipPlugin;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Enemy {
    requires Common;
    requires CommonBullet;
    requires java.desktop;
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides IGamePluginService with EnemySpaceShipPlugin;
    provides IEntityProcessingService with EnemySpaceShipControlSystem;
    
}
