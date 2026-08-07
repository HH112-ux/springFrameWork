package com.jh.task2;

public class Student {
    private String name;
    private String cardColor;  // 红色 / 蓝色
    private String cardType;   // A类 / B类

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return name + " 持有" + cardColor + cardType + "借书证";
    }
}
