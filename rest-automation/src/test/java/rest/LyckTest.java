package rest;

import controllers.FilmController;
import controllers.PeopleController;
import controllers.PlanetController;
import controllers.ui_model.response.FilmModelResponse;
import controllers.ui_model.response.PeopleModelResponse;
import controllers.ui_model.response.PlanetModelResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static utils.ResponseParser.validateAndParse;

public class LyckTest extends Runner {
    private PeopleController peopleController = new PeopleController();
    private PlanetController planetController = new PlanetController();
    private FilmController filmController = new FilmController();

    @Test(description = "MAXPAY TEST TASK. Validate Lyck starwars history")
    @Description("Description : MAXPAY TEST TASK. Validate Lyck starwars history")
    @Severity(SeverityLevel.CRITICAL)
    public void test() {
        PeopleModelResponse lyck = validateAndParse(peopleController.doGet(1L), PeopleModelResponse.class);
        PlanetModelResponse planet = validateAndParse(planetController.doGet(lyck.getHomeworld()), PlanetModelResponse.class);

        assertThat("Planet name is wrong", planet.getName(), equalTo("Tatooine"));
        assertThat("Planet population is wrong", planet.getPopulation(), equalTo("200000"));

        FilmModelResponse film = validateAndParse(filmController.doGet(planet.getFilms().get(0)), FilmModelResponse.class);

        assertThat("Film name is wrong", film.getTitle(), equalTo("Attack of the Clones"));
        assertThat("Film is not contains character", film.getCharacters(), hasItem(lyck.getUrl()));
        assertThat("Film is not contains planet", film.getPlanets(), hasItem(planet.getUrl()));
    }
}
