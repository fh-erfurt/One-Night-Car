package de.onenightcar.util;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/** Abstract Entity to allowed other classes to inherit from
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */


@Entity
@Inheritance( strategy	= InheritanceType.TABLE_PER_CLASS )
public abstract class AbstractDatabaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Version
    protected Long version;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date created;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date modified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

    protected void setCreated (Date date) {
        this.created = date;
    }

    @PrePersist
    void onCreate(){
        this.setCreated( new Date() );
    }

    protected void setModified (Date date) {
        this.modified = date;
    }

    @PreUpdate
    void onUpdate(){
        this.setModified( new Date());
    }

}
