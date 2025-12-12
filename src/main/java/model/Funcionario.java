package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa implements Serializable{
    @Column
    private String usuario;
    @Column
    private String senha;
    @Column
    private char sexo;

    public Funcionario() {
  
    }

    public Funcionario( int id, String nome, String fone1, String fone2, String email, String cep, String logradouro, String bairro, String cidade, String complemento, String dataCadastro, String cpf, String rg,String usuario, String senha, String obs, char status) {
        super(id, nome, fone1, fone2, email, cep, logradouro, bairro, cidade, complemento, dataCadastro, cpf, rg, obs, status);
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    
    @Override
    public String toString() {
        return  "id   = " + super.toString() + 
                "\nnome = " + this.getNome()+
                "\nUsuário = " + this.getUsuario()+
                "\nSenha   = " + this.getSenha()+
                "\nSexo = " + this.sexo;
    }
    
    
    
    
    
    
}
