package org.skripnal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Post post1 = new Post();
        post1.setTitle("Post 1");

        Post post2 = new Post();
        post2.setTitle("Post 2");



        Comment comment1 = new Comment();
        comment1.setAuthorName("Author 1");
        comment1.setPost(post1);

        Comment comment2 = new Comment();
        comment2.setAuthorName("Author 2");
        comment2.setPost(post1);

        Comment comment3 = new Comment();
        comment3.setAuthorName("Author 3");
        comment3.setPost(post2);

        post1.setComments(Arrays.asList(comment1, comment2));
        post2.setComments(Arrays.asList(comment3));

        session.save(post1);
        session.save(post2);

        session.save(comment1);
        session.save(comment2);
        session.save(comment3);


        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
