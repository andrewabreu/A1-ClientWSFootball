package clientwsfootball1;

import eu.dataaccess.footballpool.ArrayOfString;
import eu.dataaccess.footballpool.ArrayOftCountryInfo;
import eu.dataaccess.footballpool.TCountryInfo;
import java.util.List;

public class ClientWsFootball1 {

    public static void main(String[] args) {
        System.out.println("Número de tarjetas amarillas: " + yellowCardsTotal());
        System.out.println("");
        
        List<String> allDefendersSpain = allDefenders("Spain").getString();
        System.out.println("Defensas de la selección española de fútbol");
        System.out.println("");
        for (String defender : allDefendersSpain) {
            System.out.println(defender);
        }   
        System.out.println("");
        System.out.println("Defensas de cada país compitiendo en la competición");
        System.out.println("");
        List<TCountryInfo> countryNamesList = countryNames(true).getTCountryInfo();
        for (TCountryInfo tCountryInfo : countryNamesList) {
            String country = tCountryInfo.getSName();
            System.out.println("País: " + country);
            System.out.println("");
            List<String> allDefenders = allDefenders(country).getString();
            for (String defender : allDefenders) {
                System.out.println(defender);
            }
            System.out.println("");
        }    
    }

    private static int yellowCardsTotal() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap12();
        return port.yellowCardsTotal();
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap12();
        return port.allDefenders(sCountryName);
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap12();
        return port.countryNames(bWithCompetitors);
    }
    
}
