package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Author entity){
        if(entity.getId() == null){
            this.add(entity);
        }else{
            this.update(entity);
        }
    }

    private void add(Author entity)	{
        entityManager.persist(entity);
    }
    private void update(Author entity){
        entityManager.merge(entity);
    }
    public void delete(Author entity){
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public Author findById(Long id){

        return entityManager.find(Author.class, id);

    }

    public List<Author> findAll(){
        Query query = entityManager.createQuery("select a From Author a");
        return query.getResultList();
    }
}
