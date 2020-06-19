package Listeners;

import Tiles.Tile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.concurrent.TimeUnit;

public class TileClickListener extends ClickListener {

    private static Tile lastClickedTile = null;
    private Tile tile;

    public TileClickListener(Tile tile){
        this.tile = tile;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);

        if(!tile.isClicked()) {
            tile.setClicked(true);
            tile.changeToTexture();
            System.out.println("ZMIEN SIE");

            if(lastClickedTile == null)
                lastClickedTile = tile;
            else{

                lastClickedTile.setDisabled(true);
                tile.setDisabled(true);

                try {
                    TimeUnit.SECONDS.sleep(2);
                }catch(Exception e){}

                lastClickedTile.setDisabled(false);
                tile.setDisabled(false);

                if(lastClickedTile.getTexture() == tile.getTexture()){

                    //WE GOT A POINT
                    System.out.println("WE GOT A POINT!!!");

                }else{
System.out.println("HEHE");
                    //TODO: ADD NUMBER OF TRIES AND HIDE BOTH TEXTURES
                    lastClickedTile.changeToCoveredTexture();
                    tile.changeToCoveredTexture();

                }

                lastClickedTile = null;
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
