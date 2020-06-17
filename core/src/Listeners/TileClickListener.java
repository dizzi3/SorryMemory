package Listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class TileClickListener extends HandCursorListener{

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);

        System.out.println("CLICKED A TILE");
    }
}
