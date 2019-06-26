package cc.oobootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthTest {

    @Test
    void should_indicate_the_larger_length_when_compare_larger_length_to_the_shorter_one() {

        //given
        Length largerLength = new Length(7);
        Length shorterLength = new Length(5);
        String expectedResult = String.format("%s is larger then %s", largerLength.getValue(), shorterLength.getValue());

        //when
        String actualResult = largerLength.compare(shorterLength);

        //then
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void should_indicate_the_shorter_length_when_compare_shorter_length_to_the_larger_one() {

        //given
        Length shorterLength = new Length(3);
        Length largerLength = new Length(9);
        String expectedResult = String.format("%s is shorter then %s", shorterLength.getValue(), largerLength.getValue());

        //when
        String actualResult = shorterLength.compare(largerLength);

        //then
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void should_indicate_their_length_are_same_when_compare_two_same_length() {

        //given
        Length randomLength = new Length(5);
        String expectedResult = "we are same!";

        //when
        String actualResult = randomLength.compare(randomLength);

        //then
        assertEquals(expectedResult, actualResult);

    }
}
