package app.daazi.aluno.appclientevipdb.datamodel;

// MOR - Modelo Objeto Relacional
// Transforma classes em tabelas e objetos em registros.

public class ClienteDataModel {

    /**
     *     private int id;
     *     private String primeiroNome;
     *     private String sobreNome;
     *     private String email;
     *     private String senha;
     *     private boolean pessoaFisica;
     */

    private static final String TABELA = "cliente";
    private static final String ID = "id";
    private static final String PRIMEIRO_NOME = "primeiroNome";
    private static final String SOBRENOME = "sobreNome";
    private static final String EMAIL = "email";
    private static final String SENHA = "senha";
    private static final String PESSOA_FISICA = "pessoaFisica";
    private static final String DATA_INC = "datainc";
    private static final String DATA_ALT = "dataalt";

    private static String query;

    /**
     *                 "CREATE TABLE cliente (\n" +
     *                 "id      INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
     *                 "nome    TEXT, \n" +
     *                 "email   TEXT, \n" +
     *                 "status  INTEGER, \n" +
     *                 "datainc TEXT, \n" +
     *                 "dataalt TEXT \n" +
     *                 ")";
     */

    public static String gerarTabela(){

        query = "CREATE TABLE "+TABELA+" ( ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += PRIMEIRO_NOME+" TEXT, ";
        query += SOBRENOME+" TEXT, ";
        query += EMAIL+" TEXT, ";
        query += SENHA+" TEXT, ";
        query += PESSOA_FISICA+" INTEGER, ";
        query += DATA_INC+" TEXT, ";
        query += DATA_ALT+" TEXT ";
        query += " )";



        return query;
    }

}
