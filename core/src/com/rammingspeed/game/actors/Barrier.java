package com.rammingspeed.game.actors;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.rammingspeed.game.PhysicsObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author devon
 */
public class Barrier extends PhysicsObject {

    public Barrier(float x, float y, boolean horizontal) {
        super(new BodyDef(), new FixtureDef());
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x, y);

        PolygonShape shape = new PolygonShape();
        if (horizontal) {
            shape.setAsBox(150, 5);
        } else {
            shape.setAsBox(5, 150);
        }

        fixtureDef.shape = shape;
        fixtureDef.density = 4f;
        fixtureDef.friction = .6f;
        fixtureDef.restitution = 0f;
    }

//    public Barrier() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public Vector2 getPosition() {
        return this.body.getPosition();
    }

    @Override
    public void render(ShapeRenderer render) {
        Vector2 pos = this.getPosition();
//        render.rect(pos.x, pos.y, 150, 5);
    }

}
