package HiFresh.aankoop.business;

import HiFresh.aankoop.domain.Clausule;
import HiFresh.aankoop.domain.Contract;
import HiFresh.gebruiker.domain.Leverancier;

public class MailService {

    public void sendEmailNotification(Contract contract, Clausule clausule) {
        Leverancier leverancier = contract.getLeverancier();
        String message = String.format(
                "Mail verstuurd naar leverancier \"%s\" met bericht \"Clausule met periode %s, prijs %s werd toegevoegd aan contract %s\"",
                leverancier.getNaam(),
                clausule.getPeriode(),
                clausule.getPrijsAfspraak(),
                contract.getId()
        );
        System.out.println(message);
    }
}
