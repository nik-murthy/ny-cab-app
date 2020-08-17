package com.nycab.redis.api.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nycab.commons.constants.ApplicationConstants;
import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.commons.request.UriRequest;
import com.nycab.commons.util.JsonConverter;
import com.nycab.commons.util.UriHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

import java.util.*;

//@Component
public class NyCabCacheImpl implements NyCabCacheIntf {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private JsonConverter jsonConverter;

    @Autowired
    private UriHelper uriHelper;

    @Value("${db.api.url}")
    private String dbApiUrl;

    @Value("${nycab.redis.url}")
    private String redisHost;

    @Value(("${nycab.redis.port}"))
    private Integer redisPort;

    @Value("${nycab.redis.password")
    private String redisPassword;

    @Override
    public List<CabTripDataResponse> getByMedallionAndDate(String medallions, String date) {

        String cachedValue = redisTemplate.opsForValue().get(medallions.concat(date));
        if(cachedValue == null || cachedValue.isEmpty()) {
            List<CabTripDataResponse> cabTripDataResponses =
                    getByMedallionAndDateFromDb(medallions, date);
            try {
                redisTemplate.opsForValue().set(medallions.concat(date),
                        jsonConverter.getString(cabTripDataResponses));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            return cabTripDataResponses;
        } else {
            try {
                return jsonConverter.getJson(cachedValue);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return getByMedallionAndDateFromDb(medallions, date);
            }
        }
    }

    @Override
    public boolean clearCache() {
        JedisShardInfo jedisShardInfo = new JedisShardInfo(redisHost, redisPort);
        jedisShardInfo.setUser("default");
        jedisShardInfo.setPassword(redisPassword);
        Jedis jedis =  new Jedis(jedisShardInfo);
        jedis.connect();
        jedis.flushAll();
        return true;
    }

    private List<CabTripDataResponse> getByMedallionAndDateFromDb(String medallions, String date) {
        Map<String, Object> params = new HashMap<>();

        params.put("date", date);
        params.put("medallions", medallions);

        CabTripDataResponse[] trips = (CabTripDataResponse[]) uriHelper.getFromUri(
                UriRequest.of(dbApiUrl,
                        ApplicationConstants.DB_GET_BY_MEDALLIONS_AND_DATE,
                        CabTripDataResponse[].class,
                        HttpMethod.GET,
                        Optional.of(params))).getBody();

        return Arrays.asList(trips);
    }
}
