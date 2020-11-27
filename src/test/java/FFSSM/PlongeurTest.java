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
public class PlongeurTest {
    
    public PlongeurTest() {
    }
    
    Plongeur plongeur1;
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
        plongeur1 = new Plongeur ("n101", "Fournier", "Léa", "16 place Soult", "0624581547",LocalDate.of(2000, Month.MARCH, 24),3,GroupeSanguin.APLUS);
        club = new Club (moniteur, "Esteban", "0658946578");
        moniteur = new Moniteur ("n102", "Millaire", "Théo", "20 place Soult", "0626328951",LocalDate.of(2019, Month.MARCH, 24),4,205,GroupeSanguin.BPLUS);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of ajouteLicence method, of class Plongeur.
     */
    @Test
    public void testAjouteLicence() {
       assertTrue(plongeur1.listeLicence.isEmpty());
        plongeur1.ajouteLicence("n100", LocalDate.now(), club);
        assertFalse(plongeur1.listeLicence.isEmpty()); 
    }
    
}
