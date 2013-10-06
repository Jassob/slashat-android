package se.slashat.slashapp.service;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import se.slashat.slashapp.model.highfive.HighFivedBy;
import se.slashat.slashapp.model.highfive.HighFiver;
import se.slashat.slashapp.model.highfive.User;
import se.slashat.slashapp.util.Network;

import static se.slashat.slashapp.Constants.HIGHFIVE_ALL;
import static se.slashat.slashapp.Constants.HIGHFIVE_BASE_URL;
import static se.slashat.slashapp.Constants.HIGHFIVE_DO;
import static se.slashat.slashapp.Constants.HIGHFIVE_GET_MY_HIGHFIVES;
import static se.slashat.slashapp.Constants.HIGHFIVE_LOGIN_TO_SERVICE;
import static se.slashat.slashapp.Constants.HIGHFIVE_REGISTER_TO_SERVICE;

/**
 * Created by nicklas on 9/28/13.
 */
public class HighFiveService {

    private final static String LOGIN_TO_SERVICE = HIGHFIVE_BASE_URL + "/" + HIGHFIVE_LOGIN_TO_SERVICE;

    private final static String REGISTER_TO_SERVICE = HIGHFIVE_BASE_URL + "/" + HIGHFIVE_REGISTER_TO_SERVICE;

    private final static String GET_MY_HIGHFIVES = HIGHFIVE_BASE_URL + "/" + HIGHFIVE_GET_MY_HIGHFIVES;

    private final static String ALL = HIGHFIVE_BASE_URL + "/" + HIGHFIVE_ALL;

    private final static String DO = HIGHFIVE_BASE_URL + "/" + HIGHFIVE_DO;


    // Must be called async
    public static User getUser() {
        boolean networkAvailable = Network.isNetworkAvailable();


        if (networkAvailable) {
            User user = parseUserFromJson();
            return user;
        }
        return null;
    }

