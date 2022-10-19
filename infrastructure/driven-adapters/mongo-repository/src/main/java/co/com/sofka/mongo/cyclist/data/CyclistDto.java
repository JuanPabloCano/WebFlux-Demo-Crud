package co.com.sofka.mongo.cyclist.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CyclistDto {

    @Id
    private String id;
    private String fullName;

    @Max(3)
    private Integer UCN;
    private String teamId;
    private String nationality;
    private String countryId;
}
