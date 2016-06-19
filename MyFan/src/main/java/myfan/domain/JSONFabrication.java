package myfan.domain;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONFabrication {
	  public String jsonConverter(Object source) {
		    ObjectMapper mapper = new ObjectMapper();
		    String jsonInString= "{}";
		    try {
		      jsonInString = mapper.writeValueAsString(source);
		      jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(source);

		    } catch (JsonGenerationException e) {
		      e.printStackTrace();
		    } catch (JsonMappingException e) {
		      e.printStackTrace();
		    } catch (JsonProcessingException e) {
		      e.printStackTrace();
		    } 
		    return jsonInString;
		  }
}
