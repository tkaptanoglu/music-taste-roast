package com.github.tkaptanoglu.musicroast;

import com.github.tkaptanoglu.musicroast.domain.Artist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArtistTest {

    @Test
    void recordStoresValuesCorrectly() {
        Artist a = new Artist("Metallica", 12345, "some-mbid");
        assertEquals("Metallica", a.name());
        assertEquals(12345, a.playcount());
        assertEquals("some-mbid", a.mbid());
    }
}
