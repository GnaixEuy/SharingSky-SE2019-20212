package com.limitless.springbootwithjsp.controller;

import com.limitless.springbootwithjsp.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/15
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Controller
@RequestMapping(value = {"/stu"})
public class UserController {

	@GetMapping("/to")
	public String toJump(){
		return "addstu";
	}

	@PostMapping(value = {"/add"})
	public String add( String id, String name, String classInfo, HttpServletRequest httpServletRequest){
		if (ObjectUtils.isEmpty(id) || ObjectUtils.isEmpty(name)||ObjectUtils.isEmpty(classInfo)){
			return "error";
		}
		httpServletRequest.getSession().setAttribute("user",new Student(id,name,classInfo));
		return "show";
	}
}
