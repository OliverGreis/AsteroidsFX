package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {

    /**
     * <p><strong>Description:</strong></p>
     * The {@code IGamePluginService} interface start method allows creation of entities on game startup of
     * different types using {@code world}.
     *
     * <br> <br>
     *
     * <p><strong>Preconditions:</strong></p>
     * <ul>
     *   <li>{@code gameData} is not {@code null}.</li>
     *   <li>{@code world} is not {@code null}.</li>
     * </ul>
     *
     * <p><strong>Postconditions:</strong></p>
     * <ul>
     *     <li>Entities of different types are created and added to {@code world}, according to plugin implementations. </li>
     * </ul>
     *
     * @param gameData contains data about the current game state
     * @param world contains map of active entities
     * @throws NullPointerException if {@code gameData} or {@code world} is {@code null}
     */

    void start(GameData gameData, World world);

    /**
     * <p><strong>Description:</strong></p>
     * The {@code IGamePluginService} interface stop method allows
     * removal of entities from {@code world}.
     *
     * <br> <br>
     *
     * <p><strong>Preconditions:</strong></p>
     * <ul>
     *   <li>{@code gameData} is not {@code null}.</li>
     *   <li>{@code world} is not {@code null}.</li>
     *   <li>1 or more of plugin entity type in {@world}</li>
     * </ul>
     *
     * <p><strong>Postconditions:</strong></p>
     * <ul>
     *     <li>Entities for given type are removed from {@code world}, according to plugin implementations. </li>
     * </ul>
     *
     * @param gameData contains data about the current game state
     * @param world contains map of active entities
     * @throws NullPointerException if {@code gameData} or {@code world} is {@code null}
     */

    void stop(GameData gameData, World world);
}
