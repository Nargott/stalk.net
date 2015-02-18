package net.ua.stalk.action;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import org.primefaces.model.map.DefaultMapModel;  
import org.primefaces.model.map.LatLng;  
import org.primefaces.model.map.MapModel;  
import org.primefaces.model.map.Polygon; 

@ManagedBean //Означает, что этот бин будет виден для JSF
@SessionScoped //Область действия -- сессия
public class MapPage implements Serializable {
	private static final long serialVersionUID = -3261247947821833832L;
	private static final Logger logger = Logger.getLogger(MapPage.class.getName());
	
	private MapModel polygonModel;  
    
    public MapPage() {  
        polygonModel = new DefaultMapModel();  
          
        //Shared coordinates  50.169669,28.272972
        /*LatLng coord1 = new LatLng(50.169669, 28.272972);  
        LatLng coord2 = new LatLng(36.883707, 30.689216);  
        LatLng coord3 = new LatLng(36.879703, 30.706707); */ 
  
        //Polygon  
        //https://maps.google.com/maps/ms?msid=201934792344069171373.0004c47c0b78c1ed16ac5&msa=0&ll=50.167979,28.265998&spn=0.012329,0.033023
        Polygon polygon = new Polygon();  
        polygon.getPaths().add(new LatLng(50.173847, 28.265033));  
        polygon.getPaths().add(new LatLng(50.175716, 28.272028));  
        polygon.getPaths().add(new LatLng(50.174315, 28.27426));
        polygon.getPaths().add(new LatLng(50.168295, 28.27795));
        polygon.getPaths().add(new LatLng(50.16479,  28.272715));
        polygon.getPaths().add(new LatLng(50.16424,  28.267522));
        polygon.getPaths().add(new LatLng(50.166742, 28.26602));
        polygon.getPaths().add(new LatLng(50.167979, 28.265998));
        
  
        polygon.setStrokeColor("#BAFFFF");  
        polygon.setFillColor("#BAFFFF");  
        polygon.setStrokeOpacity(0.6);  
        polygon.setFillOpacity(0.2);  
          
        polygonModel.addOverlay(polygon);
        logger.info("MapPage() constructor called!");
    }  
  
    public MapModel getPolygonModel() {  
    	logger.info("getPolygonModel() called!");
    	return polygonModel;  
    }
}
