package com.example.kaitaishinsho.login.controller;

import com.example.kaitaishinsho.login.domain.model.SignUpForm;
import com.example.kaitaishinsho.login.domain.model.User;
import com.example.kaitaishinsho.login.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	private Map<String, String> radioMarriage;

	private Map<String, String> initRadioMarriage() {
		Map<String, String> radio =  new LinkedHashMap<>();

		radio.put("既婚", "true");
		radio.put("未婚", "false");

		return radio;
	}

	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("contents", "login/home :: home_contents");
		return "login/homeLayout";
	}

	@GetMapping("/userList")
	public String getUserList(Model model) {
		model.addAttribute("contents", "login/userList :: userList_contents");

		List<User> userList = userService.selectMany();

		model.addAttribute("userList", userList);

		int count = userService.count();
		model.addAttribute("userListCount", count);

		return "login/homeLayout";
	}

	@GetMapping("/userDetail/{id:.+}")
	public String getUserDetail(@ModelAttribute SignUpForm form, Model model,
	                            @PathVariable("id") String userId) {
		System.out.println("userId = " + userId);

		model.addAttribute("contents", "login/userDetail :: userDetail_contents");

		radioMarriage = initRadioMarriage();

		model.addAttribute("radioMarriage", radioMarriage);

		if (userId != null && userId.length() > 0) {
			User user = userService.selectOne(userId);

			form.setUserId(user.getUserId());
			form.setUserName(user.getUserName());
			form.setBirthday(user.getBirthday());
			form.setAge(user.getAge());
			form.setMarriage(user.isMarriage());

			model.addAttribute("signUpForm", form);
		}
		return "login/homeLayout";
	}

	@PostMapping(value = "/userDetail", params = "update")
	public String postUserDetailUpdate(@ModelAttribute SignUpForm form, Model model) {
		System.out.println("update処理");

		User user = new User();

		user.setUserId(form.getUserId());
		user.setUserName(form.getUserName());
		user.setBirthday(form.getBirthday());
		user.setAge(form.getAge());
		user.setMarriage(form.isMarriage());

		boolean result = userService.updateOne(user);

		if (result == true) {
			model.addAttribute("result", "success update");
		} else {
			model.addAttribute("result", "fail update");
		}

		return getUserList(model);
	}

	@PostMapping(value = "/userDetail", params = "delete")
	public String postUserDetailDelete(@ModelAttribute SignUpForm form, Model model) {
		System.out.println("delete処理");

		boolean result = userService.deleteOne(form.getUserId());

		if (result == true) {
			model.addAttribute("result", "success delete");
		} else {
			model.addAttribute("result", "fail delete");
		}

		return getUserList(model);
	}

	@PostMapping("/logout")
	public String postLogout() {
		return "redirect:/login";
	}

	@GetMapping("/userList/csv")
	public String getUserListCsv(Model model) {
		return getUserList(model);
	}
}
