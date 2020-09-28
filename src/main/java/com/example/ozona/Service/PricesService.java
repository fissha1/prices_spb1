package com.example.ozona.Service;

import com.example.ozona.Model.Prices;
import com.example.ozona.Repository.PricesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PricesService {

	// Daatos de salida
    public String sProduct_id; 
    public String sBrand_id; 
    public String sPrice_list; 
    public String sfechaEnt;
    public String sfechaSal;
    public String sPrice;
    public String sCurr;
    
    public String fechaHora;
    public String Response;
    public boolean found = false;
	
    @Autowired
    private PricesRepository pricesRepository;

    public String retRespuesta(String id) {
    	pricesRepository.findAll();
    	return "Respuesta service con parametro id: " + id + "paasdo al servicio";
    }
    
    public String retResponse(String fechaEnt,
			  				  String horaEnt,
			  				  String producto,
			  				  String brandId,
			  				  String control) {
    	
    	//String salida = "on".equals(control) ? "Checkeado" : ">>";
	    String salida = "";
	
	    List < Prices > Prices = pricesRepository.findAll();
	
	    // formta java 8 datetime
	    //DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
	    LocalDate local_date_1;
	    LocalDate local_date_2;
	    LocalDate local_date_3;
    
	    fechaHora = fechaEnt + " " + horaEnt;
	    local_date_1 = LocalDate.parse(fechaHora, formatter_2);
    
	    Response="";
    
	    for(int i=0;i<Prices.size();i++){
    	
	    	//salida = salida +  ":" + Prices.get(i)+":";
	    	//salida = salida + ":" + Prices.get(i).getBrand_id()+":";
	    	//salida = salida + ":" + Prices.get(i).getProduct_id()+":";
    	
	    	//salida = salida + "\n" + Prices.get(i).getStart_date()+"start date";
	    	//salida = salida + "\n" + fechaHora + " " + "fecha hora";            
	    	//salida = salida + "\n" + Prices.get(i).getEnd_date()+"end date";
        
	    	//salida = salida + "\n";
        
        local_date_2 = LocalDate.parse(Prices.get(i).getStart_date(), formatter_2);   
        local_date_3 = LocalDate.parse(Prices.get(i).getEnd_date(), formatter_2);

        if (local_date_1.compareTo(local_date_2) >= 0) {            
        	if (local_date_3.compareTo(local_date_1) >= 0) {
        		if (Prices.get(i).getBrand_id().equals(brandId)) {
            		// salida = salida + "\n igual a brandId ";
            		if (Prices.get(i).getProduct_id().equals(producto)) {
            			salida = salida + ":\n" + Prices.get(i).getPrice_list() + " ";
            			salida = salida + ":" + "\nfent entre start date y end date ";
            			//crear salida:
        				sProduct_id = Prices.get(i).getProduct_id();
        				sBrand_id = Prices.get(i).getBrand_id();
        				sPrice_list = Prices.get(i).getPrice_list();
        				sfechaEnt = Prices.get(i).getStart_date();
        				sfechaSal = Prices.get(i).getEnd_date();
        				sPrice = Prices.get(i).getPrice();
        				sCurr = Prices.get(i).getCurr();
        				
        				found = true;
            		}
            	}
        	}
        }        

    }
    if (found == false) {
    	Response = "No se ha encontrado información para estos datos";
    }else{
    	Response = Response + "El producto " + sProduct_id + " "; 
		Response = Response + "con identificación de cadena " + sBrand_id + "\n"; 
		Response = Response + "de la lista de precios " + sPrice_list + ",\n";  
		Response = Response + "en el rango de fechas de " + sfechaEnt + " "; 
		Response = Response + "a " + sfechaSal + ",\n"; 
		Response = Response + "tiene el precio final de: " + sPrice + " " + sCurr; 
    }
    return Response;
    //return String.format("%s %s %s %s %s!", salida, fechaEnt, horaEnt, producto, brandId);
}
/*
    public List<Prices> retrieveAllPrices() {
    	retrieveAllPrices = PricesRepository.findAll() {
		return retrieveAllPrices;
	} 
*/
    /*
    public List<Prices> listPrices() {
        Iterable<Prices> Prices = PricesRepository.findAll();
        List<Prices> list = new ArrayList<Prices>();
        Prices.forEach(list::add);
        return list;
    }
    
*/
/*
    public User create(User user) {
        return UserRepository.save(user);
    }
*/
}
