package controllers;

public class PeopleController extends AbstractController {
    @Override
    public String getStringUrl() {
        return "/api/people/{id}/";
    }
}
