package models;

import java.util.UUID;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import io.ebean.Model;

@MappedSuperclass
public abstract class BaseModel extends Model {
    @Id
    public UUID id;

    public BaseModel(){
        id=UUID.randomUUID();
    }
    public abstract UUID getId();
}
