
package com.mytrendin.jaksonlibrary;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "colorName",
    "hexValue"
})
public class ColorsArray {

    @JsonProperty("colorName")
    private String colorName;
    @JsonProperty("hexValue")
    private String hexValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("colorName")
    public String getColorName() {
        return colorName;
    }

    @JsonProperty("colorName")
    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @JsonProperty("hexValue")
    public String getHexValue() {
        return hexValue;
    }

    @JsonProperty("hexValue")
    public void setHexValue(String hexValue) {
        this.hexValue = hexValue;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
