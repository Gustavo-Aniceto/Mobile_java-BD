package com.example.aula1910;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula1910.dao.AlunoDAO;
import com.example.aula1910.model.Aluno;

public class manutencao extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtCpf;
    private EditText edtTelefone;
    private EditText edtId;
    private AlunoDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manutencao);

        edtNome = findViewById(R.id.edtNome);
        edtCpf = findViewById(R.id.edtCpf);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtId = findViewById(R.id.edtId);
    }

    public void alterar(View v){
        Aluno a = new Aluno();
        a.setId(Integer.parseInt(edtId.getText().toString()));
        a.setNome(edtNome.getText().toString());
        a.setCpf(edtCpf.getText().toString());
        a.setTelefone(edtTelefone.getText().toString());
        dao = new AlunoDAO(this);
        dao.update(a);
        Toast.makeText(getApplicationContext(), "Aluno alterado! ",
                Toast.LENGTH_LONG).show();
    }
    public void consultar(View v){
        dao = new AlunoDAO(this);
        Aluno a = dao.read(Integer.parseInt(edtId.getText().toString()));
        edtNome.setText(a.getNome());
        edtCpf.setText(a.getCpf());
        edtTelefone.setText(a.getTelefone());
    }

    public void excluir(View v){
        Aluno a = new Aluno();
        a.setId(Integer.parseInt(edtId.getText().toString()));
        dao = new AlunoDAO(this);
        dao.delete(a);
        Toast.makeText(getApplicationContext(), "Aluno Excluido! "
                , Toast.LENGTH_LONG).show();
    }
    public void voltar(View v){
        finish();
    }

}