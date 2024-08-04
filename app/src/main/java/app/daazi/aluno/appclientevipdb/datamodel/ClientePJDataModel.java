package app.daazi.aluno.appclientevipdb.datamodel;

// MOR - Modelo Objeto Relacional
// Transforma classes em tabelas e objetos em registros.

public class ClientePJDataModel {

    /**
     *     private int fk;
     *     private String cnpj;
     *     private String razaoSocial;
     *     private String dataAbertura;
     *     private boolean simplesNacional;
     *     private boolean mei;
     */

    private static final String TABELA = "clientePJ";
    private static final String ID = "id";
    private static final String FK = "clientePFID";
    private static final String CNPJ = "cnpj";
    private static final String RAZAO_SOCIAL = "razaoSocial";
    private static final String DATA_ABERTURA = "dataAbertura";
    private static final String SIMPLES_NACIONAL = "simplesNacional";
    private static final String MEI = "mei";
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
        query += FK+" INTEGER, ";
        query += CNPJ+" TEXT, ";
        query += RAZAO_SOCIAL+" TEXT, ";
        query += DATA_ABERTURA+" TEXT, ";
        query += DATA_ABERTURA+" TEXT, ";
        query += SIMPLES_NACIONAL+" INTEGER, ";
        query += MEI+" INTEGER, ";
        query += DATA_INC+" TEXT, ";
        query += DATA_ALT+" TEXT, ";
        query += "FOREIGN KEY("+FK+") REFERENCES clientePF(id) ";
        query += " )";

        return query;
    }

}
