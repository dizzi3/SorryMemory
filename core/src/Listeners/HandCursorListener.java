package Listeners;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public abstract class HandCursorListener extends ClickListener {

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        super.enter(event, x, y, pointer, fromActor);

        Pixmap pm = new Pixmap(Gdx.files.internal("other/hand_cursor.png"));
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 8, 0));
        pm.dispose();
    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        super.exit(event, x, y, pointer, toActor);

        Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
    }

}
