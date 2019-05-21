package dictionary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import dictionary.models.Word;
import dictionary.services.Dictionary;

@Controller
public class DictionaryController {
	
	@Autowired
	private Dictionary myDictionary;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String dictionary() {
		return "search";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String wordSubmit(@RequestParam("word") String word, Model model) {
	
		Word result = myDictionary.findExplanation(word);
		
		model.addAttribute("word", word);
		model.addAttribute("explanation", result.getExplanation());

		return "search";
	}
	
	@RequestMapping(value = "/wordSuggestions", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String wordSuggestions(@RequestParam("term") String word, Model model) {
		
		return new Gson().toJson(myDictionary.findSuggestions(word));
	}

}
