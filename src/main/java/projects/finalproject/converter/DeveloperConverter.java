package projects.finalproject.converter;

import org.springframework.stereotype.Component;
import projects.finalproject.domain.model.Developer;
import projects.finalproject.web.command.CreateDeveloperCommand;

@Component
public class DeveloperConverter {
    public Developer from(CreateDeveloperCommand createDeveloperCommand) {
        return Developer.builder()
               .name(createDeveloperCommand.getName())
               .contactNumber(createDeveloperCommand.getContactNumber())
               .contactPersonName(createDeveloperCommand.getContactPersonName())
               .build();
    }
}