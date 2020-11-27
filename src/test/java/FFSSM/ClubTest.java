/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author leabf
 */
public class ClubTest {
    
    public ClubTest() {
    }
    Moniteur moniteur;
    Plongeur plongeur1;
    Plongeur plongeur2;
    Club club;
    Plongee plongee1;
    Plongee plongee2;
    Site site;
    
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        plongeur1 = new Plongeur ("n101", "Fournier", "Léa", "16 place Soult", "0624581547",LocalDate.of(2000, Month.MARCH, 24),3,GroupeSanguin.APLUS);
        plongeur2 = new Plongeur ("n103", "Fournier", "Ambre", "14 place Soult", "0624581543",LocalDate.of(2004, Month.MARCH, 20),3,GroupeSanguin.AMOINS);
        club = new Club (moniteur, "Esteban", "0658946578");
        site = new Site("Calanque de Sormiou", "Découverte des fonds marins");
        
        moniteur = new Moniteur ("n102", "Millaire", "Théo", "20 place Soult", "0626328951",LocalDate.of(2019, Month.MARCH, 24),4,205,GroupeSanguin.BPLUS);
         
        plongee1 = new Plongee(site, moniteur, LocalDate.of(2021, Month.MARCH, 22), 10, 1);
        plongee2 = new Plongee(site, moniteur, LocalDate.of(2020, Month.DECEMBER, 12), 20, 2);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of plongeesNonConformes method, of class Club.
     */
    @Test
    public void testPlongeesNonConformes() {
       
        
        //La licence est valide
        plongeur1.ajouteLicence("n101", LocalDate.now(), club); 
        //La licence n'est pas valide
        plongeur2.ajouteLicence("n103", LocalDate.of(2019,Month.AUGUST ,7), club);  
        
        plongee1.ajouteParticipant(plongeur1);
        plongee2.ajouteParticipant(plongeur2);
        
        //Le club organise les plongées
        club.organisePlongee(plongee1);
        club.organisePlongee(plongee2);
        
        assertTrue(club.plongeesNonConformes().contains(plongee2)&& !club.plongeesNonConformes().contains(plongee1));
         
    }


 
    
}
