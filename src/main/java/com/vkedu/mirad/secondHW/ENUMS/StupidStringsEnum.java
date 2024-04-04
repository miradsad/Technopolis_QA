package com.vkedu.mirad.secondHW.ENUMS;

public enum StupidStringsEnum {
    STRING_1("hdabshdjbakhjserncqbueafasjdfnajsfnjasdfnasdfjasfkjkadnfasfdggadgfajgfkjaskuUWVUAGYUF"),
    STRING_2("123твывлфывьлфвdhjadfnjasjdkfdjvnkajsndfopajsdfjabdqwertyuiopasdfghjklzxsadfdasdfasfcvbnm"),
    STRING_3("фоатфрамрфыоа12345фhasdfhasырфгвшфрвгшфрывгфрвdasjdnanskjdasdaiomsdo12miomiomыврафылвтыипа67890");

    private final String value;

    StupidStringsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
