package com.rammingspeed.game;

import com.rammingspeed.game.actors.Barrier;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.rammingspeed.game.actors.Player;

public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    ShapeRenderer shapeRenderer;
    Camera camera;
    World world;
    Box2DDebugRenderer debugRenderer;
    Scene scene;

    @Override
    public void create() {
        Box2D.init();
        batch = new SpriteBatch();
        world = new World(new Vector2(0, -98), true);
        debugRenderer = new Box2DDebugRenderer();
        shapeRenderer = new ShapeRenderer();
//        camera = new OrthographicCamera(128f, 100f);
        camera = new OrthographicCamera(228f, 200f);
        scene = new Scene();
        scene.AddActor(new Player(), world);
        scene.AddActor(new Barrier(10, -100, true), world);
        scene.AddActor(new Barrier(10, 100, true), world);
        scene.AddActor(new Barrier(114, 10, false), world);
        scene.AddActor(new Barrier(-114, -10, false), world);
    }

    @Override
    public void render() {
        camera.update();
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.getProjectionMatrix().set(camera.combined);
        batch.begin();
        scene.Render(batch);
        batch.end();
        shapeRenderer.getProjectionMatrix().set(camera.combined);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        scene.Render(shapeRenderer);
        shapeRenderer.end();
        debugRenderer.render(world, camera.combined);
    }

    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
    }
}
