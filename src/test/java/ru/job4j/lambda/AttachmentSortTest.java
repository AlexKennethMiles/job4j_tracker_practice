package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AttachmentSortTest {
//    @Test
//    public void whenSimpleAbstractComparatorForSize() {
//        List<Attachment> attachments = new ArrayList<>(Arrays.asList(
//                new Attachment("image 3", 13),
//                new Attachment("image 1", 100),
//                new Attachment("image 2", 34))
//        );
//        List<Attachment> expected = new ArrayList<>(Arrays.asList(
//                new Attachment("image 3", 13),
//                new Attachment("image 2", 34),
//                new Attachment("image 1", 100))
//        );
//        Comparator comparator = new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Attachment left = (Attachment) o1;
//                Attachment right = (Attachment) o2;
//                return left.getSize() - right.getSize();
//            }
//        };
//        attachments.sort(comparator);
//        assertThat(attachments, is(expected));
//    }
//
//    @Test
//    public void whenGeneralizedAbstractComparatorForName() {
//        List<Attachment> attachments = new ArrayList<>(Arrays.asList(
//                new Attachment("image 3", 79),
//                new Attachment("image 1", 42),
//                new Attachment("image 2", 34))
//        );
//        List<Attachment> expected = Arrays.asList(
//                new Attachment("image 1", 42),
//                new Attachment("image 2", 34),
//                new Attachment("image 3", 79)
//        );
//        Comparator comparatorGen = new Comparator<Attachment>() {
//            @Override
//            public int compare(Attachment o1, Attachment o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        };
//        attachments.sort(comparatorGen);
//        assertThat(attachments, is(expected));
//    }
}
