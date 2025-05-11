/**
 * @author nayara.maisa
 */

package com.naymaisa.api_rick_and_morty.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CharacterResponse {
    private int id;
    private String name;
    private String status;
    private String species;
    private String image;
    private List<String> epiode;
}
