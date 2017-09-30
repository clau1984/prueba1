package inacaptemuco.cl.carseguro1;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;

/**
 * Created by Claudia on 24-09-2017.
 */

public class InicioActivity extends AppCompatActivity {
    ImageView img;
    ImageView portal;
    Button entrar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        portal= (ImageView)findViewById(R.id.imagen);
        img= (ImageView)findViewById(R.id.foto);
        entrar= (Button) findViewById(R.id.acceso);
        portal.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.autos));
        img.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.car));


        entrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent entrar = new Intent(InicioActivity.this, MainActivity.class);

                startActivity(entrar);
            }
        }) ;
        }
}
