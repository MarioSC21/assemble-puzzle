package com.example.exparcial;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.LinkedHashSet;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Random rand;
    private ImageView f1c1,f1c2,f1c3,f1c4,f2c1,f2c2,f2c3,f2c4,f3c1,f3c2,f3c3,f3c4,f4c1,f4c2,f4c3,f4c4,event1;
    private Drawable df1c1,df1c2,df1c3,df1c4,df2c1,df2c2,df2c3,df2c4,df3c1,df3c2,df3c3,df3c4,df4c1,df4c2,df4c3,df4c4,event2;
    private int vista;
    private int vista2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f1c1 = (ImageView) findViewById(R.id.f1c1);
        f1c2 = (ImageView) findViewById(R.id.f1c2);
        f1c3 = (ImageView) findViewById(R.id.f1c3);
        f1c4 = (ImageView) findViewById(R.id.f1c4);
        f2c1 = (ImageView) findViewById(R.id.f2c1);
        f2c2 = (ImageView) findViewById(R.id.f2c2);
        f2c3 = (ImageView) findViewById(R.id.f2c3);
        f2c4 = (ImageView) findViewById(R.id.f2c4);
        f3c1 = (ImageView) findViewById(R.id.f3c1);
        f3c2 = (ImageView) findViewById(R.id.f3c2);
        f3c3 = (ImageView) findViewById(R.id.f3c3);
        f3c4 = (ImageView) findViewById(R.id.f3c4);
        f4c1 = (ImageView) findViewById(R.id.f4c1);
        f4c2 = (ImageView) findViewById(R.id.f4c2);
        f4c3 = (ImageView) findViewById(R.id.f4c3);
        f4c4 = (ImageView) findViewById(R.id.f4c4);



    }
    public void obtnenerDraw(){
        df1c1 = f1c1.getDrawable();
        df1c2 = f1c2.getDrawable();
        df1c3 = f1c3.getDrawable();
        df1c4 = f1c4.getDrawable();

        df2c1 = f2c1.getDrawable();
        df2c2 = f2c2.getDrawable();
        df2c3 = f2c3.getDrawable();
        df2c4 = f2c4.getDrawable();

        df3c1 = f3c1.getDrawable();
        df3c2 = f3c2.getDrawable();
        df3c3 = f3c3.getDrawable();
        df3c4 = f3c4.getDrawable();

        df4c1 = f4c1.getDrawable();
        df4c2 = f4c2.getDrawable();
        df4c3 = f4c3.getDrawable();
        df4c4 = f4c4.getDrawable();
    }

    public void original_click(View v){

        obtnenerDraw();

        ImageView[] arrayImage = new ImageView[]{
                f1c1, f1c2,f1c3,f1c4,f2c1,f2c2,f2c3,f2c4,f3c1,f3c2,f3c3,f3c4,
                f4c1,f4c2,f4c3,f4c4
        };
        Drawable[] arrayDraw = new Drawable[]
                {
                        df1c1, df1c2,df1c3,df1c4,df2c1,df2c2,df2c3,df2c4,df3c1,df3c2,df3c3,df3c4,
                        df4c1,df4c2,df4c3,df4c4
                };
        rand = new Random();

        //LLENANDO SET CON NUMEROS RANDOM QUE NO ESTEN REPETIDOS
        Set<Integer> set = new LinkedHashSet<Integer>();

        while (set.size() < 16) {
            set.add(rand.nextInt(16));
        }

        //CONVIRTIENDO EL SER A UN ARRAY DE OBJETOS
        Object[] objects = set.toArray();

        //CREANDO ARRAYLIS DE LOS NUMEROS ENTEROS
        ArrayList<Integer> i = new ArrayList<>();
        for(Object obj : objects){
           i.add(Integer.parseInt(obj.toString()));
        }

        //ASIGNANDO UN NUMERO ALEATORIO PARA SE DESORDENE EL ROMPECABEZAS

        for(int in = 0; in< arrayDraw.length ; in++){
            arrayImage[in].setImageDrawable(arrayDraw[i.get(in)]);
        }

    }
    //funcion para poder mover
    public void mover(View view, int id , Drawable d, ImageView img){
        if(view.getId() == id){
            if(vista != view.getId() ){
                if(vista == vista2) {
                    vista = view.getId();//0080
                    event1 = (ImageView) findViewById(id);
                    event2 = img.getDrawable();
                }else{
                    vista2 = view.getId();//0080
                    if(vista  != view.getId() & vista2 > 0){
                        img.setImageDrawable(event2);
                        event1.setImageDrawable(d);
                    }
                    event1 = (ImageView) findViewById(id);
                    event2 = img.getDrawable();
                    vista = 0;
                    vista2 = 0;
                }
            }

        }
    }

    public void puzzle_click (View view){

        obtnenerDraw();

        mover(view,R.id.f1c1,df1c1,f1c1);
        mover(view,R.id.f1c2,df1c2,f1c2);
        mover(view,R.id.f1c3,df1c3,f1c3);
        mover(view,R.id.f1c4,df1c4,f1c4);

        mover(view,R.id.f2c1,df2c1,f2c1);
        mover(view,R.id.f2c2,df2c2,f2c2);
        mover(view,R.id.f2c3,df2c3,f2c3);
        mover(view,R.id.f2c4,df2c4,f2c4);

        mover(view,R.id.f3c1,df3c1,f3c1);
        mover(view,R.id.f3c2,df3c2,f3c2);
        mover(view,R.id.f3c3,df3c3,f3c3);
        mover(view,R.id.f3c4,df3c4,f3c4);

        mover(view,R.id.f4c1,df4c1,f4c1);
        mover(view,R.id.f4c2,df4c2,f4c2);
        mover(view,R.id.f4c3,df4c3,f4c3);
        mover(view,R.id.f4c4,df4c4,f4c4);

        if(vista == 0 ){
            Toast.makeText(this,"Reinicio de valores vuelva a seleccionar la casilla uno y despues la casilla dos " + vista + " " + vista2 ,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Casilla uno valor :  "+ vista + " casilla dos valor : " + vista2 ,Toast.LENGTH_SHORT).show();
        }
    }
}
