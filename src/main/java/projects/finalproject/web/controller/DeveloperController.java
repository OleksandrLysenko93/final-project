package projects.finalproject.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.finalproject.exception.DeveloperAlreadyExistsException;
import projects.finalproject.service.DeveloperService;
import projects.finalproject.web.command.CreateDeveloperCommand;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping("/add")
    public String getAddDeveloperPage(Model model) {
        model.addAttribute(new CreateDeveloperCommand());
        return "developers/add";
    }

    @GetMapping("/list")
    public String getDevelopersListPage() {
        return "developers/list";
    }


    //todo only admin can add/edit/delete developers
    @PostMapping("/add")
    private String processAddDeveloper(@Valid CreateDeveloperCommand createDeveloperCommand, BindingResult bindingResult) {
        log.debug("Developer to be saved: {}", createDeveloperCommand);

        if (bindingResult.hasErrors()) {
            log.debug("Wrong data: {}", bindingResult.getAllErrors());
            return "developers/add";
        }

        try {
            developerService.add(createDeveloperCommand);
            log.debug("Developer added successfully");
            return "redirect:/developers/list";
        } catch (DeveloperAlreadyExistsException daee) {
            bindingResult.rejectValue("developerName", null, "Developer with such name already exists");
            return "developers/add";
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.debug("Error while receiving developer command to be saved");
            return "developers/add";
        }
    }

}
