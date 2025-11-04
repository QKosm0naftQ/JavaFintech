package com.example;
import com.example.entities.CategoryEntity;
import com.example.utils.HibernateHelper;
/**
 * Hello world!
 *
 */
public class App 
{
public static void main(String[] args) {
        //System.out.println( "Привіт козаки!");

        //SimpleInsert();
        //SimpleInsertFactory();  
        /* 
        var session = HibernateHelper.getSession();
        try {
            var result = session.createSelectionQuery("from CategoryEntity", CategoryEntity.class)
                    .getResultList();
            result.forEach(System.out::println);
        }catch (Exception e) {
            System.out.println("Хюсто у нас проблеми "+e);
        }
        */
        // ------------------------------------------------------ CRUD
        // Create
        createCategory("Борщ");
        
        // Read
        readAllCategories();
        
        // Update
        updateCategory(1, "Вареники");
        
        // Delete
        deleteCategory(2);


    }
    private static void createCategory(String name) {
        var sessionFactory = HibernateHelper.getSessionFactory();
        sessionFactory.inTransaction(session -> {
            session.persist(new CategoryEntity(name));
        });
    }
    private static void readAllCategories() {
        var session = HibernateHelper.getSession();
        try {
            var categories = session.createSelectionQuery("from CategoryEntity", CategoryEntity.class)
                    .getResultList();
            System.out.println("All categories:");
            categories.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error reading categories: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    private static CategoryEntity readCategory(int id) {
        var session = HibernateHelper.getSession();
        try {
            return session.get(CategoryEntity.class, id);
        } finally {
            session.close();
        }
    }

    private static void updateCategory(int id, String newName) {
        var sessionFactory = HibernateHelper.getSessionFactory();
        sessionFactory.inTransaction(session -> {
            CategoryEntity category = session.get(CategoryEntity.class, id);
            if (category != null) {
                category.setName(newName);
                session.merge(category);
            }
        });
    }

    private static void deleteCategory(int id) {
        var sessionFactory = HibernateHelper.getSessionFactory();
        sessionFactory.inTransaction(session -> {
            CategoryEntity category = session.get(CategoryEntity.class, id);
            if (category != null) {
                session.remove(category);
            }
        });
    }








    private static void SimpleInsert() {
        var session = HibernateHelper.getSession();
        try {
            session.beginTransaction();
            CategoryEntity [] list = new CategoryEntity[2];
            list[0] = new CategoryEntity();
            list[0].setName("Калабуджа");
            //session.save(category);
            session.persist(list[0]);

            list[1] = new CategoryEntity();
            list[1].setName("Пельмені");
            session.persist(list[1]);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println("У нас проблеми Хюстон :("+e);
        }
        finally {
            session.close();
        }
    }

    private static void SimpleInsertFactory() {
        var sessionFactory = HibernateHelper.getSessionFactory();
        sessionFactory.inTransaction(session -> {
            session.persist(new CategoryEntity("Кабачок"));
            session.persist(new CategoryEntity("Диня"));
        });
        sessionFactory.close();
    }
}




/*
jdbc:postgresql://ep-holy-recipe-agjxg8ct-pooler.c-2.eu-central-1.aws.neon.tech/neondb?
user=neondb_owner
&
password=npg_3kTh9geRfvjL
&
sslmode=require
&
channelBinding=require
 */