package Appli_Alexandre_Huynh.demo;

public class Produit {

    private int idProduit;

    private String nomProduit;

    private String categorie;

    private double prix;

    /*
    private int nbVentes;

    private int stock;
     */

    public Produit() {

    }

    public Produit(int unId, String unNomProduit, String uneCategorie, double unPrix) {
        this.idProduit = unId;
        this.nomProduit = unNomProduit;
        this.categorie = uneCategorie;
        this.prix = unPrix;
        /*
        this.nbVentes = unNbVentes;
        this.stock = unStock;
         */
    }

    public double getPrix() {
        return prix;
    }

    public int getIdProduit() {
        return idProduit;
    }

    /*
    public int getNbVentes() {
        return nbVentes;
    }

    public int getStock() {
        return stock;
    }

     */

    public String getCategorie() {
        return categorie;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
/*
    public void setNbVentes(int nbVentes) {
        this.nbVentes = nbVentes;
    }
 */
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    /*
    public void setStock(int stock) {
        this.stock = stock;
    }
     */

    @Override
    public String toString() {
        return super.toString();
    }

}
