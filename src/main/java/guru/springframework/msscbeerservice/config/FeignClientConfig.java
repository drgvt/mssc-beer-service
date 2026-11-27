/*
 * Этот класс настраивает базовую аутентификацию (Basic Auth) для Feign-клиентов:
 * он берет логин и пароль из конфигурации (свойства sfg.brewery.inventory-user и
 * inventory-password) и создает бин BasicAuthRequestInterceptor, который автоматически
 * добавляет заголовок Authorization с закодированными учетными данными в каждый
 * исходящий HTTP-запрос, чтобы ваш микросервис мог успешно авторизоваться при обращении к
 * защищенному API другого сервиса (например, сервиса инвентаризации)
 */
package guru.springframework.msscbeerservice.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jt on 5/16/20.
 */
@Configuration
public class FeignClientConfig {

    @Bean
    // объявление метода, который возвращает перехватчик для Basic Auth
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor( @Value("${sfg.brewery.inventory-user}") String inventoryUser, // подставлено из ${sfg.brewery.inventory-user} - сработала функция «сворачивания» (Code Folding) в IntelliJ IDEA
                                                                    @Value("${sfg.brewery.inventory-password}")String inventoryPassword){ // подставлено из ${sfg.brewery.inventory-password}
        return new BasicAuthRequestInterceptor(inventoryUser, inventoryPassword); // создает и возвращает экземпляр перехватчика, который будет автоматически добавлять логин и пароль в заголовки всех запросов Feign
    }
}
