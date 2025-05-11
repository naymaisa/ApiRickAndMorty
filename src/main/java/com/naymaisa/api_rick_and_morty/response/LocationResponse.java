/**
 * @author nayara.maisa
 */

package com.naymaisa.api_rick_and_morty.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LocationResponse {
    private int id;
    private String name;
    private String type;
    private List<String> residents;
    private String url;
}
