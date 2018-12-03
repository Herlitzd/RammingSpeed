/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rammingspeed.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.rammingspeed.game.actors.Actor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author devon
 */
public class Scene {

    private final List<Renderable> actors;

    public Scene() {
        this.actors = new ArrayList<Renderable>();
    }
    public void AddActor(Renderable a){
        this.actors.add(a);
    }
    public void AddActor(PhysicsObject a, World world){
        a.affixToWorld(world);
        this.AddActor(a);
    }

    public void Render(SpriteBatch batch) {
        for (Renderable actor : actors) {
            actor.render(batch);
        }
    }

    public void Render(ShapeRenderer shapeRender) {
        for (Renderable actor : actors) {
            actor.render(shapeRender);
        }
    }
}
