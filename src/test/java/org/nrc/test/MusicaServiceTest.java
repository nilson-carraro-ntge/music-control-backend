package org.nrc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.nrc.repository.MusicaRepository;
import org.nrc.service.MusicaService;

@RunWith(MockitoJUnitRunner.class)
public class MusicaServiceTest {

    @Mock
    private MusicaRepository musicaRepository;

    @InjectMocks
    private MusicaService musicaService;

    @Test
    public void salvarMusicaTest() {
    }
}