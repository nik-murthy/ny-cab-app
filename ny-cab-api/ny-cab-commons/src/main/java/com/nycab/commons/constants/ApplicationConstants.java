package com.nycab.commons.constants;

public class ApplicationConstants {

    //Web API Controller Mappings
    public static final String WEB_GET_TRIPS_SUMMARY = "/trips/medallions/{medallions}/date/{date}";
    public static final String WEB_GET_TRIPS_SUMMARY_FROM_DB = "/trips/medallions/{medallions}/date/{date}/ignoreCache";

    //DB API Controller Mappings
    public static final String DB_GET_BY_MEDALLIONS_AND_DATE = "/db/medallions";

    //Cache API Controller Mappings
    public static final String CACHE_GET_BY_MEDALLIONS_AND_DATE = "/cache/medallions";

}
