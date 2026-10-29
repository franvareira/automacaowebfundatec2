package Framework.Utils;

import net.datafaker.Faker;

import java.text.Normalizer;
import java.util.Locale;

public class FakersGeneration {

    private Faker faker;
    private String fisrtName;
    private String lastName;
    private String zipCode;
    private String email;

    public FakersGeneration (){

        faker = new Faker(new Locale("pt-BR"));
    }

    public static String removerAcentos(String texto) {
        return Normalizer
                .normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }

    public String getFisrtName(){

        fisrtName = removerAcentos(faker.name().firstName());
        return fisrtName;

       // return faker.name().firstName();
    }

    public String getLastName(){

        lastName = removerAcentos(faker.name().lastName());
        return lastName;
    }

    public String getZipCode(){

        zipCode = faker.address().zipCode();
        return zipCode;
    }

    public String getEmail(){

        email = faker.internet().emailAddress();
        return email;
    }



}
