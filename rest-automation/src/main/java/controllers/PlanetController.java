package controllers;

public class PlanetController extends AbstractController {
    @Override
    public String getStringUrl() {
        return "/api/planets/{id}/";
    }
}
