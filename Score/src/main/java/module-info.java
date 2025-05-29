import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.ScoringService;
import dk.sdu.mmmi.cbse.common.services.Stats.StatService;

import java.io.StreamCorruptedException;


module Score {
    requires Common;
    //provides ScoringService with dk.sdu.mmmi.cbse.score.ScoreProcessor;
}