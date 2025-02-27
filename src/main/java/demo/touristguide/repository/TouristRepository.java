package demo.touristguide.repository;

import org.springframework.stereotype.Repository;
import demo.touristguide.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository(){
        // Opretter CopenHill og tilføjer by + tags
        TouristAttraction copenHill = new TouristAttraction(
                "CopenHill",
                "En urban skibakke og aktivitetspark på taget af et forbrændingsanlæg, " +
                        "hvor man kan stå på ski, løbe eller nyde panoramaudsigten over København.",
                "København"
        );
        copenHill.addTag("Skiløb");
        copenHill.addTag("Udendørs aktivitet");
        copenHill.addTag("Sportsanlæg");
        attractions.add(copenHill);

        // Opretter Reffen Street Food og tilføjer by + tags
        TouristAttraction reffen = new TouristAttraction(
                "Reffen Street Food",
                "En kreativ mad- og kulturhub i København, hvor unge kan smage internationale retter, " +
                        "lytte til livemusik og opleve en afslappet street food-atmosfære.",
                "København"
        );
        reffen.addTag("Mad");
        reffen.addTag("Kultur");
        reffen.addTag("Musik");
        attractions.add(reffen);

        // Opretter FÆNGSLET og tilføjer by + tags
        TouristAttraction faengslet = new TouristAttraction(
                "FÆNGSLET",
                "Et tidligere fængsel i Horsens, omdannet til museum," +
                        " koncertsted og eventlokale, hvor man kan opleve autentiske celler, spændende historie og escape room-udfordringer",
                "Horsens"
        );
        faengslet.addTag("Museum");
        faengslet.addTag("Historie");
        faengslet.addTag("Begivenhed");
        attractions.add(faengslet);

        // Opretter Aarhus Festuge +  og tilføjer by + tags
        TouristAttraction aarhusFestuge = new TouristAttraction(
                "Aarhus Festuge",
                "En årlig kulturfestival i Aarhus, der byder på alt fra koncerter " +
                        "og kunstinstallationer til teater og debatter, skabt for at samle unge og kreative sjæle.",
                "Aarhus"
        );
        aarhusFestuge.addTag("Festival");
        aarhusFestuge.addTag("Kultur");
        aarhusFestuge.addTag("Musik");
        aarhusFestuge.addTag("Kunst");
        attractions.add(aarhusFestuge);
    }

    public List<String> getAllCities() {
        List<String> cities = new ArrayList<>();
        for (TouristAttraction attraction : attractions) {
            String city = attraction.getCity();
            if (!cities.contains(city)) {
                cities.add(city);
            }
        }

        return cities;
    }

    public List<String> getAllTags() {
        List<String> tags = new ArrayList<>();
        for (TouristAttraction attraction : attractions) {
            for (String tag : attraction.getTags()) {
                if (!tags.contains(tag)) {
                    tags.add(tag);
                }
            }
        }

        return tags;
    }

    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);

    }

    public List<TouristAttraction> getAllAttractions() {
        return new ArrayList<>(attractions);
    }

    public TouristAttraction getAttractionByName(String name) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }

    public void updateAttraction(TouristAttraction updatedAttraction) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(updatedAttraction.getName())) {
                attraction.setDescription(updatedAttraction.getDescription());
                attraction.setCity(updatedAttraction.getCity());
                attraction.setTags(updatedAttraction.getTags());
                return;
            }
        }
    }



    //Sletter en attraktion. (Delete funktion)
    public void deleteAttraction(String name){
        for (int i = 0; i < attractions.size(); i++){
            if(attractions.get(i).getName().equalsIgnoreCase(name)){
                attractions.remove(i);
                return;
            }

        }
    }
}
