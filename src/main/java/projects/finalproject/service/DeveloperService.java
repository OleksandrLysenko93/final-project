package projects.finalproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.finalproject.converter.DeveloperConverter;
import projects.finalproject.domain.model.Developer;
import projects.finalproject.domain.repository.DeveloperRepository;
import projects.finalproject.web.command.CreateDeveloperCommand;

@Service
@RequiredArgsConstructor
@Slf4j @Transactional
public class DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperConverter developerConverter;

    public void add(CreateDeveloperCommand createDeveloperCommand) {
        log.debug("Developer command to be converted and added: {}", createDeveloperCommand);

        Developer developerToBeSaved = developerConverter.from(createDeveloperCommand);
        log.debug("Developer entity received from command: {}", developerToBeSaved);

        if (developerRepository.existsByName(developerToBeSaved.getName())) {
            log.debug("Developer with such name already exists: {}", developerToBeSaved.getName());
        }

        developerRepository.save(developerToBeSaved);
    }


}
