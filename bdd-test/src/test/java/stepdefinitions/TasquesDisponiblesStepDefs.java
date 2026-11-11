package stepdefinitions;

import edu.ub.ds2627.anotub.controlador.Controlador;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TasquesDisponiblesStepDefs {
    private final Controlador controlador = new Controlador();
    private List<Map<String, String>> tasquesMostrades;

    @Given("l'usuari {string} està registrat com a anotadora amb expertesa {string}")
    public void usuari_registrat_amb_expertesa(String nomUsuari, String expertesa) {
        try {
            controlador.registrarUsuari(nomUsuari, "Password123", "Nom", "Cognom", "ESP", "123",
                    java.time.LocalDate.now().plusYears(1), "IBAN", "SWIFT", "email@test.com", "123456789",
                    Arrays.asList(expertesa));
        } catch (Exception ignored) {}
    }

    @Given("hi ha una tasca {string} que requereix expertesa {string}")
    public void hi_ha_tasca(String idTasca, String expertesa) {
        try {
            java.lang.reflect.Field field = Controlador.class.getDeclaredField("anotUB");
            field.setAccessible(true);
            edu.ub.ds2627.anotub.model.AnotUB anotUB = (edu.ub.ds2627.anotub.model.AnotUB) field.get(controlador);
            anotUB.afegirTasca(idTasca, "Descripció " + idTasca, Arrays.asList(expertesa));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("l'usuari {string} demana veure les tasques disponibles")
    public void usuari_demana_tasques(String nomUsuari) {
        this.tasquesMostrades = controlador.obtenirTasquesDisponibles(nomUsuari);
    }

    @Then("el sistema li mostra les tasques {string} i {string}")
    public void sistema_mostra_tasques(String tasca1, String tasca2) {
        boolean teT1 = tasquesMostrades.stream().anyMatch(t -> t.get("id").equals(tasca1));
        boolean teT2 = tasquesMostrades.stream().anyMatch(t -> t.get("id").equals(tasca2));
        if (!teT1 || !teT2) {
            throw new AssertionError("No s'han mostrat les tasques esperades");
        }
    }

    @Then("el sistema no li mostra la tasca {string}")
    public void sistema_no_mostra_tasca(String tasca) {
        boolean teTasca = tasquesMostrades.stream().anyMatch(t -> t.get("id").equals(tasca));
        if (teTasca) {
            throw new AssertionError("La tasca " + tasca + " no hauria d'aparèixer");
        }
    }
}
