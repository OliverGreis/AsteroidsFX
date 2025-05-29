package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;


public interface IPostEntityProcessingService {

    /**
     *
     * <h4><strong>IPostEntityProcessingService:</strong></h4>
     *
     *  <p><strong>Description:</strong></p>
     * The {@code IPostEntityProcessingService} interface allows interaction with entities stored
     * in the {@code World}, similar to {@code IEntityProcessingService}, but is called afterward.
     * This ensures that things like collision detection occur after all entities have been moved first.
     *
     *  <br> <br>
     *
     * <p><strong>Preconditions:</strong></p>
     * <ul>
     *   <li>{@code gameData} is not {@code null}.</li>
     *   <li>{@code world} is not {@code null}.</li>
     *   <li>{@code world} must contain valid entities</li>
     * </ul>
     *
     * <p><strong>Postconditions:</strong></p>
     * <ul>
     *         <li>Entities in {@code world} can be added, removed, or otherwise processed during runtime</li>
     * </ul>
     *
     * @param gameData contains data about the current game state
     * @param world contains map of active entities
     * @throws NullPointerException if {@code gameData} or {@code world} is {@code null}
     */

    void process(GameData gameData, World world);
}
