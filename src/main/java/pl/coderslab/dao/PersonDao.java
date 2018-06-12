package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Person entity){
        if(entity.getId() == null){
            this.add(entity);
        }else{
            this.update(entity);
        }
    }

    private void add(Person entity)	{
        entityManager.persist(entity);
    }
    private void update(Person entity){
        entityManager.merge(entity);
    }
    public void deleteBook(Person entity){
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public Person findById(Long id){

        return entityManager.find(Person.class, id);

    }

    public List<Person> allPerson(){
        Query query = entityManager.createQuery("SELECT p FROM Person p");
        List<Person> persons = query.getResultList();
        return persons;
    }

}

