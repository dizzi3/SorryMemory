package Tiles;

import Listeners.TileClickListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Tile extends ImageButton {

    private static final Texture COVERED_TEXTURE = new Texture(Gdx.files.internal("tiles/covered_tile.png"));
    private Texture texture;

    private boolean clicked = false;

    public Tile(Texture texture) {
        super(new TextureRegionDrawable(COVERED_TEXTURE));

        //TODO: DELETE THIS AND UNCOMMENT THE SUPPER ABOVE
        //super(new TextureRegionDrawable(texture));

        this.texture = texture;
        addListener(new TileClickListener(this));
    }

    public Texture getTexture(){
        return this.texture;
    }

    public void changeToTexture(){
        changeTexture(texture);
    }

    public void changeToCoveredTexture(){
        changeTexture(COVERED_TEXTURE);
    }

    private void changeTexture(Texture texture){
        ImageButtonStyle style = new ImageButtonStyle();
        style.up = new TextureRegionDrawable(texture);
        setStyle(style);
    }

    public void setClicked(boolean clicked){ this.clicked = clicked; }

    public boolean isClicked(){ return this.clicked; }

}
