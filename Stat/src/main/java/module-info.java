import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.Stats.StatService;


module Stat {
    requires Common;
    provides StatService with dk.sdu.mmmi.cbse.stat.HP;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.stat.StatControlSystem;
}