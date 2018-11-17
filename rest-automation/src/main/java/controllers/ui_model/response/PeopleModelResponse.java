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
public class PeopleModelResponse {
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("eye_color")
    private String eyeColor;
    List<String> films = new ArrayList<>();
    private String gender;
    @JsonProperty("hair_color")
    private String hairColor;
    private String height;
    private String homeworld;
    private String mass;
    private String name;
    @JsonProperty("skin_color")
    private String skinColor;
    private String created;
    private String edited;
    List<String> species = new ArrayList<>();
    List<String> starships = new ArrayList<>();
    private String url;
    List<String> vehicles = new ArrayList<>();
}
