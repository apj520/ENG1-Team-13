package com.ayman.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Bullet extends GameObject {

    private float timeLimit;
    private float timer;

    public Sprite bulletSprite;
    public Rectangle rectBullet;

    //aymans code:
    public boolean bulletHit;
    private boolean remove;

    public Bullet(float x, float y, float radians) {

        bulletSprite = textureAtlas.createSprite("bullet");

        rectBullet = bulletSprite.getBoundingRectangle();

        width = height = 18;
        this.x = x;
        this.y = y;
        this.radians = radians;

        //set bullet speed
        float speed = 350;
        dx = MathUtils.cos(radians)*speed;
        dy = MathUtils.sin(radians)*speed;

        timer = 0;
        timeLimit = 2;

        bulletHit = false;
    }

    public boolean shouldRemove() {return (remove);}


    public void update(float dt){
        x += dx * dt;
        y += dy * dt;

        bulletSprite.setX(x);
        bulletSprite.setY(y);

        rectBullet.x = x;
        rectBullet.y = y;

        timer += dt;
        if (timer > timeLimit) {
            remove = true;
        }
    }

    //public void draw(ShapeRenderer sr)
}
