package app.daazi.aluno.appclientevipdb.api;

import android.content.ContentValues;
import android.content.Context;
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

    SQLiteDatabase db;

    public AppDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criar as tabelas

        try{
            db.execSQL(ClienteDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP, "TB Cliente: "+ClienteDataModel.gerarTabela());

        }catch (SQLException e){

            Log.e(AppUtil.LOG_APP, "Erro TB Cliente: "+e.getMessage());
        }

        try{
            db.execSQL(ClientePFDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP, "TB ClientePF: "+ClientePFDataModel.gerarTabela());

        }catch (SQLException e){

            Log.e(AppUtil.LOG_APP, "Erro TB ClientePF: "+e.getMessage());
        }

        try{
            db.execSQL(ClientePJDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP, "TB ClientePJ: "+ClientePJDataModel.gerarTabela());

        }catch (SQLException e){

            Log.e(AppUtil.LOG_APP, "Erro TB ClientePJ: "+e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualizar o banco de dados e as tabelas

    }

    public boolean insert(String tabela, ContentValues dados){

        return true;
    }

    public boolean delete(String tabela, int id){

        return true;
    }

    public boolean update(String tabela, ContentValues dados){

        return true;
    }

    public List<Cliente> list(){

        List<Cliente> list = new ArrayList<>();

        return list;
    }
}
