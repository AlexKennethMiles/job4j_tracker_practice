package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ArticleTest {

    @Test
    public void whenLineGnrTrue() {
        assertThat(
                Article.generateBy(
                        "   Thank you for the warm tea.   ",
                        "Tea  you  for    "
                ),
                is(true)
        );
    }

    @Test
    public void whenLineGnrFalse() {
        assertThat(
                Article.generateBy(
                        "  Thank   you  for  the  warm  tea.  ",
                        "   iced tea"
                ),
                is(false)
        );
    }

    @Test
    public void whenLongTextTrue() {
        assertThat(
                Article.generateBy(
                        "Two roads diverged in a yellow wood, "
                                + "And sorry I could not travel both "
                                + "And be one traveler, long I stood "
                                + "And looked down one as far as I could "
                                + "To where it bent in the undergrowth. "
                                + "Then took the other, as just as fair, "
                                + "And having perhaps the better claim, "
                                + "Because it was grassy and wanted wear; "
                                + "Though as for that the passing there "
                                + "Had worn them really about the same. "
                                + "And both that morning equally lay "
                                + "In leaves no step had trodden black. "
                                + "Oh, I kept the first for another day! "
                                + "Yet knowing how way leads on to way, "
                                + "I doubted if I should ever come back. "
                                + "I shall be telling this with a sigh "
                                + "Somewhere ages and ages hence: "
                                + "Two roads diverged in a wood, and I— "
                                + "I took the one less traveled by, "
                                + "And that has made all the difference. ",
                        "I shall be telling about this day"
                ),
                is(true)
        );
    }

    @Test
    public void whenLongTextFalse() {
        assertThat(
                Article.generateBy(
                        "Two roads diverged in a yellow wood, "
                                + "And sorry I could not travel both "
                                + "And be one traveler, long I stood "
                                + "And looked down one as far as I could "
                                + "To where it bent in the undergrowth. "
                                + "Then took the other, as just as fair, "
                                + "And having perhaps the better claim, "
                                + "Because it was grassy and wanted wear; "
                                + "Though as for that the passing there "
                                + "Had worn them really about the same. "
                                + "And both that morning equally lay "
                                + "In leaves no step had trodden black. "
                                + "Oh, I kept the first for another day! "
                                + "Yet knowing how way leads on to way, "
                                + "I doubted if I should ever come back. "
                                + "I shall be telling this with a sigh "
                                + "Somewhere ages and ages hence: "
                                + "Two roads diverged in a wood, and I— "
                                + "I took the one less traveled by, "
                                + "And that has made all the difference. ",
                        "I shall be telling about mine story"
                ),
                is(false)
        );
    }
}
