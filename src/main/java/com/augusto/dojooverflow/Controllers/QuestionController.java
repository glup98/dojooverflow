package com.augusto.dojooverflow.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.augusto.dojooverflow.Models.Question;
import com.augusto.dojooverflow.Models.Tag;
import com.augusto.dojooverflow.Services.QuestionService;
import com.augusto.dojooverflow.Services.TagService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final TagService tagService;

    @GetMapping("")
    public String questionDashboard(Model model) {
        List<Question> questions = questionService.list();
        model.addAttribute("questions", questions);
        return"questionDahsboard";
    }

    @GetMapping("/new")
    public String newQuestion(@ModelAttribute("question") Question question) {
        return "newQuestion";
    }

    @PostMapping("/new")
    public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result,@RequestParam ("subjects") String subjects,Model model) {
        List <Tag> tagList = new ArrayList<>();
        if (result.hasErrors()) {
            return "newQuestion";
        } else{
            List<String> subjectList = Arrays.asList(subjects.split(","));
            if (subjectList.size() > 3) {
                String exceedsMaximum = "No puedes tener mas de 3 tags"; 
                model.addAttribute("error", exceedsMaximum);
                return "newQuestion";
            } else {
                for (String subject : subjectList) {
                    Tag optionalTag = tagService.findTagBySubjet(subject);
                    if (tagService.isLowerCase(subject)) {
                        if (optionalTag == null) {
                            Tag tag =tagService.setTagSubject(subject);
                            tagService.save(tag);
                            tagList.add(tag);
                        }
                        else{
                            tagList.add(optionalTag);
                        }
                    } else {
                        String isUpperCase= "No puedes tener mayusculas en tus tags";
                        model.addAttribute("error", isUpperCase);
                        return "newQuestion";
                    }
                }
                question.setTags(tagList);
                questionService.save(question);
            }
        }
        return "redirect:/questions/new";
    }

}
