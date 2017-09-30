package inacaptemuco.cl.carseguro1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Claudia on 19-09-2017.
 */

public class ActitytyRecibir extends Activity {

    ImageView portal;
    TextView patente;
    TextView marca;
    TextView modelo;
    TextView anio_recibido;
    TextView resultado_uf;
    TextView antiguedad;
    TextView estado_vehiculo;
    TextView valor_seguro;
    ImageView imagenes;
    Calculos calcular = new Calculos();
    String patente_recibida, marca_recibida, modelo_recibido;
    int resultado_anio, uf_recibida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actityty_recibir);


        portal= (ImageView)findViewById(R.id.imagen);
        patente = (TextView) findViewById(R.id.etiqueta_patente);
        marca = (TextView) findViewById(R.id.resultado_marca);
        modelo = (TextView) findViewById(R.id.resultado_modelo);
        anio_recibido = (TextView) findViewById(R.id.resultado_anio);
        resultado_uf = (TextView) findViewById(R.id.resultado_uf);
        antiguedad = (TextView) findViewById(R.id.resultado_antiguedad);
        estado_vehiculo = (TextView) findViewById(R.id.resultado_estado);
        valor_seguro = (TextView) findViewById(R.id.resultado_valorSeguro);
        portal.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.autos));
        imagenes = (ImageView) findViewById(R.id.auto);


        Bundle recibir = this.getIntent().getExtras();
        patente_recibida = recibir.getString("patente");
        marca_recibida = recibir.getString("marca");
        modelo_recibido = recibir.getString("modelo");
        resultado_anio = recibir.getInt("anio");
        uf_recibida = recibir.getInt("valor_uf");

        patente.setText(patente_recibida);
        marca.setText(marca_recibida);
        modelo.setText(modelo_recibido);
        anio_recibido.setText(String.valueOf(resultado_anio));
        resultado_uf.setText(String.valueOf(uf_recibida));
        String antiguedadAuto = calcular.Antiguo(resultado_anio);
        antiguedad.setText(antiguedadAuto);
        String estado_auto = calcular.estado(resultado_anio);
        estado_vehiculo.setText(estado_auto);
        String Seguro_uf = calcular.ValorSeguro(uf_recibida, resultado_anio);
        valor_seguro.setText(Seguro_uf);
        imagen(marca_recibida);


    }

    public void imagen(String marca) {

        if (marca.equals("Kia")) {
            imagenes.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.kia));

        }else if (marca.equals("Ferrari")) {
            imagenes.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ferrari));
        } else if (marca.equals("Mercedes-Benz")) {
            imagenes.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.mercedes));
        } else if (marca.equals("BMW")) {
        } else if (marca.equals("Peugeot")) {
                imagenes.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.peugeot));
            }else if (marca.equals("Chevrolet")) {
            imagenes.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.chevrolet));
        } else if (marca.equals("Ford")) {
            imagenes.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ford));

        } else if (marca.equals("Nissan")) {
            imagenes.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.nissan));
        } else if (marca.equals("Toyota")) {
            imagenes.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.toyota));
        } else if (marca.equals("Honda")) {
            imagenes.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.honda));


        }
        }
    }