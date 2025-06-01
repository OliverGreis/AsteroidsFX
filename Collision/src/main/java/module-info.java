import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.ScoringService;

module Collision {
    requires Common;
    requires spring.beans;
    requires spring.context;
    exports dk.sdu.mmmi.cbse.collisionsystem;
}