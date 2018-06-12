package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Publisher entity){
        if(entity.getId() == null){
            this.add(entity);
        }else{
            this.update(entity);
        }
    }

    private void add(Publisher entity)	{
        entityManager.persist(entity);
    }
    private void update(Publisher entity){
        entityManager.merge(entity);
    }
    public void delete(Publisher entity){
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public Publisher findById(Long id){

        return entityManager.find(Publisher.class, id);

    }

    public List<Publisher> findAll(){
        Query query = entityManager.createQuery("select p From Publisher p");
        return query.getResultList();
    }
}
