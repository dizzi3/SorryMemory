package Screens;

import Listeners.MenuButtonListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.dizzie.game.MemoryGame;

public class MenuScreen extends AbstractScreen{

    private TextButton startGameButton;
    private TextButton.TextButtonStyle startGameButtonStyle;
    private BitmapFont font;
    private Skin skin;

    private Table table;

    public MenuScreen(MemoryGame game){
        super(game);
    }

    @Override
    protected void init() {
        initializeButtons();
        initializeTable();
    }

    private void initializeButtons() {
        initializeFont();
        skin = new Skin();

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("Pack.atlas"));
        skin.addRegions(atlas);

        startGameButtonStyle = new TextButton.TextButtonStyle();
        startGameButtonStyle.font = font;
        startGameButtonStyle.fontColor = Color.BLACK;
        startGameButtonStyle.up = new NinePatchDrawable(skin.getPatch("Button"));
        startGameButton = new TextButton("START GAME", startGameButtonStyle);
        startGameButton.addListener(new MenuButtonListener());
    }

    private void initializeFont(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/LexendTera-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    private void initializeTable(){
        table = new Table();
        table.setFillParent(true);
        table.add(startGameButton);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        skin.dispose();
        font.dispose();
    }
}
