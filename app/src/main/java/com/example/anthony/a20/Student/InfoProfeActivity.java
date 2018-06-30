package com.example.anthony.a20.Student;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.anthony.a20.BusinessLogic.IProfeRepo;
import com.example.anthony.a20.BusinessLogic.ProfeRepo;
import com.example.anthony.a20.Entities.Profesor;
import com.example.anthony.a20.R;

public class InfoProfeActivity extends AppCompatActivity {

    TextView nombres;
    TextView descripcion;
    TextView experiencia;
    TextView cursos;
    TextView zonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_profe);
    }
    @Override
    protected void onStart() {
        super.onStart();
        nombres        = findViewById(R.id.item_nombre_apellidos);
        descripcion     = findViewById(R.id.item_profe_descripcion);
        experiencia     = findViewById(R.id.item_profe_exp);
        cursos      = findViewById(R.id.item_profe_cursos);
        zonas       = findViewById(R.id.item_profe_zonas);

        new GetTask().execute();
    }

    public void fillSpinner(Profesor profesor) {

        nombres.setText(String.valueOf(profesor.getNombre()+profesor.getApellido()));
        descripcion.setText(String.valueOf(profesor.getDescripcion()));
        experiencia.setText(String.valueOf(profesor.getExperiencia()));

    }

    class GetTask extends AsyncTask<String,Profesor,Profesor> {

        @Override
        protected Profesor doInBackground(String... strings) {
            Bundle bundle = getIntent().getExtras();
            int id = bundle.getInt("idProfesorInfo");
            IProfeRepo repo = new ProfeRepo();
            Profesor profe= repo.getProfesor2(id);

            return profe;
        }

        @Override
        protected void onPostExecute(Profesor profesor) {
            super.onPostExecute(profesor);
            fillSpinner(profesor);
        }

    }
}
