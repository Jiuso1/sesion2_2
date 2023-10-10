package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sesion2_2.Empleado;

class EmpleadoTest {
    public enum TipoEmpleado {Vendedor, Encargado, Otro};

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("Before All");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("After All");
    }

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("Before Each");
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("After Each");
    }

    @Test
    void testCalculoNominaEncargado() {
    	double expected = 2500 + 200 + 300;
        double actual = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 1700.0, 10.0);
        assertEquals(expected, actual);
    }

    @Test
    void testCalculoNominaVendedor() {
    	double expected = 2000 + 200 + 300;
        double actual = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 1700.0, 10.0);
        assertEquals(expected, actual);
    }

    @Test
    void testCalculoNominaOtro() {
    	double expected = 0 + 200 + 300;
        double actual = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Otro, 1700.0, 10.0);
        assertEquals(expected, actual);
    }

    @Test
    void testCalculoNominaVentasMesNegativas() {
    	double expected = 2500 + 0 + 300;
        double actual = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, -1700.0, 10.0);
        assertEquals(expected, actual);
    }

    @Test
    void testCalculoNominaVentasMesMenorMil() {
    	double expected = 2500 + 0 + 300;
        double actual = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 200.0, 10.0);
        assertEquals(expected, actual);
    }

    @Test
    void testCalculoNominaVentasMesEntreMilYMilQuinientos() {
    	double expected = 2500 + 100 + 300;
        double actual = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 1200.0, 10.0);
        assertEquals(expected, actual);
    }

    @Test
    void testCalculoNominaVentasMesMayorMilQuinientos() {
    	double expected = 2500 + 200 + 300;
        double actual = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 2300.0, 10.0);
        assertEquals(expected, actual);
    }

    @Test
    void testCalculoNominaNeta() {
    	double expected = (double) (3000 * (1 - 0.18));
        double actual = Empleado.calculoNominaNeta(3000);
        assertEquals(expected, actual);
    }
}
