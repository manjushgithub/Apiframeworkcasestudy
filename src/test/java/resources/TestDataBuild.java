package resources;

import POJO.Location;
import POJO.addplace;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public  addplace addplacepayload(String name,String language,String address) {
        addplace p = new addplace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setName(name);
        p.setPhone_number("(+91) 983 893 3937");
        List<String> mylist = new ArrayList<>();
        mylist.add("shoe park");
        mylist.add("shop");
        p.setTypes(mylist);
        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;

    }
}
