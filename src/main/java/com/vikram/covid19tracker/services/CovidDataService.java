package com.vikram.covid19tracker.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.vikram.covid19tracker.models.LocationStat;

@Service
public class CovidDataService {

	private static String COVID_DATA_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private List<LocationStat> allStats = new ArrayList<>();
	
	
	@PostConstruct
//	@Scheduled(cron = "* * 1 * * *")
	public void fetchCovidData() throws IOException, InterruptedException {
		List<LocationStat> newStats = new ArrayList<>();
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(COVID_DATA_URL))
				.build();
		HttpResponse<String> httpResponse = client.send(request,HttpResponse.BodyHandlers.ofString());
//		System.out.println("Data=>"+httpResponse.body());
		
		StringReader csvBodyReader = new StringReader(httpResponse.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		for (CSVRecord record : records) {
			LocationStat locationStat = new LocationStat();
			locationStat.setState(record.get("Province/State"));
			locationStat.setCountry(record.get("Country/Region"));
			long previousDayCases = Long.parseLong(record.get(record.size()-2));
			long TotalCases = Long.parseLong(record.get(record.size()-1));
			long todaysCases = TotalCases-previousDayCases;
			locationStat.setLatestTotalCases(TotalCases+"");
			locationStat.setNewCases(todaysCases+"");
			newStats.add(locationStat);
		    System.out.println(locationStat);
		}
		
		this.allStats=newStats;
	}


	public List<LocationStat> getAllStats() {
		return allStats;
	}
}
