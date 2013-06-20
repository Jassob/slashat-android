package se.slashat.slashapp.service;

import se.slashat.slashapp.R;
import se.slashat.slashapp.model.Personal;
import se.slashat.slashapp.model.Personal.Type;

public class PersonalService {

    public static Personal[] getPersonal(Type type) {

        // Create static entries for every person.

        if (type == Type.HOST) {
            Personal[] personal = new Personal[2];

            personal[0] = new Personal("Jezper S�derlund", "PROGRAMLEDARE", Type.HOST, R.drawable.jezper, "kontakt@jezper.se", "jezperse", "http://www.jezper.se",
                    "En glad och bekv�m herre, �rsmodell 1980. Jobbar som originalare men �r ocks� aktiv inom dansmusikscenen som producenten och DJ:n Airbase."
                            + "\n\nHan spenderar orimligt mycket tid framf�r datorer och har numer helt och h�llet l�mnat PC-land f�r en hundraprocentig Apple-milj�."
                            + "N�gra Linux-dojor har han aldrig velat ha. Intresset f�r datorer och teknik har h�ngt med sedan Amiga 500:an."
                            + "\n\n�vriga intressen innefattar musik, film, resor, gott �l och vin, motorcyklar, golf och egentligen allt som h�r livsnjutning till.");

            personal[1] = new Personal(
                    "Tommie Podzemski",
                    "PROGRAMLEDARE",
                    Type.HOST,
                    R.drawable.tommie,
                    "tommie@tommie.nu",
                    "tommienu",
                    "http://www.tommie.nu",
                    "Tommie en tj�tig och sportig serie-entrepren�r med visst huvud f�r kod."
                            + "Vilket allt som oftast inneb�r att Tommie f�r en id� p� fredagen, spenderar hela helgen p� att koda den f�r att sedan l�gga ner allt p� m�ndagen."
                            + "\n\nK�r uteslutande PC (Ubuntu och Windows), och �r vad man kallar en Android-fanboy."
                            + "\n\nHan har en viss f�rk�rlek till att pyssla med linux-k�rror och jobbar som IT-ansvarig p� ett medelstort svenskt f�retag och s�ger s�llan, t.om aldrig, nej till en �l.");
            return personal;
        }
        if (type == Type.ASSISTANT){
            Personal[] personal = new Personal[2];
            personal[0] = new Personal("Magnus Jonasson", "FORUMGENERAL", Type.ASSISTANT, R.drawable.magnus, "magnus@magnusjonasson.com", "magnusjonasson", "http://www.magnusjonasson.com",
                    "Killen som drar upp medel�ldern p� Slashat-redaktionen d� han �r den enda i g�nget som �r f�dd p� 70-talet."
                            + "\n\nMagnus jobbar till vardags som IT-tekniker och konsult med aff�rssystem och Windows Server-milj�er som specialitet, men f�redrar faktiskt Mac privat."
                            + "\n\nBeskriver sig sj�lv som en pryln�rd och �r alltid hungrig p� nya prylar att integrera med sitt digitala liv."
                            + "\n\nF�rutom teknik s� har en k�rlek till matlagning har funnits l�nge och inte mycket sl�r hemlagat med en kall �l till. Eller tv�.");
            personal[1] = new Personal(
                    "Johan Larsson",
                    "KOTTRAGEAR OCH APPUTVECKLING",
                    Type.ASSISTANT,
                    R.drawable.johan,
                    "johan@johanl.se",
                    "kottkrig",
                    "http://johanl.se",
                    "�lskar allt som �r interaktivt. Utvecklar till vardags multimediaproduktioner och till s�ngdags s� utvecklar jag annat sm�tt och gott."
                            + "\n\n�r biOS s� jag anv�nder (och utvecklar) lika g�rna med Android som iOS. Det finns styrkor och svagheter med allt men jag f�rs�ker att anv�nda det som k�nns mest sp�nnande f�r stunden."
                            + "\n\nArbetar hellre i OS X och Linux �n i Windows n�r jag vill vara produktiv. Anv�nder hellre Windows �n annat n�r det kommer till lek & spel.");
            return personal;
        }

        if (type == Type.DEV) {
            Personal[] personal = new Personal[1];
            personal[0] = new Personal("Nicklas L�f", "APPUTVECKLING", Type.DEV, R.drawable.nicklas, "nicklaslof76@gmail.com", "nicklas.lof", "http://www.soundcloud.com/snukey/",
                    "Blah blahblahlbhal bahbl ahab halb labh");

            return personal;
        }

        return new Personal[0];

    }

}
