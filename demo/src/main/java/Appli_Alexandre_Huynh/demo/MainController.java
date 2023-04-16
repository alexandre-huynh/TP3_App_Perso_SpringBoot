package Appli_Alexandre_Huynh.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static List<Produit> liste_produits = new ArrayList<Produit>();

    static {
        liste_produits.add(new Produit(0, "Kinder Bueno", "Snack", 0.50));
        liste_produits.add(new Produit(1, "Kit Kat", "Snack", 0.80));
        liste_produits.add(new Produit(2, "Cristalline Fraise", "Boisson", 0.90));
        liste_produits.add(new Produit(3, "Madeleines", "Snack", 1.50));
        liste_produits.add(new Produit(4, "Coca-cola", "Boisson", 1.10));
        liste_produits.add(new Produit(5, "Chips", "Snack", 0.35));


    }

    // Inject via application.properties
    @Value("${welcome:message}")
    private String message;

    @Value("${error:message}")
    private String errorMessage;

    // en gros quand on tape / ou /index dans l'URL, renvoie vers la page index
    // ne reconnait pas le reste
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "issues/index";
    }

    // si url /personlist affiche la liste des personnes mais c'est logique
    @RequestMapping(value = { "/produitList" }, method = RequestMethod.GET)
    public String produitList(Model model) {
        Search search = new Search();

        model.addAttribute("liste_produits", liste_produits);
        model.addAttribute("search", search); // doit avoir le même nom que sur le formulaire html personlist.html
        return "issues/produitList";
    }

    // ============== MON CODE POUR SEARCH =========================
    @RequestMapping(value = { "/searchProduit" }, method = RequestMethod.POST)
    public String searchProduit(Model model, @ModelAttribute("produitForm") Search search) {

        // on cherche via firstname
        String categorie = search.getCategorie();

        // nouvelle liste avec les personnes matchant ce nom
        List<Produit> categories_match = new ArrayList<Produit>();

        // alternative si prénom est un identifiant, donc unique = il y en qu'1 seul
        //Person persons_match = null;

        // si firstname searché n'est pas vide
        if (categorie != null && categorie.length() > 0) {
            // on parcours la liste des personnes existantes
            for (int i = 0; i < liste_produits.size(); i++) {

                // si on trouve une personne avec même firstName, retourner
                if ( liste_produits.get(i).getCategorie().equals(categorie) ){

                    // on rajoute à la liste des personnes qui matchent le firstname
                    categories_match.add(liste_produits.get(i));

                    // alternative si on veut retourner qu'un seul identifiant
                    //persons_match = persons.get(i);

                } // fin condition if

            } // fin parcours liste personnes

            model.addAttribute("liste_produits", categories_match);
            model.addAttribute("search", search);
            return "issues/produitList";

        } // fin boucle

        model.addAttribute("errorMessage", errorMessage);
        return "issues/produitList";
    }
    // ===================================================
    /*
    @RequestMapping(value = { "/addProduit" }, method = RequestMethod.GET)
    public String showAddProduitPage(Model model) {

        Produit produit = new Produit(); //
        model.addAttribute("produitForm", produit); //

        return "issues/addProduit";
    }

    @RequestMapping(value = { "/addProduit" }, method = RequestMethod.POST)
    public String saveProduit(Model model, @ModelAttribute("produitForm") Produit produit) {

        int idProduit = produit.getIdProduit();
        String nomProduit = produit.getNomProduit();
        String categorie = produit.getCategorie();
        double prix = produit.getPrix();

        if (nomProduit != null && nomProduit.length() > 0) {
            Produit newProduit = new Produit(idProduit,nomProduit,categorie,prix);
            liste_produits.add(newProduit);

            return "redirect:/produitList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "issues/addProduit";
    }
    
     */

    // TEMPORAIRE TEST =============================
}
