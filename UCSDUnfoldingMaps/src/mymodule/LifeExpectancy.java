package mymodule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class LifeExpectancy extends PApplet{
	
	
	HashMap<String, Float> lifeExpMap;
	UnfoldingMap map;
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	public void setup(){
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this , 50, 50, 700, 500,new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		lifeExpMap=loadLifeExpectancyFromCSV("/home/jitu/git/UCSDUnfoldingMaps/UCSDUnfoldingMaps/data/LifeExpectancyWorldBank.csv");
		countries=GeoJSONReader.loadData(this,"/home/jitu/git/UCSDUnfoldingMaps/UCSDUnfoldingMaps/data/countries.geo.json");
		countryMarkers=MapUtils.createSimpleMarkers(countries);	
		map.addMarkers(countryMarkers);
		
		shadeCountries();
	}
	
	public void draw(){
	map.draw();
	}
	
	
	private void shadeCountries() {
	for(Marker marker: countryMarkers){
		String countryId= marker.getId();
		
		if (lifeExpMap.containsKey(countryId)){
			float lifeExp=lifeExpMap.get(countryId);
			int colorLevel =(int) map(lifeExp,40,90,10,255);
			marker.setColor(color(255-colorLevel,100,colorLevel));
		}else {
			marker.setColor(color(150,10,10));
		}
	}
		
	}

		
	private HashMap<String,Float> loadLifeExpectancyFromCSV(String filename){
		HashMap<String, Float> lifeExpMap= new HashMap<String, Float>();
		
		String [] rows =loadStrings(filename);
		
		for(String row : rows ){
			String[] columns =row.split(",");
			if(columns.length == 6 && !columns[5].equals("..")){
					float value = Float.parseFloat(columns[5]);
					lifeExpMap.put(columns[4], value);
				}
			}
		return lifeExpMap;
		
	}
	
	
}