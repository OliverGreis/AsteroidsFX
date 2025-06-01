package dk.sdu.mmi.cbse.stat;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.stat.CD;
import dk.sdu.mmmi.cbse.stat.HP;
import dk.sdu.mmmi.cbse.stat.StatControlSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Not;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StatUnitTest {

    CD cd;
    HP hp;
    StatControlSystem scs;
    World world;
    GameData gameData;
    int MAX_CD = 30;


    @BeforeEach
    public void testSetUp() {
        cd = spy(new CD());
        hp = spy(new HP());
        scs = spy(new StatControlSystem());
        world = mock(World.class);
        gameData = mock(GameData.class);

    }

        @Test
        public void testHPStatClass() {
            assertEquals(2,hp.getStat());
            hp.setStat(4);
            assertEquals(4,hp.getStat());
            hp.addStat(2);
            assertEquals(6,hp.getStat());
            hp.SubtractStat(2);
            assertEquals(4,hp.getStat());
        }

    @Test
    public void testCDStatClass() {
        assertEquals(0,cd.getStat());
        cd.setStat(4);
        assertEquals(4,cd.getStat());
        cd.addStat(2);
        assertEquals(6,cd.getStat());
        cd.SubtractStat(2);
        assertEquals(4,cd.getStat());
    }

    @Test
    public void testStatControlSystem() {
        Entity entity1 = spy(new Entity());
        Entity entity2 = spy(new Entity());
        Entity entity3 = spy(new Entity());
        CD cd2 = spy(new CD());
        HP hp2 = spy(new HP());

        entity1.addStat(hp);
        entity2.addStat(hp2);
        entity1.getStat("HP").setStat(0);
        entity1.addStat(cd);
        entity1.getStat("CD").setStat(28);
        entity2.addStat(cd2);
        entity2.getStat("CD").setStat(MAX_CD);


        Map<String,Entity> Entities = new ConcurrentHashMap<>();
        Entities.put("1",entity1);
        Entities.put("2",entity2);
        Entities.put("3",entity3);
        when(world.getEntities()).thenReturn(Entities.values());

        scs.process(gameData,world);
        verify(world,times(1)).removeEntity(entity1);
        assertEquals(29,entity1.getStat("CD").getStat());
        assertEquals(0,entity2.getStat("CD").getStat());
    }
}
