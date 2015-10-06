package module4;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

/** Implements a visual marker for land earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 *
 */
public class LandQuakeMarker extends EarthquakeMarker {
	
	
	public LandQuakeMarker(PointFeature quake) {
		
		// calling EarthquakeMarker constructor
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = true;
	}


	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		// Draw a centered circle for ocean quakes
		// DO NOT set the fill color here.  That will be set in the EarthquakeMarker
		// class to indicate the depth of the earthquake.
		// Simply draw a centered circle.
		
		// HINT: Notice the radius variable in the EarthquakeMarker class
		// and how it is set in the EarthquakeMarker constructor
		
		// TODO: Implement this method
		float radius=0;
		if(this.getMagnitude()>=5)			
			radius=10;
		else if(this.getMagnitude()>=4 && this.getMagnitude()<5)
			radius=7;
		else if(this.getMagnitude()<4)
		radius=4;
//		pg.fill(red);
		//System.out.println(this.getProperty("Age"));
		//if(this.getProperty("Age")=="Past Hour")
		//{
			//pg.line(x, y, x+radius, y+radius);
			//pg.line(x+radius, y+radius, x, y);
		//}
		pg.ellipse(x, y, radius, radius);
	}
	

	// Get the country the earthquake is in
	public String getCountry() {
		return (String) getProperty("country");
	}



		
}