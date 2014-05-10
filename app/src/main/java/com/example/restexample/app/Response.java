package com.example.restexample.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;

/**
 * Created by calber on 10/5/14.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {


    @DatabaseField(generatedId = true)
    Long id;

    @JsonProperty
    @DatabaseField
    String base;

    @JsonProperty
    @DatabaseField
    String name;
}
