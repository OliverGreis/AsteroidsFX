package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 *
 * @author corfixen
 */
public class AsteroidSplitterImpl implements IAsteroidSplitter {

    @Override
    public void createSplitAsteroid(Entity e, World world) {
        if(e.getPolygonCoordinates()[0] <= 5){
            world.removeEntity(e);

        }
        else{
            int size = (int)e.getPolygonCoordinates()[0]/2;
            Entity asteroid1 = new Asteroid();
            Entity asteroid2 = new Asteroid();
            asteroid1.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
            asteroid1.setX(e.getX());
            asteroid1.setY(e.getY());
            asteroid1.setRadius((float)size);
            asteroid1.setRotation(Math.random()*360);
            asteroid2.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
            asteroid2.setX(e.getX());
            asteroid2.setY(e.getY());
            asteroid2.setRadius(size);
            asteroid2.setRotation(asteroid1.getRotation()-180);
            world.removeEntity(e);
            world.addEntity(asteroid1);
            world.addEntity(asteroid2);
        }
    }

}


