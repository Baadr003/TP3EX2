/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
/**
 *
 * @author DELL
 */
public class LigneCommandeService implements IDao<LigneCommandeProduit> {

    @Override
    public boolean create(LigneCommandeProduit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(LigneCommandeProduit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(LigneCommandeProduit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public LigneCommandeProduit findById(int id) {
        Session session = null;
        LigneCommandeProduit e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (LigneCommandeProduit) session.get(LigneCommandeProduit.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return e;
    }

    @Override
    public List<LigneCommandeProduit> findAll() {
        Session session = null;
        List<LigneCommandeProduit>  lignecommandeservices = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            lignecommandeservices = session.createQuery("from LigneCommandeProduit").list();
            session.getTransaction().commit();
            return lignecommandeservices;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return lignecommandeservices;
    }

    

}