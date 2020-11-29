package projects.finalproject.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class CreateDeveloperCommand {

    @NotBlank
    @Size(min = 3, max = 24)
    private String name;

    private String contactPersonName;

    @NotBlank
    @Size(min = 10, max = 13)
    private String contactNumber;

}
