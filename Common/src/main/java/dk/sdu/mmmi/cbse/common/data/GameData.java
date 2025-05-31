package dk.sdu.mmmi.cbse.common.data;

public class GameData {

    private int displayWidth  = 800 ;
    private int displayHeight = 800;
    private String ScoreText;
    private final GameKeys keys = new GameKeys();


    public GameKeys getKeys() {
        return keys;
    }

    public void setDisplayWidth(int width) {
        this.displayWidth = width;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayHeight(int height) {
        this.displayHeight = height;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public String getScoreText() {
        return ScoreText;
    }

    public void setScoreText(String scoreText) {
        ScoreText = scoreText;
    }
}
