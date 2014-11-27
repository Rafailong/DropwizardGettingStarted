package com.gettingstarted;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by sergionearbpo on 9/8/14.
 */
public class Saying {

    private long id;

    @Length(max = 3)
    private String content;

    public Saying(String content, long id) {
        this.content = content;
        this.id = id;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
