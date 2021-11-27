package com.vikram.covid19tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vikram.covid19tracker.models.LocationStat;
import com.vikram.covid19tracker.services.CovidDataService;

@Controller
public class CovidDataController {

	@Autowired
	private CovidDataService covidDataService;
	
	@GetMapping("/")
	public String getCovidData(Model model) {
		long totalCases=0;
		long totalNewCases=0;
		for(LocationStat each : covidDataService.getAllStats()) {
			totalCases = totalCases+Long.parseLong(each.getLatestTotalCases());
			totalNewCases = totalNewCases+Long.parseLong(each.getNewCases());
		}
		model.addAttribute("locationStats",covidDataService.getAllStats());
		model.addAttribute("totalCases",totalCases);
		model.addAttribute("totalNewCases",totalNewCases);
		return "latest-covid";
	}
}
