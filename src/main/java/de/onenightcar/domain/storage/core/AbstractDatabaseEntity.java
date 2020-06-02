package de.onenightcar.domain.storage.core;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/** Represents a PersonAddress
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */


@MappedSuperclass
@Inheritance( strategy	= InheritanceType.TABLE_PER_CLASS )
public abstract class AbstractDatabaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version
    protected Long version;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date created;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date modified;


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
