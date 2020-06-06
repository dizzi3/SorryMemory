package Styles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public class DefaultButtonStyle extends TextButton.TextButtonStyle{

    private Skin skin;
    private TextureAtlas atlas;

    public DefaultButtonStyle(){
        initialize();
    }

    private void initialize(){
        skin = new Skin();
        initializeFont();

        atlas = new TextureAtlas(Gdx.files.internal("packed/MainMenuButtons.atlas"));
        skin.addRegions(atlas);

        fontColor = Color.BLACK;
        up = new NinePatchDrawable(skin.getPatch("button_"));
        over = new NinePatchDrawable(skin.getPatch("button_hover"));
    }

    private void initializeFont(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/LexendTera-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

}
