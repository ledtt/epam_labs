package com.example.epam_java; //определение пакета

//импорт классов из библиотеки Spring Framework
import org.springframework.boot.SpringApplication; //класс содержит статический метод run() для запуска приложения
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping; //
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication //аннотация для добавления автоконфигурации и настройки String
@RestController //класс является контроллером, который будет обрабатывать HTTP-запросы
public class EpamJavaApplication {
    public static void main(String[] args) {  //метод, запускающий приложение
        SpringApplication.run(EpamJavaApplication.class, args);
    }

    @GetMapping("/solveEquation") //аннотация HTTP-метода GET
    //получение параметров из запроса
    public String solveEquation(@RequestParam(value = "a") double a,
                                @RequestParam(value = "b") double b,
                                @RequestParam(value = "start") double start,
                                @RequestParam(value = "end") double end) {
    //вычисления
        double x = start;
        double epsilon = 0.0001;

        while (x <= end) {
            double y = x + a;
            if (Math.abs(y - b) < epsilon) {
                return String.format("x=%.4f", x); //возвращение ответа
            }
            x += epsilon;
        }

        return "No solution found";
    }
}
