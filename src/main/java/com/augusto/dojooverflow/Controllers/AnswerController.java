package com.augusto.dojooverflow.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.augusto.dojooverflow.Models.Answer;
import com.augusto.dojooverflow.Models.Question;
import com.augusto.dojooverflow.Models.Tag;
import com.augusto.dojooverflow.Services.AnswerService;
import com.augusto.dojooverflow.Services.QuestionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answers")
public class AnswerController {

    private final QuestionService questionService;
    private final   AnswerService answerService;

    @GetMapping("/{questionId}")
    public String newAnswer(@ModelAttribute ("answer") Answer answer, @PathVariable ("questionId") Long questionId, Model model) {
        Question question = questionService.findById(questionId);
        List<Tag> tagsList = question.getTags();
        model.addAttribute("tagsList", tagsList);
        model.addAttribute("question", question);
        return "newAnswer";
    }

    @PostMapping("/{questionId}")
    public String createAnswer(@Valid @ModelAttribute ("answer") Answer answer,BindingResult result, @PathVariable ("questionId") Long questionId) {

        System.out.println(result.getAllErrors());
        if (result.hasErrors()) {
            return "newAnswer";
        } else {
            Question question = questionService.findById(questionId);
            List<Answer> answers = question.getAnswers();
            answers.add(answer);
            question.setAnswers(answers);
            answer.setQuestion(question);
            questionService.save(question);
            answerService.save(answer);
        }
        return "redirect:/answers/"+ questionId;
    }

}
