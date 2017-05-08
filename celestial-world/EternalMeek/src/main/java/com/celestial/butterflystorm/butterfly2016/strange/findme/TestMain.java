package com.celestial.butterflystorm.butterfly2016.strange.findme;

import java.io.IOException;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

public class TestMain {
    public static void main(String[] args) {
        try {
            LookupService cl = new LookupService("src/main/java/com/celestial/butterflystorm/strange/findme/deploy/GeoLiteCity.dat", LookupService.GEOIP_MEMORY_CACHE);
//            Location l2 = cl.getLocation("182.150.46.239");
            Location l2 = cl.getLocation("192.30.253.112");
            System.out.println(
                    "countryCode: " + l2.countryCode +"\n"+
                    "countryName: " + l2.countryName +"\n"+
                    "region: " + l2.region +"\n"+
                    "city: " + l2.city +"\n"+
                    "latitude: " + l2.latitude +"\n"+
                    "longitude: " + l2.longitude);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}