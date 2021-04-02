package homework.domain;

public class Radio {
    private String name;
    private int currentRadioChanel;
    private int maxRadioChanel = 9;
    private int minRadioChanel = 0;
    private int currentVolume;
    private int maxVolume = 10;
    private int minVolume = 0;
    private boolean on;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentRadioChanel() {
        return currentRadioChanel;
    }

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

    public int getMaxRadioChanel() {
        return maxRadioChanel;
    }

    public void setMaxRadioChanel(int maxRadioChanel) {
        this.maxRadioChanel = maxRadioChanel;
    }

    public int getMinRadioChanel() {
        return minRadioChanel;
    }

    public void setMinRadioChanel(int minRadioChanel) {
        this.minRadioChanel = minRadioChanel;
    }

    public int getCurrentVolume() {
        return currentVolume;
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

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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



