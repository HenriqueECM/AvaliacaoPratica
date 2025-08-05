package utils;

import java.time.LocalDate;

public class Validador {
    public static boolean validarTitulo(String titulo){
        return titulo != null && !titulo.trim().isEmpty();

    }
    
    public static boolean validarData(LocalDate data){
        return data != null && !data.isBefore(LocalDate.now());
    }
}
