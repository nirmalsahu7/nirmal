package resources;

import supporting_files.pojo.AddPlace;
import supporting_files.pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {


    public AddPlace addPlacePayload(){
        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setName("Frontline house");
        p.setPhone_number("+91) 983 893 3937");
        p.setAddress("29, side layout, cohen 09");
        p.setWebsite("http://google.com");
        p.setLanguage("French-IN");
        List<String> myList = new ArrayList<>() ;
        myList.add("shoe park");
        myList.add("shop");
        p.setTypes(myList);
        Location l=new Location();
        l.setLat(38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }

    public AddPlace addPlacePayloadWithArg(String name,String language, String address){
        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setName(name);
        p.setPhone_number("+91) 983 893 3937");
        p.setAddress(address);
        p.setWebsite("http://google.com");
        p.setLanguage(language);
        List<String> myList = new ArrayList<>() ;
        myList.add("shoe park");
        myList.add("shop");
        p.setTypes(myList);
        Location l=new Location();
        l.setLat(38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }

    public String deletePlacePayload(String place_id){
        return "{\"place_id\":\""+place_id+"\"}";
    }
}
