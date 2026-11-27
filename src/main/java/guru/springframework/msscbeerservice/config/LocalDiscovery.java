/*
 * Этот конфигурационный класс включает регистрацию микросервиса в реестре Eureka (@EnableDiscoveryClient),
 * но делает это только тогда, когда приложение запущено с активным Spring-профилем local-discovery
 * (чтобы при обычном локальном запуске или в тестах сервис не падал от отсутствия работающего сервера Eureka).
 *
 * «Локальное обнаружение сервисов» означает, что микросервисы находят друг друга через реестр Eureka,
 * запущенный прямо на вашем компьютере (localhost:8761), а его антонимом в этом курсе является работа без
 * обнаружения сервисов (по жёстко прописанным URL в application.properties, когда профиль local-discovery выключен)
 * или облачное/контейнерное обнаружение (в Docker Compose или Kubernetes, где используются имена
 * контейнеров/сервисов вместо localhost).
 */

package guru.springframework.msscbeerservice.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by jt on 3/7/20.
 */
@Profile("local-discovery")
@EnableDiscoveryClient
@Configuration
public class LocalDiscovery {
}
