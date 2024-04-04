package com.vkedu.mirad.secondHW.ENUMS;

public enum AuthDataEnum {
    EMPTY_PASSWORD("randomWordHa-Ha-Ha",null),
    EMPTY_LOGIN(null,"opaopaopaopa123"),
    BAD_DATA_1("Freddie_Mercury_j12vg1h9","ajsdnajkdnajsd"),
    BAD_DATA_2("Kanye_West_y5ui2qu","bdjfjdgdfgsdfg"),
    BAD_DATA_3("Antonio_Vivaldi_io1k7al","cfjijdfgnkjdf");
    private final String login;
    private final String password;
    AuthDataEnum(String login, String password){
        this.login=login;
        this.password=password;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword(){
        return password;
    }
}
