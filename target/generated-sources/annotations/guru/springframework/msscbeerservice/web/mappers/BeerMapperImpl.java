package guru.springframework.msscbeerservice.web.mappers;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-11-24T14:02:16+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21 (Amazon.com Inc.)"
)
public class BeerMapperImpl extends BeerMapperDecorator {

    private final BeerMapper delegate;

    public BeerMapperImpl() {
        this( new BeerMapperImpl_() );
    }

    private BeerMapperImpl(BeerMapperImpl_ delegate) {
        this.delegate = delegate;
    }
}
