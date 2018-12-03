/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rammingspeed.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public abstract class PhysicsObject extends Renderable {

    protected final BodyDef bodyDef;
    protected final FixtureDef fixtureDef;
    protected Body body;

    public PhysicsObject(BodyDef def, FixtureDef fixture) {
        this.bodyDef = def;
        this.fixtureDef = fixture;
    }

    public final void affixToWorld(World world) {
        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
    }
}
