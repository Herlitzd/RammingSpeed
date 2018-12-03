/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rammingspeed.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

/**
 *
 * @author devon
 */
public class Player extends Actor {

    static float width = 5, height = 12;

    public Player() {
        super(Player.getShape());
        this.texture = new Texture(Gdx.files.internal("playerwalk.png"));
    }

    public static Shape getShape() {
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2, height / 2);
        return shape;
    }

    @Override
    public void render(SpriteBatch batch) {
        Vector2 pos = this.getPosition();
        if (Gdx.input.isKeyPressed(Keys.SPACE)) {
            this.body.applyLinearImpulse(0, 500f, pos.x, pos.y, true);
        } else if (Gdx.input.isKeyPressed(Keys.A)) {
            this.body.applyLinearImpulse(-100f, 0, pos.x, pos.y, true);
        } else if (Gdx.input.isKeyPressed(Keys.D)) {
            this.body.applyLinearImpulse(100f, 0, pos.x, pos.y, true);
        }
        batch.draw(texture, pos.x - (width / 2), pos.y - (height / 2), width, height);
    }

}
