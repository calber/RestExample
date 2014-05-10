package com.example.restexample.app;

import com.googlecode.androidannotations.annotations.rest.Accept;
import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;
import com.googlecode.androidannotations.api.rest.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by calber on 10/5/14.
 */

@Rest(rootUrl = "http://api.openweathermap.org/data/2.5/", converters = {MappingJackson2HttpMessageConverter.class})
public interface JsonApi {

    @Get("weather?q=Genova,it")
    @Accept(MediaType.APPLICATION_JSON)
    abstract Response getResponse();
}
