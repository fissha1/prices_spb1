package com.example.ozona.Controller;

import java.util.HashMap;
import java.util.Map;

import java.util.List;
// import java.util.ArrayList;

//import java.time.format.DateTimeFormatter;
//import java.time.LocalDate; 

import javax.validation.Valid;

import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ozona.Exception.ResourceNotFoundException;

import com.example.ozona.Model.Prices;
import com.example.ozona.Service.PricesService;
//import com.example.ozona.Repository.PricesRepository;


@RestController
// @RequestMapping("/api/v1")
public class PricesController {
    
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
    
	//@Autowired
	//private PricesRepository PricesRepository;
    
    @Autowired
   	private PricesService pricesService;
	
	@GetMapping("/Respuesta/{id}")
    public String retornaRespuesta(String id) {
		return pricesService.retRespuesta(id);
	}
    @RequestMapping(path="/consulta", produces=MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String processForm(@RequestParam(defaultValue="fechaEnt") String fechaEnt,
    						  @RequestParam(defaultValue="horaEnt") String horaEnt,
    						  @RequestParam(defaultValue="producto") String producto,
    						  @RequestParam(defaultValue="brandId") String brandId,
                              @RequestParam(required = false) String control) {

    	Response = pricesService.retResponse(fechaEnt, horaEnt, producto, brandId, control);
/*
    	//String salida = "on".equals(control) ? "Checkeado" : ">>";
        String salida = "";
    	
        List < Prices > Prices = PricesRepository.findAll();
    	
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
*/ 
        return Response;
        //return String.format("%s %s %s %s %s!", salida, fechaEnt, horaEnt, producto, brandId);
    }
    
	@GetMapping("/Consulta2")
	public String Respuesta() {
		
		String fechaEnt = ""; 
		String horaEnt = ""; 
		String producto = ""; 
		String brandId = ""; 
		String control = ""; 
		
		Response = pricesService.retResponse(fechaEnt, horaEnt, producto, brandId, control); 
		
		return Response;
	}

/*	
    @GetMapping("/Prices")
    public List < Prices > getAllPrices() {
        return PricesRepository.findAll();
    }

    @GetMapping("/Prices/{id}")
    public ResponseEntity < Prices > getPricesById(@PathVariable(value = "id") Long PricesId)
    throws ResourceNotFoundException {
        Prices Prices = PricesRepository.findById(PricesId)
            .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado nada para este id :: " + PricesId));
        return ResponseEntity.ok().body(Prices);
    }
    
    @PostMapping("/Prices")
    public Prices createPrices(@Valid @RequestBody Prices Prices) {
        return PricesRepository.save(Prices);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity < Prices > updatePrices(@PathVariable(value = "id") Long PricesId,
        @Valid @RequestBody Prices PricesDetails) throws ResourceNotFoundException {
        Prices Prices = PricesRepository.findById(PricesId)
            .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado nada para este id :: " + PricesId));

        //Prices.setEmailId(PricesDetails.getEmailId());
        //Prices.setLastName(PricesDetails.getLastName());
        //Prices.setFirstName(PricesDetails.getFirstName());
        final Prices updatedPrices = PricesRepository.save(Prices);
        return ResponseEntity.ok(updatedPrices);
    }

    @DeleteMapping("/employees/{id}")
    public Map < String, Boolean > deletePrices(@PathVariable(value = "id") Long PricesId)
    throws ResourceNotFoundException {
        Prices Prices = PricesRepository.findById(PricesId)
            .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado nada para este id :: " + PricesId));

        PricesRepository.delete(Prices);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
*/
}