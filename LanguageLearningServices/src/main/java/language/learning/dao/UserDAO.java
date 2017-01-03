package language.learning.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import language.learning.exception.EntityNotFoundException;
import language.learning.model.Noun;
import language.learning.model.User;

/**
 * Created by Cristi on 1/3/2017.
 */

@Stateless
public class UserDAO {
    @PersistenceContext
    private EntityManager em;

    public User getUserByEmail(String email) throws EntityNotFoundException {
        try {
            List<User> users = em.createQuery("select u from User u where u.email like :email")
                    .setParameter("email", "%" + email + "%").getResultList();

            if (users == null || users.size() <= 0 || users.size() > 1) {
                throw new EntityNotFoundException("User with email [" + email + "] not found");
            }

            return users.get(0);
        } catch (NoResultException nre) {
            throw new EntityNotFoundException("User with email [" + email + "] not found");
        }
    }
}
