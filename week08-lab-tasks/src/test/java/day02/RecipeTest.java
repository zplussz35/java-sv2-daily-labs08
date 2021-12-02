package day02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {


    @Test
    void testCreateByName(){
        Recipe r = new Recipe("Almáspite");
        assertEquals("Almáspite",r.getName());
        assertNull(r.getDescription());
        assertEquals(0,r.getIngredients().size());
    }

    @Test
    void testCreateByNameAndDescription(){
        Recipe r = new Recipe("Almáspite","Nagyon finom!");
        assertEquals("Almáspite",r.getName());
        assertEquals("Nagyon finom!",r.getDescription());
        assertEquals(0,r.getIngredients().size());
    }

    @Test
    void testAddOneIngredient() {
        Recipe r = new Recipe("Almáspite","Nagyon finom!");
        r.addIngredient("alma");
        assertEquals(1,r.getIngredients().size());


    }

    @Test
    void testAddMoreIngredient() {
        Recipe r = new Recipe("Almáspite","Nagyon finom!");
        r.addIngredient("alma","liszt","tojás");
        assertEquals(3,r.getIngredients().size());
    }

}