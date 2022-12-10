package com.plum.apitest.controller;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.collections4.MapUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class MainController {

	@GetMapping("echo-get")
	public String echo(@RequestParam Map<String, Object> allParameters) {
		MapUtils.debugPrint(System.out, "echo", allParameters);
		Map<String, Object> resp = new HashMap<String, Object>();
		Set<String> keySet = allParameters.keySet();
		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			resp.put(key, allParameters.get(key));
		}
		Gson gson = new Gson();
		String json = gson.toJson(resp);
		return json;
	}
	
	@PostMapping("echo-post")
	public String echoPost(@RequestBody Map<String, Object> allParameters) {
		MapUtils.debugPrint(System.out, "echoPost", allParameters);
		Map<String, Object> resp = new HashMap<String, Object>();
		Set<String> keySet = allParameters.keySet();
		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			resp.put(key, allParameters.get(key));
		}
		Gson gson = new Gson();
		String json = gson.toJson(resp);
		return json;
	}
	
}
