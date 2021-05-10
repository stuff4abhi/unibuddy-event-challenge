package com.unibuddy.event.helpers;

public enum Urls {
    HOME("https://events-staging.unibuddy.co/your-university/my-first-event/"),
    REGISTRATION_MAIN("https://events-staging.unibuddy.co/your-university/my-first-event/auth/register"),
    REGISTRATION_SECOND("https://events-staging.unibuddy.co/your-university/my-first-event/auth/register2"),
    LOGIN("https://events-staging.unibuddy.co/your-university/my-first-event/auth/login"),
    RESET_PASSWORD("https://events-staging.unibuddy.co/your-university/my-first-event/auth/reset");

    private String url;

    Urls(String url) {
        this.url = url;
    }

    public String getValue(){
        return this.url;
    }
}
