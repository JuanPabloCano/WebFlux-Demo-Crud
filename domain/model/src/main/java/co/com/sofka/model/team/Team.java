package co.com.sofka.model.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Team {

    private String id;
    private String name;
    private String code;
    private String countryId;
}
