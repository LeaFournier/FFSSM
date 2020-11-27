/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongeur;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author leabf
 */
public class Main {
    public static void main(String[] args){
        Plongeur plongeur1 = new Plongeur ("n101", "Fournier", "Léa", "16 place Soult", "0624581547",LocalDate.of(2000, Month.MARCH, 24),3,GroupeSanguin.APLUS);
        Plongeur plongeur2 = new Plongeur ("n103", "Fournier", "Ambre", "14 place Soult", "0624581543",LocalDate.of(2004, Month.MARCH, 20),3,GroupeSanguin.AMOINS);
        
        Moniteur moniteur = new Moniteur ("n102", "Millaire", "Théo", "20 place Soult", "0626328951",LocalDate.of(2019, Month.MARCH, 24),4,205,GroupeSanguin.BPLUS);
        
        Club club = new Club (moniteur, "Esteban", "0658946578");
        
        Licence l1 = new Licence (plongeur1, "n101", LocalDate.of(2020, Month.MARCH, 14), 3, club); 
        Licence l2 = new Licence (plongeur2, "n103", LocalDate.of(2019, Month.MARCH, 15), 3, club);
        Licence l3 = new Licence (moniteur, "n102", LocalDate.of(2020, Month.MARCH, 13), 5, club);
        
        Site site = new Site("Calanque de Sormiou", "Découverte des fonds marins");
        
        Plongee plongee1 = new Plongee(site, moniteur, LocalDate.of(2021, Month.MARCH, 22), 10, 1);
        
        plongeur1.listeLicence.add(l1);
        plongeur2.listeLicence.add(l2);
        moniteur.listeLicence.add(l3);
        club.organisePlongee(plongee1);
        club.listePlongees.add(plongee1);
        club.plongeesNonConformes();
        plongee1.mesParticipants.add(plongeur1);
        plongee1.mesParticipants.add(plongeur2);
        
        System.out.println ("La liste des plongeurs est : " + plongee1.mesParticipants);
        
       
       
        
}
}
