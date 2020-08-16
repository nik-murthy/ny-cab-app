package com.nycab.commons.constants;

public class ApplicationConstants {

    //Web API Controller Mappings
    public static final String WEB_GET_BY_MEDALLION = "/medallion/{medallion}";
    public static final String WEB_GET_BY_MEDALLION_AND_DATE = "/medallion/{medallion}/date/{date}";

    //DB API Controller Mappings
    public static final String DB_GET_BY_MEDALLION = "/db/medallion";
    public static final String DB_GET_BY_MEDALLION_AND_DATE = "/db/";
}
