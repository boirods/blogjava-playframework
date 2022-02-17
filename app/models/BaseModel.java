package models;

import java.util.UUID;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import io.ebean.Model;

/**
 * Classe que representa um objeto generico na aplicação.
 * @author rodrigo
 *
 */
@MappedSuperclass
public abstract class BaseModel extends Model {

    @Id
    public UUID id;

    /**
     * Construtor da classe base e que gera um id no formato UUID ao objeto.
     */
    public BaseModel(){
        id=UUID.randomUUID();
    }
    /**
     * Método que recupera o id do objeto gerado.
     * @return
     */
    public abstract UUID getId();
}
