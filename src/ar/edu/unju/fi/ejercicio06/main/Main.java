package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {
    public static void main(String[] args) {
        FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
        Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());

        FelinoSalvaje felino1 = converter.convert(gato);
        converter.mostrarObjeto(felino1);

        // Conversión de Felino Salvaje a Doméstico
        FelinoSalvaje salvaje = new FelinoSalvaje("Tanner", (byte)20, 186f);
        if (Converter.isNotNull(salvaje)) {
            Converter<FelinoSalvaje, FelinoDomestico> reverseConverter = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
            FelinoDomestico domestico = reverseConverter.convert(salvaje);
            reverseConverter.mostrarObjeto(domestico);
        }
    }
}
