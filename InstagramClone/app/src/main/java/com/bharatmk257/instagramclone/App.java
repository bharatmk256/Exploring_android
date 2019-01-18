package com.bharatmk257.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("YVGOYzTivmIV5cJMdUnCpJtpIq5UvJ1XLkXx7xKn")
                // if defined
                .clientKey("0UQiUQnK3rBjxwoxhyiwp0l3Cp0y7WRoXww4jd5Z")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
