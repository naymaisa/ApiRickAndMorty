/**
 * @author nayara.maisa
 */

package com.naymaisa.api_rick_and_morty.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@Data
public class EpisodeResponse {

    private int id;
    private String name;
    private String air_date;
    private String episode;
    private List<String> characters;
    private String url;

}
