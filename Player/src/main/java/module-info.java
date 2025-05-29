
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.Stats.StatService;

module Player {
    requires Common;
    requires CommonBullet;   
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    uses StatService;
    provides IGamePluginService with dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.playersystem.PlayerControlSystem;
}
