package vttp2022.csf.assessment.server.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vttp2022.csf.assessment.server.services.RestaurantService;

@Controller
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantSvc;

    
    @GetMapping(path="/cuisines")
    @ResponseBody
    public ResponseEntity<String> getCuisines() {
        return ResponseEntity.ok(restaurantSvc.getCuisines());
        
    }

    @GetMapping(path="/{cuisine}/restaurants") 
    @ResponseBody
    public ResponseEntity<String> getRestaurantsByCuisine(@PathVariable String cuisine) {
       return null;
    }

    // @GetMapping(path="/restaurant/{name}")
    // @ResponseBody
    // public ResponseEntity<String> getRestaurant(@PathVariable String name) throws IOException {
    //     //Make query
    //     Optional<Restaurant> opt = restaurantSvc.getRestaurant(name);
    //     if (opt.isEmpty()) {
    //         JsonObject error = Json.createObjectBuilder()
    //                             .add("error", "Restaurant not found for %s".formatted(name))
    //                             .build();
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.toString());
    //     }
    //     Restaurant r = opt.get();

    //     //Retrieve image from s3

    //     //get image from chuk
    //     byte[] image = mapCache.getMap(r.getCoordinates().getLatitude(), r.getCoordinates().getLongitude());
    //     //save it to s3
    //     String imgUrl = s3Service.upload(image);
    //     System.out.println(imgUrl);
    //     r.setMapURL("https://drewkwan.sgp1.digitaloceanspaces.com/csfAssessment%2F"+imgUrl);
    //     return ResponseEntity.ok(r.toJson().toString());
    //     // System.out.println(r);
    //     // return null;
    // }


    @PostMapping(path="/comments", consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> postComments(@RequestBody String body) {
      return null; 
        
    }

}
