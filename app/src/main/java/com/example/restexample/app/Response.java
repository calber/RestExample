package com.example.restexample.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by calber on 10/5/14.
 */


@JsonIgnoreProperties(ignoreUnknown=true)
public class Response {


    @JsonProperty
    String base;

    @JsonProperty
    String name;
}
