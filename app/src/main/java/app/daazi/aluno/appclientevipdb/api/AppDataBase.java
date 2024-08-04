package app.daazi.aluno.appclientevipdb.api;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import app.daazi.aluno.appclientevipdb.datamodel.ClienteDataModel;

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
        String sqlTabelaCliente = "CREATE TABLE cliente (\n" +
                "id      INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "nome    TEXT, \n" +
                "email   TEXT, \n" +
                "status  INTEGER, \n" +
                "datainc TEXT, \n" +
                "dataalt TEXT \n" +
                ")";


        try{

            db.execSQL(ClienteDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP, "TB Cliente: "+ClienteDataModel.gerarTabela());

        }catch (SQLException e){

            Log.e(AppUtil.LOG_APP, "Erro TB Cliente: "+e.getMessage());

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualizar o banco de dados e as tabelas

    }
}
