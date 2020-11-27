package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Plongeur extends Personne{
    ArrayList <Licence> listeLicence = new ArrayList<Licence>();

    private int niveau;
    
    public Plongeur (String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin gs){
        super(numeroINSEE, nom, prenom,adresse,telephone,naissance,gs);
        this.niveau = niveau;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    public void ajouteLicence(String numero, LocalDate delivrance, Club club){
        Licence l = new Licence (this, numero, delivrance, niveau, club);
        listeLicence.add(l);
        
    }
}
    

