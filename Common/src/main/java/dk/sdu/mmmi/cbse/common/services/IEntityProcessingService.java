package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     * <p><strong>Description:</strong></p>
     * The {@code IEntityProcessingService} interface allows interaction with entities stored
     * in the {@code World} like adding, removing or updating entity states.
     *
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
     * @param world contains active map of active entities
     * @throws NullPointerException if {@code gameData} or {@code world} is {@code null}
     */

    void process(GameData gameData, World world);
}
