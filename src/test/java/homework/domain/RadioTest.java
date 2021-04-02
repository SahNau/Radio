package homework.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    public void createRadio() {
        Radio radio = new Radio();
        String expected = "Радиоман";
        assertNull(radio.getName());
        radio.setName(expected);
        assertEquals(expected, radio.getName());
    }

    @Test
    // тест переключения канала
    public void shouldChangeChanel() {
        // создали объект
        Radio radio = new Radio();
        // добавим проверку текущего канала, что он 0;
        assertEquals(0, radio.getCurrentRadioChanel());
        // присвоим наши значение;
        radio.setCurrentRadioChanel(8);
        // проверяем будет ли 8
        assertEquals(8, radio.getCurrentRadioChanel());
    }

    @Test
    // тест переключения канала вперёд
    public void nextChanel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChanel(4);
        radio.pressNextChanel();
        assertEquals(5,radio.getCurrentRadioChanel());
    }

    @Test
    // тест переключения канала назад
    public void backChanel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChanel(4);
        radio.pressBackChanel();
        assertEquals(3,radio.getCurrentRadioChanel());
    }

    @Test
    // тест перехода на канал вперёд при лимите
    public void overLimitChanel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChanel(9);
        radio.pressNextChanel();
        assertEquals(0, radio.getCurrentRadioChanel());
    }

    @Test
    // тест перехода на предыдущий канал при лимите
    public void underLimitChanel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChanel(0);
        radio.pressBackChanel();
        assertEquals(9, radio.getCurrentRadioChanel());
    }

    @Test
    // тест переключения на канал выше лимита
    public void overInitialChanel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChanel(13);
        radio.getMaxRadioChanel();
        assertEquals(0, radio.getCurrentRadioChanel());
    }

    @Test
// тест переключения на канал ниже лимита
    public void underInitialChanel() {
        Radio radio = new Radio();
        radio.setCurrentRadioChanel(-3);
        radio.getMinRadioChanel();
        assertEquals(0, radio.getCurrentRadioChanel());
    }


    @Test
// тест перехода на громкость выше
    public void maxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(13);
        radio.getMaxVolume();
        assertEquals(10, radio.getMaxVolume());
    }

    @Test
    public void minVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-11);
        radio.getMinVolume();
        assertEquals(0, radio.getMinVolume());

    }

    @Test
    public void plusVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(7);
        radio.pressPlusVolume();
        assertEquals(8, radio.getCurrentVolume());
    }

    @Test
    public void minusVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(7);
        radio.pressMinusVolume();
        assertEquals(6, radio.getCurrentVolume());
    }
}