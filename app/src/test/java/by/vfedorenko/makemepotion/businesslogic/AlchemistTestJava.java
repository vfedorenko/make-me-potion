package by.vfedorenko.makemepotion.businesslogic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import by.vfedorenko.makemepotion.entities.plain.Effect;
import by.vfedorenko.makemepotion.entities.plain.Ingredient;
import by.vfedorenko.makemepotion.entities.plain.Potion;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 06.03.17.
 */
public class AlchemistTestJava {
    private static Effect sameEffect = new Effect("same effect", false);

    private static List<Ingredient> successData = new ArrayList<>();
    private static Potion expectedPotion;

    private Alchemist alchemist = new Alchemist();

    static {
        final Effect eff1 = new Effect("eff1", false);
        final Effect eff2 = new Effect("eff2", false);
        final Effect eff3 = new Effect("eff3", false);
        final Effect eff4 = new Effect("eff4", false);
        final Effect eff5 = new Effect("eff5", false);
        final Effect eff6 = new Effect("eff6", false);
        final Effect eff7 = new Effect("eff7", false);

        List<Effect> effects1 = new ArrayList<>();
        effects1.add(eff1);
        effects1.add(sameEffect);
        effects1.add(eff2);

        List<Effect> effects2 = new ArrayList<>();
        effects2.add(eff3);
        effects2.add(sameEffect);
        effects2.add(eff4);
        List<Effect> effects3 = new ArrayList<>();
        effects3.add(eff5);
        effects3.add(eff6);
        effects3.add(eff7);

        Ingredient ingr1 = new Ingredient("ingr1", effects1, true);
        Ingredient ingr2 = new Ingredient("ingr2", effects2, true);
        Ingredient ingr3 = new Ingredient("ingr3", effects3, true);

        successData.add(ingr1);
        successData.add(ingr2);
        successData.add(ingr3);

        expectedPotion = new Potion();
        expectedPotion.getEffects().add(eff2);
        expectedPotion.getIngredients().add(ingr1);
        expectedPotion.getIngredients().add(ingr2);
    }

    @Test
    public void successPotion() {
        Potion testPotion = alchemist.beginExperiment(successData);

        assertNotNull(testPotion);

        assertTrue(testPotion.getEffects().size() == expectedPotion.getEffects().size());
        assertTrue(testPotion.getEffects().get(0).equals(sameEffect));
        assertTrue(testPotion.getIngredients().size() == expectedPotion.getEffects().size());
    }
}
