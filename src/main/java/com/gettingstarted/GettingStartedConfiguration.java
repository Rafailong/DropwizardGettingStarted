package com.gettingstarted;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.*;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by sergionearbpo on 9/8/14.
 */
public class GettingStartedConfiguration extends Configuration {

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Strager";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }
}