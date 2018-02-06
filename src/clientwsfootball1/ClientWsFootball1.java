package clientwsfootball1;

public class ClientWsFootball1 {

    public static void main(String[] args) {
        System.out.println("Número de tarjetas amarillas: " + yellowCardsTotal());
        System.out.println("");
    }

    private static int yellowCardsTotal() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap12();
        return port.yellowCardsTotal();
    }
}
