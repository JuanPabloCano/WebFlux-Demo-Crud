package co.com.sofka.mongo.team.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TeamDto {

    @Id
    private String id;
    private String name;

    @Size(max = 3)
    private String code;
    private String countryId;
}
