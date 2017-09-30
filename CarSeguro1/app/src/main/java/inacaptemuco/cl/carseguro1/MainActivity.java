package inacaptemuco.cl.carseguro1;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

import inacaptemuco.cl.carseguro1.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView portal;
    EditText patente;
    Spinner marca;
    EditText modelo;
    EditText anio;
    EditText valor_uf;
    Button ingresar;
    String[] seleccionaMarca = new String[]{
            "Seleccionar Marca",
            "Kia", "Ferrari", "Mercedes-Benz",
            "Peugeot", "Chevrolet", "Ford", "Nissan",
            "Toyota", "Honda"};
    Calendar fecha_ingresada =new GregorianCalendar();
    int anio_actual = fecha_ingresada.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        portal = (ImageView) findViewById(R.id.imagen);
        patente = (EditText) findViewById(R.id.patente);
        modelo = (EditText) findViewById(R.id.modelo);
        anio = (EditText) findViewById(R.id.anio);
        valor_uf = (EditText) findViewById(R.id.valor_uf);
        ingresar = (Button) findViewById(R.id.ingresar);
        ingresar.setOnClickListener(this);
        marca = (Spinner) findViewById(R.id.marca);
        portal.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.autos));
        ArrayAdapter<String> lista = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_activated_1, seleccionaMarca);
        marca.setAdapter(lista);


    }

    @Override
    public void onClick(View v) {
        Intent p = new Intent(MainActivity.this, ActitytyRecibir.class);
        String envio_patente, envio_marca, enviar_modelo;
        int envio_anio, envio_uf;

        if (patente.getText().toString().isEmpty()) {
            patente.setError("La patente no fue ingresada");
        } else if (marca.getSelectedItem().toString().equals("Seleccionar Marca")) {
            Toast.makeText(getApplicationContext(), "La marca del vehículo no a sido ingresa", Toast.LENGTH_SHORT).show();
        } else if (modelo.getText().toString().isEmpty()) {
            modelo.setError("No a ingresado el modelo");
        } else if (anio.getText().toString().isEmpty()) {
            anio.setError("Ingrese año vehículo");
        }else if (Integer.parseInt(anio.getText().toString())>anio_actual) {
            Toast.makeText(getApplicationContext(), "Ingreso un año no válido", Toast.LENGTH_SHORT).show();
        } else if (valor_uf.getText().toString().isEmpty()) {
            valor_uf.setError("Ingrese UF por favor");
        } else {

            envio_patente = patente.getText().toString();
            envio_marca = marca.getSelectedItem().toString();
            enviar_modelo = modelo.getText().toString();
            envio_anio = Integer.parseInt(anio.getText().toString());
            envio_uf = Integer.parseInt(valor_uf.getText().toString());

            p.putExtra("patente", envio_patente);
            p.putExtra("marca", envio_marca);
            p.putExtra("modelo", enviar_modelo);
            p.putExtra("anio", envio_anio);
            p.putExtra("valor_uf", envio_uf);
            startActivity(p);


            startActivity(p);
        }
    }
}
