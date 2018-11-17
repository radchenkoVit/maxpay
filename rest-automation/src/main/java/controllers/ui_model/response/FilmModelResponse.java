package controllers.ui_model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class FilmModelResponse {
    private String title;
    @JsonProperty("episode_id")
    private float episodeId;
    @JsonProperty("opening_crawl")
    private String openingCrawl;
    private String director;
    private String producer;
    @JsonProperty("release_date")
    private String releaseDate;
    List<String> characters = new ArrayList<>();
    List<String> planets = new ArrayList <>();
    List<String> starships = new ArrayList <>();
    List<String> vehicles = new ArrayList <>();
    List<String> species = new ArrayList <>();
    private String created;
    private String edited;
    private String url;
}
