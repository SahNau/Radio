package homework.domain;

import org.junit.jupiter.api.Test;

import javax.management.ObjectName;

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
        Radio radio = new Radio("Radio", 0, 10, 0, 0, 100, 0, true);
        // присвоим наши значение;
        radio.setCurrentRadioChanel(8);
        // проверяем будет ли 8
        assertEquals(8, radio.getCurrentRadioChanel());
    }

    @Test
    // тест переключения канала вперёд
    public void nextChanel() {
        Radio radio = new Radio("Radio", 4, 10, 0, 0, 100, 0, true);
        radio.pressNextChanel();
        assertEquals(5, radio.getCurrentRadioChanel());
    }

    @Test
    // тест переключения канала назад
    public void backChanel() {
        Radio radio = new Radio("Radio", 4, 10, 0, 0, 100, 0, true);
        radio.pressBackChanel();
        assertEquals(3, radio.getCurrentRadioChanel());
    }

    @Test
    // тест перехода на канал вперёд при лимите
    public void overLimitChanel() {
        Radio radio = new Radio("Radio", 10, 10, 0, 0, 100, 0, true);
        radio.pressNextChanel();
        assertEquals(0, radio.getCurrentRadioChanel());
    }

    @Test
    // тест перехода на предыдущий канал при лимите
    public void underLimitChanel() {
        Radio radio = new Radio("Radio", 10, 10, 0, 0, 100, 0, true);
        radio.pressBackChanel();
        assertEquals(9, radio.getCurrentRadioChanel());
    }

    @Test
    // тест переключения на канал выше лимита
    public void overInitialChanel() {
        Radio radio = new Radio("Radio", 5, 10, 0, 0, 100, 0, true);
        radio.getMaxRadioChanel();
        assertEquals(10, radio.getMaxRadioChanel());
    }

    @Test
// тест переключения на канал ниже лимита
    public void underInitialChanel() {
        Radio radio = new Radio("Radio", -3, 10, 0, 0, 100, 0, true);
        radio.getMinRadioChanel();
        assertEquals(0, radio.getMinRadioChanel());
    }


    @Test
// тест перехода на громкость выше
    public void maxVolume() {
        Radio radio = new Radio("Radio", 4, 10, 0, 13, 100, 0, true);
        radio.getMaxVolume();
        assertEquals(100, radio.getMaxVolume());
    }

    @Test
    public void minVolume() {
        Radio radio = new Radio("Radio", 4, 10, 0, -11, 100, 0, true);
        radio.getMinVolume();
        assertEquals(0, radio.getMinVolume());

    }

    @Test
    public void plusVolume() {
        Radio radio = new Radio("Radio", 4, 10, 0, 7, 100, 0, true);
        radio.pressPlusVolume();
        assertEquals(8, radio.getCurrentVolume());
    }

    @Test
    public void minusVolume() {
        Radio radio = new Radio("Radio", 4, 10, 0, 7, 100, 0, true);
        radio.pressMinusVolume();
        assertEquals(6, radio.getCurrentVolume());
    }

    // Если уровень громкости звука достиг максимального значения,
    // то дальнейшее нажатие на + не должно ни к чему приводить
    @Test
    public void overInitialVolume() {
        Radio radio = new Radio("Radio", 4, 10, 0, 100, 100, 0, true);
        radio.pressPlusVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    // Если уровень громкости звука достиг минимального значения,
// то дальнейшее нажатие на - не должно ни к чему приводить
    @Test
    public void underInitialVolume() {
        Radio radio = new Radio("Radio", 4, 10, 0, 0, 100, 0, true);
        radio.getMinVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}

