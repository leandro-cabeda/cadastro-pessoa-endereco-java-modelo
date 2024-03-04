/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.pessoas.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_endereco", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "estado", length = 2, nullable = false)
    @NotNull(message = "O estado não pode ser nulo")
    @Length(max = 2, message = "O estado não pode ter mais que {max} caracteres")
    private String estado;

    @Column(name = "logradouro", length = 100, nullable = false)
    @NotNull(message = "O logradouro não pode ser nulo")
    @Length(max = 100, message = "O logradouro não pode ter mais que {max} caracteres")
    private String logradouro;

    @Column(name = "numero", nullable = false)
    @NotNull(message = "O numero não pode ser nulo")
    private Integer numero;

    @Column(name = "cep", length = 8, nullable = false)
    @NotNull(message = "O cep não pode ser nulo")
    @Length(max = 8, message = "O cep não pode ter mais que {max} caracteres")
    private String cep;

    @Column(name = "cidade", length = 100, nullable = false)
    @NotNull(message = "A cidade não pode ser nulo")
    @Length(max = 100, message = "A cidade não pode ter mais que {max} caracteres")
    private String cidade;

    @NotNull(message = "A pessoa deve ser informado")
    @ManyToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_endereco_pessoa")
    private Pessoa pessoa;

    public Endereco() {

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
