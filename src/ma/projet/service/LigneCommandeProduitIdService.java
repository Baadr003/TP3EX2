/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.LigneCommandeProduitId;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author DELL
 */
public class LigneCommandeProduitIdService implements IDao<LigneCommandeProduitId> {

    @Override
    public boolean create(LigneCommandeProduitId o) {
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
    public boolean delete(LigneCommandeProduitId o) {
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
    public boolean update(LigneCommandeProduitId o) {
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
    public LigneCommandeProduitId findById(int id) {
        Session session = null;
        LigneCommandeProduitId e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (LigneCommandeProduitId) session.get(LigneCommandeProduitId.class, id);
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
    public List<LigneCommandeProduitId> findAll() {
        Session session = null;
        List<LigneCommandeProduitId>  lignecommandeproduitIds = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            lignecommandeproduitIds = session.createQuery("from LigneCommandeProduitId").list();
            session.getTransaction().commit();
            return lignecommandeproduitIds;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return lignecommandeproduitIds;
    }
}