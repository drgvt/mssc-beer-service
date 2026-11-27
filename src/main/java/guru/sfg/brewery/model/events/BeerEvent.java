package guru.sfg.brewery.model.events;

import guru.sfg.brewery.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by jt on 2019-07-21.
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

    /*
     * serialVersionUID нужен как штамп версии класса, чтобы при стандартной бинарной сериализации
     * Java получатель мог убедиться в совместимости структуры класса и не упасть с ошибкой
     * InvalidClassException, а сгенерировал его сам автор курса в IntelliJ IDEA на этапе написания
     * этого класса (хотя при используемой здесь JSON-сериализации через Jackson это поле фактически не задействуется)
     */
    static final long serialVersionUID = -5781515597148163111L;

    private BeerDto beerDto;
}
