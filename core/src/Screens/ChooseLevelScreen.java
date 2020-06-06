package Screens;

import Styles.DefaultButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.dizzie.game.MemoryGame;

public class ChooseLevelScreen extends AbstractScreen{

    private Table table;

    private TextButton lvlEasyButton;
    private TextButton lvlMediumButton;
    private TextButton lvlHardButton;

    public ChooseLevelScreen(MemoryGame game){
        super(game);
    }

    @Override
    protected void init() {
        initializeButtons();
        initializeTable();
    }

    private void initializeButtons() {
        lvlEasyButton = new TextButton("Easy - 12 pairs", new DefaultButtonStyle());
        lvlMediumButton = new TextButton("Medium - 18 pairs", new DefaultButtonStyle());
        lvlHardButton = new TextButton("Hard - 24 pairs", new DefaultButtonStyle());
    }

    private void initializeTable(){
        table = new Table();
        table.setFillParent(true);
        table.add(lvlEasyButton).padBottom(40);
        table.row();
        table.add(lvlMediumButton).padBottom(40);
        table.row();
        table.add(lvlHardButton);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        stage.act();
        stage.draw();
    }

}
