package com.nika.GerenciamentoDeFornecedores.model;

import jakarta.persistence.*;

@Entity(name = "Fornecedor")
@Table(name = "tb_fornecedor")
public class FornecedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NomeFantasiaFornecedor")
    private String nomeFantasia;

    @Column(name = "CnpjFornecedor")
    private String cnpj;

    @Column(name = "ContatoFornecedor")
    private String contato;

    @Enumerated
    @Column(name = "StatusFornecedor")
    private  FornecedorEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public FornecedorEnum getStatus() {
        return status;
    }

    public void setStatus(FornecedorEnum status) {
        this.status = status;
    }
}
