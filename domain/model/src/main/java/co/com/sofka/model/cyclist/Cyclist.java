package co.com.sofka.model.cyclist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Cyclist {

    private String id;
    private String fullName;
    private Integer UCN;
    private String teamId;
    private String nationality;
    private String countryId;
}

