package com.tinytravel.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by alval on 11/05/2017.
 */
public class Insecto {
    //private Sprite sprite;
    private int x,y;
    private Animation animacion;
    private float tiempo;
    private TextureRegion[] regionMovimiento;
    private Texture imagen;
    private TextureRegion frameActual;

    public Insecto(int x,int y){
        this.x=x;
        this.y=y;
        imagen = new Texture(Gdx.files.internal("tiny-come.png"));
        TextureRegion[][] tmp = TextureRegion.split(imagen,imagen.getWidth()/2,imagen.getHeight());
        regionMovimiento = new TextureRegion[2];
        for(int i = 0;i < 2 ; i++) {
            regionMovimiento[i] = tmp[0][i];
        }
        animacion = new Animation(1/5f,regionMovimiento);
        tiempo = 0f;
        //sprite = new Sprite(new Texture(Gdx.files.internal("insecto.png")),64,64);
    }
    public void setX(int x){
        this.x=x;
    }

    public void setY(int y){
        this.y=y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public void render(final SpriteBatch batch){
        tiempo+= Gdx.graphics.getDeltaTime(); //El tiempo que paso desde el utlimo render()
        frameActual = (TextureRegion)animacion.getKeyFrame(tiempo,true);
        batch.draw(frameActual,x,y);
    }
}