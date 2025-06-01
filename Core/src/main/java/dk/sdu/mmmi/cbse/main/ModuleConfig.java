package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.collisionsystem.CollisionDetector;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import java.util.List;
import java.util.ServiceLoader;
import static java.util.stream.Collectors.toList;

import dk.sdu.mmmi.cbse.common.services.ScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {
        "dk.sdu.mmmi.cbse.collisionsystem",
        "dk.sdu.mmmi.cbse.common"
})
class ModuleConfig {
    
    public ModuleConfig() {
    }

    @Autowired
    private List<IPostEntityProcessingService> postEntityProcessingServices;

    @Bean
    public Game game(){
        return new Game(gamePluginServices(), entityProcessingServiceList(), postEntityProcessingServices(),scoringService());
    }

    @Bean
    public List<IEntityProcessingService> entityProcessingServiceList(){
        return ServiceLoader.load(IEntityProcessingService.class).stream()
                .map(ServiceLoader.Provider::get)
                .collect(toList());
    }

    @Bean
    public List<IGamePluginService> gamePluginServices() {
        return ServiceLoader.load(IGamePluginService.class).stream()
                .map(ServiceLoader.Provider::get)
                .collect(toList());
    }

    @Bean
    public List<IPostEntityProcessingService> postEntityProcessingServices() {
        return postEntityProcessingServices;
    }
    @Bean
    public ScoringService scoringService() {
        return ServiceLoader.load(ScoringService.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No ScoringService implementation found"));
    }

}
