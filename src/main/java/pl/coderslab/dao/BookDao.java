package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Book entity){
        if(entity.getId() == null){
            this.add(entity);
        }else{
            this.update(entity);
        }
    }

    private void add(Book entity)	{
        entityManager.persist(entity);
    }
    private void update(Book entity){
        entityManager.merge(entity);
    }
    public void deleteBook(Book entity){
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public Book findById(Long id){

        return entityManager.find(Book.class, id);

    }

    public List<Book> getRatingList(double rating){
        Query	queryp	=	entityManager.
                createQuery("SELECT b FROM Book b where b.rating	>=:rating");
        queryp.setParameter("rating",	rating);
        queryp.setMaxResults(5);
        List<Book>	booksp	=	queryp.getResultList();
        return booksp;
    }

    public List<Book> findAll(){
        Query query = entityManager.createQuery("Select b from Book b");
        return query.getResultList();
    }
}
