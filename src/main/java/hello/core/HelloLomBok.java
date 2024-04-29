package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLomBok
{
    private String name;
    private int age;

    public static void main(String[] args)
    {
        HelloLomBok helloLomBok = new HelloLomBok();
        helloLomBok.setName("agsadf");

        System.out.println(helloLomBok);
    }

}
