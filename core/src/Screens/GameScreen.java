package Screens;

import Styles.TriesLabelStyle;
import Tiles.RandomTileTexture;
import Tiles.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.dizzie.game.MemoryGame;

import java.util.Arrays;
import java.util.Random;


public class GameScreen extends AbstractScreen{

    private Tile[] tiles;
    private Table table;
    private int nTries;
    private int currentTries = 0;
    private int points = 0;

    private Label triesLabel;

    public GameScreen(MemoryGame game, int numberOfTiles){
        super(game);

        tiles = new Tile[numberOfTiles];
        nTries = numberOfTiles;
        initialize();
    }

    private void initialize(){
        initializeTable();
        initializeLabels();
        initializeTiles();
    }

    private void initializeTable() {
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
    }

    private void initializeLabels() {
        triesLabel = new Label("Tries: " + currentTries + "/" + nTries, new TriesLabelStyle());

        int yOffset;
        if(tiles.length == 12)
            yOffset = 200;
        else if(tiles.length == 18)
            yOffset = 150;
        else
            yOffset = 100;

        triesLabel.setPosition(MemoryGame.WIDTH / 2 - triesLabel.getWidth() / 2,MemoryGame.HEIGHT - yOffset);
        stage.addActor(triesLabel);
    }

    private void initializeTiles(){
        Arrays.fill(tiles, null);

        do{
            Texture texture = RandomTileTexture.get();
            tiles[getRandomEmptyTileIndex()] = new Tile(texture, this);
            tiles[getRandomEmptyTileIndex()] = new Tile(texture, this);

        }while(isThereAnEmptyTile());


        for(int i = 0; i < tiles.length; i++){
            table.add(tiles[i]).padRight(30).padBottom(30);

            if((i+1) % 6 == 0)
                table.row();
        }
    }

    private boolean isThereAnEmptyTile(){
        for(int i = 0; i < tiles.length; i++){
            if(tiles[i] == null)
                return true;
        }

        return false;
    }

    private int getRandomEmptyTileIndex(){
        Random rand = new Random();
        int emptyTileIndex;
        do{
            emptyTileIndex = rand.nextInt(tiles.length);
        }while(tiles[emptyTileIndex] != null);

        return emptyTileIndex;
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        stage.act();
        stage.draw();
    }

    public void setAllTilesDisabled(){
        for(int i = 0; i < tiles.length; i++) {
            tiles[i].setDisabled(true);
            tiles[i].setClicked(true);
        }
    }

    public void undisableTiles(){
        for(int i = 0; i < tiles.length; i++) {
            if(!tiles[i].isUncovered()) {
                tiles[i].setDisabled(false);
                tiles[i].setClicked(false);
            }
        }
    }

    @Override
    protected void init() {

    }

    public void increaseTries(){
        this.currentTries++;
        triesLabel.setText("Tries: " + currentTries + "/" + nTries);

        if(currentTries >= nTries)
            game.setScreen(new EndGameScreen(game, false));
    }

    public void increasePoints(){
        points++;
        if(points >= tiles.length / 2)
            game.setScreen(new EndGameScreen(game, true));
    }

}
