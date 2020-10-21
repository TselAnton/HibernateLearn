package com.tsel.repository;

import com.tsel.hibernate.HibernateSessionFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;

import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public abstract class AbstractCrudRepository<E extends Serializable, I extends Serializable>
        implements CrudRepository<E, I> {

    private Class<E> targetClass;

    public AbstractCrudRepository(Class<E> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public Optional<E> findOne(I id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return of(session.get(targetClass, id));

        } catch (Exception e) {
            return empty();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> findAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return (List<E>) session.createQuery("from " + targetClass.getSimpleName()).list();

        } catch (Exception e) {
            return emptyList();
        }
    }

    @Override
    public boolean save(E entity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.persist(entity);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(E entity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.delete(entity);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public long count() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return (long) session
                    .createQuery("SELECT count(*) from " + targetClass.getSimpleName())
                    .getSingleResult();

        } catch (Exception e) {
            return 0;
        }
    }
}
