/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
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
public class MoniteurTest {
    
    public MoniteurTest() {
    }
    Moniteur moniteur;
    Club club;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        moniteur = new Moniteur ("n102", "Millaire", "Théo", "20 place Soult", "0626328951",LocalDate.of(2019, Month.MARCH, 24),4,205,GroupeSanguin.BPLUS);
        
        club = new Club (moniteur, "Esteban", "0658946578");
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of employeurActuel method, of class Moniteur.
     */
    @Test
    public void testEmployeurActuel() throws Exception {
       moniteur.nouvelleEmbauche(club, LocalDate.now());
        assertEquals(club, moniteur.employeurActuel().get(), "L'employeur n'est pas le même");
    }

    /**
     * Test of nouvelleEmbauche method, of class Moniteur.
     */
    @Test
    public void testNouvelleEmbauche() {
        //Le moniteur1 n'a pas d'emplois
        assertTrue(moniteur.mesemplois.isEmpty());
        //On lui en ajoute un
        moniteur.nouvelleEmbauche(club, LocalDate.now());
        //Il est embauché
        assertTrue(!moniteur.mesemplois.isEmpty());
    }

    /**
     * Test of emplois method, of class Moniteur.
     */
    @Test
    public void testEmplois() {
        
    }
    
}
