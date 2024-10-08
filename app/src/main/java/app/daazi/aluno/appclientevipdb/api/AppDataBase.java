package app.daazi.aluno.appclientevipdb.api;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import app.daazi.aluno.appclientevipdb.datamodel.ClienteDataModel;
import app.daazi.aluno.appclientevipdb.datamodel.ClientePFDataModel;
import app.daazi.aluno.appclientevipdb.datamodel.ClientePJDataModel;
import app.daazi.aluno.appclientevipdb.model.Cliente;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "clienteDB.sqlite";
    public static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public AppDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criar as tabelas

        try {
            db.execSQL(ClienteDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP, "TB Cliente: " + ClienteDataModel.gerarTabela());

        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP, "Erro TB Cliente: " + e.getMessage());
        }

        try {
            db.execSQL(ClientePFDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP, "TB ClientePF: " + ClientePFDataModel.gerarTabela());

        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP, "Erro TB ClientePF: " + e.getMessage());
        }

        try {
            db.execSQL(ClientePJDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP, "TB ClientePJ: " + ClientePJDataModel.gerarTabela());

        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP, "Erro TB ClientePJ: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualizar o banco de dados e as tabelas

    }

    public boolean insert(String tabela, ContentValues dados) {

        boolean sucesso = true;

        try {

            Log.i(AppUtil.LOG_APP, tabela + " insert() executado com sucesso.");
            sucesso = db.insert(tabela, null, dados) > 0;

        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP, tabela + " falhou ao executar o insert(): " + e.getMessage());
        }

        return sucesso;
    }

    public boolean delete(String tabela, int id) {

        boolean sucesso = true;

        try {

            Log.i(AppUtil.LOG_APP, tabela + " delete() executado com sucesso.");
            sucesso = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;

        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP, tabela + " falhou ao executar o delete(): " + e.getMessage());
        }

        return sucesso;
    }

    public boolean update(String tabela, ContentValues dados) {

        boolean sucesso = true;

        try {

            int id = dados.getAsInteger("id");

            Log.i(AppUtil.LOG_APP, tabela + " update() executado com sucesso.");
            sucesso = db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)}) > 0;

        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP, tabela + " falhou ao executar o update(): " + e.getMessage());
        }

        return sucesso;

    }

    @SuppressLint("Range")
    public List<Cliente> list(String tabela) {

        List<Cliente> list = new ArrayList<>();

        Cliente cliente;

        String sql = "SELECT * FROM " + tabela;

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {

                    cliente = new Cliente();

                    cliente.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                    cliente.setPrimeiroNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.PRIMEIRO_NOME)));
                    cliente.setSobreNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.SOBRENOME)));
                    cliente.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                    cliente.setSenha(cursor.getString(cursor.getColumnIndex(ClienteDataModel.SENHA)));
                    cliente.setPessoaFisica(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.PESSOA_FISICA)) == 1);

                    list.add(cliente);

                } while (cursor.moveToNext());

                Log.i(AppUtil.LOG_APP, tabela + " lista gerada com sucesso.");
            }

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP, "Erro ao listar os dados: " + tabela);
            Log.e(AppUtil.LOG_APP, "Erro: " + e.getMessage());
        }

        return list;
    }
}
