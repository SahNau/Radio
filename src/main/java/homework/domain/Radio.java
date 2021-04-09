package homework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Radio {
    private String name;
    private int currentRadioChanel;
    private int maxRadioChanel;
    private int minRadioChanel;
    private int currentVolume;
    private int maxVolume;
    private int minVolume;
    private boolean on;


    // настройка канала по дефолту
    public void setCurrentRadioChanel(int currentRadioChanel) {
        if (currentRadioChanel > maxRadioChanel) {
            return;
        }
        if (currentRadioChanel < minRadioChanel) {
            return;
        }
        this.currentRadioChanel = currentRadioChanel;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > maxVolume) {
            return;
        }
        if (currentVolume < minVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }


    // настройка переключения канала вперёд
    public void pressNextChanel() {
        if (currentRadioChanel >= maxRadioChanel) {
            setCurrentRadioChanel(minRadioChanel);
        } else {
            setCurrentRadioChanel(currentRadioChanel + 1);
        }
    }

    // настройка переключения канала назад
    public void pressBackChanel() {
        if (currentRadioChanel <= minRadioChanel) {
            setCurrentRadioChanel(maxRadioChanel);
        } else {
            setCurrentRadioChanel(currentRadioChanel - 1);
        }
    }

    // настройка прибавления звука
    public void pressPlusVolume() {
        setCurrentVolume(currentVolume + 1);
    }

    // настройка убавления звука
    public void pressMinusVolume() {
        setCurrentVolume(currentVolume - 1);
    }
}





