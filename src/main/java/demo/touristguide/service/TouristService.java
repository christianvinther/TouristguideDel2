package demo.touristguide.service;

import org.springframework.stereotype.Service;
import demo.touristguide.model.TouristAttraction;
import demo.touristguide.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository){
        this.touristRepository = touristRepository;
    }

        public void addAttraction(TouristAttraction attraction){
            touristRepository.addAttraction(attraction);
        }

        public List<String> getAllCities() {
            return touristRepository.getAllCities();
        }

        public List<String> getAllTags() {
            return touristRepository.getAllTags();
        }


    //Lister alle attraktioner igennem touristRepository. (Read funktion)
    public List<TouristAttraction> getAllAttractions(){
        return touristRepository.getAllAttractions();
    }

    //Henter en attraktion ud fra navnet igennem touristRepository. (Read funktion)
    public TouristAttraction getAttractionByName(String name){
        return touristRepository.getAttractionByName(name);
    }

    //Opdaterer en attraktion igennem touristRepository. (Update funktion)
    public boolean updateAttraction(String name, String updateDesc){
        return touristRepository.updateAttraction(name,updateDesc);
    }

    //Sletter en attraktion igennem touristRepository. (Delete funktion)
    public boolean deleteAttraction(String name){
        return touristRepository.deleteAttraction(name);
    }


}
