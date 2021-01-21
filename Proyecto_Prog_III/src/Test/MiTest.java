package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import BaseDatos.BD;
import Datos.TieneCod;
import Datos.Usuario;
import Datos.Visita;

class MiTest {

	@Test
	void testAniadirUsuario() {
		BD.anyadirUsuario(new Usuario("Z", "Z", "Z@Z.com"));
		Usuario u = BD.obtenerUsuario("Z");
		assertNotNull(u);
		assertEquals("Z", u.getUsuario());
	}
	@Test
	void testGenerarCodigosNoRepetidos() {
		Visita v = new Visita("Guggemheim", "Bilbao", 5, 10, 60);
		assertFalse(BD.existeVisita(v.getCodigo()));
	}

}
