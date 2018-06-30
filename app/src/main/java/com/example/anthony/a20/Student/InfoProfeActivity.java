package com.example.anthony.a20.Student;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.anthony.a20.Adapters.CourseAdapter;
import com.example.anthony.a20.BusinessLogic.CursoGradoRepo;
import com.example.anthony.a20.BusinessLogic.ICursoGradoRepo;
import com.example.anthony.a20.BusinessLogic.IProfeRepo;
import com.example.anthony.a20.BusinessLogic.ProfeRepo;
import com.example.anthony.a20.Entities.Cursogrado;
import com.example.anthony.a20.Entities.Profesor;
import com.example.anthony.a20.R;

import java.util.ArrayList;

public class InfoProfeActivity extends AppCompatActivity {

    TextView nombres;
    TextView descripcion;
    TextView experiencia;
    TextView cursos;
    TextView zonas;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
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
        zonas       = findViewById(R.id.item_profe_zonas);
        recyclerView = (RecyclerView) findViewById(R.id.item_profe_cursos);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        ICursoGradoRepo repo = new CursoGradoRepo();
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("idProfesorInfo");
        Log.d("ID", String.valueOf(id));
        ArrayList<Cursogrado>list= repo.getCursosDelProfe(id);
        Log.d("list",list.get(0).getGrado());
        CourseAdapter adapter = new CourseAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
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
