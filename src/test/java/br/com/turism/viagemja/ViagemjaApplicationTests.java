package br.com.turism.viagemja;

import static br.com.turism.viagemja.commum.DestinationConstants.DESTINATION;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.turism.viagemja.models.Destination;
import br.com.turism.viagemja.repositories.DestinationRepository;
import br.com.turism.viagemja.services.DestinationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
class ViagemjaApplicationTests {
	@InjectMocks
	private DestinationService destinationService;

	@Mock
	private DestinationRepository destinationRepository;

	@Test
	public void createDestination_ReturnDestination() {
		Mockito.when(destinationRepository.save(DESTINATION)).thenReturn(DESTINATION);

		// system under test
		Destination place = destinationService.create(DESTINATION);
		System.out.println(place);
		assertThat(place).isEqualTo(DESTINATION);
	}

}
