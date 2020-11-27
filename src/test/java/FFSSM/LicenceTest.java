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
public class LicenceTest {
    Plongeur plongeur1;
    Plongeur plongeur2;
    Moniteur moniteur;
    Club club;
    Licence l1;
    Licence l2;
    
    
    public LicenceTest() {
    }
    
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
        
        moniteur = new Moniteur ("n102", "Millaire", "Théo", "20 place Soult", "0626328951",LocalDate.of(2019, Month.MARCH, 24),4,205,GroupeSanguin.BPLUS);
        
        club = new Club (moniteur, "Esteban", "0658946578");
        
        l1 = new Licence (plongeur1, "n101", LocalDate.of(2020, Month.MARCH, 14), 3, club); 
        l2 = new Licence (plongeur2, "n103", LocalDate.of(2019, Month.MARCH, 15), 3, club);
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getPossesseur method, of class Licence.
     */
    @Test
    public void testGetPossesseur() {
        assertEquals(plongeur1, l1.getPossesseur(), "retourne le possesseur");
    }
    
 
    /**
     * Test of getNumero method, of class Licence.
     */
    @Test
    public void testGetNumero() {
        assertEquals("n101", l1.getNumero(), "retourne le numero");
    }

    /**
     * Test of getDelivrance method, of class Licence.
     */
    @Test
    public void testGetDelivrance() {
        assertEquals(LocalDate.of(2020, Month.MARCH, 14), l1.getDelivrance(), "retourne la date de delivrance");
    }

    /**
     * Test of getNiveau method, of class Licence.
     */
    @Test
    public void testGetNiveau() {
         assertEquals(3, l1.getNiveau(), "retourne le niveau");
    }

    /**
     * Test of getClub method, of class Licence.
     */
    @Test
    public void testGetClub() {
       assertEquals(club, l1.getClub(), "retourne le club"); 
    }

    /**
     * Test of estValide method, of class Licence.
     */
    @Test
    public void testEstValide() {
        // on crée une date de délivrance
        LocalDate delivrance1 = LocalDate.of(2020, Month.MARCH, 14);
        LocalDate delivrance2 = LocalDate.of(2019, Month.MARCH, 15);
        //on crée une licence 
        Licence l1 = new Licence (plongeur1, "n101", delivrance1, 3, club); 
        Licence l2 = new Licence (plongeur2, "n103", delivrance2, 3, club);
        //date du jour pour d
        LocalDate d = LocalDate.now();
        
        assertEquals(true, l1.estValide(d), "la licence doit être valide");
        assertEquals(false, l2.estValide(d), "la licence doit être invalide");
       
    }
    
}
