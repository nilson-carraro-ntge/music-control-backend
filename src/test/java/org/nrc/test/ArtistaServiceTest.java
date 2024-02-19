package org.nrc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.nrc.repository.ArtistaRepository;
import org.nrc.service.ArtistaService;

@RunWith(MockitoJUnitRunner.class)
public class ArtistaServiceTest {

    @Mock
    private ArtistaRepository artistaRepository;

    @InjectMocks
    private ArtistaService artistaService;

    @Test
    public void salvarArtistaTest() {
    }
}
