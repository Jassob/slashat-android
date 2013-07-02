package se.slashat.slashapp.async;

import android.os.AsyncTask;
import android.util.Log;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.slashat.slashapp.Callback;
import se.slashat.slashapp.model.LiveEvent;
import se.slashat.slashapp.util.IOUtils;

/**
 * Created by nicklas on 7/2/13.
 */
public class GoogleCalendarLoaderAsyncTask extends AsyncTask<URL, Void, List<LiveEvent>> {
    private Callback<List<LiveEvent>> callback;

    public GoogleCalendarLoaderAsyncTask(Callback<List<LiveEvent>> callback) {

        this.callback = callback;
    }

    @Override
    protected List<LiveEvent> doInBackground(URL... urls) {

        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) urls[0].openConnection();

            connection.setDoOutput(false);
            connection.setRequestMethod("GET");
            connection.connect();

            String jsonString = IOUtils.readStringFromStream(connection.getInputStream());
            JSONObject jsonObject = new JSONObject(jsonString);

            JSONArray items = jsonObject.getJSONArray("items");

            ArrayList<LiveEvent> liveEvents = new ArrayList<LiveEvent>();



            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                liveEvents.add(createEventFromJson(item));
            }

            System.out.println(jsonObject);


            return Collections.unmodifiableList(liveEvents);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                if (connection.getResponseCode() > 200) {
                    Log.e(this.getClass().getName(), IOUtils.readStringFromStream(connection.getErrorStream()));
                }

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;

    }

    private LiveEvent createEventFromJson(JSONObject item) throws JSONException {

        DateTime start = new DateTime(item.getJSONObject("start").getString("dateTime"));
        DateTime end = new DateTime(item.getJSONObject("end").getString("dateTime"));
        String summary = item.getString("summary");

        return new LiveEvent(start,end,summary);
    }

    @Override
    protected void onPostExecute(List<LiveEvent> list) {
        callback.call(list);
    }
}