
package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;


/**
* Classe que representa a tabela PERIODO
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"PERIODO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Periodo")
public class Periodo implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @Column(name = "periodo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String periodo;


    /**
    * @generated
    */
    @Column(name = "ativo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean ativo;


    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @Column(name = "dataInicial", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date dataInicial;


    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @Column(name = "dataFinal", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date dataFinal;


    /**
    * Construtor
    * @generated
    */
    public Periodo(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Periodo setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém periodo
    * return periodo
    * @generated
    */
    public java.lang.String getPeriodo() {
        return this.periodo;
    }

    /**
    * Define periodo
    * @param periodo periodo
    * @generated
    */
    public Periodo setPeriodo(java.lang.String periodo) {
        this.periodo = periodo;
        return this;
    }
    /**
    * Obtém ativo
    * return ativo
    * @generated
    */
    public java.lang.Boolean getAtivo() {
        return this.ativo;
    }

    /**
    * Define ativo
    * @param ativo ativo
    * @generated
    */
    public Periodo setAtivo(java.lang.Boolean ativo) {
        this.ativo = ativo;
        return this;
    }
    /**
    * Obtém dataInicial
    * return dataInicial
    * @generated
    */
    public java.util.Date getDataInicial() {
        return this.dataInicial;
    }

    /**
    * Define dataInicial
    * @param dataInicial dataInicial
    * @generated
    */
    public Periodo setDataInicial(java.util.Date dataInicial) {
        this.dataInicial = dataInicial;
        return this;
    }
    /**
    * Obtém dataFinal
    * return dataFinal
    * @generated
    */
    public java.util.Date getDataFinal() {
        return this.dataFinal;
    }

    /**
    * Define dataFinal
    * @param dataFinal dataFinal
    * @generated
    */
    public Periodo setDataFinal(java.util.Date dataFinal) {
        this.dataFinal = dataFinal;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Periodo object = (Periodo)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}