package com.example.lucas.leilaogibis;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.lucas.leilaogibis.modelo.dao.GibiDAO;
import com.example.lucas.leilaogibis.modelo.entidade.Gibi;
import com.example.lucas.leilaogibis.view.helper.CadastroGibiHelper;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ListView lvGibi;

    private List<Gibi> listaGibis;
    private ArrayAdapter<Gibi> adapter;
    private int adapterlayout = android.R.layout.simple_list_item_1;

    private final String TAG = "CADASTRO_GIBI";
    private final String GIBI_KEY = "LISTA";

    private Button btnSalvar,  btnCadastroUser;


    @Override
    protected void onResume() {
        super.onResume();

        carregarLista();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvGibi = (ListView) findViewById(R.id.lvGibi);

        registerForContextMenu(lvGibi);





        btnSalvar = (Button) findViewById(R.id.btnSalvarGibi);
        btnCadastroUser = (Button) findViewById(R.id.btnCadastrarUser);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CadastroGibiHelper helper = new CadastroGibiHelper(MainActivity.this);

                Gibi gibi = helper.getGibi();

                Log.i("Gibi: ", gibi.getNome());

                GibiDAO dao = new GibiDAO(MainActivity.this);


                    dao.cadastrarGibi(gibi);


                carregarLista();


            }
        });

        btnCadastroUser.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                intent.setClass(MainActivity.this, CadastroActivity.class);


                startActivity(intent);
            }
        });

    }

    private void carregarLista(){

        GibiDAO dao = new GibiDAO(this);

        this.listaGibis = dao.listar();

        Log.i("GIBI: ", listaGibis.toString());

        this.adapter = new ArrayAdapter<Gibi>(this, adapterlayout, listaGibis);

        this.lvGibi.setAdapter(adapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
