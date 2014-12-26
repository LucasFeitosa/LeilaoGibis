package com.example.lucas.leilaogibis;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lucas.leilaogibis.modelo.dao.GibiDAO;
import com.example.lucas.leilaogibis.modelo.dao.UsuarioDAO;
import com.example.lucas.leilaogibis.modelo.entidade.Gibi;
import com.example.lucas.leilaogibis.modelo.entidade.Usuario;
import com.example.lucas.leilaogibis.view.helper.CadastroUsuarioHelper;

/**
 * Created by lucas on 23/12/14.
 */
public class CadastroActivity extends ActionBarActivity {

    private Button salvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_usuario);

        salvar = (Button) findViewById(R.id.btnSalvarUser);


        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CadastroUsuarioHelper helper = new CadastroUsuarioHelper(CadastroActivity.this);

                Usuario user = helper.getUsuario();

                Log.i("Usuario: ", user.getNome());

                UsuarioDAO dao = new UsuarioDAO(CadastroActivity.this);


                dao.cadastrarUsuario(user);

                Toast.makeText(CadastroActivity.this, "Usuario cadastrado", Toast.LENGTH_LONG).show();

                finish();


            }
        });




        



    }
}
