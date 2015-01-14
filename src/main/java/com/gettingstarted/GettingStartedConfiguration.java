package com.gettingstarted;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.*;
import org.hibernate.validator.constraints.NotEmpty;

public class GettingStartedConfiguration extends Configuration {

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Strager";

    private Long healtChecksPort;

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

    @JsonProperty
    public void setHealtChecksPort(Long port) {
        this.healtChecksPort = port;
    }

    @JsonProperty
    public Long getHealtChecksPort() {
        return this.healtChecksPort;
    }
}
