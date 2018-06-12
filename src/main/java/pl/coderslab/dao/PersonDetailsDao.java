package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(PersonDetails entity){
        if(entity.getId() == null){
            this.add(entity);
        }else{
            this.update(entity);
        }
    }

    private void add(PersonDetails entity)	{
        entityManager.persist(entity);
    }
    private void update(PersonDetails entity){
        entityManager.merge(entity);
    }
    public void deleteBook(PersonDetails entity){
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public PersonDetails findById(Long id){

        return entityManager.find(PersonDetails.class, id);

    }

    public List<PersonDetails> allPerson(){
        Query query = entityManager.createQuery("SELECT pd FROM PersonDetails pd");
        List<PersonDetails> persons = query.getResultList();
        return persons;
    }
}

