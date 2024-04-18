package com.vkedu.mirad.ThirdHW.ENUMS;

public enum AuthDataEnum {
    EMPTY_PASSWORD("randomWordHa-Ha-Ha",null,"Введите пароль"),
    EMPTY_LOGIN(null,"opaopaopaopa123", "Введите логин"),
    BAD_DATA_1("Freddie_Mercury_j12vg1h9","ajsdnajkdnajsd", "Неправильно указан логин и/или пароль"),
    BAD_DATA_2("Kanye_West_y5ui2qu","bdjfjdgdfgsdfg", "Неправильно указан логин и/или пароль"),
    BAD_DATA_3("Antonio_Vivaldi_io1k7al","cfjijdfgnkjdf", "Неправильно указан логин и/или пароль");
    private final String login;
    private final String password;
    private final String error;
    AuthDataEnum(String login, String password, String error){
        this.login = login;
        this.password = password;
        this.error = error;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword(){
        return password;
    }
    public String getError(){
        return error;
    }
}
