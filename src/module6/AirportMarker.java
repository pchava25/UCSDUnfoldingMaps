package module6;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	routes=new ArrayList<SimpleLinesMarker>();
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(255,0,0);
		pg.ellipse(x, y, 5, 5);
		
		
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		
		// show routes
		String title = getName()+" "+getCode()+"\n"+getCity()+" "+getCountry()+"\n In Routes"+getInRoutes()+" Out Routes"+getOutRoutes();
		System.out.println(getInRoutes());
		//int i=getInRoutes();
		//System.out.println(getAltitude());
		
		pg.pushStyle();
		
		pg.rectMode(PConstants.CORNER);
		
		pg.stroke(110);
		pg.fill(255,255,255);
		pg.rect(x, y + 15, pg.textWidth(title) +6, 58, 5);
		
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.fill(0);
		pg.text(title, x + 3 , y +18);
		
		
		pg.popStyle();

		
		
	}
	
	public String getName() {
		return (String) getProperty("name");	
		
	}
	
	public String getCity() {
		return (String) getProperty("city");	
		
	}

	public String getCountry() {
		return (String) getProperty("country");	
		
	}

	public String getCode() {
		return getProperty("code").toString();	
		
	}
	public float getAltitude() {
		return Float.parseFloat(getProperty("altitude").toString());	
		
	}
	public int getInRoutes(){
		int count=0;
		for(SimpleLinesMarker s:routes)
		{
			//System.out.println(s.getLocation(1).toString());
			if(s.getLocation(1).equals(this.getLocation()))
				count++;
		}
		return count;
	}
	public int getOutRoutes(){
		int count=0;
		for(SimpleLinesMarker s:routes)
		{
			//System.out.println(s.getLocation(1).toString());
			if(s.getLocation(0).equals(this.getLocation()))
				count++;
		}
		return count;
	}
}
