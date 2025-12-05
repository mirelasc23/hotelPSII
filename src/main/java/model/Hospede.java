package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hospede extends Pessoa{
    @Column
    private String razaoSocial;
    @Column
    private String cnpj;
    @Column
    private String inscricaoEstdual;
    @Column
    private String contato;
    @Column
    private char sexo;

    public Hospede() {
    }

    public Hospede( int id, String nome, String fone1, String fone2, String email, String cep, String logradouro, String bairro, String cidade, String complemento, String dataCadastro, String cpf, String rg, String razaoSocial, String cnpj, String inscricaoEstdual, String contato, String obs, char status) {
        super(id, nome, fone1, fone2, email, cep, logradouro, bairro, cidade, complemento, dataCadastro, cpf, rg, obs, status);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscricaoEstdual = inscricaoEstdual;
        this.contato = contato;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstdual() {
        return inscricaoEstdual;
    }

    public void setInscricaoEstdual(String inscricaoEstdual) {
        this.inscricaoEstdual = inscricaoEstdual;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    
    @Override
    public String toString() {
        return  super.toString() + 
                "\nCnpj   = " + this.getCnpj()+
                "\nInscricaoEstadual   = " + this.getInscricaoEstdual()+
                "\nCep    = " + this.getCep()+
                "\nCidade = " + this.getCidade()+
                "\nBairro = " + this.getBairro()+
                "\nLogradouro = " + this.getLogradouro()+
                "\nComplemento= " + this.getComplemento()+
                "\nContato    = " + this.getContato()+
                "\nStatus = " + this.getStatus();
    }
    
    
    
    
    
}
