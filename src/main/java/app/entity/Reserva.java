
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
* Classe que representa a tabela RESERVA
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"RESERVA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Reserva")
public class Reserva implements Serializable {
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
    @Column(name = "ativo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean ativo;


    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date data;


    /**
    * @generated
    */
    @Column(name = "periodo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String periodo;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_vaga", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Vaga vaga;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private User user;


    /**
    * Construtor
    * @generated
    */
    public Reserva(){
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
    public Reserva setId(java.lang.String id) {
        this.id = id;
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
    public Reserva setAtivo(java.lang.Boolean ativo) {
        this.ativo = ativo;
        return this;
    }
    /**
    * Obtém data
    * return data
    * @generated
    */
    public java.util.Date getData() {
        return this.data;
    }

    /**
    * Define data
    * @param data data
    * @generated
    */
    public Reserva setData(java.util.Date data) {
        this.data = data;
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
    public Reserva setPeriodo(java.lang.String periodo) {
        this.periodo = periodo;
        return this;
    }
    /**
    * Obtém vaga
    * return vaga
    * @generated
    */
    public Vaga getVaga() {
        return this.vaga;
    }

    /**
    * Define vaga
    * @param vaga vaga
    * @generated
    */
    public Reserva setVaga(Vaga vaga) {
        this.vaga = vaga;
        return this;
    }
    /**
    * Obtém user
    * return user
    * @generated
    */
    public User getUser() {
        return this.user;
    }

    /**
    * Define user
    * @param user user
    * @generated
    */
    public Reserva setUser(User user) {
        this.user = user;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Reserva object = (Reserva)obj;
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