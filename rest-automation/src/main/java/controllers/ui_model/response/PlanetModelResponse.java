package controllers.ui_model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class PlanetModelResponse {
    private String climate;
    private String created;
    private String diameter;
    private String edited;
    List<String> films = new ArrayList<>();
    private String gravity;
    private String name;
    @JsonProperty("orbital_period")
    private String orbitalPeriod;
    private String population;
    List<String> residents = new ArrayList<>();
    @JsonProperty("rotation_period")
    private String rotationPeriod;
    @JsonProperty("surface_water")
    private String surfaceWater;
    private String terrain;
    private String url;
}
