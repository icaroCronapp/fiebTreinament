
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
* Classe que representa a tabela VAGA
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"VAGA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Vaga")
public class Vaga implements Serializable {
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
    @Column(name = "name", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String name;


    /**
    * @generated
    */
    @Column(name = "status", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String status;


    /**
    * @generated
    */
    @OneToOne
    @JoinColumn(name="fk_localizacao", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Localizacao localizacao;


    /**
    * Construtor
    * @generated
    */
    public Vaga(){
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
    public Vaga setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém name
    * return name
    * @generated
    */
    public java.lang.String getName() {
        return this.name;
    }

    /**
    * Define name
    * @param name name
    * @generated
    */
    public Vaga setName(java.lang.String name) {
        this.name = name;
        return this;
    }
    /**
    * Obtém status
    * return status
    * @generated
    */
    public java.lang.String getStatus() {
        return this.status;
    }

    /**
    * Define status
    * @param status status
    * @generated
    */
    public Vaga setStatus(java.lang.String status) {
        this.status = status;
        return this;
    }
    /**
    * Obtém localizacao
    * return localizacao
    * @generated
    */
    public Localizacao getLocalizacao() {
        return this.localizacao;
    }

    /**
    * Define localizacao
    * @param localizacao localizacao
    * @generated
    */
    public Vaga setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Vaga object = (Vaga)obj;
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