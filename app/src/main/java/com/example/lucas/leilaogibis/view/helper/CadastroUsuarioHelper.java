package com.example.lucas.leilaogibis.view.helper;

import android.widget.EditText;

import com.example.lucas.leilaogibis.CadastroActivity;
import com.example.lucas.leilaogibis.R;
import com.example.lucas.leilaogibis.modelo.entidade.Usuario;

/**
 * Created by lucas on 23/12/14.
 */
public class CadastroUsuarioHelper {

    private EditText edNome, edEmail;
    private Usuario usuario;

    public CadastroUsuarioHelper(CadastroActivity activity){

        edNome = (EditText) activity.findViewById(R.id.edNomeUser);
        edEmail = (EditText) activity.findViewById(R.id.edEmail);
        
        usuario = new Usuario();


    }

    public EditText getEdNome() {
        return edNome;
    }

    public void setEdNome(EditText edNome) {
        this.edNome = edNome;
    }

    public EditText getEdEmail() {
        return edEmail;
    }

    public void setEdEmail(EditText edEmail) {
        this.edEmail = edEmail;
    }

    public Usuario getUsuario() {
        usuario.setNome(edNome.getText().toString());
        usuario.setEmail(edEmail.getText().toString());

        return usuario;
    }

    public void setUsuario(Usuario usuario) {

        edNome.setText(usuario.getNome());
        edEmail.setText(usuario.getEmail());
        
        
        this.usuario = usuario;
    }





}
