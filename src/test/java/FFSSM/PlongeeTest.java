/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
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
public class PlongeeTest {
    
    public PlongeeTest() {
    }
    Moniteur moniteur;
    Club club;
    Plongeur plongeur1;
    Plongeur plongeur2;
    Site site;
    Plongee plongee1;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        site = new Site("Calanque de Sormiou", "Découverte des fonds marins");
        
        plongee1 = new Plongee(site, moniteur, LocalDate.of(2021, Month.MARCH, 22), 10, 1);
        
         plongeur1 = new Plongeur ("n101", "Fournier", "Léa", "16 place Soult", "0624581547",LocalDate.of(2000, Month.MARCH, 24),3,GroupeSanguin.APLUS);
         plongeur2 = new Plongeur ("n103", "Fournier", "Ambre", "14 place Soult", "0624581543",LocalDate.of(2004, Month.MARCH, 20),3,GroupeSanguin.AMOINS);
    
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of ajouteParticipant method, of class Plongee.
     */
    @Test
    public void testAjouteParticipant() {
    
        //Le club ne possède pas de plongée dans sa liste
        assertTrue(club.listePlongees.isEmpty());
        //On ajoute une plongée
        club.organisePlongee(plongee1);
        //La liste des plongées ne doit plus être vide
        assertFalse(club.listePlongees.isEmpty());
    }

    /**
     * Test of estConforme method, of class Plongee.
     */
    @Test
    public void testEstConforme() {
        club.organisePlongee(plongee1);
        //La liste des plongées ne doit plus être vide
        assertFalse(club.listePlongees.isEmpty());
        //Le plongeur 1 a une licence valide
        plongeur1.ajouteLicence("0", LocalDate.now(), club);
        //Le plongeur 2 a une licence non valide
        plongeur2.ajouteLicence("0", LocalDate.of(2019, Month.MARCH, 25), club);

        //Il n'y a pas de plongeurs dans la plongée
        assertTrue(plongee1.mesParticipants.isEmpty());

        //On ajoute le Plongeur1 (valide) à la plongée
        plongee1.ajouteParticipant(plongeur1);

        //La plongée n'est plus vide
        assertTrue(!plongee1.mesParticipants.isEmpty());
        //Les plongeurs ont une licence valide
        assertTrue(plongee1.estConforme());

        //On ajoute le Plongeur2 (invalide) à la plongée
        plongee1.ajouteParticipant(plongeur2);
        //// plongee1 n'est plus conforme 
        assertFalse(plongee1.estConforme()); 
      
        
    }
    
}
