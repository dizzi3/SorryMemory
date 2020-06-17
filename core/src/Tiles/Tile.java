package Tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Tile extends ImageButton {

    private static final Texture COVERED_TEXTURE = new Texture(Gdx.files.internal("tiles/covered_tile.png"));
    private Texture texture;

    public Tile(Texture texture) {
        //super(new TextureRegionDrawable(COVERED_TEXTURE));
        super(new TextureRegionDrawable(texture));
        this.texture = texture;
    }

    public Texture getTexture(){
        return this.texture;
    }

}
