package projects.finalproject.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.finalproject.service.DeveloperService;
import projects.finalproject.web.command.CreateDeveloperCommand;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    @PostMapping("add")
    private String processAddDeveloper(@Valid CreateDeveloperCommand createDeveloperCommand, BindingResult bindingResult) {
        log.debug("Developer to be saved: {}", createDeveloperCommand);

        if (bindingResult.hasErrors()) {
            log.debug("Wrong data: {}", bindingResult.getAllErrors());
            return "developers/add";
        }

        try {
            developerService.add(createDeveloperCommand);
            log.debug("Getting developer command and passing to be saved: {}", createDeveloperCommand);
            return "redirect:/developers/list";
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.debug("Error while receiving developer command to be saved");
            return "developers/add";
        }
    }

}
