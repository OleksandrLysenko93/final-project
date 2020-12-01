package projects.finalproject.converter;

import org.springframework.stereotype.Component;
import projects.finalproject.data.developer.DeveloperSummary;
import projects.finalproject.domain.model.Developer;
import projects.finalproject.web.command.CreateDeveloperCommand;

@Component
public class DeveloperConverter {
    public Developer from(CreateDeveloperCommand createDeveloperCommand) {
        return Developer.builder()
               .developerName(createDeveloperCommand.getDeveloperName())
               .contactNumber(createDeveloperCommand.getContactNumber())
               .contactPersonName(createDeveloperCommand.getContactPersonName())
               .build();
    }

    public DeveloperSummary from(Developer developer) {
        return DeveloperSummary.builder()
                .developerName(developer.getDeveloperName())
                .contactNumber(developer.getContactNumber())
                .contactPersonName(developer.getContactPersonName())
                .build();
    }
}
