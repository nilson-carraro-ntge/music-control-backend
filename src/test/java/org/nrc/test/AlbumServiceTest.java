package org.nrc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.nrc.repository.AlbumRepository;
import org.nrc.service.AlbumService;

@RunWith(MockitoJUnitRunner.class)
public class AlbumServiceTest {

    @Mock
    private AlbumRepository albumRepository;

    @InjectMocks
    private AlbumService albumService;

    @Test
    public void salvarAlbumTest() {
    }
}