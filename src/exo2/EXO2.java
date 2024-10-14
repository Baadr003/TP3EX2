/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.LigneCommandeProduitId;
import ma.projet.classes.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeService;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class EXO2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
       CategorieService categorieService = new CategorieService();
        ProduitService produitService = new ProduitService();
        CommandeService commandeService = new CommandeService();
        LigneCommandeService ligneCommandeService = new LigneCommandeService();
        
        
         // Création et sauvegarde des catégories
        Categorie cat1 = new Categorie("CAT1", "Ordinateurs");
        Categorie cat2 = new Categorie("CAT2", "Imprimantes");
        categorieService.create(cat1);
        categorieService.create(cat2);
        
        // Création et sauvegarde des produits
        Produit prod1 = new Produit("PROD1", 1000, cat1);
        Produit prod2 = new Produit("PROD2", 500, cat1);
        Produit prod3 = new Produit("PROD3", 200, cat2);
        produitService.create(prod1);
        produitService.create(prod2);
        produitService.create(prod3);
        
        //Afficher la liste des produits par catégorie
        System.out.println("Produits dans la catégorie Ordinateurs :");
        List<Produit> produitsCat1 = produitService.findByCategorie(cat1);
        for (Produit produit : produitsCat1) {
            System.out.println(produit.getReference() + " - Prix: " + produit.getPrix());
        }

        System.out.println("\nProduits dans la catégorie Imprimantes :");
        List<Produit> produitsCat2 = produitService.findByCategorie(cat2);
        for (Produit produit : produitsCat2) {
            System.out.println(produit.getReference() + " - Prix: " + produit.getPrix());
        }
        
        //Creation des commandes
        Commande commande1 = new Commande();
        commande1.setDate(new Date());
        commandeService.create(commande1);

        LigneCommandeProduit ligne1 = new LigneCommandeProduit(commande1, prod1, 2);
        ligne1.setPk(new LigneCommandeProduitId(commande1.getId(), prod1.getId()));
        ligneCommandeService.create(ligne1);

        LigneCommandeProduit ligne2 = new LigneCommandeProduit(commande1, prod2, 1);
        ligne2.setPk(new LigneCommandeProduitId(commande1.getId(), prod2.getId()));
        ligneCommandeService.create(ligne2);

        LigneCommandeProduit ligne3 = new LigneCommandeProduit(commande1, prod3, 3);
        ligne3.setPk(new LigneCommandeProduitId(commande1.getId(), prod3.getId()));
        ligneCommandeService.create(ligne3);
        
        // La liste des produits commandés entre deux dates. 
        System.out.println("\nLa liste des produits commandés entre deux dates");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startDate = sdf.parse("2024-10-12 23:45:53");
            Date endDate = sdf.parse("2024-10-20 23:55:26");

            List<Produit> produitsEntreDeuxDates = produitService.findBetweenDates(startDate, endDate);
            
            for (Produit p : produitsEntreDeuxDates) {
                System.out.println("Reference: " + p.getReference()
                        + ", Prix: " + p.getPrix());
            }
      
// Test getProduitsCommande
            System.out.println("\nLes produits commandés dans une commande donnée");
        List<Produit> produitsCommande = commandeService.getProduitsCommande(commande1.getId());
        System.out.println("Produits de la commande " + commande1.getId() + ":"+
                "            Date :" + new SimpleDateFormat("dd/MM/yyyy").format(commande1.getDate()));
        for (Produit pc : produitsCommande) {
            System.out.println(" - " + pc.getReference()+"      Prix : " +pc.getPrix()+"          Quantité : "+pc.getPrix());
        }
        
        //La liste des produits dont le prix est supérieur à 100 DH 
        System.out.println("\nLa liste des produits dont le prix est supérieur à 100 DH");
        float prixMin = 100;
        List<Produit> produitsCher = produitService.getProduitsPrixSuperieur(prixMin);
        System.out.println("Produits avec un prix supérieur à " + prixMin + " DH:");
        for (Produit p : produitsCher) {
            System.out.println(" - " + p.getReference() + " : " + p.getPrix() + " DH");
        }
    
    }
}
    
    
    
