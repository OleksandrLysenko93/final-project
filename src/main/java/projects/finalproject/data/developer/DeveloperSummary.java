package projects.finalproject.data.developer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class DeveloperSummary {

    private String developerName;
    private String contactPersonName;
    private String contactNumber;

}
