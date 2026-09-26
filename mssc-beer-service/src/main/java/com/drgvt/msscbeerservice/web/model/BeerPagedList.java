package com.drgvt.msscbeerservice.web.model;/*
 Created by KonstantinAndrievski on 9/26/2026.
 */

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

// BeerPagedList нужен, чтобы Spring корректно сериализовал страницу с пивом в JSON для любого клиента, в т.ч. Swagger
public class BeerPagedList extends PageImpl<BeerDto> {

    public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPagedList(List<BeerDto> content) {
        super(content);
    }
}
