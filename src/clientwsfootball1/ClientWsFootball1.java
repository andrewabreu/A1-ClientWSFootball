package clientwsfootball1;

import eu.dataaccess.footballpool.ArrayOfString;
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
}
