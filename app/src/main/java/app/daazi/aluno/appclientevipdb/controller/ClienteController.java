package app.daazi.aluno.appclientevipdb.controller;

import app.daazi.aluno.appclientevipdb.model.Cliente;

public class ClienteController {

    public static boolean validarDadosDoCliente(Cliente cliente, String email, String senha) {

        boolean retorno = ((cliente.getEmail().equals(email)) && (cliente.getSenha().equals(senha)));

        return retorno;
    }

    public static Cliente getClienteFake() {

        Cliente fake = new Cliente();
        fake.setPrimeiroNome("Alexandre");
        fake.setSobreNome("Augusto");
        fake.setEmail("alexandresfcpg@yahoo.com.br");
        fake.setSenha("12345");
        fake.setPessoaFisica(true);

        return fake;
    }
}
