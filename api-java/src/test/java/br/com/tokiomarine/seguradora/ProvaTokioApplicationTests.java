package br.com.tokiomarine.seguradora;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tokiomarine.seguradora.consumer.ViaCepConsumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvaTokioApplicationTests {

	@Test
	public void contextLoads() {
		String cep = "03738260";
		var cepObj = ViaCepConsumer.fetchByPostalCode(cep);

		assertEquals(cepObj.getCep(), cep);
	}

}
