package com.example.lucas.leilaogibis.view.helper;

import android.widget.EditText;

import com.example.lucas.leilaogibis.MainActivity;
import com.example.lucas.leilaogibis.R;
import com.example.lucas.leilaogibis.modelo.entidade.Gibi;

/**
 * Created by lucas on 23/12/14.
 */
public class CadastroGibiHelper {

    private EditText edNome;
    private Gibi gibi;

    public CadastroGibiHelper(MainActivity activity){

        edNome = (EditText) activity.findViewById(R.id.edNomeGibi);

        gibi = new Gibi();


    }



    public Gibi getGibi() {
        return gibi;
    }

    public void setGibi(Gibi gibi) {

        edNome.setText(gibi.getNome());


        this.gibi = gibi;
    }

    public EditText getEdNome() {

        gibi.setNome(edNome.getText().toString());

        return edNome;
    }

    public void setEdNome(EditText edNome) {
        this.edNome = edNome;
    }






}
