package dk.sdu.mmmi.cbse.common.data;

import dk.sdu.mmmi.cbse.common.services.Stats.StatService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

public class Entity implements Serializable {

    private final UUID ID = UUID.randomUUID();
    
    private double[] polygonCoordinates;
    private double x;
    private double y;
    private double rotation;
    private float radius;
    private float time;
    private HashMap<String, StatService> Stats = new HashMap<>();
    public boolean destroyed;


    public String getID() {
        return ID.toString();
    }


    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void setPolygonCoordinates(double... coordinates ) {
        this.polygonCoordinates = coordinates;
    }

    public double[] getPolygonCoordinates() {
        return polygonCoordinates;
    }
       

    public void setX(double x) {
        this.x =x;
    }

    public double getX() {
        return x;
    }

    
    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
        
    public float getRadius() {
        return this.radius;
    }

    public void setCurrentTime(float time) {this.time = time;}

    public float getCurrentTime() {return this.time;}

    public void addCurrentTime(float time) {this.time = this.time + time;}

    public void addStat(StatService stat){
        Stats.put(stat.getClass().getSimpleName(),stat);
    }
    public HashMap<String, StatService> getStats() {
        return Stats;
    }

    public StatService getStat(String name) {
        return Stats.get(name);
    }
}
