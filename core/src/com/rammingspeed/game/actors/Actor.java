/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rammingspeed.game.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.rammingspeed.game.PhysicsObject;

/**
 *
 * @author devon
 */
public abstract class Actor extends PhysicsObject {

    public Actor(Shape shape) {
        super(new BodyDef(), new FixtureDef());
        bodyDef.type = BodyType.DynamicBody;
        bodyDef.position.set(10, 10);
        bodyDef.fixedRotation = true;
        
        fixtureDef.shape = shape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = .8f;
        fixtureDef.restitution = 0f;
    }

    @Override
    public Vector2 getPosition() {
        return this.body.getPosition();
    }

}
