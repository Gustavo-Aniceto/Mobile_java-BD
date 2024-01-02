package com.example.aula1910;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula1910.dao.AlunoDAO;
import com.example.aula1910.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome,edtCpf,edtTelefone,edtListar,edtId;
    private Button btnSalvar, btnLimpar,btnListar,btnProximaTela;
    private AlunoDAO dao;
    private List<Aluno> alunos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = findViewById(R.id.edtId);
        edtNome = findViewById(R.id.edtNome);
        edtCpf = findViewById(R.id.edtCpf);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtListar = findViewById(R.id.edtListar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnListar = findViewById(R.id.btnListar);
        btnProximaTela = findViewById(R.id.btnProximaTela);
    }
    public void limpar(View v){
        edtId.setText(null);
        edtNome.setText(null);
        edtCpf.setText(null);
        edtTelefone.setText(null);
        edtListar.setText(null);
    }
    public void salvar(View v){
        Aluno aluno = new Aluno();
        aluno.setId(edtId.getText().toString());
        aluno.setNome(edtNome.getText().toString());
        aluno.setCpf(edtCpf.getText().toString());
        aluno.setTelefone(edtTelefone.getText().toString());
        //CRIAR DAO PARA ABRIR O BANCO DE DADOS
        dao = new AlunoDAO(this);
        //SALVAR OS DADOS DOS ALUNOS
        long id = dao.insert(aluno);
        Toast.makeText(getApplicationContext(), "SALVO COM SUCESSO "+id, Toast.LENGTH_LONG).show();
    }
    public void listar(View v){
        //criar lista
        List<Aluno> lista = new ArrayList<Aluno>();
        //criar o DAO e abre o banco de dados
        AlunoDAO dao = new AlunoDAO(this);
        lista = dao.obterTodos();
        for (Aluno aluno : lista) {
            edtListar.append("\nNome : " + aluno.getNome() + "\n");
            edtListar.append("CPF : " + aluno.getCpf() + "\n");
            edtListar.append("Telefone: " + aluno.getTelefone() + "\n===============================");

        }
    }
    public void mudarTela(View v) {
        Intent it = new Intent(this, manutencao.class);
        startActivity(it);
    }
}