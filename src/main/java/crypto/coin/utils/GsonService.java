package crypto.coin.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonService {
    public static GsonService singleton;
    private Gson gson;

    public static GsonService getInstance() {
        if (singleton == null) {
            singleton = new GsonService();
        }
        return singleton;
    }

    public Gson getGsonInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        return gson;
    }
}
