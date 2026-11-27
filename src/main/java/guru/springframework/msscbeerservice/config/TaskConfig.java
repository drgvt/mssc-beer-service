/*
 * Этот конфигурационный класс включает в Spring поддержку асинхронного выполнения
 * задач (@EnableAsync) и фоновых задач по расписанию (@EnableScheduling — для периодической
 * проверки остатков и запуска варки пива в BrewingService), а также создаёт SimpleAsyncTaskExecutor,
 * чтобы каждая асинхронная задача запускалась в отдельном потоке.
 */

package guru.springframework.msscbeerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by jt on 2019-07-21.
 */
@EnableAsync
@EnableScheduling
@Configuration
public class TaskConfig { // Класс конфигурации фоновых и асинхронных задач

    @Bean // Регистрирует возвращаемый объект в контейнере Spring
    TaskExecutor taskExecutor(){ // Метод создания исполнителя (пула) потоков
        return new SimpleAsyncTaskExecutor(); // Создаёт исполнитель, запускающий каждую задачу в новом отдельном потоке
    }
}
