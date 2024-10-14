/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author DELL
 */
@Entity
public class LigneCommandeProduit{
      @EmbeddedId
    private LigneCommandeProduitId pk;
    
    @ManyToOne
     @JoinColumn(name = "commandeId", insertable = false, updatable = false)
    private Commande commande;
    
    @ManyToOne
     @JoinColumn(name = "produitId", insertable = false, updatable = false)
    private Produit produit;
    
    private int quantite;

    public LigneCommandeProduit( Commande commande, Produit produit, int quantite) {
       
        this.commande = commande;
        this.produit = produit;
        this.quantite = quantite;
    }

    public LigneCommandeProduit() {}


    public LigneCommandeProduitId getPk() {
        return pk;
    }

    public void setPk(LigneCommandeProduitId pk) {
        this.pk = pk;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
        
    }
    
    
}