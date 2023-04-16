package Appli_Alexandre_Huynh.demo;

public class Search {
    private String categorie;
    public Search(){
        super();
    }
    public Search(String unNomProd) {
        this.categorie = unNomProd;
    }

    public void setCategorie(String uneCateg) {
        this.categorie = uneCateg;
    }

    public String getCategorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return "Search{" +
                "categorie='" + categorie + '\'' +
                '}';
    }


}
