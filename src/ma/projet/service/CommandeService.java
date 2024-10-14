/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.classes.Commande;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
/**
 *
 * @author DELL
 */
public class CommandeService implements IDao<Commande> {

    @Override
    public boolean create(Commande o) {
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
    public boolean delete(Commande o) {
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
    public boolean update(Commande o) {
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
    public Commande findById(int id) {
        Session session = null;
        Commande e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Commande) session.get(Commande.class, id);
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
    public List<Commande> findAll() {
        Session session = null;
        List<Commande>  commandes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            commandes = session.createQuery("from Commande").list();
            session.getTransaction().commit();
            return commandes;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return commandes;
    }
public List<Produit> getProduitsCommandesEntreDates(Date dateDebut, Date dateFin) {
        Session session = null;
        List<Produit>  produits = null;
        try{
         session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         produits = session.createQuery(
            "select distinct p from Produit p " +
            "join p.lignesCommande lc " +
            "join lc.commande c " +
            "where c.date between :dateDebut and :dateFin")
            .setParameter("dateDebut", dateDebut)
            .setParameter("dateFin", dateFin)
            .list();
        return produits;
    } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return produits;
    }

 public List<Produit> getProduitsCommande(int commandeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Produit> produits = session.createQuery(
            "select p from Produit p " +
            "join p.ligneCommandeProduits lc " +
            "where lc.commande.id = :commandeId")
            .setParameter("commandeId", commandeId)
            .list();
        session.close();
        return produits;
    }
}
