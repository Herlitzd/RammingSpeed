package com.rammingspeed.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public abstract class Renderable {

    protected Texture texture;

    public abstract Vector2 getPosition();

    public void render(SpriteBatch batch) {
    }

    public void render(ShapeRenderer render) {
    }
}
