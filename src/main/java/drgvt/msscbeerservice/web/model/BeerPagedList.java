package drgvt.msscbeerservice.web.model;/*
 Created by KonstantinAndrievski on 9/26/2026.
 */

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tools.jackson.databind.JsonNode;

import java.util.List;

// В современных версиях Spring (Spring Data 3+) и при использовании Jackson 3 — смысла
// в этом классе практически нет, так как Spring Data умеет корректно сериализовать Page
// и Slice в JSON «из коробки» без кастомных оберток.
public class BeerPagedList extends PageImpl<BeerDto> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BeerPagedList(@JsonProperty("content") List<BeerDto> content,
                         @JsonProperty("number") int number,
                         @JsonProperty("size") int size,
                         @JsonProperty("totalElements") Long totalElements,
                         @JsonProperty("pageable") JsonNode pageable,
                         @JsonProperty("last") boolean last,
                         @JsonProperty("totalPages") int totalPages,
                         @JsonProperty("sort") JsonNode sort,
                         @JsonProperty("first") boolean first,
                         @JsonProperty("numberOfElements") int numberOfElements) {

        super(content, PageRequest.of(number, size), totalElements);
    }

    public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPagedList(List<BeerDto> content) {
        super(content);
    }
}
