package Listeners;

import Screens.GameScreen;
import Tiles.Tile;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TileClickListener extends ClickListener {

    private static Tile lastClickedTile = null;
    private Tile tile;
    private GameScreen gameScreen;

    public TileClickListener(Tile tile, GameScreen gameScreen){
        this.tile = tile;
        this.gameScreen = gameScreen;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);

        if(!tile.isClicked()) {
            tile.setClicked(true);
            tile.changeToTexture();

            if(lastClickedTile == null)
                lastClickedTile = tile;
            else{

                gameScreen.setAllTilesDisabled();

                ScheduledExecutorService scheduler
                        = Executors.newSingleThreadScheduledExecutor();

                Runnable task = new Runnable() {
                    public void run() {

                        if(lastClickedTile.getTexture() == tile.getTexture()){

                            //WE GOT A POINT
                            System.out.println("WE GOT A POINT!!!");
                            lastClickedTile.setUncovered(true);
                            tile.setUncovered(true);

                        }else{

                            //TODO: ADD NUMBER OF TRIES AND HIDE BOTH TEXTURES
                            lastClickedTile.changeToCoveredTexture();
                            tile.changeToCoveredTexture();
                        }

                        lastClickedTile = null;
                        gameScreen.undisableTiles();
                    }
                };

                int delay = 2;
                scheduler.schedule(task, delay, TimeUnit.SECONDS);
            }
        }
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        super.enter(event, x, y, pointer, fromActor);

        if(!tile.isClicked()) {
            Pixmap pm = new Pixmap(Gdx.files.internal("other/hand_cursor.png"));
            Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 8, 0));
            pm.dispose();
        }
    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        super.exit(event, x, y, pointer, toActor);

        Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
    }
}
