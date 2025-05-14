package com.example;

import java.util.List;

public interface Predator {

    List<String> eatMeat() throws Exception;

    Object getKittens();
}
//mvn test - запуск тестов
//После этого отчёт о покрытии кода появится здесь:
//qa_java/target/site/jacoco/index.html