    public static Collection<HighFiver> getAllHighfivers() {
        List<HighFiver> highFivers = new ArrayList<HighFiver>();
        try {

            highFivers.add(new HighFiver("Nicklas Löf", "123", "Smiley", new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg")));
            highFivers.add(new HighFiver("Tommie Podzemski", "456", "Tommienu", new URL("http://forum.slashat.se/download/file.php?avatar=53_1379446237.png")));
            highFivers.add(new HighFiver("Jezper Söderlund", "789", "Jezper", new URL("http://forum.slashat.se/download/file.php?avatar=54_1371413866.png")));
            highFivers.add(new HighFiver("Magnus Jonasson", "987", "Jonasson", new URL("http://forum.slashat.se/download/file.php?avatar=66_1368392108.jpg")));
            highFivers.add(new HighFiver("Johan Larsson", "654", "Kottkrig", new URL("http://forum.slashat.se/download/file.php?avatar=78_1279716572.jpg")));
            highFivers.add(new HighFiver("Nicklas Löf", "123", "Smiley", new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg")));
            highFivers.add(new HighFiver("Tommie Podzemski", "456", "Tommienu", new URL("http://forum.slashat.se/download/file.php?avatar=53_1379446237.png")));
            highFivers.add(new HighFiver("Jezper Söderlund", "789", "Jezper", new URL("http://forum.slashat.se/download/file.php?avatar=54_1371413866.png")));
            highFivers.add(new HighFiver("Magnus Jonasson", "987", "Jonasson", new URL("http://forum.slashat.se/download/file.php?avatar=66_1368392108.jpg")));
            highFivers.add(new HighFiver("Johan Larsson", "654", "Kottkrig", new URL("http://forum.slashat.se/download/file.php?avatar=78_1279716572.jpg")));
            highFivers.add(new HighFiver("Nicklas Löf", "123", "Smiley", new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg")));
            highFivers.add(new HighFiver("Tommie Podzemski", "456", "Tommienu", new URL("http://forum.slashat.se/download/file.php?avatar=53_1379446237.png")));
            highFivers.add(new HighFiver("Jezper Söderlund", "789", "Jezper", new URL("http://forum.slashat.se/download/file.php?avatar=54_1371413866.png")));
            highFivers.add(new HighFiver("Magnus Jonasson", "987", "Jonasson", new URL("http://forum.slashat.se/download/file.php?avatar=66_1368392108.jpg")));
            highFivers.add(new HighFiver("Johan Larsson", "654", "Kottkrig", new URL("http://forum.slashat.se/download/file.php?avatar=78_1279716572.jpg")));
            highFivers.add(new HighFiver("Nicklas Löf", "123", "Smiley", new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg")));
            highFivers.add(new HighFiver("Tommie Podzemski", "456", "Tommienu", new URL("http://forum.slashat.se/download/file.php?avatar=53_1379446237.png")));
            highFivers.add(new HighFiver("Jezper Söderlund", "789", "Jezper", new URL("http://forum.slashat.se/download/file.php?avatar=54_1371413866.png")));
            highFivers.add(new HighFiver("Magnus Jonasson", "987", "Jonasson", new URL("http://forum.slashat.se/download/file.php?avatar=66_1368392108.jpg")));
            highFivers.add(new HighFiver("Johan Larsson", "654", "Kottkrig", new URL("http://forum.slashat.se/download/file.php?avatar=78_1279716572.jpg")));
            highFivers.add(new HighFiver("Nicklas Löf", "123", "Smiley", new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg")));
            highFivers.add(new HighFiver("Tommie Podzemski", "456", "Tommienu", new URL("http://forum.slashat.se/download/file.php?avatar=53_1379446237.png")));
            highFivers.add(new HighFiver("Jezper Söderlund", "789", "Jezper", new URL("http://forum.slashat.se/download/file.php?avatar=54_1371413866.png")));
            highFivers.add(new HighFiver("Magnus Jonasson", "987", "Jonasson", new URL("http://forum.slashat.se/download/file.php?avatar=66_1368392108.jpg")));
            highFivers.add(new HighFiver("Johan Larsson", "654", "Kottkrig", new URL("http://forum.slashat.se/download/file.php?avatar=78_1279716572.jpg")));
            highFivers.add(new HighFiver("Nicklas Löf", "123", "Smiley", new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg")));
            highFivers.add(new HighFiver("Tommie Podzemski", "456", "Tommienu", new URL("http://forum.slashat.se/download/file.php?avatar=53_1379446237.png")));
            highFivers.add(new HighFiver("Jezper Söderlund", "789", "Jezper", new URL("http://forum.slashat.se/download/file.php?avatar=54_1371413866.png")));
            highFivers.add(new HighFiver("Magnus Jonasson", "987", "Jonasson", new URL("http://forum.slashat.se/download/file.php?avatar=66_1368392108.jpg")));
            highFivers.add(new HighFiver("Johan Larsson", "654", "Kottkrig", new URL("http://forum.slashat.se/download/file.php?avatar=78_1279716572.jpg")));
            highFivers.add(new HighFiver("Nicklas Löf", "123", "Smiley", new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg")));
            highFivers.add(new HighFiver("Tommie Podzemski", "456", "Tommienu", new URL("http://forum.slashat.se/download/file.php?avatar=53_1379446237.png")));
            highFivers.add(new HighFiver("Jezper Söderlund", "789", "Jezper", new URL("http://forum.slashat.se/download/file.php?avatar=54_1371413866.png")));
            highFivers.add(new HighFiver("Magnus Jonasson", "987", "Jonasson", new URL("http://forum.slashat.se/download/file.php?avatar=66_1368392108.jpg")));
            highFivers.add(new HighFiver("Johan Larsson", "654", "Kottkrig", new URL("http://forum.slashat.se/download/file.php?avatar=78_1279716572.jpg")));
            highFivers.add(new HighFiver("Nicklas Löf", "123", "Smiley", new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg")));
            highFivers.add(new HighFiver("Tommie Podzemski", "456", "Tommienu", new URL("http://forum.slashat.se/download/file.php?avatar=53_1379446237.png")));
            highFivers.add(new HighFiver("Jezper Söderlund", "789", "Jezper", new URL("http://forum.slashat.se/download/file.php?avatar=54_1371413866.png")));
            highFivers.add(new HighFiver("Magnus Jonasson", "987", "Jonasson", new URL("http://forum.slashat.se/download/file.php?avatar=66_1368392108.jpg")));
            highFivers.add(new HighFiver("Johan Larsson", "654", "Kottkrig", new URL("http://forum.slashat.se/download/file.php?avatar=78_1279716572.jpg")));
            highFivers.add(new HighFiver("Nicklas Löf", "123", "Smiley", new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg")));
            highFivers.add(new HighFiver("Tommie Podzemski", "456", "Tommienu", new URL("http://forum.slashat.se/download/file.php?avatar=53_1379446237.png")));
            highFivers.add(new HighFiver("Jezper Söderlund", "789", "Jezper", new URL("http://forum.slashat.se/download/file.php?avatar=54_1371413866.png")));
            highFivers.add(new HighFiver("Magnus Jonasson", "987", "Jonasson", new URL("http://forum.slashat.se/download/file.php?avatar=66_1368392108.jpg")));
            highFivers.add(new HighFiver("Johan Larsson", "654", "Kottkrig", new URL("http://forum.slashat.se/download/file.php?avatar=78_1279716572.jpg")));
            highFivers.add(new HighFiver("Nicklas Löf", "123", "Smiley", new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg")));
            highFivers.add(new HighFiver("Tommie Podzemski", "456", "Tommienu", new URL("http://forum.slashat.se/download/file.php?avatar=53_1379446237.png")));
            highFivers.add(new HighFiver("Jezper Söderlund", "789", "Jezper", new URL("http://forum.slashat.se/download/file.php?avatar=54_1371413866.png")));
            highFivers.add(new HighFiver("Magnus Jonasson", "987", "Jonasson", new URL("http://forum.slashat.se/download/file.php?avatar=66_1368392108.jpg")));
            highFivers.add(new HighFiver("Johan Larsson", "654", "Kottkrig", new URL("http://forum.slashat.se/download/file.php?avatar=78_1279716572.jpg")));
            highFivers.add(new HighFiver("Nicklas Löf", "123", "Smiley", new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg")));
            highFivers.add(new HighFiver("Tommie Podzemski", "456", "Tommienu", new URL("http://forum.slashat.se/download/file.php?avatar=53_1379446237.png")));
            highFivers.add(new HighFiver("Jezper Söderlund", "789", "Jezper", new URL("http://forum.slashat.se/download/file.php?avatar=54_1371413866.png")));
            highFivers.add(new HighFiver("Magnus Jonasson", "987", "Jonasson", new URL("http://forum.slashat.se/download/file.php?avatar=66_1368392108.jpg")));
            highFivers.add(new HighFiver("Johan Larsson", "654", "Kottkrig", new URL("http://forum.slashat.se/download/file.php?avatar=78_1279716572.jpg")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return highFivers;
    }

    private static User parseUserFromJson() {
        try {
            // Mock HighFivedBy:
            HighFivedBy highFivedBy = new HighFivedBy("Nicklas Löf", new Date(), "Uppsala");
            // Mock HighFiver:

            Collection<HighFiver> highFivers = getAllHighfivers();

            // Mock user:
            return new User("Nicklas Löf", "123", "smiley", highFivedBy, new URL("http://forum.slashat.se/download/file.php?avatar=1197_1372799107.jpg"), new URL("http://qrcode"), highFivers);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}