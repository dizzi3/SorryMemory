package Screens;

import Listeners.StartGameButtonListener;
import Styles.DefaultButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.dizzie.game.MemoryGame;

public class MenuScreen extends AbstractScreen{

    private TextButton startGameButton;

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
        startGameButton = new TextButton("START GAME", new DefaultButtonStyle());
        startGameButton.addListener(new StartGameButtonListener(game));
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
    }
}
