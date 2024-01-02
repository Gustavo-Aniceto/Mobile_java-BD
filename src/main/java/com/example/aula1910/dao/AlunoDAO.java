package com.example.aula1910.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.aula1910.model.Aluno;
import com.example.aula1910.util.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private ConnectionFactory conexao;
    private SQLiteDatabase banco;

    public AlunoDAO(Context context) {
        //Conexao com o banco de dados
        conexao = new ConnectionFactory(context);
        banco = conexao.getWritableDatabase();
    }

    // método inserir
    public long insert(Aluno aluno) {
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("cpf", aluno.getCpf());
        values.put("telefone", aluno.getTelefone());
        return (banco.insert("aluno", null, values));
    }

    public List<Aluno> obterTodos() {
        List<Aluno> alunos = new ArrayList<>();
        Cursor cursor = banco.query("aluno", new String[]{"id", "nome", "cpf",
                        "telefone"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            Aluno a = new Aluno();
            a.setId(cursor.getInt(0));
            a.setNome((cursor.getString(1)));
            a.setCpf((cursor.getString(2)));
            a.setTelefone((cursor.getString(3)));
            alunos.add(a);
        }
        return alunos;
    }


    public void update(Aluno a) {
    }

    public Aluno read(int parseInt) {
        return null;
    }

    public void delete(Aluno a) {
    }
}
