package com.distribuida.test;

import com.distribuida.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp(){
        cliente = new Cliente(1,"1755571872","Katherine","Aguirre","Tababela","0967865057","klac2504@gmail.com");
    }

    @Test
    public void testclienteConstructorAndGetter(){
        assertAll("Validar datos cliente",
                () -> assertEquals(1, cliente.getIdCliente()),
                () -> assertEquals("1755571872", cliente.getCedula()),
                () -> assertEquals("Katherine", cliente.getNombre()),
                () -> assertEquals("Aguirre", cliente.getApellido()),
                () -> assertEquals("Tababela", cliente.getDireccion()),
                () -> assertEquals("0967865057", cliente.getTelefono()),
                () -> assertEquals("klac2504@gmail.com", cliente.getCorreo())
        );
    }

    @Test
    public void testClienteSetters(){
        cliente = new Cliente();

        cliente.setIdCliente(3);
        cliente.setCedula("1755571872");
        cliente.setNombre("Katherine");
        cliente.setApellido("Aguirre");
        cliente.setDireccion("Tababela");
        cliente.setTelefono("0967865057");
        cliente.setCorreo("klac2504@gmail.com");

        assertAll("Validar datos cliente ",
                () -> assertEquals(3,cliente.getIdCliente()),
                () -> assertEquals("1755571872",cliente.getCedula()),
                () -> assertEquals("Katherine",cliente.getNombre()),
                () -> assertEquals("Aguirre",cliente.getApellido()),
                () -> assertEquals("Tababela",cliente.getDireccion()),
                () -> assertEquals("0967865057",cliente.getTelefono()),
                () -> assertEquals("klac2504@gmail.com",cliente.getCorreo())
        );
    }

    @Test
    public void TestToString(){
        String str = cliente.toString();
        assertAll("Validar datos de cliente",
                () -> assertTrue(str.contains("2")),
                () -> assertTrue(str.contains("1755571872")),
                () -> assertTrue(str.contains("Katherine")),
                () -> assertTrue(str.contains("Aguirre")),
                () -> assertTrue(str.contains("Tababela")),
                () -> assertTrue(str.contains("0967865057")),
                () -> assertTrue(str.contains("klac2504@gmail.com"))
        );


    }
}
