package Styles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class GameNameLabel extends Label.LabelStyle
/** Styl do obiektu klasy Label.
 * Klasa odpowiada za zmiane czcionki oraz jej rozmiaru. */{

    public GameNameLabel(){
        initializeFont();
    }

    private void initializeFont(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/LexendTera-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 55;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

}
