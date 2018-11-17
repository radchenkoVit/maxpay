package controllers;

public class FilmController extends AbstractController {
    @Override
    public String getStringUrl() {
        return "/api/films/{id}/";
    }
}
